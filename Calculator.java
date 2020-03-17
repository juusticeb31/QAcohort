import java.util.*;

/**
 * <p>the Calculator class is the main class that runs the
 * program using a do while loop and will ask the user if they
 * would like to do another calculation
 * </p>
 * @author Justice Baker
 */
public class Calculator{
	
	/**
	 * <p>the main() function will call the
	 * other functions in the Calculations class
	 * it performs basic calculations using 2 numbers and a single
	 * operator then displays the result
	 * it will ask the user if they would like to calculate again</p>
	 * @param args String the main arguments will be passed into a String array
	 *  */
	public static void main(String[] args) {

        //create a new Calculator object
        Calculations myCalc = new Calculations();
        //create a new Scanner object
        Scanner scan = new Scanner(System.in);
        //goAgain empty String for user to input y or n to do another calc
        String goAgain = "";
        
         do {
        	 	//display menu of operator choices
				myCalc.displayMenu();
        	 
				//prompt user to enter a first number
				myCalc.enterFirstNum();

				//prompt user to enter a operator
				myCalc.enterOp();
				 
				//prompt user to enter a second number
				myCalc.enterSecondNum();
				 
				//display calculation result
				myCalc.displayResult();
				
				System.out.println("\nWould you like to do another calculation? (y or n) ");
				goAgain = scan.nextLine();
				
		    }while(goAgain.equalsIgnoreCase("y"));
		        
		        scan.close();

	}

}
