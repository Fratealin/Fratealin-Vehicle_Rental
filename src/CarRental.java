import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by A.Dungca on 28/10/2020
 * Car subclass for a vehicle rental program
 */
public class CarRental extends VehicleRental {

   //import Scanner class
   Scanner keyboard = new Scanner(System.in);
   //import Decimal Format class
   DecimalFormat df = new DecimalFormat("0.00");

   //variables unique to CarRental class
   private static int countCarsRented=0;
   private int seats,doors;

   //default constructor
   public CarRental(){
   }

   //alternative constructor1
   public CarRental(String carMake,String carReg,int carMilesBefore,int lengthDays,double dailyFee,int carSeats,int carDoors){
      super(carMake,carReg,carMilesBefore,lengthDays,dailyFee);
      seats=carSeats;
      doors=carDoors;
      countCarsRented++;
   }

   //alternative constructor2
   public CarRental(String carReg,int carMilesBefore,int lengthDays,int carSeats){
      super(carReg,carMilesBefore,lengthDays);
      seats=carSeats;
      doors=0;
   }

   protected int getSeats() {
      return seats;
   }

   protected void setSeats(int carSeats) {
      seats = carSeats;
   }

   protected int getDoors() {
      return doors;
   }

   protected void setDoors(int carDoors) {
      doors = carDoors;
   }

   //adding to superclass toString
   public String toString(){
      return super.toString()+"\n"+
            "No. of seats in car: "+seats+"\n"+
            "No. of doors in car:"+doors+"\n";
   }

   //get number of car rentals
   protected static int getNumberCarRentals(){
      return countCarsRented;
   }

   //completing abstract method getVehicleType()
   protected String getVehicleType(){
      return ("This is a car rental");
   }

}//class
