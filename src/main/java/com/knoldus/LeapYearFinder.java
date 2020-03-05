package com.knoldus;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LeapYear{

    List<Integer> yearFinder(LocalDate startDate, LocalDate endDate){

        List<Integer> listOfLeapYears = Stream.iterate(startDate.getYear(),n -> n+1).limit(endDate.getYear()-startDate.getYear())
                .map(Year::of).filter(Year::isLeap).map(year -> year.getValue()).collect(Collectors.toList());
        return listOfLeapYears;
    }

}
public class LeapYearFinder {
    public static void main(String[] args) {
        LeapYear operation=new LeapYear();
        LocalDate startDate=LocalDate.of(1950,1,26);
        LocalDate endDate=LocalDate.now();
        System.out.println(operation.yearFinder(startDate,endDate));

    }
}
