import java.util.*;
import java.math.*;
public class NoteTester
{
    public static void main(String[] args)
    {
      //Declare variables to hold user input
      int noteValue;
      String noteLength;
      int tempLength;
      
      //Create scanner object to hold user input
		Scanner userInput = new Scanner(System.in);
		
		//Retrieve starting value from user
		System.out.println("Please enter a value for your note\n"+
                         "between -48 and 39:");
      noteValue = userInput.nextInt();
      
      //While loop ensures a valid number
      while(noteValue < -48 || noteValue > 39)
      {
         System.out.println("Please enter a valid value for your note\n"+
                            "between -48 and 39:");
         noteValue = userInput.nextInt();
      }
      
      
      //Retrieve starting length from user
      System.out.println("Please enter the number between 1-5\n" +
                         "you would like to represent\n" +
                         "the length of your note.\n"+
                         "1. Whole\n" +
                         "2. Half\n" +
                         "3. Quarter\n" +
                         "4. Eighth\n" +
                         "5. Sixteenth");
      tempLength = userInput.nextInt();
      
      //While loop ensures a valid length
      while(tempLength > 5 || tempLength < 1)
      {
         System.out.println("Please enter the number between 1-5\n" +
                         "you would like to represent\n" +
                         "the length of your note.\n"+
                         "1. Whole\n" +
                         "2. Half\n" +
                         "3. Quarter\n" +
                         "4. Eighth\n" +
                         "5. Sixteenth");
         tempLength = userInput.nextInt();                
      }
      //Create demoNote object
      Note demoNote = new Note(noteValue, tempLength);
      
      
      //Print user the information about their note
      System.out.print("Your value was " + demoNote.getValue() + ", your length was a(n) " + demoNote.getLengthString()
                       + " note, your note's \nletter value was " + demoNote.getLetter() + " which is a " + 
                       demoNote.getSharp() + " note. \nThe frequency of your" +
                        " note is " + demoNote.getFreq() + " hz." );
      //This portion of the program creates a list of Note objects
      //and sorts them
      Note other = new Note(-35, 1); 
      Note other1 = new Note(4, 1);
      Note other2 = new Note(16, 4);
      Note other3 = new Note(-34, 5);
      Note[] notes = {demoNote,other,other1,other2,other3};
      Arrays.sort(notes);
      System.out.println("\nHere is a list of notes sorted by length, then by frequency: ");
      for(int i = 0; i < notes.length; i++)
      {
         System.out.println(notes[i].toString());
      }
     
    
    }
}        


class Note implements Comparable<Note>
{
   /*Declare variables privately so they cannot be accessed from outside the class. Set the value default
   to middle C and the length default to quarter.*/
   private int value = 0;
   private int length = 3;
   private String letter;
   private String sharp;
   private double freq;
   
   //Comparable method
   public int compareTo(Note other)
   {
      if(getLength() > other.getLength())
      {
         return 1;
      }
      else if(getLength() < other.getLength())
      {
         return -1;
      }
      else if(getFreq() < other.getFreq())
      {
         return 1;
      }
      else if(getFreq() > other.getFreq())
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
    * @param value the note's starting value
    * @param length the note's starting length 
    */
   public Note(int value, int length)
   {
      this.value = value;
      this.length = length;
   }
      
   //Setters
   
   /**
    * Assigns this.value to variable value
    */
   void setValue(int value)
   {
      this.value = value;
   }
   
   /**
    * Assigns this.length to variable length
    */ 
   void setLength(int x)
   {
      this.length = length;
   }
   
   //Getters
   
   /**
    * @return The value of the note
    */
   public double getValue()
   {
      return value;
   }
   
   /**
    * @return The length of the note
    */ 
   public int getLength()
   {
      return length;
   }
   
   /**
    * @return The letter of the chromatic scale the value is assigned to
    */
   public String getLetter()
   {
      switch(value % 12)
      {
         case 0 :
            letter = "A";
            break;
         case 1 :
            letter = "A#";
            break;
         case 2 :
            letter = "B";
            break;
         case 3 :
            letter = "C";
            break;
         case 4 :
            letter = "C#";
            break;
         case 5 :
            letter = "D";
            break;
         case 6 :
            letter = "D#";
            break;
         case 7 :
            letter = "E";
            break;
         case 8 :
            letter = "F";
            break;
         case 9 :
            letter = "F#";
            break;
         case 10 :
            letter = "G";
            break;
         case 11 :
            letter = "G#";
            break;
         case -1 :
            letter = "A#";
            break;
         case -2 :
            letter = "B";
            break;
         case -3 :
            letter = "C";
            break;
         case -4 :
            letter = "C#";
            break;
         case -5 :
            letter = "D";
            break;
         case -6 :
            letter = "D#";
            break;
         case -7 :
            letter = "E";
            break;
         case -8 :
            letter = "F";
            break;
         case -9 :
            letter = "F#";
            break;
         case -10 :
            letter = "G";
            break;
         case -11 :
            letter = "G#";
            break;   
         default :
            letter = "Invalid";
     
      }
      return letter;
   }   

   /**
    * @return Whether or not the note is sharp
    */   
   public String getSharp()
   {
      switch(value % 12)
      {
         case 0 :
            sharp = "natural";
            break;
         case 1 :
            sharp = "sharp";
            break;
         case 2 :
            sharp = "natural";
            break;
         case 3 :
            sharp = "natural";
            break;
         case 4 :
            sharp = "sharp";
            break;
         case 5 :
            sharp = "natural";
            break;
         case 6 :
            sharp = "sharp";
            break;
         case 7 :
            sharp = "natural";
            break;
         case 8 :
            sharp = "natural";
            break;
         case 9 :
            sharp = "sharp";
            break;
         case 10 :
            sharp = "natural";
            break;
         case 11 :
            sharp = "sharp";
            break;
         case -1 :
            sharp = "sharp";
            break;
         case -2 :
            sharp = "natural";
            break;
         case -3 :
            sharp = "natural";
            break;
         case -4 :
            sharp = "sharp";
            break;
         case -5 :
            sharp = "natural";
            break;
         case -6 :
            sharp = "sharp";
            break;
         case -7 :
            sharp = "natural";
            break;
         case -8 :
            sharp = "natural";
            break;
         case -9 :
            sharp = "sharp";
            break;
         case -10 :
            sharp = "natural";
            break;
         case -11 :
            sharp = "sharp";
            break;
   
         default :
            letter = "Invalid";
       } 
      return sharp;  
   }
   
  /**
    * @return The frequency of the note
    */   
   public double getFreq()
   {
      freq = (440 * Math.pow(2, value / 12.0));
      return freq;
   }
   public String getLengthString()
   {
      if(getLength() == 1)
      {
         return "whole";
      }
      else if(getLength() == 2)
      {
         return "half";
      }
      else if(getLength() == 3)
      {
         return "quarter";
      }
      else if(getLength() == 4)
      {
         return "eighth";
      }
      else if(getLength() == 5)
      {
         return "sixteenth";
      }
      else
      {
         return "Invalid";
      }
   }   
   
   //ToString to print notes
   public String toString()
   {
      return "(Length :: " + getLengthString() + " Frequency :: " + getFreq() + ")";
   }
}
/*=====TESTING==========

Correct Notes

1.
Input
Value = 0
Length = 1

Output

Letter = A
SharporNat = Natural
Freq = 440 hz
Length = Whole

2.
Input
Value = 15
Length = 3

Output

Letter = C
SharporNat = Natural
Freq = 1046.50
Length = Quarter

3.
Input
Value = -25
Length = 5

Output
Letter = G#
SharporNat = Sharp
Freq = 103.826
Length = Sixteenth

Test Notes (What came out of my program)

1.
Letter = A
SharporNat = Natural
Freq = 440
Length = Whole

2.
Letter = C
SharporNat = Natural
Freq = 1046.50
Length = Quarter

3.
Letter = G#
SharporNat = Sharp
Freq = 103.826
Length = Sixteenth

All test results were the same as the correct results done by an external calculator.
==========================*/