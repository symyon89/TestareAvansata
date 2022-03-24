import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverterImpl implements ArgumentConverter {
    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String)) {
            throw new IllegalArgumentException("This argument should be a string:" + source);
        }
        return LocalDate.parse(((String) source), DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        //alta varianta
//        String[] parts = ((String)source).split("/");
//        int year = Integer.parseInt(parts[0]);
//        int month = Integer.parseInt(parts[1]);
//        int day = Integer.parseInt(parts[2]);
//
//        return LocalDate.of(year,month,day);
    }
}
