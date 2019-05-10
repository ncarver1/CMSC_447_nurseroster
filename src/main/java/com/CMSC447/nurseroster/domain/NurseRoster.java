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

import java.util.LinkedList;
import java.util.List;

@PlanningSolution
public class NurseRoster {

    @ProblemFactCollectionProperty
    private List<ScheduleConstraint> scheduleConstraints;

    private HardSoftScore score;

    private List<ShiftAssignment> shiftAssignments;

    // constructor
    NurseRoster(List<ShiftAssignment> shftAssign, List<ScheduleConstraint> schCon){
    	this.scheduleConstraints = schCon;
    	this.shiftAssignments = shftAssign;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        int hardScore = 0;
        int softScore = 0;





        return score;
    }

    private List<Pair<Employee,List<Shift>>> reformatAssignments(){
        List<Employee> employees = new LinkedList<Employee>();
        for(ShiftAssignment assignment: shiftAssignments){
            if(!employees.contains(assignment.employee)){
                employees.add(assignment.employee);
                
            }
        }
    }

    @PlanningEntityCollectionProperty
    public List<ShiftAssignment> getShiftAssignments() {
        return shiftAssignments;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

}
