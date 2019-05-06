package com.CMSC447.nurseroster.domain;


import org.drools.compiler.lang.Location;
import org.javatuples.Pair;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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
    * Checks to see if shift follows this Pattern
    *
    * @param shift  the shift to be compared
    * @return true if the shift is valid under this pattern
    * */
    public boolean matches(Shift shift){
        boolean isAllowed = false;

        //Check Start Time allowed
        for(Pair<LocalTime,LocalTime> range : startTimeRanges ){

            if( shift.getStartTime().toLocalTime().compareTo(range.getValue0())>=0
            && shift.getStartTime().toLocalTime().compareTo(range.getValue1())<=0
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

        //Check Duration allowed
        if(isAllowed){
            Float duration = (float)(shift.getStartTime().until(shift.getEndTime(), ChronoUnit.MINUTES));
            isAllowed = false;
            for(Pair<Float,Float> range : lengthRanges ){
                if( duration.compareTo(range.getValue0())>=0
                        && duration.compareTo(range.getValue1())<=0
                ){
                    isAllowed = true;
                }
            }
        }

        //Chack Location Allowed
        if( isAllowed ){
            isAllowed = allowedLocations.contains(shift.getLocation());
        }

        //Check Day of Week
        // BIG NOTE!!!: In this case, It is reasonable to assume that a shift will not last longer than a day
        // starting on one day, spanning an illegal day and then stopping on a third day, hence we only need
        // to chect the start and end days.
        if(isAllowed){
            isAllowed = allowedDaysOfWeek.contains(shift.getStartTime().getDayOfWeek())
                     && allowedDaysOfWeek.contains(shift.getEndTime().getDayOfWeek());
        }

        // Check types are valid
        if( isAllowed ){
            isAllowed = true;
            for(String type : requiredTypes){
                if(! (shift.getShiftTypes().contains(type))){
                    isAllowed = false;
                }
            }
            for(String type : bannedTypes){
                if(shift.getShiftTypes().contains(type)){
                    isAllowed = false;
                }
            }
        }


        return isAllowed;
    }


}
