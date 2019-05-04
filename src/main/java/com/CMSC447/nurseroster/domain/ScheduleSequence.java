package com.CMSC447.nurseroster.domain;

import java.util.List;

public class ScheduleSequence extends Sequence{
    List<Integer> employeePatten;
    List<Employee> employeeRequirements;
    List<Role> rolePattern;


    public List<List<ShiftAssignment>> matches(List<ShiftAssignment> shift){
        System.out.println("Implement ScheduleSequence.matches");
        return null;
    }
}
