import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter getting a given number in the Fibonacci sequence (preferably no more than 43) --> ");
        int lengthSequence = scanner.nextInt();
        Fibonacci fibo = new Fibonacci(lengthSequence);
        System.out.println("Please wait...");
        int[] sequence = fibo.generateSequence();
        fibo.showSequence(sequence);
        System.out.print("-----------------------------------------------------------------------------------");
        int n = -11;
        fibo.getN(n);
        System.out.print(fibo.getN(n));
    }
}
