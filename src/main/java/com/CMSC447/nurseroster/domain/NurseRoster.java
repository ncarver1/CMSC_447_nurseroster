/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.CMSC447.nurseroster.domain;


import org.optaplanner.core.api.domain.entity.PlanningEntity;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;

import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.javatuples.Pair;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@PlanningSolution
public class NurseRoster {

    @ProblemFactCollectionProperty
    private List<ScheduleConstraint> scheduleConstraints;

    private HardSoftScore score;

    private List<ShiftAssignment> shiftAssignments;
    private List<LocalDateTime> shiftDates = new LinkedList<LocalDateTime>();
    private List<Employee> employees;

    // constructor
    NurseRoster(List<ShiftAssignment> shftAssign, List<ScheduleConstraint> schCon){
    	this.scheduleConstraints = schCon;
    	this.shiftAssignments = shftAssign;
    	reformatAssignments();
    }

    @PlanningScore
    public HardSoftScore getScore() {
        HardSoftScore score = HardSoftScore.ZERO;

        List<Pair<Employee,List<Shift>>> shiftsByEmployees = reformatAssignments();
        for( Pair<Employee, List<Shift>> employeeShifts : shiftsByEmployees){
            score.add(employeeShifts.getValue0().score(employeeShifts.getValue1()));
        }

        for(ScheduleConstraint scheduleConstraint :scheduleConstraints ) {
            score.add(HardSoftScore.ofHard(scheduleConstraint.score(shiftAssignments)));
        }

        return score;
    }


    private List<Pair<Employee,List<Shift>>> reformatAssignments(){
        List<Pair<Employee,List<Shift>>> reformat = new LinkedList<Pair<Employee,List<Shift>>>();
        List<Employee> employees = new LinkedList<Employee>();
        List<LocalDateTime> shiftDates = new LinkedList<LocalDateTime>();
        shiftAssignments.sort(new CompareByStartDate());
        for(ShiftAssignment assignment: shiftAssignments){
            if(!employees.contains(assignment.employee)){
                employees.add(assignment.employee);
                List<Shift> shifts = new LinkedList<Shift>();
                shifts.add(assignment.shift);
                shiftDates.add(assignment.shift.startTime);
                reformat.add(new Pair<>(assignment.employee, shifts));
            }else{
                for(Pair<Employee,List<Shift>> item : reformat){
                    if(item.getValue(0).equals(assignment.employee)){
                        ((List)item.getValue(1)).add(assignment.shift);
                        shiftDates.add(assignment.shift.startTime);
                    }
                }
            }
        }
        this.shiftDates = shiftDates;
        this.employees = employees;
        return reformat;
    }

    @PlanningEntityCollectionProperty
    public List<ShiftAssignment> getShiftAssignments() {
        return shiftAssignments;
    }

    public List<Employee> getEmployees() {
        reformatAssignments();
        return employees;
    }

    public List<LocalDateTime> getShiftDateList() {
        reformatAssignments();
        return shiftDates;
    }


// ************************************************************************
    // Complex methods
    // ************************************************************************

}
