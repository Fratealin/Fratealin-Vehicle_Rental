import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by P.Donnelly on 29/10/2020
 * Car subclass for a vehicle rental program
 */
public class HGVRental extends VehicleRental {

   //import Scanner class
   Scanner keyboard = new Scanner(System.in);
   //import Decimal Format class
   DecimalFormat df = new DecimalFormat("0.00");

   //variables unique to HGVRental class
   private static int countHGVRented=0;
   private double height, loadCapacity;

   //default constructor
   public HGVRental(){
   }//end default constructor

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
   protected double getLoadCapacity() {
      return loadCapacity ;
   }//end getLoadCapacity()

   //method to setLoadCapacity
   protected void setLoadCapacity(double maxLoad) {
      loadCapacity =maxLoad;
   }//end setLoadCapacity


   //method to get height of HGV
   protected double getHeight() {
      return height;
   }//end getHeight()


   //method to set height of HGV
   protected void setHeight(double HGVHeight) {
      height = HGVHeight;
   }//end setHeight

   //adding to superclass toString
   public String toString(){
     String message="";
      message= super.toString()+"\n";
           if(height==-999.9){
              message= message +"\nThe maximum height of the HGV is: Not declared";
           }//end if
           else{
              message=message+ "\nThe maximum height of the HGV is: "+df.format(height)+" metres "+"\n";
           }//end else
           if (loadCapacity==-999.9){
              message = message+ "\nLoad capacity of the HGV is: Not declared ";
           }//end if
           else{
              message=message+ " \nThe maximum working load capacity of the HGV is: "+df.format(loadCapacity)+"kg"+"\n";
           }//end else
         return message;
   }//end toString

   //get number of HGV rentals
   protected static int getNumberCarRentals(){
      return countHGVRented;
   }//end getNumberHGVRentals

   //completing abstract method getVehicleType()
   protected String getVehicleType(){
      return ("This is a HGV rental");
   }//end abstract method - getVehicleType

}//class