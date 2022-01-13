/**
 * 
 * @author 00055829 (contestant ID number)
 *
 */
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
public class baseKaddition {
	
	private static Scanner inFile = null;
	//private static PrintWriter outFile = null;
	/**
	 * reads in a file, such as basekaddition.txt
	 * reads the elements in the file- the number of times to perform addition, the first num, and second num, etc
	 * converts any letters A-J to numbers 10-19
	 * then passes those elements into the writeOutput() method and calls the writeOutput() method
	 * @param String input ( a file name)
	 */
	public static void readFiles(String input) {
		int whatLine=0;
		String stringnum1="",stringnum2="";
		double base=0, num1=0,num2=0;
		int[] num= {10,11,12,13,14,15,16,17,18,19};
		char[] let = {'A','B','C','D','E','F','G','H','I','J'};
		boolean allNum=true;
	   
	    	int timesPerformAddit = inFile.nextInt();
	    	for (int i = 0;i<timesPerformAddit; i++) {
	    		while(inFile.hasNext()) {
					base=inFile.nextDouble();
					//Double.parseDouble(str);
					stringnum1=inFile.next();
					stringnum2=inFile.next();
					for (int j = 0; j<stringnum1.length(); j++) {
						for (int m = 0; m<num.length;m++) {
							if (stringnum1.charAt(j)==let[m]){
								allNum=false;
								stringnum1=stringnum1.replace(String.valueOf(stringnum1.charAt(j)), String.valueOf(num[m]));
								
							}
						}
						
					}
					if (allNum==false)
						num1=Double.parseDouble(stringnum1);
					else if (allNum==true)
						num1=Double.parseDouble(stringnum1);
					for (int j = 0; j<stringnum2.length(); j++) {
						for (int m = 0; m<num.length;m++) {
							if (stringnum2.charAt(j)==let[m]){
								allNum=false;
								stringnum2=stringnum2.replace(String.valueOf(stringnum2.charAt(j)), String.valueOf(num[m]));
								
							}
						}
						
					}
					if (allNum==false)
						num2=Double.parseDouble(stringnum2);
					else if (allNum==true)
						num2=Double.parseDouble(stringnum2);
					writeOutput(timesPerformAddit,base,num1,num2);
		    	
				
		    }
	    }
	}
	public static double add(double base, double num1, double num2) {
			
			 String a=String.valueOf(num1);
			 String b =String.valueOf(num2);
		    // Function to find the sum of
		    // two integers of base B
		   
		        int len_a, len_b;
		     
		        len_a = a.length();
		        len_b = b.length();
		     
		        String sum, s;
		        s = "";
		        sum = "";
		     
		        int diff;
		        diff = Math.abs(len_a - len_b);
		         
		        // Padding 0 in front of the
		        // number to make both numbers equal
		        for (int i = 1; i <= diff; i++)
		            s += "0";
		         
		        // Condition to check if the strings
		        // have lengths mis-match
		        if (len_a < len_b)
		            a = s + a;
		        else
		            b = s + b;
		     
		        double curr;
				double carry = 0;
		         
		        // Loop to find the find the sum
		        // of two integers of base B
		        for (int i = Math.max(len_a, len_b) - 1;
		                            i > -1; i--) {
		             
		            // Current Place value for
		            // the resultant sum
		            curr = carry + (a.charAt(i) - '0') +
		                        (b.charAt(i) - '0');
		     
		            // Update carry
		            carry = curr / base;
		     
		            // Find current digit
		            curr = curr % base;
		     
		            // Update sum result
		            sum = (char)(curr + '0') + sum;
		        }
		        if (carry > 0)
		            sum = (char)(carry + '0') + sum;
		        double finalSum= 0;
		        System.out.println("sum="+sum);
		        finalSum=Double.valueOf(sum);
		        return finalSum;
		    }
		     
		    
		
		 
	
	/**
	 * after file elements passed in, it prints the base, numbers, and sum
	 * 
	 * @param timesPerformAddit
	 * @param base
	 * @param num1
	 * @param num2
	 */
	public static void writeOutput(int timesPerformAddit, double base, double num1, double num2) {
			double sum=0;
		//	System.out.println("perform additiom" +timesPerformAddit);
			System.out.println("The base of the numbers to add is "+base);
			System.out.println("The first number is "+num1);
			System.out.println("The second number is "+num2);
			if (base==10)
				System.out.println("The sum is: "+(num1+num2));
			else 
				System.out.println("The sum is: "+ add(base,num1,num2));
		
	}
	/**
	 * opens the file, such as basekaddition.txt and catches an error if file isnt found
	 * @param input
	 */
	public static void openFiles(String input) {
		try {
			inFile = new Scanner(new FileReader("basekaddition.txt"));
			//outFile = new PrintWriter(output);
			//outFile = new PrintWriter(output);
			
		}
		catch (FileNotFoundException e) {
			
			System.out.println("Unable to open input file, " + input);
			System.out.println(e.getMessage());
		}
	}
	/**
	 * main method checks if the command line/args is empty or not- if it is, an error is displayed and system exits
	 * if not, the main method opens and reads the file
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		if(args==null||args.length<=0) {
			System.out.println("argument Error");
			System.exit(0);
		}
		else {
		String inputFile=args[0];
		
	
		openFiles(inputFile);
		readFiles(inputFile);
		}
		/*
		Scanner in = new Scanner(System.in);
		int timesPerformAddit = in.nextInt();
		int a=0,b=0,c=0;
		int[]ans=new int[timesPerformAddit];
		
		for (int i = 0;i<timesPerformAddit; i++) {
			a=in.nextInt();
			b=in.nextInt();
			c=in.nextInt();
		}
		*/
		
		
		

	}


}
