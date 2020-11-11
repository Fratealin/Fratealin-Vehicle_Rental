import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by Ali Dore on 29/10/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
public class CustomerRental
{
   // creating arrays to store orders in
   private static final int NUMBER_OF_BUSES = 10;
   public static MPVRental[] arrayOfBusOrders = new MPVRental[NUMBER_OF_BUSES];
   private static final int NUMBER_OF_CARS = 5;
   public static CarRental[] arrayOfCarOrders = new CarRental[NUMBER_OF_CARS];


   static DecimalFormat df = new DecimalFormat("£###,##0");
   static DecimalFormat currencyFormat = new DecimalFormat("£###,##0.00");



   public static void generateOrders()
   {
      System.out.println("======================");
      System.out.println("Running Customer Rental Class\nGenerating some orders from customer rental class");
      //update discount list
      System.out.println("Update discount list: ");
      VehicleRental.autoUpdateDiscountList();

      System.out.println("======================");

      //create a couple of buses
      System.out.println("Instating a couple of buses and saving them to an array");
      Random r = new Random();

      for(int i = 0; i < NUMBER_OF_BUSES; i++){
         // setting values
         MPVRental thisMPVOrder = new MPVRental("Bus", "Mini", "asd 343", 2000, 10, 400, 8);
         thisMPVOrder.setSeats(2+r.nextInt(40));
         int endMileage = 2000 + r.nextInt(1000);
         thisMPVOrder.setEndMileage(endMileage);

         // adding it to array
         arrayOfBusOrders[i] = thisMPVOrder;
      }
      System.out.println("======================");

      //create a couple of cars
      System.out.println("Instating a couple of car orders and saving them to an array");

      for(int i = 0; i < NUMBER_OF_CARS; i++){
         // setting values
         CarRental thisCarOrder = new CarRental("ASCR 123", 127000, 5, 4);
         thisCarOrder.setSeats(2+r.nextInt(6));
         int endMileage = 127000 + r.nextInt(1000);
         thisCarOrder.setEndMileage(endMileage);

         // adding it to array
         arrayOfCarOrders[i] = thisCarOrder;
         System.out.println(thisCarOrder);
      }
   } // generateOrders

   public static void makeSummaryTable()
   {
      int widthOfSummary = 4;
      int heightOfTable = arrayOfBusOrders.length+arrayOfCarOrders.length+1;
      String[][] orderSummary = new String[heightOfTable][widthOfSummary];
      // Header row
      orderSummary[0][0] = "OrderID";
      orderSummary[0][1] = "Type";
      orderSummary[0][2] = "Total Miles Travelled";
      orderSummary[0][3] = "Total Cost";

      // Add bus orders
      for (int row = 1; row <= arrayOfBusOrders.length; row++)
      {
         MPVRental thisMPVOrder = arrayOfBusOrders[row-1];
         orderSummary[row][0] = String.valueOf(thisMPVOrder.getRentalID());
         orderSummary[row][1] = "Bus";
         orderSummary[row][2] = String.valueOf(thisMPVOrder.getTotalMileage());
         orderSummary[row][3] = String.valueOf(thisMPVOrder.calculateTotalRentalCost());
      }

      //Add car orders
      int orderNumber = 0;
      int startRow = arrayOfBusOrders.length;
      int endRow = startRow + arrayOfCarOrders.length;
      for (int row = startRow+1; row <= endRow; row++)
      {
         CarRental thisCarOrder = arrayOfCarOrders[orderNumber];
         orderNumber++;
         orderSummary[row][0] = String.valueOf(thisCarOrder.getRentalID());
         orderSummary[row][1] = "Car";
         orderSummary[row][2] = String.valueOf(thisCarOrder.getTotalMileage());
         orderSummary[row][3] = String.valueOf(thisCarOrder.calculateTotalRentalCost());
      }

      // display summary
      System.out.println("=================");
      System.out.println("Display Summary");
      int totalMileage = 0;
      double totalCost = 0;
      // display header
      for (int col = 0; col < widthOfSummary; col++)
      {
         System.out.print(orderSummary[0][col] + "\t");
      }
      System.out.println();
      // display contents of summary table
      for (int row = 1; row < heightOfTable; row++)
      {
         // calculate totals
         totalMileage+=Integer.parseInt(orderSummary[row][2]);
         totalCost+=Double.parseDouble(orderSummary[row][3]);
         // display row
         System.out.println(orderSummary[row][0] + "\t" +orderSummary[row][1] + "\t" +orderSummary[row][2] + "\t" +df.format(Double.parseDouble(orderSummary[row][3])));
      }
      // display totals
      System.out.println("Total number of buses rented " + MPVRental.getNumberBusRentals());
      System.out.println("Total number of cars rented " + arrayOfCarOrders.length);
      System.out.println("Total mileage for all vehicles rented: " + df.format(totalMileage));
      System.out.println("Total revenue from all vehicles rented: " + currencyFormat.format(totalCost));
   }

   public static void displayOrders(){

      for(int i = 0; i < NUMBER_OF_BUSES; i++){

         MPVRental thisMPVOrder = arrayOfBusOrders[i];
         // adding it to array

         // printing details
         System.out.println("=================");
         System.out.println("Details of bus order number " + thisMPVOrder.getRentalID());
         System.out.println(thisMPVOrder);
      }
      System.out.println("Total number of buses rented " + MPVRental.getNumberBusRentals());
      System.out.println("Total number of cars rented " + CarRental.getNumberCarRentals());
   }

} // class