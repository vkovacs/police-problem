package com.crs.policeproblem.policeproblem.strategy;

import com.crs.policeproblem.policeproblem.domain.InterceptStrategy;

import java.util.List;

public class CatchFirstWhichIsTallerThanPreviousStrategy implements InterceptStrategy {
    @Override
    public boolean intercept(Integer robber, List<Integer> leftRobbers, int allRobbersCount) {
        if (leftRobbers.isEmpty()) {
            return false;
        }
        var previousRobber = leftRobbers.get(leftRobbers.size() - 1);

        return robber > previousRobber;
    }

    @Override
    public void reset() {
        //No implementation needed here.
    }
}
