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


import org.drools.compiler.lang.Location;

import java.time.LocalDateTime;
import java.util.List;

public class Shift {

    LocalDateTime startTime;
    LocalDateTime endTime;
	List<String> shiftTypes;
    Location location;
    Boolean mandatory;
    // restrictions??
    List<Integer> RoleID;
    
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public List<String> getShiftTypes() {
        return shiftTypes;
    }

    public Location getLocation() {
        return location;
    }

    public Shift(LocalDateTime startTime, LocalDateTime endTime, List<String> shiftTypes, Location location, Boolean mandatory, List<Integer> RoleID) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftTypes = shiftTypes;
        this.location = location;
        this.mandatory = mandatory; 
        this.RoleID = RoleID;
    }
}
