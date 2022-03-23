public class Checks {

    public static boolean isBlank(String input) {
        return null == input || input.trim().isEmpty();
    }

    public static boolean isOdd(Integer number) {
        return number % 2 == 0;
    }
}
