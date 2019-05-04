package com.CMSC447.nurseroster.domain;

import org.javatuples.Pair;

import java.time.Duration;
import java.util.List;

public class Sequence {
    List<ShiftPattern> shiftPatterns;
    List<Pair<Duration, Duration>> startTimeDifferenceRanges;
    List<Pair<Duration, Duration>> endTimeDifferenceRanges;
    List<Pair<Duration, Duration>> timeGapSizeRanges;
}
