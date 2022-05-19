package tp2;

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
	
	public double calculateMetric(FingerPrint fp) {
		if (this.getSize() != fp.getSize())
			throw new IllegalArgumentException("bad dim");
		
		double sum = 0;
		
		for (int i = 0; i<this.getSize(); i++) {
			sum += Math.abs(fp._signals.get(i) - this._signals.get(i));
		}
		
		return sum;
	}

	@Override
	public String toString() {
		return "FingerPrint [_signals=" + _signals + "]";
	}
}
