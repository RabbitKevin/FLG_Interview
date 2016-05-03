public enum VehicleSize {Motorcycle, Compact, Large}
public abstract class Vehicle{
    //collection of parking spot used
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    //---------------------------//
    public int getSpotNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void parkInSpot(ParkingSpot s) {
        parkingSpots.add(s);
    }

    public void clearSpot();

    public abstract boolean canFitInSpot(ParkingSpot spot);
}

//----Bus extends Vehicle
/*
    Design of Parkinglot
*/
