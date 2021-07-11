package com.crs.policeproblem.policeproblem.domain;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class Building {
    private final Set<Integer> robbers = new HashSet<>();

    private Building() {
    }

    public static Building of(Integer... robbers) {
        var building = new Building();
        building.robbers.addAll(Arrays.asList(robbers));

        return building;
    }

    public Set<Integer> robbers() {
        return Collections.unmodifiableSet(robbers);
    }
}
