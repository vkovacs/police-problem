package com.crs.policeproblem.policeproblem.strategy;

import com.crs.policeproblem.policeproblem.domain.InterceptStrategy;

import java.util.List;

public class TallerThenAverageAfterHalfwayStrategy implements InterceptStrategy {
    @Override
    public boolean intercept(Integer robber, List<Integer> leftRobbers, int allRobbersCount) {
        if (leftRobbers.size() > allRobbersCount / 2) {
            int average = (int) leftRobbers.stream().mapToInt(value -> value).average().orElse(0);
            return robber > average;
        }
        return false;
    }

    @Override
    public void reset() {
        //No implementation needed here.
    }
}
