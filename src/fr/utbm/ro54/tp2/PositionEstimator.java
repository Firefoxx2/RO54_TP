package tp2;

import java.util.ArrayList;
import java.util.Collections;
import generic_tools.Position;


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
		double m1 = cells.get(0).getMetric();
		double m2 = cells.get(1).getMetric();
		double m3 = cells.get(2).getMetric();
		double m4 = cells.get(3).getMetric();
		
		double alpha1 = 1/(1 + m1/m2 + m1/m3 + m1/m4);
		alphas.add(alpha1);
		alphas.add(alpha1 * m1 / m2);
		alphas.add(alpha1 * m1 / m3);
		alphas.add(alpha1 * m1 / m4);

		
		//compute position vector
		Position MobilePosition = new Position(cells.get(0).getPosition().getSize());
		for (int i = 0; i<K; i++) {
			Position pos = cells.get(i).getPosition().multiply(alphas.get(i));
			MobilePosition = MobilePosition.add(pos);
		}
		
		return MobilePosition;
	}
}
