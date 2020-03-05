package com.knoldus;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import java.util.stream.Stream;


class DayOfWeek {

    public List<String> dayFinder(LocalDate birthday) {
        LocalDate currentDate = LocalDate.now();
        List<String> totalDays = Stream.iterate(birthday.getYear(), n -> n + 1).limit(currentDate.getYear()-birthday.getYear())
                .map(year -> LocalDate.of(year, birthday.getMonthValue(), birthday.getDayOfMonth()).getDayOfWeek().toString())
                .collect(Collectors.toList());


        return totalDays;
    }


}

public class DayOfWeekFinder {
    public static void main(String[] args) {
        DayOfWeek operation=new DayOfWeek();
        LocalDate birthday = LocalDate.of(1997, 9, 30);
        System.out.println(operation.dayFinder(birthday));
    }
}