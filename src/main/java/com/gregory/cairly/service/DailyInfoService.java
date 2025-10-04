package com.gregory.cairly.service;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class DailyInfoService {
    public String getSuffix(int dayMonth) {
        String suffix;
        switch (dayMonth) {
            case 1:
                suffix = "st";
                break;
            case 2:
                suffix = "nd";
                break;
            case 3:
                suffix = "rd";
                break;
            default:
                suffix = "th";
                break;
        }
        return suffix;
    }

    public String getActualDate() {
        return LocalDate.now().getDayOfWeek() + " " + LocalDate.now().getDayOfMonth() +
                getSuffix(LocalDate.now().getDayOfMonth()) + " " + LocalDate.now().getMonth()
                + " " + LocalDate.now().getYear();
    }

    public String getActualRatio() {
        return LocalDate.now().getDayOfYear()+"/"+LocalDate.now().lengthOfYear();
    }


    public String getActualDateAndRatio() {
        return getActualDate()  +"\n" + getActualRatio();
    }
}
