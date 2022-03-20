package fr.utbm.ro54.tp2;

import fr.utbm.ro54.generic_tools.Position;

public class Cell implements Comparable<Cell>{
	@Override
	public String toString() {
		return "Cell [_fingerPrint=" + _fingerPrint + ", _position=" + _position + ", _metric=" + _metric + "]";
	}

	private FingerPrint _fingerPrint;
	private Position _position;
	private double _metric;
	
	public Cell(FingerPrint fp, Position position, FingerPrint fpToCompare) {
		this._fingerPrint = fp;
		this._position = position;
		_metric = fpToCompare.evaluateDistance(this._fingerPrint);
	}

	public enum Mode {
		NN,
		KNN, 
		WEIGHTEDKNN
	}

	public double getNeighborWeight(Mode mode, int K) {
		switch (mode) {
		case NN:
			return 1;
		case KNN:
			return 1/K;
		case WEIGHTEDKNN:
			if (this._metric == 0) {
				return Double.MAX_VALUE;
			} else {
				return 1/Math.abs(this._metric);
			}
		default:
			throw new IllegalArgumentException("bad argv");
		}
	}
	
	public double getMetric() {
		return this._metric;
	}
	
	public Position getPosition() {
		return this._position;
	}

	@Override
	public int compareTo(Cell o) {
		if (o._metric == this._metric)
			return 0;
		if (o._metric > this._metric)
			return 1;
		else
			return -1;
	}
	
	
}
