import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void beforeEach(){
        System.out.println("Before");
        calculator = new Calculator();
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After");
    }

    @BeforeAll
    static void beforeAllEach(){
        System.out.println("Started test at :" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @AfterAll
    static void afterAllEach(){
        System.out.println("Ended test at :" +  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Test
    @DisplayName("Documantatie test, adica acest test aduna 2 numere")
    void addTest() {
        //given
        double firstNumber = 4;
        double secondNumber = 5;
        double expectedResult = 9;
        //when
        Double actualResult = calculator.add(firstNumber, secondNumber);
        //then
        assertEquals(expectedResult, actualResult);
        assertNotEquals(5,actualResult);
        assertNotNull(actualResult);
        //assertTrue(expectedResult == actualResult);// utilizata cand metoda intoarce un boolean

        assertThat(actualResult)
                .isNotZero()
                .isBetween(4.0,11.0)
                .isGreaterThan(1);
    }

    @Test
    public void divideTest_ThowaExeptionWith0Value() {
        String expectedExceptionMessage = "division by 0";
        IllegalArgumentException actualExceptionThrown = assertThrows(IllegalArgumentException.class, () -> calculator.divide(10.0, 0.0));

        assertEquals(expectedExceptionMessage, actualExceptionThrown.getMessage());
    }

    @Test
    public void divideTest_ThowaExeptionWith0Value_AssertJstyle() {
        assertThatThrownBy(()-> calculator.divide(10d,0d))
                .hasMessage("division by 0")
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addWithMultipleNumbersTest(){
        assertAll(
                () -> assertEquals(4,calculator.add(2.0,2.0)),
                () -> assertEquals(10,calculator.add(10.0,0.0)),
                () -> assertEquals(5,calculator.add(2.0,3.0)),
                () -> assertEquals(7,calculator.add(2d,5d))
        );
    }

    @Test
    @RepeatedTest(3) //o sa ruleze testul de 3 ori
    @DisplayName("Documantatie test, adica acest test aduna 2 numere")
    void addRepeatedTest() {
        //given
        double firstNumber = 4;
        double secondNumber = 5;
        double expectedResult = 9;
        //when
        Double actualResult = calculator.add(firstNumber, secondNumber);
        //then
        assertEquals(expectedResult, actualResult);

    }

}
