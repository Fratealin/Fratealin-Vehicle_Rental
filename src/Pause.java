/**
 * Created by Ali Dore on 17/11/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Pause
{

   public static void scrollPrint(String myString){
      // Prints in a scroll
      char[] letters = myString.toCharArray();
      for (char l : letters)
      {
         System.out.print(l);
         pause(0.02
         );
      }
   }

   public static void pause(double secs)
   {
      try
      {
         Thread.sleep((long)(secs*1000));
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      }

   } // main
} // class