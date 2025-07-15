package com.gregory.cairly;


import com.gregory.cairly.service.DailyInfoService;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DailyInfoServiceTest {
    DailyInfoService dailyInfoService = new DailyInfoService();
    String[] daySuffixes = {"st", "th", "nd", "rd"};

    @Test
    @DisplayName("should verify if the right suffix is returned")
    void shouldVerifyIfTheRightSuffixIsReturned() {


        assertThat(dailyInfoService.getSuffix(2)).isEqualTo("nd");
        assertThat(dailyInfoService.getSuffix(1)).isEqualTo("st");
        assertThat(dailyInfoService.getSuffix(3)).isEqualTo("rd");
        assertThat(dailyInfoService.getSuffix(28)).isEqualTo("th");
        assertThat(dailyInfoService.getSuffix(15)).isEqualTo("th");
    }

    @Test
    @DisplayName("should verify if the date is in the right format ")
    void shouldVerifyIfTheDateIsInTheRightFormat() {


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

    @Test
    @DisplayName("should verify if the ratio is in the right format ")
    void shouldVerifyIfTheRatioIsInTheRightFormat() {

        String currentRatio = dailyInfoService.getActualRatio();
        assertThat(currentRatio.split("/").length).isEqualTo(2);

        int numberOfDaysOfTheYearGone = Integer.parseInt(currentRatio.split("/")[0]);
        int totalNumberOfDaysOfTheYear = Integer.parseInt(currentRatio.split("/")[1]);

        assertThat(numberOfDaysOfTheYearGone).isEqualTo(LocalDate.now().getDayOfYear());
        assertThat(totalNumberOfDaysOfTheYear).isEqualTo(LocalDate.now().lengthOfYear());

    }

    @Test
    @DisplayName("should verify if the date and ratio are in the right format ")
    void shouldVerifyIfTheDateAndRatioIsInTheRightFormat() {

        String currentDateAndRatio = dailyInfoService.getActualDateAndRatio();
        assertThat(currentDateAndRatio.split("\n").length).isEqualTo(2);

        String date =  currentDateAndRatio.split("\n")[0];
        String ratio =  currentDateAndRatio.split("\n")[1];

        assertThat(date).isEqualTo(dailyInfoService.getActualDate());
        assertThat(ratio).isEqualTo(dailyInfoService.getActualRatio());

    }


}
