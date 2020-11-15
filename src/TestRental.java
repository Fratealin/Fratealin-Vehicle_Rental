//package GroupProject;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by User on 28/10/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
public class TestRental {

   private static void pause()
   {
      System.out.println("Pausing to let you see it.");
      try
      {
         Thread.sleep(2000);
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   } // pause



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


      System.out.println();

      CarRental testCar = new CarRental();

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

      System.out.println("printing type");
      System.out.println(carRental1.getRentalType());

      System.out.println();
      System.out.println("====================");

      System.out.println();

      //create carRental2
      System.out.println("Create carRental2 object");
      CarRental carRental2 = new CarRental("ASCR 123", 127000, 5, 5);
      System.out.println("carRental2 details:");
      System.out.println(carRental2);

      System.out.println("Enter the end mileage for carRental2");
      endMilege = keyboard.nextInt();
      carRental2.setEndMileage(endMilege);

      //print final details on return of carRental2
      System.out.println("carRental2 : Final details on return of vehicle");
      System.out.println(carRental2);


      // Code to create objects for Aldrians search class

      // create HGV object
      HGVRental hgvRental1 = new HGVRental("HGV","HGV Make","RAD 945",1000,10,400);
      System.out.println("Here is and HGV");
      System.out.println(hgvRental1);

      pause();


      MPVRental mpvRental1=new MPVRental("MPV","Ford","POP 345",2000,10,500,15);
      //set end miles for MPV rental1
      System.out.println("Enter the end mileage for MPVrental1");
      endMilege = keyboard.nextInt();
      mpvRental1.setEndMileage(endMilege);
      System.out.println("========================");


      //automate appending
      VehicleRental[] rentalsArray= {carRental1,carRental2, mpvRental1, hgvRental1};

      int choice;
      //String yesOrNo;

      Scanner scanner = new Scanner(System.in);

      System.out.println("Your Options (please enter a number):");
      System.out.println("1. Search By Rental Type  \n2. Search all rentals");

      choice = scanner.nextInt();

      switch (choice)
      {
         case 1:
            Search.searchByType(rentalsArray);
            break;

         case 2:
            Search.searchAllRentals(rentalsArray);
            break;
      }

      pause();

      String a = scanner.nextLine();
      // end of search


      //create an array of buses
      System.out.println("Instating an array of buses and saving them to an array");

      int MAX = 10;
      MPVRental[] arrayOfBusOrders = new MPVRental[MAX];
      Random r = new Random();

      for(int i = 0; i < MAX; i++){
         // setting values
         MPVRental thisMPVOrder = new MPVRental("Bus","Mini", "asd 343", 2000, 10, 400, 8);
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

