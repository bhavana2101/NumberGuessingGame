import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int actualNumber = numberGenerator();
                System.out.println("Enter any number between 1 and 100 or enter 0 to exit : ");
                int enteredNumber = sc.nextInt();
                if (enteredNumber<0 || enteredNumber>100) {
                    System.out.println("Number "+enteredNumber+" is not between 1 and 100");
                    continue;
                }
                else if(enteredNumber==0){
                    System.out.println("Exiting....");
                    break;
                }
                while (enteredNumber != actualNumber && enteredNumber != 0) {
                    if (actualNumber % 2 == 0 && actualNumber < enteredNumber) {
                        System.out.println("Number is even and less than " + enteredNumber);
                        System.out.println("Try Again");
                        enteredNumber = sc.nextInt();
                    } else if (actualNumber % 2 == 0 && actualNumber > enteredNumber) {
                        System.out.println("Number is even and greater than " + enteredNumber);
                        System.out.println("Try Again");
                        enteredNumber = sc.nextInt();
                    } else if (actualNumber % 2 != 0 && actualNumber < enteredNumber) {
                        System.out.println("Number is odd and less than " + enteredNumber);
                        System.out.println("Try Again");
                        enteredNumber = sc.nextInt();
                    } else if (actualNumber % 2 != 0 && actualNumber > enteredNumber) {
                        System.out.println("Number is odd and greater than " + enteredNumber);
                        System.out.println("Try Again");
                        enteredNumber = sc.nextInt();
                    } else {
                        System.out.println("Its a wrong guess....! Try Again...");
                        enteredNumber = sc.nextInt();
                    }
                }
                System.out.println("Hurray! You guessed it right....");
            }
            catch (InputMismatchException e){
                System.out.println("Input entered is in valid");
                System.out.println("Exiting....");
                break;
            }
        }
    }
    public static int numberGenerator(){
        int min = 1;
        int max = 101;
        double r = Math.random();
        int number = (int)(r*(max-min))+min;
        return number;
    }
}
