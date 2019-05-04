package com.CMSC447.nurseroster.domain;

import org.drools.core.spi.Constraint;

import java.util.List;

public interface ScheduleConstraint extends Constraint {
    int priority = 0;
    boolean isHardConstraint = false;

    int score(List<ShiftAssignment> shiftAssignments);

}
