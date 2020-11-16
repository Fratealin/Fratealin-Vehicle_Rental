//package GroupProject;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by P.Donnelly on 29/10/2020
 * Car subclass for a vehicle rental program
 */
public class HGVRental extends VehicleRental {

   //import Scanner class
   static Scanner keyboard = new Scanner(System.in);
   //import Decimal Format class
   DecimalFormat df = new DecimalFormat("0.00");

   //variables unique to HGVRental class
   protected static int countHGVRented=0;
   private static double height, loadCapacity;

   //default constructor
   public HGVRental(){
   }//end default constructor

   //added constructor which accepts type only
   public HGVRental(String type){

   }//end alternative constructor

   //alternative constructor
   public HGVRental(String HGVType,String HGVMake,String HGVReg,int HGVMilesBefore,int lengthDays,double dailyFee,double
         HGVheight,double HGVloadCapacity ){
      super(HGVType,HGVMake,HGVReg,HGVMilesBefore,lengthDays,dailyFee);
      height=HGVheight;
      loadCapacity=HGVloadCapacity;
      countHGVRented++;
   }//end alternative constructor

   //alternative constructor
   public HGVRental(String HGVType, String HGVMake, String HGVReg,int HGVMilesBefore,int lengthDays, double dailyFee){
      super(HGVType, HGVMake, HGVReg,HGVMilesBefore,lengthDays, dailyFee);
      height=-999.9;
      loadCapacity=-999.9;
      countHGVRented++;
   }//end alternative constructor

   //method to get load capacity
   protected static double getLoadCapacity() {
      return loadCapacity ;
   }//end getLoadCapacity()

   //method to setLoadCapacity
   protected static void setLoadCapacity(double maxLoad) {
      loadCapacity =maxLoad;
   }//end setLoadCapacity


   //method to get height of HGV
   protected static double getHeight() {
      return height;
   }//end getHeight()


   //method to set height of HGV
   protected static void setHeight(double HGVHeight) {
      height = HGVHeight;
   }//end setHeight

   //adding to superclass toString
   public String toString(){
      String message="";
      message= super.toString()+"\n";
      if(height==-999.9){
         message= message +"The maximum height of the HGV is: Not declared\n";
      }//end if
      else{
         message=message+ "The maximum height of the HGV is: "+df.format(height)+" metres "+"\n";
      }//end else
      if (loadCapacity==-999.9){
         message = message+ "Load capacity of the HGV is: Not declared\n ";
      }//end if
      else{
         message=message+ "The maximum working load capacity of the HGV is: "+df.format(loadCapacity)+"kg"+"\n";
      }//end else
      return message;
   }//end toString

   //get number of HGV rentals
   protected static int getNumberCarRentals(){
      return countHGVRented;
   }//end getNumberHGVRentals

   //completing abstract method getVehicleType()
   protected String getVehicleType(){
      return ("HGV");
   }//end abstract method - getVehicleType

   //method called from main menu to create HGV Order - created by Patrick 11/11/20
 /*  public static void createHGVOrder(){

      String make, reg, Type;
      int beforeMiles, numDays;
      double dailyFee;

      double height, loadCapacity;

      System.out.println("Please enter make:");
      make = keyboard.nextLine();
      //VehicleRental.setMake(make);
      keyboard.nextLine();
      System.out.println();
      System.out.println("Please enter Registration number:");
      reg =keyboard.nextLine();
      //VehicleRental.setRegNum(reg);
      System.out.println();
      System.out.println("Please enter Start Miles:");
      beforeMiles = keyboard.nextInt();
      //VehicleRental.setStartMileage(beforeMiles);
      //VehicleRental.setEndMileage(endMiles);
      System.out.println();
      System.out.println("Please enter length of rental (number of days):");
      numDays= keyboard.nextInt();
      //VehicleRental.setNumDays(numDays);
      System.out.println();
      String type = "HGV";
      System.out.println("Please enter Daily Fee (Â£):");
      dailyFee = keyboard.nextDouble();
      //VehicleRental.setDailyCost(dailyFee);
      System.out.println();
      System.out.println("Please enter the height of the HGV: (m) ");
      height = keyboard.nextDouble();
      //HGVRental.setHeight(height);
      System.out.println();
      System.out.println("Please enter the Load Capacity of the HGV: (kg) ");
      loadCapacity = keyboard.nextDouble();
      //HGVRental.setLoadCapacity(loadCapacity);

      HGVRental thisHGVOrder = new HGVRental(type, make, reg, beforeMiles, numDays,dailyFee);
      Rentals.add(thisHGVOrder);
      RentalsID.add(thisHGVOrder.getRentalID());

      System.out.println(thisHGVOrder);

      MainMenu.mainMenu();

   }//end createHGVOrder*/

}//class