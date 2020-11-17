//package GroupProject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by a1054125 on 13/11/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
public class TestRental_Aldrian {

   static Scanner keyboard = new Scanner(System.in);

   public static void createHGVOrder(){

      String make, reg, Type;
      int beforeMiles, numDays;
      double dailyFee;

      double height, loadCapacity;

      System.out.println("Please enter make:");
      make = keyboard.next();
      keyboard.nextLine();
      System.out.println();
      System.out.println("Please enter Registration number:");
      reg =keyboard.nextLine();
      System.out.println();
      System.out.println("Please enter Start Miles:");
      beforeMiles = keyboard.nextInt();
      System.out.println();
      System.out.println("Please enter length of rental (number of days):");
      numDays= keyboard.nextInt();
      System.out.println();
      String type = "HGV";
      System.out.println("Please enter Daily Fee (£):");
      dailyFee = keyboard.nextDouble();
      System.out.println();
      System.out.println("Please enter the height of the HGV: (m) ");
      height = keyboard.nextDouble();
      System.out.println();
      System.out.println("Please enter the Load Capacity of the HGV: (kg) ");
      loadCapacity = keyboard.nextDouble();

      HGVRental thisHGVOrder = new HGVRental(type, make, reg, beforeMiles, numDays,dailyFee,height,loadCapacity);
      VehicleRental.Rentals.add(thisHGVOrder);
      VehicleRental.RentalsID.add(thisHGVOrder.getRentalID());

      // Write file using dateID
      FileWriter.write(thisHGVOrder);

      System.out.println("HGV RENTAL CREATED\n====================");

      System.out.println(thisHGVOrder);
      Pause.pause(3);

      mainMenu();

   }//end createHGVOrder

   //mainMenu method to provide user with options and prompts user to input data via Keyboard
   protected static void mainMenu(){
      int choice;
      int id;

      System.out.println("Vehicle Rentals");
      System.out.println("===============");
      System.out.println();
      System.out.println("What would you like to do?");
      System.out.println();
      System.out.println("Your Options (please enter a number):");
      System.out.println("1. Make a single Vehicle rental order \n2. Make a multi-Vehicle (fleet) Vehicle Rental order  \n3. Search " +
            "existing orders \n4. Log details of a returned vehicle \n" +
            "5. Update Discount List \n6. Display number of rental orders \n7. Print Summary list of all rentals " +
            "\n8. Display Total Revenue\n9. Access rental receipts on our database\n0. Quit?");

      choice = ErrorHandler.getIntegerInput();

      switch (choice) {
         case 1:
            System.out.println();
            System.out.println("Create a Rental order");
            System.out.println("===============");
            System.out.println("What type of vehicle rental order would you like to make?:");
            System.out.println("1. Car\n2. MPV\n3. HGV");

            choice=keyboard.nextInt();

            //nested switch statement - Create order
            switch (choice){
               case 1:
                  CarRental.makeCarOrder();
                  break;
               case 2:
                  MPVRental.testBusOrder();
                  break;
               case 3:
                  TestRental_Aldrian.createHGVOrder();
                  break;
            }//end nested switch statement / Create order
            break;

         case 2:
            System.out.println();
            System.out.println("Create a multi-vehicle (fleet) rental order");
            System.out.println("===========================================");
            //Ali - we can call your generateOrders() here.

         case 3:

            //nested switch statement - Search
            System.out.println();
            System.out.println("Search Vehicles");
            System.out.println("===============");
            System.out.println("Your Options (please enter a number):");
            System.out.println("1. Search By Rental Type  \n2. Search all rentals");

            choice = keyboard.nextInt();

            switch (choice)
            {
               case 1:
                  searchByType(VehicleRental.Rentals);
                  break;

               case 2:
                  searchAllRentals(VehicleRental.Rentals);
                  break;
            }//end nested switch statement - Search
            break;
         case 4:
            System.out.println();
            System.out.println("Return a Vehicle");
            System.out.println("================");
            System.out.println("Please enter the Vehicle rental ID you wish to return:");
            id = keyboard.nextInt();
            VehicleRental.returnVehicle(id);
            break;
         case 5:
            VehicleRental.autoUpdateDiscountList();
            break;
         case 6:
            System.out.println("Number of Vehicle Rentals");
            System.out.println("=========================");
            System.out.println(("Your Options (please enter a number):"));
            System.out.println("1. Number of Car rentals  \n2. Number of MPV rentals \n3. Number of HGV rentals " +
                  "\n4. Total number of rentals");

            choice = keyboard.nextInt();

            //nested switch - Vehicle counts
            switch (choice){


               case 1:
                  System.out.println();
                  System.out.println("Total number of car rentals: " + CarRental.getNumberCarRentals() );
                  mainMenu();
                  break;
               case 2:
                  System.out.println();
                  System.out.println("Total number of MPV rentals: " + MPVRental.getNumberBusRentals() );
                  mainMenu();
                  break;
               case 3:
                  System.out.println();
                  System.out.println("Total number of HGV rentals: " + HGVRental.countHGVRented );
                  mainMenu();
                  break;
               case 4:
                  System.out.println();
                  System.out.println("Total number of Vehicle rentals: " + VehicleRental.countVehiclesRented );
                  mainMenu();
                  break;
            }//end nested Switch - Vehicle counts
            break;

         case 7:
            System.out.println();
            System.out.println("Summary of Rentals");
            System.out.println("==================");
            System.out.println("Summary of all Vehicle rental Orders: " );// Ali - this is where we can call your Summary table;
            SummaryTable ourTable = new SummaryTable();
            ourTable.displayTable();
            Pause.pause(3);

            mainMenu();
            break;
         case 8:
            System.out.println();
            System.out.println("Total Revenue");
            System.out.println("=============");
            System.out.println("Total revenue generated from all rentals(£): "+ VehicleRental.totalRevenue);
            mainMenu();
            break;
         case 9:
            FileWriter.getAllReceipts();
            Pause.pause(3);
            mainMenu();
            break;
         case 0:
            System.out.println("Quitting program.\nThank you.\nGoodbye");
            break;
         default:
            // added for the case there is no match
            // other wise it just ends the program
            // this dispalys the menu again. which is not ideal. But I've no ideas
            mainMenu();

      }//end switch

   }//end main menu()

   public static void searchByType(ArrayList<VehicleRental> Rentals)
   {

      Scanner userInput = new Scanner(System.in);
      String rentalType = "";

      System.out.println("What type of rental type would you like to see? (Enter a number): 1. Car, 2. MPV, 3. HGV.");
      int userChoiceType = userInput.nextInt();

      if (userChoiceType == 1)
      {
         rentalType = "Car";
      }
      else
      {
         if (userChoiceType == 2)
         {
            rentalType = "MPV";
         } else
         {
            rentalType = "HGV";
         }
      }

      System.out.println("Full Rental Details (by type)");
      System.out.println("=============================");
      System.out.println("\nThese are all the rental orders on our system for your search type");

      for (int i = 0; i < Rentals.size(); i++) {
         System.out.println();
         if (rentalType.equals(Rentals.get(i).getRentalType()))
         {
            System.out.println(Rentals.get(i));

         }

      }
      mainMenu();
   }

   //method for search for all rentals
   public static void searchAllRentals(ArrayList<VehicleRental> Rentals) {

      System.out.println("Full Rental Details");
      System.out.println("===================");
      System.out.println("\nThese are all the rental orders in our system: ");

      for(int i = 0; i < Rentals.size(); i++) {
         System.out.println();
         System.out.println(Rentals.get(i));
         // mainMenu();
         System.out.println();
      }
      mainMenu();
      System.out.println();
   }





   public static void main(String[] args) {

      //creating discount rates
      System.out.println();
      System.out.println("Vehicle Rentals");
      System.out.println("===============");
      System.out.println();
      System.out.println("Before you begin, please press enter update the systems discount list\n ");
      keyboard.nextLine();
      VehicleRental.autoUpdateDiscountList();

      mainMenu();


   }//main
}//class