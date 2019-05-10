package com.CMSC447.nurseroster.domain;

import org.drools.core.rule.Declaration;
import org.drools.core.spi.Constraint;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class ScheduleSequenceConstraint implements ScheduleConstraint{
    PersonalSequence shiftSequence;
    int minMatches;
    int maxMatches;
    Period repeatPeriod;
    LocalDate repeatStart;

    ScheduleSequenceConstraint(PersonalSequence shiftSeq, int min, int max, Period period, LocalDate repeat){
    	this.shiftSequence = shiftSeq;
    	this.minMatches = min;
    	this.maxMatches = max;
    	this.repeatPeriod = period;
    	this.repeatStart = repeat;
    }
    
    @Override
    public int score(List<ShiftAssignment> shiftAssignments) {


        return 0;
    }


}
