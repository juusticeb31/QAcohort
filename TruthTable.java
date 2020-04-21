
public class TruthTable {

	public static void main(String[] args) {

	System.out.println("A\tB\tA&B\tA|B\tA&&B\tA||B\tA^B|\t");
	System.out.println("---------------------------------------------------");

		
		displayTF(true, true);
	System.out.println("---------------------------------------------------");

		displayTF(true, false);
	System.out.println("---------------------------------------------------");

		displayTF(false, true);
	System.out.println("---------------------------------------------------");

		displayTF(false, false);
	System.out.println("---------------------------------------------------");

	}
	
	
	public static void displayTF (boolean a, boolean b) {
		
		 System.out.print((a ? "T":"F") + " |\t"); 
	     System.out.print((b ? "T":"F") + " |\t" );
	     System.out.print(((a&b) ? "T":"F") + " |\t");
	     System.out.print(((a|b) ? "T":"F") + " |\t");
	     System.out.print(((a&&b) ? "T":"F") + " |\t");
	     System.out.print(((a||b) ? "T":"F") + " |\t" ); 
	     System.out.println(((a^b) ? "T":"F") + "  |\t" );	
	     	
	}

}
