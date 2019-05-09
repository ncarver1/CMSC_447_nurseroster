package com.CMSC447.nurseroster.domain;

import org.drools.core.spi.Constraint;

import java.util.List;

public interface PersonalConstraint{
    int priority = 0;
    boolean isHardConstraint = false;

    int score(List<Shift> shiftAssignments, Employee employee);

}
