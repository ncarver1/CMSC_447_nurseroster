package com.CMSC447.nurseroster.domain;

import org.drools.core.rule.Declaration;
import org.drools.core.spi.Constraint;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDateTime;
import java.util.List;

public class ShiftPreference implements Preference {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    ShiftPreference(LocalDateTime start, LocalDateTime end){
    	this.startTime = start;
    	this.endTime = end;
    }
    
    @Override
    public int score(List<Shift> shiftAssignments, Employee employee) {
        return 0;
    }



}
