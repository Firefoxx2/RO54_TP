package fr.utbm.ro54.tp2;

import fr.utbm.ro54.generic_tools.Position;

public class Cell implements Comparable{
	private FingerPrint fp;
	private Position pos;
	private double metric;
	
	public Cell(FingerPrint fp, Position position, FingerPrint fpToCompare) {
		metric = fpToCompare.evaluateDistance(this.fp);
	}
	
	public double getMetric() {
		return metric;
	}
	
	@Override
	public int compareTo(Object o) {
		if (o.getClass() != Cell.class)
			throw new IllegalArgumentException("Bad Arg");
		if (((Cell) o).metric == this.metric)
			return 0;
		if (((Cell) o).metric > this.metric)
			return 1;
		else
			return -1;
	}
	
	
}
