package com.CMSC447.nurseroster.domain;

import org.drools.core.rule.Declaration;
import org.drools.core.spi.Constraint;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class DayOfWeekPreference implements Preference {

    int DayOfWeek;
    String location;
    Boolean isPositivePref; 

    DayOfWeekPreference(int Day, String loc, Boolean isPos){
    	this.DayOfWeek = Day;
    	this.location = loc;
    	this.isPositivePref = isPos;
    }

    @Override
    public int score(List<Shift> shiftAssignments, Employee employee) {

        for(Shift shift: shiftAssignments){

        }


        return 1;
    }

}
