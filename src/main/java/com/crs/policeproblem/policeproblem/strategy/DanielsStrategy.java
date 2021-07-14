package com.crs.policeproblem.policeproblem.strategy;

import com.crs.policeproblem.policeproblem.domain.InterceptStrategy;

import java.util.List;

public class DanielsStrategy implements InterceptStrategy {
    int tallestRobberCount = 0;
    int tallestRobber = 0;

    @Override
    public boolean intercept(Integer robber, List<Integer> leftRobbers, int allRobbersCount) {
        if (robber > tallestRobber) {
            tallestRobberCount++;
            tallestRobber = robber;
        }

        return tallestRobberCount == (int) Math.round(Math.log(allRobbersCount / 1.6));
    }

    @Override
    public void reset() {
        tallestRobberCount = 0;
        tallestRobber = 0;
    }

}
