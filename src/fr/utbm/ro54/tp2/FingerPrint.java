package fr.utbm.ro54.tp2;

import java.util.ArrayList;

import fr.utbm.ro54.generic_tools.Position;

public class FingerPrint {
	private ArrayList<Double> signals;
	
	public FingerPrint() {
		
	}
	
	public int getSize() {
		return signals.size();
	}
	
	public double evaluateDistance(FingerPrint fp) {
		if (this.getSize() != fp.getSize())
			throw new IllegalArgumentException("bad dim");
		
		double sum = 0;
		
		for (int i = 0; i<this.getSize(); i++) {
			sum += Math.pow(fp.signals.get(i) - this.signals.get(i), 2);
		}
		
		return Math.sqrt(sum);
	}
}
