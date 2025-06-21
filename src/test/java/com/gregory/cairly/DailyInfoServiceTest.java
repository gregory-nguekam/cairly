package com.gregory.cairly;


import com.gregory.cairly.service.DailyInfoService;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DailyInfoServiceTest {
    String[] daySuffixes = {"st", "th", "nd", "rd"};
    @Test
    @DisplayName("should verify if the right suffix is returned")
    void shouldVerifyIfTheRightSuffixIsReturned() {

        DailyInfoService dailyInfoService = new DailyInfoService();
        assertThat(dailyInfoService.getSuffix(2)).isEqualTo("nd");
        assertThat(dailyInfoService.getSuffix(1)).isEqualTo("st");
        assertThat(dailyInfoService.getSuffix(3)).isEqualTo("rd");
        assertThat(dailyInfoService.getSuffix(28)).isEqualTo("th");
        assertThat(dailyInfoService.getSuffix(15)).isEqualTo("th");
    }

    @Test
    @DisplayName("should verify if the date is in the right format ")
    void shouldVerifyIfTheDateIsInTheRightFormat() {

        DailyInfoService dailyInfoService = new DailyInfoService();
        String currentDate = dailyInfoService.getActualDate();

        //Splitting date into 4 formats( ex: Thursday, 4th July 1955)
        assertThat(currentDate.split(" ").length).isEqualTo(4);

        String dayOfWeek = currentDate.split(" ")[0];
        int dayOfMonth = Integer.parseInt(currentDate.split(" ")[1].substring(0, 2));
        String daySuffix = currentDate.split(" ")[1].substring(2, 4);
        String month = currentDate.split(" ")[2];
        int year = Integer.parseInt(currentDate.split(" ")[3]);

        assertThat(dayOfWeek).isEqualTo(LocalDate.now().getDayOfWeek().toString());
        assertThat(dayOfMonth).isEqualTo(LocalDate.now().getDayOfMonth());
        assertThat(month).isEqualTo(LocalDate.now().getMonth().toString());
        assertThat(year).isEqualTo(LocalDate.now().getYear());
        assertThat(daySuffix).isIn(Arrays.asList(daySuffixes));
    }


}
