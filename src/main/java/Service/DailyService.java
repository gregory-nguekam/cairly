package Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyService {

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MM yyyy");

    public String getCurrentDate() {
        return LocalDate.now().getDayOfWeek().toString() + " " + LocalDate.now().format(dateFormat);
    }
}
