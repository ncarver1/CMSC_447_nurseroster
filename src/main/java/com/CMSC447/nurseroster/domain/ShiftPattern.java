package com.CMSC447.nurseroster.domain;


import org.drools.compiler.lang.Location;
import org.javatuples.Pair;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ShiftPattern {
    List<Enum> allowedDaysOfWeek;
    List<String> requiredTypes;
    List<String> bannedTypes;
    List<Pair<LocalTime, LocalTime>> startTimeRanges;
    List<Pair<LocalTime, LocalTime>> endTimeRanges;
    List<Pair<LocalDate, LocalDate>> startDateRanges;
    List<Pair<LocalDate, LocalDate>> endDateRanges;
    List<Pair<Float,Float>> lengthRanges;
    List<Location> allowedLocations;



    /*
    * Checks to see if S
    *
    *
    * */
    public boolean matches(Shift shift){
        boolean isAllowed = false;

        //Check Start Time allowed
        for(Pair<LocalTime,LocalTime> range : startTimeRanges ){

            if( shift.getStartTime().toLocalTime().isAfter(range.getValue0())
            && shift.getStartTime().toLocalTime().isBefore(range.getValue1())
            ){
                isAllowed = true;
            }
        }

        //Check End Time Allowed
        if( isAllowed ){
            isAllowed = false;
            for(Pair<LocalTime,LocalTime> range : endTimeRanges ){
                if( shift.getEndTime().toLocalTime().compareTo(range.getValue0())>=0
                        && shift.getEndTime().toLocalTime().compareTo(range.getValue1())<=0
                ){
                    isAllowed = true;
                }
            }
        }

        //Check Start Date Allowed
        if( isAllowed ){
            isAllowed = false;
            for(Pair<LocalDate,LocalDate> range : startDateRanges ){
                if( shift.getStartTime().toLocalDate().compareTo(range.getValue0())>=0
                        && shift.getStartTime().toLocalDate().compareTo(range.getValue1())<=0
                ){
                    isAllowed = true;
                }
            }
        }

        //Check End Date Allowed
        if( isAllowed ){
            isAllowed = false;
            for(Pair<LocalDate,LocalDate> range : endDateRanges ){
                if( shift.getEndTime().toLocalDate().compareTo(range.getValue0())>=0
                        && shift.getEndTime().toLocalDate().compareTo(range.getValue1())<=0
                ){
                    isAllowed = true;
                }
            }
        }

        if( isAllowed ){

        }


        System.out.println("Implement Shiftpattern.matches");
        return false;
    }


}
