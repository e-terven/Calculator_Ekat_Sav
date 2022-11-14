import java.util.Scanner;

public class Inputs {

    public static String equation() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        String question = scanner.nextLine();
        return(question);
        //Scanner scanner = new Scanner(System.in);
        //String question = scanner.nextLine();
        //question = question.replaceAll(" ", "");
        //System.out.println(question);

    }
}
