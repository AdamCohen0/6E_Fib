/** 
  Calculate Fibonacci number n
  3 implementations
  @precondition: n >= 1
  
  Use type "long" instead of "int", because rabbits.
 */

public class Fib {
    /** 
      @return the nth Fibonacci number
              by implementing the recurrence relation
     */
     //Problem: calculate the nth Fib number
     //Recursive Abstraction: When I am asked to calculate the nth fib number,
        // the recursive abstraction will calculate the previous two fib numbers and add them.
        
    public static long fib_recurrence( int n) {
        
        // base case 1: are we calculating the zeroeth fibonacci number?   
        if (n == 0) {
            // solution to the base case: return 0 (trivial fib number)
            return 0;
        } else {
        // base case 2: are we calculating the first fibonacci number? 
            if (n == 1)
            // solution to the base case: return - (trivial fib number)
                return 1;
            // solution to the recursive case: sum the result of the recursive abstraction on the 
            // n-1 and n-2 fibonacci numbers
                return fib_recurrence(n-1) + fib_recurrence(n-2);
        // leftover processing: none, or the act of adding (open for interpretation)
        
        }
    }
     /* 
        These are class / instance methods because...
        Not only is the method completely enclosed and non-reliant on the class itself
        to calculate the nth fibonacci number, but it makes no sense to make calculating
        the nth fibonacci number a "property" of an instance of a Fib object.
    */
    
    /* 
       Time complexity:
       Consider the size of the problem to be the ordinal of the sequence value.
       
       As the proxy for the time required, count the number of recursive calls.
       
       Then cost of the the recurrence algorithm
       grows exponentially
       as the size of the problem increases,
       because there are two recursive calls with each invocation of the method
       and it will take about (1-2^n)/(1-2) = 2^n - 1 calls to reach the base case, 
       which simplifies to O(2^n) as a result of the sum of a geometric series.
     */


    /** 
      @return the nth Fibonacci number
              calculated via the 8th-grade algorithm
     */
    public static long fib_grade8( int n) {
        int first = 0;
        int second = 1;
        int storage;
        for(int count = 0; count < n; count++) {
            storage = second;
            second = first + second;
            first = storage;
        }
        return first;
    }
    /* 
       Time complexity:
       Consider the size of the problem to be the ordinal of the sequence value.
       
       As the proxy for the time required, count the number of variable assignments.
       
       Then cost of the the recurrence algorithm
       grows linearly
       as the size of the problem increases,
       because there are three assignments for each of n loops of the algorithm,
       meaning the worst case simplifies to about O(3n) = O(n).
     */


    /** 
      @return the nth Fibonacci number
              calculated via Binet's formula.
              Type is double so that this exercise can
              ignore rounding issues.
     */
    public static double fib_Binet( int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        double psi = 1 / phi;
        return Math.ceil( (Math.pow(phi, n) - Math.pow(psi, n)) / Math.sqrt(5) );
    }
    /* 
       Time complexity:
       Consider the size of the problem to be the ordinal of the sequence value.
       
       As the proxy for the time required, count mathematical operations performed.
       
       Then cost of the the recurrence algorithm
       grows constantly 
       as the size of the problem increases,
       because there is one specific, finite number of operations performed for each
       and every size, and it remains the same as the problem grows.
     */
     
     // LEROYYYY JENKENS!!!: Assuming in an average case the recurrence algorithm performs as
     // it's worst case does (O(2^n)) and assuming that an operation takes one microsecond,
     // then the 32nd fibonacci would take about 1 hour 12 minutes to compute.
}
