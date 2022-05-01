package fr.utbm.ro54.generic_tools;

import java.util.ArrayList;

public class Position {
	private ArrayList<Double> _pos;
	private int _dim;

	public Position() {
		this._dim = 0;
		this._pos = new ArrayList<Double>();
	}
	
	public Position(int dim) {
		this._dim = dim;
		this._pos = new ArrayList<Double>();
		for (int i = 0; i<dim; i++) {
			this._pos.add(0d);
		}
	}
	
	public Position(double ...vals) {
		this();
		for (double value : vals) {
			this._pos.add(value);
			this._dim++;
		}
	}
	
	public Position multiply(double alpha) {
		Position ret = new Position(this._dim);
		for(int i = 0; i<this._dim; i++) {
			ret._pos.set(i,this._pos.get(i) * alpha);
		}
		return ret;
	}
	
	public Position add(Position p2) {
		Position ret = new Position(this._dim);
		for(int i = 0; i<this._dim; i++) {
			ret._pos.set(i,this._pos.get(i) + p2._pos.get(i));
		}
		return ret;
	}

	
	public int getSize() {
		return this._dim;
	}
	
	public static double evaluateDistance(Position p1, Position p2) {
		if (p1._dim != p2._dim)
			throw new IllegalArgumentException("Dimentions are not equals");
		
		double sum = 0;
		for(int i = 0; i<p1._dim; i++) {
			sum += Math.pow(p1._pos.get(i) - p2._pos.get(i), 2);
		}
		double dist = Math.sqrt(sum);
		return dist;
	}
	
	
	public static ArrayList<Double> getMins(Position ...positions) {
		int ref = positions[0]._dim;
		for (Position p : positions) {
			if (p._dim != ref) {
				throw new IllegalArgumentException("Bad dimention");
			}
		}
		
		ArrayList<Double> ret = new ArrayList<Double>();
		for (int i = 0; i<positions[0]._dim; i++) {
			double min = Double.MAX_VALUE;
			for (Position p : positions) {
				if (p._pos.get(i) < min) {
					min = p._pos.get(i);
				}
			}
			ret.add(min);
		}
		return ret;
	}
	
	public static ArrayList<Double> getMaxs(Position ...positions) {
		int ref = positions[0]._dim;
		for (Position p : positions) {
			if (p._dim != ref) {
				throw new IllegalArgumentException("Bad dimention");
			}
		}
		
		ArrayList<Double> ret = new ArrayList<Double>();
		for (int i = 0; i<positions[0]._dim; i++) {
			double max = -Double.MAX_VALUE;
			for (Position p : positions) {
				if (p._pos.get(i) > max) {
					max = p._pos.get(i);
				}
			}
			ret.add(max);
		}
		return ret;
	}

	@Override
	public String toString() {
		StringBuffer SB = new StringBuffer();
		SB.append("(");
		for(int i = 0; i<this._dim; i++) {
			SB.append(this._pos.get(i));
			SB.append(", ");
		}
		SB.append(")");
		return SB.toString();
	}
}
