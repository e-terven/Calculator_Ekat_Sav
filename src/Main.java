import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //INPUT
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        String question = scanner.nextLine();

        question = question.replaceAll(" ", "");
        System.out.println(question);

        //Numbers b = new Numbers();
        //String equationNumbers = b.getNumbers();
        //System.out.println(equationNumbers);

        //NUMBERS
        String[] splitOp = {"*", "/", "-", "+"};
        String equationNum = question;
        for (int i = 0; i < splitOp.length; i++) {
            equationNum = equationNum.replace(splitOp[i], ",");
        }
        //System.out.println(equationNum);
        String[] equationNumbers = equationNum.split(",");

        //int numbersInteger = Integer.parseInt(equationNumbers);
        //System.out.println(Arrays.toString(equationNumbers));


        // NUMBERS CHECK
        try {
          for (int i = 0; i < equationNumbers.length; i++) {
              if (Integer.parseInt(equationNumbers[i]) > 10 || Integer.parseInt(equationNumbers[i]) < 0 || Integer.parseInt(equationNumbers[i]) % 1 !=0) {
                  throw new ArithmeticException();
              }
          }
        }
        catch (ArithmeticException ae) {
            System.out.println("Invalid input");
            throw ae;
        }

        //Operators c = new Operators();
        //String equationOperators = c.getOperators();
        //System.out.println(equationOperators);

        // OPERATORS
        String[] splitNum = {"10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
        String equationOp = question;
        for (int a = 0; a < splitNum.length; a++) {
            equationOp = equationOp.replace(splitNum[a], "");
        }
        //System.out.println(equationOp);
        String[] equationOperators = equationOp.split("");
        ArrayList<String> eqOp = new ArrayList<String>();
        for (int b = 0; b < equationOperators.length; b++) {
            eqOp.add(equationOperators[b]);
        }
        System.out.println(eqOp);

        // OPERATORS CHECK
        try {
            int numMax = 3;
            int opMax = 2;
            if (numMax < equationNumbers.length || opMax < equationOperators.length || equationNumbers.length != equationOperators.length + 1) {
                throw new ArithmeticException();
            }
        }
        catch (ArithmeticException ae) {
            System.out.println("Invalid input");
            throw ae;
        }
        
        // CALCULATION
        //String [] splitOp = {"*", "/", "-", "+"};
        // equationNumbers {2,4,7}
        // equationOp {-,+}

        double result = 0;
        double result1 = 0;

        String [] check = {"s","s"};
        String[] equationNumbersOfTwo = new String[2];

        ArrayList<String> eqNumFinal = new ArrayList<String>();
        eqNumFinal.add(equationNumbersOfTwo[0]);

        for (int c = 0; c < splitOp.length; c++) {

            if (equationOperators.length == 2) {
                //equationOperators[0]
                if (splitOp[c].equals(equationOperators[0])) {
                    if (equationOperators[1].equals("s")) {
                        equationNumbersOfTwo[1] = String.valueOf(result);
                    } else {
                        equationNumbersOfTwo[0] = equationNumbers[0];
                        equationNumbersOfTwo[1] = equationNumbers[1];
                    }
                    switch (splitOp[c]) {
                        case "*":
                            result1 = Double.parseDouble(equationNumbersOfTwo[0]) * Double.parseDouble(equationNumbersOfTwo[1]);
                            break;
                        case "/":
                            result1 = Double.parseDouble(equationNumbersOfTwo[0]) / Double.parseDouble(equationNumbersOfTwo[1]);
                            break;
                        case "-":
                            result1 = Double.parseDouble(equationNumbersOfTwo[0]) - Double.parseDouble(equationNumbersOfTwo[1]);
                            break;
                        case "+":
                            result1 = Double.parseDouble(equationNumbersOfTwo[0]) + Double.parseDouble(equationNumbersOfTwo[1]);
                            break;
                    }
                    equationOperators[0] = "s";
                    System.out.println("Out of 2 first turned: " + equationOperators[0]);
                    equationNumbersOfTwo[0] = String.valueOf(result1);
                    eqNumFinal.set(0,equationNumbersOfTwo[0]);
                    System.out.println("Again the first number is " + equationNumbersOfTwo[0] + " now");
                }
                //equationOperators[1]
                if (splitOp[c].equals(equationOperators[1])) {
                    if (equationOperators[0].equals("s")) {
                        equationNumbersOfTwo[0] = String.valueOf(result1);
                    } else {
                        equationNumbersOfTwo[0] = equationNumbers[1];
                    }
                    switch (splitOp[c]) {
                        case "*":
                            result = Double.parseDouble(equationNumbersOfTwo[0]) * Double.parseDouble(equationNumbers[2]);
                            break;
                        case "/":
                            result = Double.parseDouble(equationNumbersOfTwo[0]) / Double.parseDouble(equationNumbers[2]);
                            break;
                        case "-":
                            result = Double.parseDouble(equationNumbersOfTwo[0]) - Double.parseDouble(equationNumbers[2]);
                            break;
                        case "+":
                            result = Double.parseDouble(equationNumbersOfTwo[0]) + Double.parseDouble(equationNumbers[2]);
                            break;
                    }
                    equationOperators[1] = "s";
                    System.out.println("Out of 2 second turned: " + equationOperators[1]);
                    equationNumbersOfTwo[1] = String.valueOf(result);
                    eqNumFinal.set(0,equationNumbersOfTwo[1]);
                    System.out.println("First number is " + equationNumbersOfTwo[1] + " now");
                }

            } else if (equationOperators.length == 1) {
                if (splitOp[c].equals(equationOperators[0])) {
                    switch (splitOp[c]) {
                        case "*":
                            result1 = Double.parseDouble(equationNumbers[0]) * Double.parseDouble(equationNumbers[1]);
                            break;
                        case "/":
                            result1 = Double.parseDouble(equationNumbers[0]) / Double.parseDouble(equationNumbers[1]);
                            break;
                        case "-":
                            result1 = Double.parseDouble(equationNumbers[0]) - Double.parseDouble(equationNumbers[1]);
                            break;
                        case "+":
                            result1 = Double.parseDouble(equationNumbers[0]) + Double.parseDouble(equationNumbers[1]);
                            break;
                    }
                    equationOperators[0] = "s";
                    System.out.println("The only operator turned: " + equationOperators[0]);
                    equationNumbersOfTwo[0] = String.valueOf(result1);
                    eqNumFinal.set(0,equationNumbersOfTwo[0]);
                    }
                }
        }
        System.out.println(eqNumFinal.get(0));
    }
}