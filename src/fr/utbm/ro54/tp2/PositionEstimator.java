package fr.utbm.ro54.tp2;

import java.util.ArrayList;
import java.util.Collections;

import generic_tools.Position;

public class PositionEstimator {
	private ArrayList<FingerPrint> fingerPrintList;
	private ArrayList<Position> positionList;
	
	public PositionEstimator() {
		
	}
	
	private void run(FingerPrint fingerPrintToCompare, int K) {
		ArrayList<Cell> Cells = new ArrayList<Cell>();
		for (int i = 0; i<fingerPrintList.size(); i++) {
			Cells.add(new Cell(fingerPrintList.get(i), positionList.get(i), fingerPrintToCompare));
		}
		Collections.sort(Cells);
		
		double sum = 0;
		for (int i = 0; i<K; i++) {
			sum += 1/getNearestMetric(Cells.get(i), 1, K);
		}
		
		ArrayList<Double> alphas = new ArrayList<Double>();
		for (int i = 0; i<K; i++) {
			alphas.add(getNearestMetric(Cells.get(i), 1, K) / sum);
		}
		
		
	}
	
	private double getNearestMetric(Cell c, int mode, int K) {
		if (mode == 0) {
			return 1;
		} else if (mode == 1) {
			return K;
		} else if (mode == 2) {
			return c.getMetric();
		} else {
			throw new IllegalArgumentException("bad argv");
		}
	}
}
