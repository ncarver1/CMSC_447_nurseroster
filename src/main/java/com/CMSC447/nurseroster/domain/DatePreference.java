package com.CMSC447.nurseroster.domain;

import org.drools.core.rule.Declaration;
import org.drools.core.spi.Constraint;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class DatePreference implements Preference {

    //LocalDate startDate;
    //LocalDate endDate;
    Boolean isPosPref; 
    String StartDate;
    String EndDate;
    String location; 
    
    DatePreference(Boolean pref, String start, String end, String loc){
    	this.isPosPref = pref;
    	this.StartDate = start;
    	this.EndDate = end;
    	this.location = loc; 
    }
    
    @Override
    public int score(List<Shift> shiftAssignments, Employee employee) {
        return 0;
    }

    @Override
    public Declaration[] getRequiredDeclarations() {
        return new Declaration[0];
    }

    @Override
    public void replaceDeclaration(Declaration oldDecl, Declaration newDecl) {

    }

    @Override
    public Constraint clone() {
        return null;
    }

    @Override
    public ConstraintType getType() {
        return null;
    }

    @Override
    public boolean isTemporal() {
        return false;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
