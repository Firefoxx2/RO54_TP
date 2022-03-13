package fr.utbm.ro54.tp1;

import java.util.ArrayList;

import generic_tools.Position;

public class PositionEstimator {
	double precision;
	ArrayList<Emetteur> EmetteurList;
	
	public PositionEstimator(ArrayList<Emetteur> EL, double p) {
		EmetteurList = EL;
		precision = p;
	}
	
	public Position get3DCubeParserEvaluation(double minx, double maxx, double miny, double maxy, double minz, double maxz) {
		ArrayList<Position> posList = new ArrayList<>();
		
		for(double x = minx; x<=maxx; x+=precision) {
			for(double y = miny; y<=maxy; y+=precision) {
				for(double z = minz; z<=maxz; z+=precision) {
					posList.add(new Position(x,y,z));
				}
			}
		}
		
		return getBestSolution(posList);
	}
	
	public Position getBestSolution(ArrayList<Position> positions) {
		Position bestPos = new Position(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		double bestEval = Double.MAX_VALUE;
		
		for (Position pos : positions) {
			double eval = evaluateSolution(pos);
			if (eval<bestEval) {
				bestEval = eval;
				bestPos = pos;
			}
		}
		
		return bestPos;
	}
	
	private double evaluateSolution(Position p) {
		double sum = 0;
		for (Emetteur em : EmetteurList) {
			sum += em.evaluateDistanceWithBorder(p);
		}
		return sum;
	}
}