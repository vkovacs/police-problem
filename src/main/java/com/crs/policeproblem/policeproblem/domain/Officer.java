package com.crs.policeproblem.policeproblem.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Officer {
    @Getter
    private final InterceptStrategy interceptStrategy;
    private final int allRobbersCount;
    private final List<Integer> leftRobbers = new ArrayList<>();


    public boolean intercept(Integer robber) {
        var intercept = interceptStrategy.intercept(robber, leftRobbers, allRobbersCount);

        if (!intercept) {
            leftRobbers.add(robber);
        }

        return intercept;
    }

    public void reset() {
        interceptStrategy.reset();
    }
}
