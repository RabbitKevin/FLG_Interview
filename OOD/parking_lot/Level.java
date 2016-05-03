public class Level {

    private int floor;//the # of floor
    private ParkingSpot[] parkingspots;
    private int availableSpots = 0;
    private final int SPOTS_PER_ROW = 10;

    public Level(int flr, int numberSpots) {

    }

    public int availableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        return false;
    }

    private boolean parkStartAt(int num, Vehicle vehicle) {
        return false;
    }

    private int findAvailableSpot(Vehicle vehicle) {

    }

    public void spotFreed() {
        availableSpots++;
    }
}
