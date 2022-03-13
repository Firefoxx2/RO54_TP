package fr.utbm.ro54.tp1;
import generic_tools.Position;

public class Emetteur {
	private Position _centerPosition;
	private double _signalStrength;
	
	public Emetteur(Position centerPosition, double signalStrength) {
		this._centerPosition = centerPosition;
		this._signalStrength = signalStrength;
	}
	
	public double evaluateDistanceWithBorder(Position position){
		double dist = Math.abs(Position.evaluateDistance(position, this._centerPosition) - this._signalStrength);
		return dist;
	}

	@Override
	public String toString() {
		return "Emetteur [_centerPosition=" + _centerPosition + ", _signalStrength=" + _signalStrength + "]";
	}
}
