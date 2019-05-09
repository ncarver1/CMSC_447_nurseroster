package com.CMSC447.nurseroster.domain;

import org.drools.core.spi.Constraint;

import java.util.List;

public class Role {
    List<PersonalConstraint> constraints;
    int roleID;
    String name;
    String color;
    List<ShiftPattern> RoleShiftTemplate;
    List<HoursRequired> Requirement;
    
    //constructor
    Role(int id, String Name, String Color, List<ShiftPattern> Template, List<HoursRequired> req){
    	this.roleID = id;
    	this.name = Name;
    	this.color = Color;
    	this.RoleShiftTemplate = Template;
    	this.Requirement = req;
    }
}
