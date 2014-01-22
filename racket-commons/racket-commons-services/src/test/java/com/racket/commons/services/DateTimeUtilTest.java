package com.racket.commons.services;

import org.joda.time.DateTime;
import org.junit.Test;

import static com.racket.commons.services.utils.DateTimeUtil.*;
import static com.racket.commons.models.support.RoundUp.*;
import static org.junit.Assert.*;

public class DateTimeUtilTest {

    @Test
    public void testRound_HalfHour() {
        DateTime dateTime = new DateTime();
        DateTime rounded = roundUp(dateTime, NEXT_HALF_HOUR);
        assertTrue(rounded.getMinuteOfHour() % 30 == 0);
    }
    
    @Test
    public void testRound_Hour() {
        DateTime dateTime = new DateTime();
        DateTime rounded = roundUp(dateTime, NEXT_HOUR);
        
        System.out.println(dateTime);
        System.out.println(rounded);
        
        assertTrue(rounded.getMinuteOfHour() == 0);
    }
    
}
