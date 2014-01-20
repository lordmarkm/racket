package com.racket.commons.services.utils;

import org.joda.time.DateTime;

/**
 * @author Mark
 *
 */
public class DateTimeUtil {

	public static int HALF_HOUR = 30;
	public static int HOUR = 60;
	
	/**
	 * http://stackoverflow.com/questions/11222316/how-to-round-datetime-of-joda-library-to-the-nearest-x-minutes
	 */
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
