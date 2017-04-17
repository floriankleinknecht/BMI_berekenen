/*This program is written by Florian Kleinknecht. For questions or remarks please send a mail to floriankleinknecht@gmail.com. Feedback (in English or Dutch) will always be very much appreciated. Thank you for your interest.*/
/*Version 1.4, last updated on: 6 april 2017.*/

import java.io.*; 

public class BMI {
	
	private int age;
	private double weight;
	private double length;
	private double QI;
	private String gender;
	private String input;
	
	static String ONDERGEWICHT = "ondergewicht.";
	static String GEZONDGEWICHT = "een gezond gewicht.";
	static String LICHTOVERGEWICHT = "licht overgewicht.";
	static String MATIGOVERGEWICHT = "matig overgewicht.";
	static String ERNSTIGOVERGEWICHT = "ernstig overgewicht.";
	static String ZIEKELIJKOVERGEWICHT = "ernstige obesitas.";
	
	/*1. This method checks the input of question 1 (age).*/	

	public void CheckAge() { 
		
		int temp = 0;
		input = input.trim();
		temp = Integer.parseInt(input);
		if (temp<18) throw new IllegalArgumentException();
		
	}

	/*2. This method checks the input of question 2 (weight).*/

	public void CheckWeight() {
		
		input = input.replace(',', '.');
		
	}
	
	/*3. This method checks the input of question 3 (length).*/

	public void CheckLength() {
	
		input = input.replace(',', '.');
		
		if (input.length() == 3 && input.charAt(1) != '.') {
			
			StringBuilder temp = new StringBuilder();
			input = temp.append(input).insert(1, ".").toString();
			System.out.println("\nInvoer is ge�nterpreteerd als: " + input + " meter.\n");
		
		}
	}

	/*4. This method checks the input of question 4 (gender).*/

	public void CheckGender(String input) {
	
		gender = input.trim().toLowerCase();
		switch (gender) {
		
	    case "man": 
	    	break;
	    	
	    case "vrouw": 
	    	break;
	    	
	    case "m": 
	    	gender = "man"; 
	    	System.out.println("\nInvoer is ge�nterpreteerd als: " + gender + "\n");
	    	break;
	    	
	    case "v": 
	    	gender = "vrouw"; 
	    	System.out.println("\nInvoer is ge�nterpreteerd als: " + gender + "\n");
	    	break;
	    	
	    default: 
	    	throw new IllegalArgumentException();
	    	
		}
	}
	
	/*5. This method transfers the value of question 2 (weight) from a String to a double and checks the value.*/

	public double setWeight(String input) {
	
		double temp = 0;
		temp = Double.parseDouble(input);
		if (temp<=0) throw new IllegalArgumentException();
		return temp;
		
	}
	
	/*6. This method transfers the value of question 3 (length) from a String to a double and checks the value. To avoid mistakes, the length cannot be longer than 3 meters.*/

	public double setLength(String input) {
		double temp = 0;
		temp = Double.parseDouble(input);
		if (temp<=0 || temp>3) throw new IllegalArgumentException();
		return temp;
		
	}

	/*7. This method calculates the QI value.*/

	public double setQI(double weight, double length) {
		QI = weight/(length*length);
		return QI;
		
	}
	
	/*8. this method sets the value of Gender.*/
	
	public void setGender(String input) {
		gender = input;
		
	}
	
	/*9. This method calls the reference values for respectively men and women. Default is added because the method must return a String.*/
	
	public String Calculate_BMI() {
		String temp_man = "";
		String temp_woman = "";
		
		switch (gender) {
		
		case "man": 
		temp_man = BMI_Man();
		return temp_man;
    	
		case "vrouw": 
			temp_woman = BMI_Woman();
			return temp_woman;
			
		default: return "";
		
		}
	}
	
	/*10. This method returns the value of the Calculate_BMI method for men.*/
	
	public String BMI_Man() {
		
		if (QI <= 20.0) return(ONDERGEWICHT);
		else if (QI<=25.0) return(GEZONDGEWICHT);
		else if (QI<=27.0) return(LICHTOVERGEWICHT);
		else if (QI<=30.0) return(MATIGOVERGEWICHT);
		else if (QI<=40.0) return(ERNSTIGOVERGEWICHT);
		else return(ZIEKELIJKOVERGEWICHT);
		
	}
	
	/*11. This method returns the value of the Calculate_BMI method for women.*/
	
	public String BMI_Woman() {
		
		if (QI <= 18.6) return(ONDERGEWICHT);
		else if (QI<=23.8) return(GEZONDGEWICHT);
		else if (QI<=25.7) return(LICHTOVERGEWICHT);
		else if (QI<=28.5) return(MATIGOVERGEWICHT);
		else if (QI<=40.0) return(ERNSTIGOVERGEWICHT);
		else return(ZIEKELIJKOVERGEWICHT);
		
	}
	
	/*11. This method returns the BMI reference tabel for men or women, depending on the input of the user.*/
	
	public void Referentietabel() {
		
		if (gender.equals("man")) {
			
			System.out.println("\nReferentietabel voor mannen: \nBMI kleiner dan 20.0 = ondergewicht \nBMI tussen 20.0 en 25.0 = gezond gewicht \nBMI tussen 25.0 en 27.0 = licht overgewicht \nBMI tussen 27.0 en 30.0 = matig overgewicht \nBMI tussen 30.0 en 40.0 = ernstig overgewicht \nBMI groter dan 40 = ernstige obesitas");
			
			
		} else {
			
			System.out.println("\nReferentietabel voor vrouwen: \nBMI kleiner dan 18.6 = ondergewicht \nBMI tussen 18.6 en 23.8 = gezond gewicht \nBMI tussen 23.8 en 25.7 = licht overgewicht \nBMI tussen 25.7 en 28.5 = matig overgewicht \nBMI tussen 28.5 en 40.0 = ernstig overgewicht \nBMI groter dan 40 = ernstige obesitas");
			
		}
	}	
	
	public static void main(String[] args) throws IOException {

		Console console = System.console();
		if (console == null) { throw new RuntimeException("console niet beschikbaar");
		
		} else {
			
			System.out.println("\nDit programma rekent het BMI (Queteletindex) uit voor volwassenen aan de hand van vier vragen. Aangezien de index geen rekening houdt met individuele verschillen in lichaamsbouw is de uitslag slechts een indicatie voor een gezond gewicht. Raadpleeg bij zorgen over uw gewicht een arts. Aan de uitslag kunnen geen rechten worden ontleend."); 
			
			System.out.println("\nVul X in bij een van de vragen om het programma af te sluiten.\n");
			
			
			//this loop enables the user to shut down the program by filling in "x" in one of the questions.
			start: while (true) {
				
				BMI user = new BMI();

				/*Every question has a while loop. If the input is invalid, the while loop construct will return the question again to the user. The loop breaks if the question is answered with a valid input.*/
				
				question1: while (true) { 
					
					user.input = console.readLine("Wat is uw leeftijd: "); // Question 1
					
					try {
						
						// Closes program when user fills in x.
						if (user.input.equalsIgnoreCase("X")) break start;
						
						// Checks the input.
						user.CheckAge(); 
						break;
						
					} catch (NumberFormatException e) {
						
						System.out.println("\nInvoer moet een getal zijn zonder decimalen.\n");
						
						continue question1;
						
					} catch (IllegalArgumentException e) {
						
						System.out.println("\nDit programma rekent helaas alleen het BMI uit voor volwassenen.\n");
						
						continue question1;
						
					}
				}
				question2: while (true) {
					
					console.flush();
					
					// Question 2.
					user.input = console.readLine("Vul hier uw gewicht in kilogram in: "); 
				
					try {
					
						// Closes program when user fills in "x".
						if (user.input.equalsIgnoreCase("X")) break start;
						
						// Checks the input.
						user.CheckWeight();
						
						// Transfers the String value from the question to a double and sets weight.
						user.weight = user.setWeight(user.input); 
						break;
					
					} catch (NumberFormatException e) {
						
						System.out.println("\nInvoer moet een getal zijn, bijvoorbeeld 62.5.\n");
						
						continue question2;
						
					} catch (IllegalArgumentException e) {
						
						System.out.println("\nInvoer moet een getal zijn groter dan 0.\n");
						
						continue question2;
						
					}
				}
				question3: while (true) {
					
					console.flush();
					
					// Question 3.
					user.input = console.readLine("Vul hier uw lengte in meters in: "); 
					
					try {
						
						// Closes program when user fills in "x".
						if (user.input.equalsIgnoreCase("X")) break start;
						
						// Checks the input.
						user.CheckLength(); 
						
						// Transfers the String value from the question to a double and sets length.
						user.length = user.setLength(user.input); 
						break;
						
					} catch (NumberFormatException e) {
						
						System.out.println("\nInvoer moet een getal zijn, bijvoorbeeld: 1.75.\n");
						
						continue question3;
						
					} catch (IllegalArgumentException e) {
						
						System.out.println("\nInvoer moet een getal zijn tussen 0 en 3 meter.\n");
						
						continue question3;
						
					}
				}
				
				question4: while (true) {
				
					console.flush();	
					
					// Question 4.
					user.input = console.readLine("Bent u een man of een vrouw: "); 
					user.setGender(user.input);	
				
					try {
					
						// Closes program when user fills in "x".
						if (user.input.equalsIgnoreCase("X")) break start; 
						
						// Checks the input.
						user.CheckGender(user.gender); 
						break;
					
					} catch (IllegalArgumentException e) {
						
						System.out.println("\nVul \"man\" of \"vrouw\" in.\n");
						continue question4;
						
					}
				}
				
				// Calculates the QI value.
				user.QI = user.setQI(user.weight, user.length); 
				
				// Prints the reference table of the BMI index for the user.
				user.Referentietabel();
				
				// Returns the rounded QI of the user in 1 decimal.
				System.out.println("\nUw BMI is: "+ Math.round(user.QI*10)/10.0); 
				
				// Returns the BMI index of the user.
				System.out.println("\nOp grond van de BMI index heeft u " + user.Calculate_BMI()); 
				System.out.println();
				
				// Closes program.
				break start; 
			}
		}
	}
}