//package GroupProject;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by User on 28/10/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
public class TestRental {
   public static void main(String[] args) {

      Scanner keyboard = new Scanner(System.in);
      DecimalFormat df= new DecimalFormat("0.00");

      //local insyance variables
      int endMilege;

      //update discount list
      System.out.println("Update discount list: ");
      //VehicleRental.updateDiscountList();
      //ali added automatic updateDiscountList();
      VehicleRental.autoUpdateDiscountList();

      System.out.println("======================");

      //create new carRental
      System.out.println("Create carRental1 object");
      CarRental carRental1 =new CarRental("VW", "ABC 123", 123000, 7,75.00,6,5);

      System.out.println(carRental1);

      //set end miles for car rental1
      System.out.println("Enter the end mileage for carRental1");
      endMilege = keyboard.nextInt();
      carRental1.setEndMileage(endMilege);
      System.out.println("========================");

      //print final details on return of carRental1
      System.out.println("carRental1 : Final details on return of vehicle");
      System.out.println(carRental1);

      System.out.println();
      System.out.println("====================");

      //create carRental2
      System.out.println("Create carRental2 object");
      CarRental carRental2 = new CarRental("ASCR 123", 127000, 5, 5);
      System.out.println("carRental2 details:");
      System.out.println(carRental2);

      System.out.println("Enter the end mileage for carRental2");
      endMilege = keyboard.nextInt();
      carRental2.setEndMileage(endMilege);

      //print final details on return of carRental1
      System.out.println("carRental2 : Final details on return of vehicle");
      System.out.println(carRental2);

      //create a couple of buses
      System.out.println("Instating a couple of buses and saving them to an array");

      int MAX = 10;
      MPVRental[] arrayOfBusOrders = new MPVRental[MAX];
      Random r = new Random();

      for(int i = 0; i < MAX; i++){
         // setting values
         MPVRental thisMPVOrder = new MPVRental("Mini", "asd 343", 2000, 10, 400, 8);
         thisMPVOrder.setSeats(2+r.nextInt(40));
         int endMileage = 2000 + r.nextInt(1000);
         thisMPVOrder.setEndMileage(endMileage);

         // adding it to array
         arrayOfBusOrders[i] = thisMPVOrder;

         // printing details
         System.out.println("=================");
         System.out.println("Details of bus order number " + thisMPVOrder.getRentalID());
         System.out.println(thisMPVOrder);
         thisMPVOrder.getTotalMileage();
      }

      System.out.println("Total number of buses rented " + MPVRental.getNumberBusRentals());

      // generate list of orders
      CustomerRental.generateOrders();
      //CustomerRental.displayOrders();
      CustomerRental.makeSummaryTable();

   }//main
}//class

