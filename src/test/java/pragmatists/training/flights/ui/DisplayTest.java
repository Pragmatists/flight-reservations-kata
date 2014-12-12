package pragmatists.training.flights.ui;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;

import org.junit.Test;

public class DisplayTest {

    private DefaultTimeProvider provider = mock(DefaultTimeProvider.class);
    private TimeDisplay timeDisplay = new TimeDisplay(provider);

    @Test
    public void shouldDisplayNoon() throws Exception {
        givenHourAndMinuteIs(12, 0);

        String result = timeDisplay.getCurrentTimeAsHtmlFragment();

        assertThat(result).isEqualTo(wrappedInSpan("Noon"));
    }

    @Test
    public void shouldDisplayMidnight() throws Exception {
        givenHourAndMinuteIs(0, 0);

        String result = timeDisplay.getCurrentTimeAsHtmlFragment();

        assertThat(result).isEqualTo(wrappedInSpan("Midnight"));
    }

    @Test
    public void shouldDisplayAmTime() throws Exception {
        givenHourAndMinuteIs(11, 15);

        String result = timeDisplay.getCurrentTimeAsHtmlFragment();

        assertThat(result).isEqualTo(wrappedInSpan("11:15 AM"));
    }

    @Test
    public void shouldDisplayPmTime() throws Exception {
        givenHourAndMinuteIs(16, 17);

        String result = timeDisplay.getCurrentTimeAsHtmlFragment();

        assertThat(result).isEqualTo(wrappedInSpan("4:17 PM"));
    }

    private void givenHourAndMinuteIs(int hour, int minute) {
        Calendar noon = Calendar.getInstance();
        noon.set(Calendar.HOUR_OF_DAY, hour);
        noon.set(Calendar.MINUTE, minute);
        when(provider.getTime()).thenReturn(noon);
    }

    private String wrappedInSpan(String time) {
        return "<span class=\"tinyBoldText\">" + time + "</span>";
    }
}
