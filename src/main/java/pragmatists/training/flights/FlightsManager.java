package pragmatists.training.flights;

import java.util.ArrayList;
import java.util.List;

public class FlightsManager {

    private final List<Flight> flights;

    public FlightsManager(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> fromOrigin(String origin) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.origin.equals(origin)) {
                result.add(flight);
            }
        }
        return result;
    }

}
