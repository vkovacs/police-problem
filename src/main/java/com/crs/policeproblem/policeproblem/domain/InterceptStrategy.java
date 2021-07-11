package com.crs.policeproblem.policeproblem.domain;

import java.util.List;

public interface InterceptStrategy {
    boolean intercept(List<Integer> leftRobbers, int allRobbersCount);
}
