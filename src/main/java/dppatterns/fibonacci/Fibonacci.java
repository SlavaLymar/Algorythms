package dppatterns.fibonacci;

public class Fibonacci {

    //
    // n = 5
    // 0 1 1 2 3 5
    // n1 = 3, n2 = 5, tmp = 5
    //
    // t: O (N)
    // space: O (1)
    //
    public int CalculateFibonacci(int n) {
        int n1 = 0, n2 = 1;
        for (int i = 0; i < n - 1; i++) {
            int tmp = n1 + n2;
            n1 = n2;
            n2 = tmp;
        }
        return n2;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
    }
}
