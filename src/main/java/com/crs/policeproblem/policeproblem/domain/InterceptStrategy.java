package com.crs.policeproblem.policeproblem.domain;

import java.util.List;

public interface InterceptStrategy {
    boolean intercept(Integer robber, List<Integer> leftRobbers, int allRobbersCount);
    void reset();
}
