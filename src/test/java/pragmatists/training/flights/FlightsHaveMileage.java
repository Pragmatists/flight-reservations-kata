package pragmatists.training.flights;

import static com.googlecode.catchexception.CatchException.*;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.*;
import static org.fest.assertions.Assertions.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FlightsHaveMileage {

    private static final String VALID_FLIGHT_NUMBER = "1255 ULW";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldConvertMileageToKm() throws Exception {
        // given
        Flight newFlight = createFlightWithMileage(1122);
        // when
        int actualKilometres = newFlight.getMileageAsKm();
        // then
        assertThat(actualKilometres).isEqualTo(1810);
    }

    private Flight createFlightWithMileage(int mileage) {
        Flight newFlight = new Flight(null);
        newFlight.setMileage(mileage);
        return newFlight;
    }

    @Test
    public void shouldConstructFlightWithValidNumber() throws Exception {
        Flight newFlight = new Flight(VALID_FLIGHT_NUMBER);

        assertThat(newFlight.number).isEqualTo(VALID_FLIGHT_NUMBER);
        assertThat(newFlight.getAirlineCode()).isEqualTo("");
        assertThat(newFlight.airline).isNull();
    }

    @Test
    public void cannotConvertMileageToKmOnCancelledFlight() throws Exception {
        Flight newFlight = createFlightWithMileage(1122);
        newFlight.cancel();

        expectedException.expect(InvalidRequestException.class);
        expectedException.expectMessage(is("Cannot get cancelled flight mileage"));
        newFlight.getMileageAsKm();
    }

    @Test
    public void cannotConvertMileageToKmOnCancelledFlightBDD() throws Exception {
        Flight newFlight = createFlightWithMileage(1122);
        newFlight.cancel();

        when(newFlight).getMileageAsKm();

        then(caughtException())
                .isInstanceOf(InvalidRequestException.class)
                .hasMessage("Cannot get cancelled flight mileage");
    }
}
