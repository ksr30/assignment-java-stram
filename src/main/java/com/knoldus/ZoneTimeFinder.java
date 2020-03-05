package com.knoldus;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

 class ZoneTime{

    public String timeFinder (String timeZone){
        LocalDateTime timeToZone = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of(timeZone);
        ZonedDateTime timeOfGivenZone=timeToZone.atZone(zoneId);
        return timeOfGivenZone.toString();
    }
}

public class ZoneTimeFinder{
    public static void main(String[] args) {

        ZoneTime operation = new ZoneTime();
        System.out.println(operation.timeFinder("Africa/Blantyre"));
    }
}
