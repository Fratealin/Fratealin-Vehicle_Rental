package Group3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Ali Dore on 16/11/2020. Amended by A.Dungca 17/11
 * Reading and writing text file, gets a list of orders created
 */
public class FileManager {
   static String fileName;
   static String filePath = "order_receipts";

   private static void create() {
      try {
         File file = new File(fileName);
         file.createNewFile();
      } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
   }

   public static void createFolder() {
      File theDir = new File(filePath);
      if (!theDir.exists()) {
         theDir.mkdirs();
      }
   }

   public static void getAllReceipts() {
      Scanner keyboard = new Scanner(System.in);

      System.out.println("\nHistorical Orders on our system\n===========================\n");
      File theDir = new File(filePath);
      if (!theDir.exists()) {
         System.out.println("No Orders");
      } else {
         System.out.println("Enter number of order you'd like to see");
         String[] orders;
         // Creates a new File instance by converting the given order file string
         // into an abstract pathname
         File f = new File(filePath);

         // Populates the array with names of files and directories
         orders = f.list();

         // For each pathname in the pathnames array
         int i = 0;
         for (String pathname : orders) {
            // Print the names of files and directories
            System.out.println(i + "\t" + pathname);
            i++;
         }

         int index;
         String wantedFilename;
         do {
            try {

               index = ErrorHandler.getIntegerInput();

               wantedFilename = orders[index];

            } catch (ArrayIndexOutOfBoundsException e) {
               System.out.println(e.getMessage());
               System.out.println("Please try again");
               VehicleRental.keyboard.next(); // reset scanner otherwise enters infinite loop.
               continue;

            }
            break; // need this to leave do loop if try successful
         } while (true);

         //wantedFilename = orders[3];

         fileName = filePath + "/" + wantedFilename;
         System.out.println(read());
      }
   }

   public static void write(VehicleRental vehicleRental) {
      createFolder();

      fileName = String.format("%s/%s_receipt_%s_%s.txt", filePath, vehicleRental.getRentalType(), vehicleRental.getDateID(), vehicleRental.getRentalID());

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

   public static String read() {
      String text = "";

      try {
         File file = new File(fileName);
         Scanner myReader = new Scanner(file);

         while (myReader.hasNextLine()) {
            text += myReader.nextLine() + "\n";
         }

         myReader.close();
         return text;
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
         e.getMessage();
      }
      return text;
   }
}//class