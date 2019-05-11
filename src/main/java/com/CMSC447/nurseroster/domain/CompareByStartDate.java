package com.CMSC447.nurseroster.domain;

import java.util.Comparator;

public class CompareByStartDate implements Comparator<ShiftAssignment> {
    public int compare(ShiftAssignment sh1, ShiftAssignment sh2){
        return sh1.shift.getStartTime().compareTo(sh2.shift.getStartTime());
    }
}