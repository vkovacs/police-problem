package com.crs.policeproblem.policeproblem.strategy;

import com.crs.policeproblem.policeproblem.domain.InterceptStrategy;

import java.util.List;

public class EagerStrategy implements InterceptStrategy {
    @Override
    public boolean intercept(List<Integer> leftRobbers, int allRobbersCount) {
        return true;
    }
}
