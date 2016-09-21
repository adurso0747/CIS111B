import java.util.*;
/*
*
* @author Alex Durso
*
*/

public class QuadraticTester 
{
   public static void main(String[] args)
   {
      //Create new scanner to retrieve starting values from user
      Scanner userInput = new Scanner(System.in);
      
      //Allow user to input values for a, b and, c
      System.out.println("Welcome to the quadratic equation solver. Your \n" +
                         "equation will be modeled in the form of ax^2 + bx" +
                         " + c.");
		System.out.println("Please enter a value for a: ");
      double a = userInput.nextDouble();
      System.out.println("Please enter a value for b: ");
      double b = userInput.nextDouble();
      System.out.println("Please enter a value for c: ");
      double c = userInput.nextDouble();
      Quadratic quad = new Quadratic(a, b, c);
      
      //If statement to determine if values form a valid quadratic
      //equation
      if(a == 0)
      {
         System.out.println("Your equation is not quadratic");
         System.exit(0);
      }
      
      //Else statement to determine if equation has real or
      //complex roots
      else if(quad.realRoots() == false)
      {
         System.out.println("Your equation had a negative discriminant.\n" +
                           "Therefore your equation did not have any real roots. \n" +
                            "Your equation must have complex roots" );
      }
      
      //If quadratic is valid and has real roots tell user their
      //roots
      else
      {
         double root1 = quad.firstRoot();
         double root2 = quad.secondRoot();
         System.out.println("Your equation was " + a + "^2 + " + b + "x + " + c +
                            ", \nyour first root was " + root1 + " and your second\n" +
                            "root was " + root2);
      }
      
      //Ask user if they would like to calculate a discriminant
      System.out.println("Would you like to compute the value\n" +
                         "of the first derivative of the quadratic\n" + 
                         "at a specific point?" +
                         "\nPlease enter 1 for yes and 2 for no");
      double input = userInput.nextDouble();
      
      //If statement for if user would like to calculate 
      //derivaive
      if(input == 1)
      {
         //Gather user value for x
         System.out.println("Please enter a value for x: ");
         double x = userInput.nextDouble();
         //Set X to x
         quad.setValue(x);
         //Set deriv to calculated derivative
         double deriv = quad.derivative();
         System.out.println("The derivative of " + a + "x " + " + b" 
                            + "x + " + c + "\nat point " + x + " was : "
                            + deriv + ".");
      }
      //Statement for if user does not want to calculate derivative
      else
      {
         System.out.println("Goodbye");
      }
      //This portion of the program creates a list of quadratics, then sorts
      //them by how fast they open
      Quadratic other = new Quadratic(1,2,3);
      Quadratic other1 = new Quadratic(5,6,7);
      Quadratic other2 = new Quadratic(3,4,6);
      Quadratic other3 = new Quadratic(1,8,12);
      Quadratic[] quadratics = {quad,other,other1,other2,other3};
      Arrays.sort(quadratics);
      System.out.println("\nHere is a list of quadratics sorted by how quickly they open: ");
      for(int i = 0; i < quadratics.length; i++)
      {
         System.out.println(quadratics[i].toString());
      }
     
    
   }
}
class Quadratic implements Comparable<Quadratic>
{
   //Declare variables
   private double A;
   private double B;
   private double C;
   private double X;
   private double discriminant;
   
   //Comparable method
   public int compareTo(Quadratic other)
   {
      if(getA() < other.getA())
      {
         return 1;
      }
      if(getA() > other.getA())
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }

  	/**
    * Constructor
    * @param A the value of a in the quadratic equation
    * @param B the value of b in the quadratic equation
    * @param C the value of c in the quadratic equation
    */
   public Quadratic(double a, double b, double c)
   {
      A = a;
      B = b;
      C = c;
      calcDiscriminant();
   }
   
   //Setters
   
   /**
    * Assigns x to variable X
    */ 
   void setValue(double x)
   {
      this.X = x;
   }
   
   void setA(double a)
   {
     A = a;
   }
   void setB(double b)
   {
     B = b;
   }
   void setC(double c)
   {
     C = c;
   }

   
   /**
    * Calculates discriminant and sets it equal to
    * variable discriminant
    */ 
   private void calcDiscriminant() 
   {
      discriminant = B*B - 4.0*A*C;
   }
   
   //Getters
   
   /**
    * @return The first root of the quadratic
    */ 
   
   public double getA()
   {
      return A;
   }
    public double getB()
   {
      return B;
   }
   public double getC()
   {
      return C;
   }
   public double firstRoot()
   {
      return (-B + Math.sqrt(discriminant))/(2.0*A);
   }
   
   /**
    * @return The second root of the quadratic
    */ 
   public double secondRoot()
   {
      return (-B - Math.sqrt(discriminant))/(2.0*A);
   }
   
   /**
    * @return Whether or not the quadratic has real roots
    */ 
   public boolean realRoots()
   {
      if(discriminant < 0) return false;
      else return true;
   }
   
   /**
    * @return The calculation of the derivative
    */ 
   public double derivative()
   {
      return ((2.0*A*X) + B);
   }
   //ToString to print quadratics
   public String toString()
   {
      return "(Quadratic:: " + getA() + "x^2 + " + getB() + "x + " + getC() + ")";
   }
}

/*=====TESTING==========

Correct Equations (Done with calculator)

2x² + 4x + 2
Roots = (-1, -1)
Discriminant = Positive
Derivative at point x = 2 : f'(2) = 12

0x² + 4x + 2

Not quadratic - N/A

1x² + 2x + 2
Roots = Complex
Discriminant = Negative
Derivative at point x = 6 : f'(6) = 14

x² - 2x + 1
Roots = (1, 1)
Discriminant = Zero
Derivative at point x = 6 : f'(6) = 10

15x² - 36x + 16
Roots = (1.81, .58)
Discriminant = Positive
Derivative at point x = 15 f'(15) = 414

Output from my code:

2x² + 4x + 2
Roots = (-1, -1)
Discriminant = Positive
Derivative at point x = 2 : f'(2) = 12

0x² + 4x + 2

Not quadratic - N/A

1x² + 2x + 2
Roots = Complex
Discriminant = Negative
Derivative at point x = 6 : f'(6) = 14

x² - 2x + 1
Roots = (1, 1)
Discriminant = Zero
Derivative at point x = 6 : f'(6) = 10

15x² - 36x + 16
Roots = (1.81, .58)
Discriminant = Positive
Derivative at point x = 15 f'(15) = 414

*/