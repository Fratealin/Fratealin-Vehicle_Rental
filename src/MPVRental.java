/**
 * Created by Ali Dore on 29/10/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Ali Dore on 29/10/2020
 * Bus subclass for a vehicle rental program
 */
public class MPVRental extends VehicleRental {

   //variables unique to BusRental class
   private static int countBusesRented=0;
   private int seats;
   // I tried to give the buses a different starting number but it didn't work
   private static int uniqueNum = 20001;

   //default constructor
   public MPVRental(){
      super();
      seats = 2;
      countBusesRented++;
   }

   //alternative constructor1
   public MPVRental(String busMake,String busReg,int busMilesBefore,int lengthDays,double dailyFee, int busSeats){
      super(busMake,busReg,busMilesBefore,lengthDays,dailyFee);
      seats=busSeats;
      countBusesRented++;
   }

   //alternative constructor2
   public MPVRental(String busReg,int busMilesBefore,int lengthDays,int busSeats){
      super(busReg,busMilesBefore,lengthDays);
      seats=busSeats;
   }

   protected int getSeats() {
      return seats;
   }

   protected void setSeats(int carSeats) {
      seats = carSeats;
   }

   //adding to superclass toString
   public String toString(){
      return super.toString()+"\n"+
            "No. of seats in bus: "+seats+"\n";
   }

   //get number of bus rentals
   protected static int getNumberBusRentals(){
      return countBusesRented;
   }

   //completing abstract method getVehicleType()
   protected String getVehicleType(){
      return ("This is a bus rental");
   }

}//class