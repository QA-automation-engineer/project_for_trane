/**
 * Created by Vladimir on 20.02.2016.
 */
public class Fibonacci {
    public static void main (String[] args)
    {
        int dim = 30;
        int[] fib;
        fib = new int[dim+1];

        fib[0] = 0;
        fib[1] = 1;

        for (int i=0; i<(dim+1);i++)
        {
            if (i>1) fib[i] = fib[i-2] + fib[i-1];
            System.out.println(i + "-e число: " + fib[i]);
        }
    }
}
