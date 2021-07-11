package com.crs.policeproblem.policeproblem.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

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

    public static Building ofSize(int size) {
        var building = new Building();
        while (building.robbers.size() < size) {
            building.addRobber(ThreadLocalRandom.current().nextInt(160, 201));
        }
        return building;
    }

    public Set<Integer> robbers() {
        return Collections.unmodifiableSet(robbers);
    }

    public Integer robberLeave() {
        if (robbers.isEmpty()) {
            throw new IllegalArgumentException("The building is empty!");
        }

        List<Integer> robberList = new ArrayList<>(robbers);
        var randomRobber = robberList.get(ThreadLocalRandom.current().nextInt(0, robbers.size()));

        robbers.remove(randomRobber);
        return randomRobber;
    }

    private void addRobber(Integer robber) {
        robbers.add(robber);
    }
}
