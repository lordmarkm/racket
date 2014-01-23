package com.racket.commons.services.utils;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Minutes;

import com.racket.commons.models.support.RoundUp;

/**
 * @author Mark
 *
 */
public class DateTimeUtil {

    public static int getRoundedChargeableMinutes(DateTime startTime, DateTime endTime, RoundUp roundUp) {
        int minutes = 0;
        switch (roundUp) {
        case NONE:
            return Minutes.minutesBetween(startTime, endTime).getMinutes();
        case NEXT_HALF_HOUR:
            minutes = Minutes.minutesBetween(startTime, endTime).getMinutes();
            return minutes + (30 - minutes%30);
        case NEXT_HOUR:
            minutes = Minutes.minutesBetween(startTime, endTime).getMinutes();
            return minutes + (60 - minutes%60);        
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
