import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Ali Dore on 17/11/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
public class ErrorHandler
{
   public static int getIntegerInput()
   {
      Scanner myScanner = new Scanner(System.in);
      int thisInt;
      do
      {
         try
         {
            thisInt = myScanner.nextInt();
            System.out.println(thisInt);
         }


         catch (InputMismatchException e)
         {
            System.out.println(e.getMessage());
            System.out.println("You typed in text. Please try again");
            myScanner.next(); // reset scanner otherwise enters infinite loop.
            continue; // will go again until doesn't cause error
         }


         System.out.println("Try was successfull");
         return thisInt; // will leave do loop if try successful
      } while (true);
   }

} // class