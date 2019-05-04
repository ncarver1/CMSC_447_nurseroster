package com.CMSC447.nurseroster.domain;

import org.drools.compiler.lang.Location;

public interface Preference extends PersonalConstraint {
    boolean isPositivePreference = false;
    Location location = null;

}
