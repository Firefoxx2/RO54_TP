package fr.utbm.ro54.tp2;

import java.util.ArrayList;

public class FingerPrint {
	private ArrayList<Double> _signals;

	public FingerPrint() {
		this._signals = new ArrayList<Double>();
	}

	public FingerPrint(double ...signals) {
		this();
		for (double value : signals) {
			this._signals.add(value);
		}
	}
	
	public int getSize() {
		return _signals.size();
	}
	
	public double evaluateDistance(FingerPrint fp) {
		if (this.getSize() != fp.getSize())
			throw new IllegalArgumentException("bad dim");
		
		double sum = 0;
		
		for (int i = 0; i<this.getSize(); i++) {
			sum += Math.pow(fp._signals.get(i) - this._signals.get(i), 2);
		}
		
		return Math.sqrt(sum);
	}

	@Override
	public String toString() {
		return "FingerPrint [_signals=" + _signals + "]";
	}
}
