package pragmatists.training.flights;

import static java.util.Arrays.*;
import static org.fest.assertions.Assertions.*;

import java.util.List;

import org.junit.Test;

public class ManageAirportFlights {

    private static final String WARSAW = "WAW";
    private static final String CALGARY = "Calgary";
    private static final Long CALGARY_ID = 1L;
    private static final Long WARSAW_ID = 15L;

    @Test
    public void shouldFindByOrigin() throws Exception {
        Flight fromCalgary = new FlightBuilder()
                .withNumber("1")
                .withOrigin(CALGARY_ID, CALGARY)
                .build();
        Flight fromWarsaw = new FlightBuilder()
                .withNumber("2")
                .withOrigin(WARSAW_ID, WARSAW)
                .build();
        FlightsManager flightsManager = new FlightsManager(asList(fromCalgary, fromWarsaw));

        List<Flight> flightsFromCalgary = flightsManager.fromOrigin(CALGARY);

        assertThat(flightsFromCalgary).containsOnly(fromCalgary);
    }

    private static class FlightBuilder {

        private static final long BANGALORE_ID = 0L;
        private static final String BANGALORE = "Bangalore";
        private String flightNumber = "0";
        private Long originId = BANGALORE_ID;
        private String origin = BANGALORE;
        private String destination = BANGALORE;
        private Long destinationId = 0L;
        private String airlineCode = "LOT";

        public FlightBuilder withNumber(String flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public Flight build() {
            Flight flight = new Flight(flightNumber);
            flight.setOriginId(originId);
            flight.setOrigin(origin);
            flight.setDestination(destination);
            flight.setDestinationId(destinationId);
            flight.setAirlineCode(airlineCode);

            return flight;
        }

        public FlightBuilder withAirlineCode(String airlineCode) {
            this.airlineCode = airlineCode;
            return this;
        }

        public FlightBuilder withDestination(Long destinationId, String destination) {
            this.destinationId = destinationId;
            this.destination = destination;
            return this;
        }

        public FlightBuilder withOrigin(Long originId, String origin) {
            this.originId = originId;
            this.origin = origin;
            return this;
        }

    }
}
