package fr.utbm.ro54.tp2;

import java.util.ArrayList;
import java.util.Collections;
import fr.utbm.ro54.generic_tools.Position;


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
		
		
		//sort metric in descending order
		Collections.sort(cells);
		Collections.reverse(cells);
		
		
		//compute alphas
		ArrayList<Double> alphas = new ArrayList<Double>();
		double alpha1 = 1;
		for (int i = 1; i<K; i++) {
			alpha1 += cells.get(0).getMetric() / cells.get(i).getMetric();
		}
		alpha1 = 1/alpha1;
		alphas.add(alpha1);
		
		for (int i = 1; i<K; i++) {
			alphas.add(alpha1*cells.get(0).getMetric()/cells.get(i).getMetric());
		}

		
		//compute position vector
		Position MobilePosition = new Position(cells.get(0).getPosition().getSize());
		for (int i = 0; i<K; i++) {
			Position pos = cells.get(i).getPosition().multiply(alphas.get(i));
			MobilePosition = MobilePosition.add(pos);
		}
		
		return MobilePosition;
	}
}
