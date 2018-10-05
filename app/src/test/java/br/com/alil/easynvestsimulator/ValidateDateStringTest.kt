package br.com.alil.easynvestsimulator

import org.junit.Assert.*
import org.junit.Test


class ValidateDateStringTest {

    @Test
    fun testDayIsInvalid() {
        assertFalse("32/02/2012".isDateValid())
    }

    @Test
    fun testMonthIsInvalid() {
        assertFalse("31/20/2012".isDateValid())
    }

    @Test
    fun testYearIsInvalid() {
        assertFalse("31/20/19991".isDateValid())
    }

    @Test
    fun testDateFormatIsInvalid() {
        assertFalse("2012/02/20".isDateValid())
    }

    @Test
    fun testDateFeb29_2012() {
        assertTrue("29/02/2012".isDateValid())
    }

    @Test
    fun testDateFeb29_2011() {
        assertFalse("29/02/2011".isDateValid())
    }

    @Test
    fun testDateFeb28() {
        assertTrue("28/02/2011".isDateValid())
    }

    @Test
    fun testDateIsValid_1() {
        assertTrue("31/01/2012".isDateValid())
    }

    @Test
    fun testDateIsValid_2() {
        assertTrue("30/04/2012".isDateValid())
    }

    @Test
    fun testDateIsValid_3() {
        assertTrue("31/05/2012".isDateValid())
    }

}