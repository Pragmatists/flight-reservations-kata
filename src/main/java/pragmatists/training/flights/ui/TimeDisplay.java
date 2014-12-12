package pragmatists.training.flights.ui;

import static java.util.Calendar.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class TimeDisplay {

    private DefaultTimeProvider timeProvider;

    public TimeDisplay(DefaultTimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String getCurrentTimeAsHtmlFragment() {
        Calendar time = timeProvider.getTime();
        StringBuffer result = new StringBuffer();
        result.append("<span class=\"tinyBoldText\">");
        if (isMidnight(time)) {
            result.append("Midnight");
        } else if (isNoon(time)) { // noon
            result.append("Noon");
        } else {
            SimpleDateFormat fr = new SimpleDateFormat("h:mm a");
            result.append(fr.format(time.getTime()));
        }
        result.append("</span>");
        return result.toString();
    }

    private boolean isNoon(Calendar time) {
        return (time.get(HOUR_OF_DAY) == 12)
                && (time.get(MINUTE) == 0);
    }

    private boolean isMidnight(Calendar time) {
        return (time.get(HOUR_OF_DAY) == 0)
                && (time.get(MINUTE) <= 1);
    }

}
