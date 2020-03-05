package com.knoldus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

class ActiveTime {


    public long diffFinder(LocalDateTime birthday, LocalDateTime deathday) {
        long diffInSec = ChronoUnit.DAYS.between(birthday, deathday);
        return diffInSec;
    }


}


public class ActiveTimeFinder {
    public static void main(String[] args) {
        ActiveTime operation = new ActiveTime();
        LocalDateTime deathDay = LocalDateTime.now();
        LocalDateTime birthday = LocalDateTime.of(1998, 9, 01, 0, 0);
        System.out.println(operation.diffFinder(birthday,deathDay));

    }
}
