import java.text.DecimalFormat;

/**
 * Created by Ali Dore on 17/11/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
public class SummaryTable
{
   int totalOrders;
   int widthOfSummary = 5;
   static DecimalFormat df = new DecimalFormat("£###,##0");
   static DecimalFormat currencyFormat = new DecimalFormat("£###,##0.00");


   public void displayTable()
   {
      totalOrders = VehicleRental.Rentals.size();
      System.out.println("Orders Generated today");

      String[][] orderSummary = new String[totalOrders+1][widthOfSummary];
      // Header row
      orderSummary[0][0] = "Date";

      orderSummary[0][1] = "OrderID";
      orderSummary[0][2] = "Type";
      orderSummary[0][3] = "Total Miles Travelled";
      orderSummary[0][4] = "Total Cost";

      int row = 1;
      for (VehicleRental thisOrder : VehicleRental.Rentals)
      {
         // Print the names of files and directories
         System.out.println(thisOrder.getDateID());
            orderSummary[row][0] = thisOrder.getDateOfOrderID();
            orderSummary[row][1] = String.valueOf(thisOrder.getRentalID());
            orderSummary[row][2] = thisOrder.getRentalType();
            orderSummary[row][3] = String.valueOf(thisOrder.getTotalMileage());
            orderSummary[row][4] = String.valueOf(thisOrder.calculateTotalRentalCost());
            row ++;

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
      for (row = 1; row < totalOrders+1; row++)
      {
         // calculate totals
         totalMileage+=Integer.parseInt(orderSummary[row][3]);
         totalCost+=Double.parseDouble(orderSummary[row][4]);
         // display row
         System.out.println(orderSummary[row][0] + "\t\t\t\t" +orderSummary[row][1] + "\t" +orderSummary[row][2] + "\t" +orderSummary[row][3] + "\t" +df.format(Double.parseDouble(orderSummary[row][4])));
      }
      // display totals
      System.out.println("Total number of buses rented " + MPVRental.getNumberBusRentals());
      System.out.println("Total number of cars rented: unknown " ); // TODO:
      System.out.println("Total mileage for all vehicles rented: " + df.format(totalMileage));
      System.out.println("Total revenue from all vehicles rented: " + currencyFormat.format(totalCost));









   } // main
} // class