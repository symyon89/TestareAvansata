
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.IOException;
import java.time.Month;
import java.util.EnumSet;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParametrizedTests {

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 8, -2, 10, Integer.MAX_VALUE - 1})
    public void isOddTest(int number) {
        assertTrue(Checks.isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void isBlankTest(String text) {
        assertTrue(Checks.isBlank(text));
    }

    @ParameterizedTest
    @NullSource
    public void isBlankWithNullSourceTest(String text) {
        assertTrue(Checks.isBlank(text));
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void isBlankWithNullandEmptySourceTest(String text) {
        assertTrue(Checks.isBlank(text));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    public void isBlankWithAllTest(String text) {
        assertTrue(Checks.isBlank(text));
    }

    @ParameterizedTest
    @EnumSource(Month.class)
    public void getValueForMonthTest(Month month) {
        int monthValue = month.getValue();
        assertTrue(monthValue >= 1 && monthValue <= 12);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "FEBRUARY" ,"JUNE", "NOVEMBER","SEPTEMBER"}, mode = EnumSource.Mode.EXCLUDE)
    public void getSelectedValuesForMonthTest(Month month) {
        boolean isLeapYear = false;
        assertEquals(31, month.length(isLeapYear));
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
    public void getSelectedMonthWithMatch(Month month) {
        EnumSet<Month> monthsWithBer = EnumSet.of(Month.SEPTEMBER,Month.DECEMBER,Month.OCTOBER,Month.NOVEMBER);
        assertTrue(monthsWithBer.contains(month));
    }

    @ParameterizedTest
    @CsvSource({"test, TEST", "java, JAVA" , "sda, SDA"}) //cheie valoare separate prin virgula
    public void csvSourceTest(String input, String expected) {
        String actualValue =input.toUpperCase();
        assertEquals(actualValue,expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"test: TEST", "java: JAVA" , "sda: SDA"}, delimiter = ':')
    public void csvSourceWithCustoDelimiter(String input, String expected){
        String actualValue =input.toUpperCase();
        assertEquals(actualValue,expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", delimiter = ','/*e redundant*/)
    public void csvFileSource(String input, String expected){
        String actualValue =input.toUpperCase();
        assertEquals(actualValue,expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", delimiter = ','/*e redundant*/, numLinesToSkip = 2/*ca sa scap de un header*/)
    public void csvFileSourceSkipHeaders(String input, String expected){
        String actualValue =input.toUpperCase();
        assertEquals(actualValue,expected);
    }
}
