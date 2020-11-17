/**
 * Created by Ali Dore on 17/11/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Pause
{
   public static void pause(int secs)
   {
      try
      {
         Thread.sleep(secs*1000);
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      }

   } // main
} // class