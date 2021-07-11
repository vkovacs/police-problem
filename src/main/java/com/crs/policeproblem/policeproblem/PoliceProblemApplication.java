package com.crs.policeproblem.policeproblem;

import com.crs.policeproblem.policeproblem.domain.Building;
import com.crs.policeproblem.policeproblem.domain.Officer;
import com.crs.policeproblem.policeproblem.strategy.EagerStrategy;
import com.crs.policeproblem.policeproblem.strategy.CatchFirstWhichIsTallerThanPreviousStrategy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PoliceProblemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PoliceProblemApplication.class, args);
    }

    @Override
    public void run(String... args) {

        final Map<String, Integer> results = new HashMap<>();
        int allRunCount = 100_000;
        int robbersCount = 30;

        var eagerOfficer = new Officer(new EagerStrategy(), robbersCount);
        results.put("EagerStrategy", executeSuit(robbersCount, eagerOfficer, allRunCount));

        var catchFirstWhichIsTallerThanPreviousStrategy = new Officer(new CatchFirstWhichIsTallerThanPreviousStrategy(), robbersCount);
        results.put("CatchFirstWhichIsTallerThanPreviousStrategy", executeSuit(robbersCount, catchFirstWhichIsTallerThanPreviousStrategy, allRunCount));

        System.out.println(results);
    }

    private int executeSuit(int robbersCount, Officer officer, int allRunCount) {
        int successCount = 0;
        for (int i = 0; i < allRunCount; i++) {
            var result = execute(robbersCount, officer);
            if (result) {
                successCount++;
            }
        }
        return successCount;
    }

    private boolean execute(int robbersCount, Officer officer) {
        var building = Building.ofSize(robbersCount);

        while (!building.robbers().isEmpty()) {
            var robber = building.robberLeave();
            var intercept = officer.intercept(robber);

            if (intercept) {
                return robber.equals(building.leader());
            }
        }
        return false; //lazy officer does not intercept anyone
    }
}
