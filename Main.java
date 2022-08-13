/*
 * Araav Nayak
 * August 13th 2022 11:30am
 */
import java.util.Scanner;

public class Main {

	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);

		System.out.println("Enter the equation for a parabola: ");
		String eq = s.nextLine();

		eq = eq.substring(2); //excluding the "y=" or "x="
		
		//handles cases where a,b,c values are explicitly (clearly) entered
		//equation must be in standard form:
		// 		y=ax^2+bx+c
		//		x=ay^2+by+c
		
		String z = findVar(eq);

		//obtain values of a,b,c
		double a = Double.parseDouble(eq.substring(0,eq.indexOf("^2")-1));
		double b = Double.parseDouble(eq.substring(eq.indexOf("^2") + 3, eq.indexOf("" + z, eq.indexOf("^2") + 3)));
		double c = Double.parseDouble(eq.substring(eq.lastIndexOf("" + z)+2));

		//System.out.println("Values: " + a + ", " + b + ", " + c);

		//calculate value of p --> 1/(4p) = a
		double p = 1/(4*a);

		//find vertex --> Vx = b/2a -> f(Vx)
		double h = -b/(2*a);
		double k = a * Math.pow(h, 2) + b * h + c;

		if(a >= 0) p = Math.abs(p);
		else p = -Math.abs(p);

		if(Math.abs(h) == 0.0) h = 0;
		if(Math.abs(k) == 0.0) h=k = 0;

		double focusX = 0, focusY = 0;
		String directrixLine = "";
		
		if(z.equals("x")) {
			focusX = h;
			focusY = k+p;
			directrixLine = "y=" + (k-p);
		} else if(z.equals("y")) {
			focusX = h+p;
			focusY = k;
			directrixLine = "x=" + (h-p);
		}
		
		System.out.println("Focus: (" + focusX + ", " + focusY + ")");
		System.out.println("Directrix: " + directrixLine);
	}

	public static String findVar(String s) {
		if(s.charAt(0) == 'y') return "x";
		return "y";
	}
}
