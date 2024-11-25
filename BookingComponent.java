package booking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookingComponent {
    private List<Driver> drivers = new ArrayList<>();

    public void addDriver(String location, double rating, String vehicleType) {
        drivers.add(new Driver(location, rating, vehicleType));
    }

    public List<Driver> searchAndSortDriversByRating() {
        drivers.sort(Comparator.comparingDouble(d -> -d.rating));
        return drivers;
    }

    public static class Driver {
        String location;
        double rating;
        String vehicleType;

        public Driver(String location, double rating, String vehicleType) {
            this.location = location;
            this.rating = rating;
            this.vehicleType = vehicleType;
        }

        @Override
        public String toString() {
            return "Driver{" + "location='" + location + '\'' + ", rating=" + rating + ", vehicleType='" + vehicleType + '\'' + '}';
        }
    }
}
