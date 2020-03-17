import java.util.*;

/**
 * <p>the Calculations class extends the Exception class
 * for exception handling and implements the MakeAssistable
 * interface to use the help() function
 * it performs basic calculations using 2 numbers and a single
 * operator then displays the result
 * it has methods for a variety of calculations: +, -, *, /, %, ^, root
 * </p>
 * @author Justice Baker
 */
public class Calculations extends Exception implements MakeAssistable{
	
	String firstNum= "";
	String secondNum = "";
	String operator = "";
    double a; //value of firstNum
    double b; //value of secondNum

	//create a new scanner object
	Scanner scan = new Scanner(System.in);
	
	public String getFirstNum() {
		return firstNum;
	}


	public void setFirstNum(String firstNum) {
		this.firstNum = firstNum;
	}


	public String getSecondNum() {
		return secondNum;
	}


	public void setSecondNum(String secondNum) {
		this.secondNum = secondNum;
	}


	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	public double getA() {
		return a;
	}


	public void setA(double a) {
		this.a = a;
	}


	public double getB() {
		return b;
	}


	public void setB(double b) {
		this.b = b;
	}


	/**
	 * <p>the displayMenu() function displays the 
	 * menu of operator choices the user can enter
	 * </p>
	 */
	public void displayMenu() {
		
		//display menu of operator choices & HELP
		System.out.println("\nOperator Choices:");
		System.out.println("+ \n-  \n*  \n/ "
		+ "\n%  \n^  \nrt \n");
		System.out.print("\n**Type ! for HELP\n\n");
	}
	
	
	/**
	 * <p>the enterFirstNum() function gets the firstNumber
	 * from the user via a string then converts it
	 * to double a 
	 * </p>
	 * @return a the value of the first number
	 * @exception throws an exception if the user enters null input/incorrect format
	 */
	public double enterFirstNum() {

		try {
				//prompt user for 1st number
				System.out.print("Enter the first number: ");
				firstNum = scan.nextLine();
				
				
				if(firstNum.trim().equals("!")){
					
					System.out.println(help());
					System.out.println("\n");
					enterFirstNum();
				}
				
			
				//account for PI & pi as input and trim any extra white space
				 a = firstNum.trim().equalsIgnoreCase("PI") ? Math.PI : Double.parseDouble(firstNum);

		    }catch(NullPointerException e) {
				
				System.out.println("\nException: Incorrect input..\n");
				System.out.println(e);
				System.out.println("\n");
				enterFirstNum();
				
			}catch(NumberFormatException e) {
			
				System.out.println("\nException: Incorrect input..\n");
				System.out.println(e);
				System.out.println("\n");
				enterFirstNum();
			}
		
			return a;
	}
	
	/**
	 * <p>the enterSecondNum() function gets the secondNumber
	 * from the user via a string then converts it
	 * to double b 
	 * </p>
	 * @return b the value of the first number
	 * @exception throws an exception if the user enters null input/incorrect format
	 */
	public double enterSecondNum() {

		try {
			
			//prompt user for second number
			System.out.print("Enter the second number: ");
			secondNum = scan.nextLine();
			System.out.print("\n\n");
			
			//if the user wants help at this step, display basic help
			if(secondNum.trim().equals("!")){
				
				System.out.println(help());
				System.out.println("\n");
				System.out.println("The first number: " + a);
				System.out.println("The operator: " + operator);
				enterSecondNum();
			}
			
			//account for PI & pi as input and trims any extra white space
			b = secondNum.trim().equalsIgnoreCase("PI") ? Math.PI : Double.parseDouble(secondNum);	
			
			 
	    }catch(NullPointerException e) {
			
			System.out.println("\nException: Incorrect input..\n");
			System.out.println(e);
			System.out.println("\n");
			enterSecondNum();
			
		}catch(NumberFormatException e) {
		
			System.out.println("\nException: Incorrect input..\n");
			System.out.println(e);
			System.out.println("\n");
			enterSecondNum();
	
		}
			return b;		
	}

	/**
	 * <p>the enterOp() function gets the operator
	 * from the user via a string then, checks it against the
	 * list of acceptable operators and will repeatedly ask if the input is incorrect
	 * it also provides basic help functionality
	 * </p>
	 */
	public void enterOp(){
			
		//prompt user to enter an operator from the list or ! for help
			System.out.print("Enter an operator: ");
			operator = scan.nextLine();
			
			//while the operator does not equal the list of acceptable operators,
			//stay in a loop and repeatedly ask to enter an operator or will display basic help
			while (!operator.trim().equals("+") && !operator.trim().equals("-") 
					&& !operator.trim().equals("*") && !operator.trim().equals("/") 
					&& !operator.trim().equals("%") && !operator.trim().equals("^") 
					&& !operator.trim().equals("rt")) {
				
				if (operator.trim().equals("!")) {
					
					System.out.println(help());
					System.out.println("\n");
				}
			//re-prompt for operator
				System.out.println("The first number: " + a);		
				System.out.print("Enter an operator: ");
				operator = scan.nextLine();
			
			}	
	}
	
	/**
	 * <p>the displayResult() function will display the result
	 * of the calculation depending on the operator
	 * and call the appropriate function or will display help
	 * </p>
	 */
	public void displayResult() {
		
			if (operator.trim().equals("+")){
			
				System.out.println(a + " + " + b + " = " + add(a, b));
			
			}
			else if (operator.trim().equals("-")) {
			
				System.out.println(a + " - " + b + " = " + subtract(a, b));
			}
			else if (operator.trim().equals("*")){
			
				System.out.println(a + " * " + b + " = " + multiply(a, b));
			}
			else if (operator.trim().equals("/")) {
				
				System.out.println(a + " / " + b + " = " + divide(a, b));	
			}
		
			else if (operator.trim().equals("%")) {
			
				System.out.println(a + " % " + b + " = " + modulo(a, b));
			}
			else if (operator.trim().equals("^")) {
			
				System.out.println(a + " ^ " + b + " = " + power(a, b));
			}
			else if (operator.trim().equals("rt")) {
	
				System.out.println(a + " rt " + b + " = " + root(a, b));
			}
			else {
			
				operator.trim().equals("!");
				
				System.out.println(help());
				System.out.println("\n");
			}
	}
	
	/**
	 * <p>the add() function will add parameters a and b
	 * then return the result
	 * </p>
	 * @param a double value of first number
	 * @param b double value of second number
	 * @return a + b
	 */
	public double add(double a, double b) {
		
		return a + b;
	}
	
	/**
	 * <p>the subtract() function will subtract
	 * parameters a and b then return the result
	 * @param a double value of first number
	 * @param b double value of second number
	 * @return a - b
	 * </p>
	 */
	public double subtract(double a, double b) {
		
		return a - b;
	}
	
	/**
	 * <p>the multiply() function will multiply 
	 * parameters a and b then return the result
	 * </p>
	 * @param a double value of first number
	 * @param b double value of second number
	 * @return a * b
	 */
	public double multiply(double a, double b) {
		
		return a * b;
	}
	
	/**
	 * <p>the divide() function will divide 
	 * parameters a and b then return the result
	 * </p>
	 * @param a double value of first number
	 * @param b double value of second number
	 * @return a / b
	 */
	public double divide(double a, double b) {
			
		return a / b;

	}
	
	/**
	 * <p>the modulo() function will calculate the
	 * modulus of a and b then return the result
	 * </p>
	 * @param a double value of first number
	 * @param b double value of second number
	 * @return a % b
	 */
	public double modulo(double a, double b) {
		
		return a % b;
	}
	
	/**
	 * <p>the power() function will take parameter a then
	 * raise it to any power, parameter b then return the result
	 * </p>
	 * @param a double value of first number
	 * @param b double value of second number
	 * @return a ^ b
	 */
	public double power(double a, double b) {
		
		return Math.pow(a, b);
	}
	
	/**
	 * <p>the root() function will take parameter a then
	 * calculate any root, parameter b then return the result
	 * </p>
	 * @param a double value of first number
	 * @param b double value of second number
	 * @return a ^ (1/b)
	 */
	public double root(double a, double b) {
		
		return Math.pow(a, (1 / b));
		
	}

	/**
	 * <p>the help() is implemented via the interface
	 * MakeAssistable and displays the basic help information
	 * </p>
	 */
	@Override
	public String help() {
		
		return "\n***HELP INFO***:\n"
				+ "Enter the first number(operand)\n"
				+ "Enter an operator\n"
				+ "\tType + to add two numbers\n"
				+ "\tType - to subtract two numbers\n"
				+ "\tType * to multiply two numbers\n"
				+ "\tType / to divide two numbers\n"
				+ "\tType % to find the modulus(remainder) of two numbers\n"
				+ "\tType ^ to raise a number to any power\n"
				+ "\tThe first number is the base, and the second number is the power/exponent (ex. 3 ^ 3)\n"
				+ "\tType rt to get any root of a number\n"
				+ "\tThe first number is the radicand, and the second number is the degree (ex. 25 rt 2)\n"
				+ "Enter the second number\n\n"
				+ "*You must choose one of the operators from the list, or you will be prompted to re-enter "
				+ "until you do.";
		
	}
		
}
