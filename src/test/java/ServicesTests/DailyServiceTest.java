package ServicesTests;

import Service.DailyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DailyServiceTest {

    DailyService dailyService = new DailyService();

    @Test
    @DisplayName("Should display the current date with the correct format")
    void shouldDisplayCurrentDateWithCorrectFormat() {
        String currentDate = dailyService.getCurrentDate();
        int year = Integer.parseInt(currentDate.split(" ")[3]);
        int day = Integer.parseInt(currentDate.split(" ")[2]);
        Calendar calendar = Calendar.getInstance();
        assertThat(year).isEqualTo(calendar.get(Calendar.YEAR));
        assertThat(day).isEqualTo(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
