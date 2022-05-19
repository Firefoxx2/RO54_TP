package tp2;

import generic_tools.Position;

public class Cell implements Comparable<Cell>{
	private FingerPrint _fingerPrint;
	private Position _position;
	private double _metric;
	
	public Cell(FingerPrint fp, Position position, FingerPrint fpToCompare) {
		this._fingerPrint = fp;
		this._position = position;
		_metric = fpToCompare.calculateMetric(this._fingerPrint);
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
	
	@Override
	public String toString() {
		return "Cell [_fingerPrint=" + _fingerPrint + ", _position=" + _position + ", _metric=" + _metric + "]";
	}

}
