import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PerpetualCalendarTest {
    
    @Test
    public void testIsValidDate() {
        // Normal date - if this isn't valid, your program has serious issues... Seriously, this date is as normal as it gets.
        assertTrue("expected: date is valid", PerpetualCalendar.isValidDate(1, 1, 1900));
        // Feb 29 in a leap year is valid
        assertTrue("expected: date is valid", PerpetualCalendar.isValidDate(29, 2, 1904));
        // Feb 29 in a normal year is invalid!
        assertFalse("expected: date is invalid", PerpetualCalendar.isValidDate(29, 2, 1903));
        
        // Out-of-range dates
        assertFalse("expected: date is invalid", PerpetualCalendar.isValidDate(0, 1, 2000));
        assertFalse("expected: date is invalid", PerpetualCalendar.isValidDate(32, 1, 2000));
        assertFalse("expected: date is invalid", PerpetualCalendar.isValidDate(1, 0, 2000));
        assertFalse("expected: date is invalid", PerpetualCalendar.isValidDate(1, 13, 2000));
        assertFalse("expected: date is invalid", PerpetualCalendar.isValidDate(31, 12, 1899));
    }
    
    @Test
    public void testCountDays() {
        assertEquals(0, PerpetualCalendar.countDays(1, 1, 1900));
        assertEquals(1, PerpetualCalendar.countDays(2, 1, 1900));
        assertEquals(2, PerpetualCalendar.countDays(3, 1, 1900));
        
        assertEquals(31, PerpetualCalendar.countDays(1, 2, 1900));
        assertEquals(59, PerpetualCalendar.countDays(1, 3, 1900));
        assertEquals(90, PerpetualCalendar.countDays(1, 4, 1900));
        assertEquals(212, PerpetualCalendar.countDays(1, 8, 1900));
        assertEquals(334, PerpetualCalendar.countDays(1, 12, 1900));
        
        assertEquals(1 * 365, PerpetualCalendar.countDays(1, 1, 1901));
        assertEquals(2 * 365, PerpetualCalendar.countDays(1, 1, 1902));
        assertEquals(3 * 365, PerpetualCalendar.countDays(1, 1, 1903));
        assertEquals(4 * 365, PerpetualCalendar.countDays(1, 1, 1904));
        assertEquals(5 * 365 + 1, PerpetualCalendar.countDays(1, 1, 1905));
    }
    
    @Test
    public void testCountDaysInMonth() {
        int aLeapYear = 2004;
        int aNormalYear = 2005;
        
        // Test months with 31 days
        assertEquals(31, PerpetualCalendar.countDaysInMonth(1, aLeapYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(1, aNormalYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(3, aLeapYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(3, aNormalYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(5, aLeapYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(5, aNormalYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(7, aLeapYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(7, aNormalYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(8, aLeapYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(8, aNormalYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(10, aLeapYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(10, aNormalYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(12, aLeapYear));
        assertEquals(31, PerpetualCalendar.countDaysInMonth(12, aNormalYear));
        
        // Test months with 30 days
        assertEquals(30, PerpetualCalendar.countDaysInMonth(4, aLeapYear));
        assertEquals(30, PerpetualCalendar.countDaysInMonth(4, aNormalYear));
        assertEquals(30, PerpetualCalendar.countDaysInMonth(6, aLeapYear));
        assertEquals(30, PerpetualCalendar.countDaysInMonth(6, aNormalYear));
        assertEquals(30, PerpetualCalendar.countDaysInMonth(9, aLeapYear));
        assertEquals(30, PerpetualCalendar.countDaysInMonth(9, aNormalYear));
        assertEquals(30, PerpetualCalendar.countDaysInMonth(11, aLeapYear));
        assertEquals(30, PerpetualCalendar.countDaysInMonth(11, aNormalYear));
        
        // Test February
        assertEquals(29, PerpetualCalendar.countDaysInMonth(2, aLeapYear));
        assertEquals(28, PerpetualCalendar.countDaysInMonth(2, aNormalYear));
    }
    
    @Test
    public void testCountDaysInYear() {
        assertEquals(365, PerpetualCalendar.countDaysInYear(1900));
        assertEquals(365, PerpetualCalendar.countDaysInYear(1901));
        assertEquals(365, PerpetualCalendar.countDaysInYear(1902));
        assertEquals(365, PerpetualCalendar.countDaysInYear(1903));
        assertEquals(366, PerpetualCalendar.countDaysInYear(1904));
        assertEquals(366, PerpetualCalendar.countDaysInYear(2000));
        assertEquals(366, PerpetualCalendar.countDaysInYear(2004));
    }
    
    @Test
    public void testIsLeapYear() {
        assertFalse("expected: year is not a leap year", PerpetualCalendar.isLeapYear(1900));
        assertFalse("expected: year is not a leap year", PerpetualCalendar.isLeapYear(1901));
        assertFalse("expected: year is not a leap year", PerpetualCalendar.isLeapYear(1902));
        assertFalse("expected: year is not a leap year", PerpetualCalendar.isLeapYear(1903));
        assertTrue("expected: year is a leap year", PerpetualCalendar.isLeapYear(1904));
        assertTrue("expected: year is a leap year", PerpetualCalendar.isLeapYear(2000));
        assertTrue("expected: year is a leap year", PerpetualCalendar.isLeapYear(2004));
    }
}
