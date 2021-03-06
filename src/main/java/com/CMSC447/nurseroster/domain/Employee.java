/*
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
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

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;
import java.util.Map;

public class Employee  {


    //constructor
	Employee(int id, List<Role> Roles, String Name, List<String> eAddr, List<DatePreference> Days, List<ShiftPattern> template){
		this.EmployeeID = id;
		this.roles = Roles;
		this.name = Name;
		this.email = eAddr;
		this.preferredDays = Days;
		this.EmployeeShiftTemplate = template;
	}

    List<PersonalConstraint> constraints;
    List<Role> roles;
    int EmployeeID;
    String name;
    List<String> email; 
    List<DatePreference> preferredDays;
    List<ShiftPattern> EmployeeShiftTemplate; 
    

    public HardSoftScore score(List<Shift> shifts){
        int softScore = 0;
        int hardScore = 0;
        for(PersonalConstraint constraint : constraints){
            softScore += constraint.score(shifts, this);
        }
        for(Role role : roles){
            for(PersonalConstraint constraint : role.constraints) {
                if (!constraints.contains(constraint)) {
                    hardScore += constraint.score(shifts, this);
                }
            }
        }

        return HardSoftScore.of(hardScore,softScore);
    }



}
