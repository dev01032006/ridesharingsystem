import java.util.*;

class InvalidRideTypeException extends Exception {
    public InvalidRideTypeException(String message) {
        super(message);
    }
}


abstract class Ride{
    private String driverName;
    private String vehicleNumber;
    protected double distance;

    public Ride(String driverName, String vehicleNumber, double distance) {
        this.driverName = driverName;
        this.vehicleNumber = vehicleNumber;
        this.distance = distance;
    }


public String getDriverName(){
    return driverName;
}

public String getVehicleNumber(){
    return vehicleNumber;
}

public double getDistance(){
    return distance;
}

public abstract double calculateFare();

public void displayDetails() {
    System.out.println("Driver: " + driverName);
    System.out.println("Vehicle No: " + vehicleNumber);
    System.out.println("Distance: " + distance + " km");
    System.out.println("Fare: ₹" + calculateFare());
    }
}

class BikeRide extends Ride{
    public BikeRide(String driverName,String vehicleNumber,double distance){
        super(driverName,vehicleNumber,distance);
    }
    @Override
    public double calculateFare() {
        return distance * 10;
    }
}

    
class CarRide extends Ride {
    public CarRide(String driverName, String vehicleNumber, double distance) {
        super(driverName, vehicleNumber, distance);
    }
    
    @Override
    public double calculateFare() {
        return distance * 20;
    }
}

public class RideSharingSystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        try{
            System.out.print("Enter ride type (bike or car): ");
            String rideType = sc.nextLine().trim().toLowerCase();

            System.out.print("Enter distance in kilometers: ");
            double distance = sc.nextDouble();
            
            if (distance <= 0) {
                System.out.println("Error: Distance must be greater than 0");
                return;
            }
            Ride ride;
            String driverName;
            String vehicleNumber;

            if (rideType.equals("bike")) {
                driverName = "Rajesh Kumar";
                vehicleNumber = "KA01AB1234";
                ride = new BikeRide(driverName, vehicleNumber, distance);
            } 
            else if (rideType.equals("car")) {
                driverName = "Mohan Singh";
                vehicleNumber = "KA02CD5678";
                ride = new CarRide(driverName, vehicleNumber, distance);
            }
            else {
                throw new InvalidRideTypeException("Invalid ride type. Please enter 'bike' or 'car'");
            }

            ride.displayDetails();


        }
        catch(InvalidRideTypeException e){
            System.out.println("Error: "+e.getMessage());

        }
        catch(Exception e){
            System.out.println("Error Invalide input. PLease enter valid date");

        }
        finally{
            sc.close();
        }
    }
}