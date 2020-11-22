package Group3;

/**
 * Created by Ali Dore on 22/11/2020
 * COMMENTS ABOUT PROGRAM HERE
 */
public class TestSummary
{
   public static void main(String[] args)
   {
      MPVRental testBus = new MPVRental("MPV", "Lada", "MNV 153Y", 1000,
            5, 75, 12);
      testBus.setEndMileage(1100);
      VehicleRental.Rentals.add(testBus);
      VehicleRental.RentalsID.add(testBus.getRentalID());

      HGVRental testHGV=new HGVRental("HGV","Skoda","MNV 153Y",1000,5,50,5,100);
      testHGV.setEndMileage(1100);
      //adding created object to arraylist
      VehicleRental.Rentals.add(testHGV);
      //adding rental ID to Parralell arraylist
      VehicleRental.RentalsID.add(testHGV.getRentalID());

      CarRental testCar = new CarRental("Car", "Mini","MNV 153Y",500,4,40, 6, 5);
      testCar.setEndMileage(750);
      VehicleRental.Rentals.add(testCar);
      VehicleRental.RentalsID.add(testCar.getRentalID());

      MPVRental testBus2 = new MPVRental("MPV", "Lada", "MNV 153Y", 1000,
            5, 75, 12);
      VehicleRental.Rentals.add(testBus2);
      VehicleRental.RentalsID.add(testBus2.getRentalID());

      SummaryTable.displaySummary();


   } // main
} // class