import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter getting a given number in the Fibonacci sequence (preferably no more than 43) --> ");
        System.out.print("Entered -> 11");
        int lengthSequence = 11;

        Fibonacci fibo = new Fibonacci(lengthSequence);


        try {
            System.out.print("Please wait...");
            Thread.sleep(3000);
            int[] sequence = fibo.generateSequence();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        int[] sequence = fibo.generateSequence();
        fibo.showSequence(sequence);
        System.out.println("\n-----------------------------------------------------------------------------------");
//        int n = 11;
//        fibo.getN(n);
//        System.out.print(fibo.getN(n));Manifest-Version: 1.0
//Main-Class: Program
    }
}
