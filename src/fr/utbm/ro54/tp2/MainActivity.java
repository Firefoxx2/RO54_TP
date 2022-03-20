package fr.utbm.ro54.tp2;

import fr.utbm.ro54.generic_tools.Position;

public class MainActivity {
	public static void main(String[] Argv) {
		FingerPrint FPtoLocate = new FingerPrint(-26, -42, -13, -46);
		
		PositionEstimator PE = new PositionEstimator();
		PE.AddCell(new FingerPrint(-38, -27, -54, -13), new Position(2, 2));
		PE.AddCell(new FingerPrint(-74, -62, -48, -33), new Position(2, 6));
		PE.AddCell(new FingerPrint(-13, -28, -12, -40), new Position(2, 10));
		PE.AddCell(new FingerPrint(-34, -27, -38, -41), new Position(6, 3));
		PE.AddCell(new FingerPrint(-64, -48, -72, -35), new Position(6, 6));
		PE.AddCell(new FingerPrint(-45, -37, -20, -15), new Position(6, 10));
		PE.AddCell(new FingerPrint(-17, -50, -44, -33), new Position(10, 3));
		PE.AddCell(new FingerPrint(-27, -28, -32, -45), new Position(10, 6));
		PE.AddCell(new FingerPrint(-30, -20, -60, -40), new Position(10, 10));
		
		System.out.println(PE.run(4, FPtoLocate));
	}
}
