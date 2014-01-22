package com.racket.commons.services.utils;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import com.racket.commons.models.support.RoundUp;

/**
 * @author Mark
 *
 */
public class DateTimeUtil {

    public static DateTime roundUp(final DateTime dateTime, RoundUp roundUp) {
        int minutes = 0;
        switch (roundUp) {
        case NONE:
            return dateTime;
        case NEXT_HALF_HOUR:
            minutes = dateTime.getMinuteOfHour();
            if (minutes == 0 || minutes == 30) {
                return dateTime;
            } else {
                return dateTime.plusMinutes(30 - (minutes%30));
            }
        case NEXT_HOUR:
            return dateTime.hourOfDay().roundCeilingCopy();
        case NEXT_DAY:
            return dateTime.dayOfMonth().roundCeilingCopy();
        default:
            throw new IllegalArgumentException("Roundup not supported: " + roundUp);
        }
    }
    
    /**
	 * http://stackoverflow.com/questions/11222316/how-to-round-datetime-of-joda-library-to-the-nearest-x-minutes
	 */
    @Deprecated
	public static DateTime roundToNearestMinutes(final DateTime dateTime, final int minutes) {
	    if (minutes < 1 || 60 % minutes != 0) {
	        throw new IllegalArgumentException("minutes must be a factor of 60");
	    }

	    final DateTime hour = dateTime.hourOfDay().roundFloorCopy();
	    final long millisSinceHour = new Duration(hour, dateTime).getMillis();
	    final int roundedMinutes = ((int)Math.round(
	        millisSinceHour / 60000.0 / minutes)) * minutes;
	    return hour.plusMinutes(roundedMinutes);
	}

}
