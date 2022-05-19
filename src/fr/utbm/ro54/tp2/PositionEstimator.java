package fr.utbm.ro54.tp2;

import java.util.ArrayList;
import java.util.Collections;

import fr.utbm.ro54.generic_tools.Position;
import fr.utbm.ro54.tp2.Cell.Mode;

public class PositionEstimator {
	private ArrayList<FingerPrint> _fingerPrints = new ArrayList<FingerPrint>();
	private ArrayList<Position> _position = new ArrayList<Position>();

	public PositionEstimator() {
		this._fingerPrints = new ArrayList<FingerPrint>();
		this._position = new ArrayList<Position>();
	}
	
	public void AddCell(FingerPrint fp, Position pos) {
		this._fingerPrints.add(fp);
		this._position.add(pos);
	}
	
	public Position run(int K, FingerPrint fingerPrintToLocate) {
		//generate cells (and compute metric)
		ArrayList<Cell> cells = new ArrayList<Cell>();
		for (int i = 0; i<_fingerPrints.size(); i++) {
			cells.add(new Cell(this._fingerPrints.get(i), this._position.get(i), fingerPrintToLocate));
		}
		//check argument
		if (K >= _fingerPrints.size())
			K = _fingerPrints.size();
		
		//sort metric
		Collections.sort(cells);
		
		//compute total weight
		double sum = 0;
		for (int i = 0; i<K; i++) {
			sum += cells.get(i).getNeighborWeight(Mode.WEIGHTEDKNN, K);
		}
		
		//compute alphas
		ArrayList<Double> alphas = new ArrayList<Double>();
		for (int i = 0; i<K; i++) {
			double alpha = cells.get(i).getNeighborWeight(Mode.WEIGHTEDKNN, K) / sum;
			//System.out.println(this._cells.get(i));
			//System.out.println(alpha);
			alphas.add(alpha);
		}
		
		//compute position vector
		Position MobilePosition = new Position(cells.get(0).getPosition().getSize());
		for (int i = 0; i<K; i++) {
			Position pos = cells.get(i).getPosition().multiply(alphas.get(i));
			MobilePosition = MobilePosition.add(pos);
			//System.out.println("id : " + i);
			//System.out.println("alpha : " + alphas.get(i));
			//System.out.println("MP : " + MobilePosition);
		}
		
		return MobilePosition;
	}
}
