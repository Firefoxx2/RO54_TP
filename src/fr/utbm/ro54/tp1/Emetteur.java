package fr.utbm.ro54.tp1;
import fr.utbm.ro54.generic_tools.Position;

public class Emetteur {
	private Position _centerPosition;
	private double _distance;
	
	public Emetteur(Position centerPosition, double signalStrength) {
		this._centerPosition = centerPosition;
		this._distance = signalStrength;
	}
	
	public double evaluateDistanceWithBorder(Position position){
		double dist = Math.abs(Position.evaluateDistance(position, this._centerPosition) - this._distance);
		return dist;
	}

	@Override
	public String toString() {
		return "Emetteur [_centerPosition=" + _centerPosition + ", _signalStrength=" + _distance + "]";
	}
}
