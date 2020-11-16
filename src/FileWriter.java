import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Ali Dore on 16/11/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
public class FileWriter
{
   static String fileName;
   static String filePath = "order_receipts";
   private static void create()
   {
      try {
         File file = new File(fileName);
         file.createNewFile();
      } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
   }

   public static void createFolder()
   {
      File theDir = new File(filePath);
      if (!theDir.exists()){
         theDir.mkdirs();
      }
   }

   public static void getAllReceipts()
   {
      Scanner keyboard = new Scanner(System.in);

      System.out.println("Historical Orders on our system");
      File theDir = new File(filePath);
      if (!theDir.exists()){
         System.out.println("No Orders");
      }


      else{
         System.out.println("Enter number of order you'd like to see");
         String[] orders;
         // Creates a new File instance by converting the given order file string
         // into an abstract pathname
         File f = new File(filePath);

         // Populates the array with names of files and directories
         orders = f.list();

         // For each pathname in the pathnames array
         int i = 0;
         for (String pathname : orders)
         {
            // Print the names of files and directories
            System.out.println(i + "\t" + pathname);
            i++;
         }
         int index = keyboard.nextInt();
         String wantedFilename = orders[index];
         fileName = filePath + "/" + wantedFilename;
         System.out.println(read());
      }
   }

   public static void write(VehicleRental vehicleRental)
   {
      createFolder();

      // TODO: You will probably have to change the / to \ to work on windows
      fileName = String.format("%s/%s_receipt_%s.txt", filePath, vehicleRental.getRentalType(), vehicleRental.getdateID());
      //fileName = "receipt_" + vehicleRental.getdateID() + ".txt";
      create();

      try {
         java.io.FileWriter myWriter = new java.io.FileWriter(fileName);

         myWriter.write(String.valueOf(vehicleRental));

         myWriter.close();
      } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
   }

   public static String read()
   {
      String text = "";

      try
      {
         File file = new File(fileName);
         Scanner myReader = new Scanner(file);


         while (myReader.hasNextLine())
         {
            text += myReader.nextLine() + "\n";
         }

         myReader.close();
         return text;
      } catch (FileNotFoundException e)
      {
         System.out.println("An error occurred.");
         e.printStackTrace();
         e.getMessage();
      }
      return text;
   }
}