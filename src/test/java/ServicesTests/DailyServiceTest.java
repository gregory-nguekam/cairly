package ServicesTests;

import Service.DailyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Locale;


import static org.assertj.core.api.Assertions.assertThat;

public class DailyServiceTest {

    DailyService dailyService = new DailyService();

    @Test
    @DisplayName("Should display the current date with the correct format")
    void shouldDisplayCurrentDateWithCorrectFormat() {
        String currentDate = dailyService.getCurrentDate();

        assertThat(currentDate.split(" ").length).isEqualTo(4);

        int year = Integer.parseInt(currentDate.split(" ")[3]);
        int month = Integer.parseInt(currentDate.split(" ")[2]);
        int day = Integer.parseInt(currentDate.split(" ")[1].substring(0, 2));

        Calendar calendar = Calendar.getInstance(Locale.FRANCE);
        assertThat(year).isEqualTo(calendar.get(Calendar.YEAR));
        assertThat(month).isEqualTo(calendar.get(Calendar.MONTH) + 1);
        assertThat(day).isEqualTo(calendar.get(Calendar.DAY_w:qOF_MONTH));
    }
}
