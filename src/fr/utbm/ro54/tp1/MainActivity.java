package fr.utbm.ro54.tp1;

import java.util.ArrayList;
import java.util.Arrays;

import fr.utbm.ro54.generic_tools.Position;

public class MainActivity {
	public static void main(String[] Argv) {

		Position p1 = new Position(-3.54,-1.85,0);
		Position p2 = new Position(-2.12,0.83,0);
		Position p3 = new Position(1.06,-1.19,0);
		Position p4 = new Position(3.38,3.61,0);
		
		Emetteur em1 = new Emetteur(p1, 2.25);
		Emetteur em2 = new Emetteur(p2, 1.44);
		Emetteur em3 = new Emetteur(p3, 2.84);
		Emetteur em4 = new Emetteur(p4, 6.57);
		
		ArrayList<Emetteur> EmetteurList = new ArrayList<Emetteur>(Arrays.asList(em1, em2, em3, em4));
		
		ArrayList<Double> maxs = Position.getMaxs(p1, p2, p3, p4);
		ArrayList<Double> mins = Position.getMins(p1, p2, p3, p4);		
		double minx = mins.get(0);
		double miny = mins.get(1);
		double minz = mins.get(2);
		double maxx = maxs.get(0);
		double maxy = maxs.get(1);
		double maxz = maxs.get(2);
		
		PositionEstimator PE = new PositionEstimator(EmetteurList, 0.01);
		System.out.println(PE.get3DCubeParserEvaluation(minx, maxx, miny, maxy, minz, maxz));
		//Ideal Position : -1.7, -0.55, 0
	}
}
