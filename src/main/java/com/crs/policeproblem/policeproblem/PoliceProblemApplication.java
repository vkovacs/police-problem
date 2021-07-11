package com.crs.policeproblem.policeproblem;

import com.crs.policeproblem.policeproblem.domain.Building;
import com.crs.policeproblem.policeproblem.domain.Officer;
import com.crs.policeproblem.policeproblem.strategy.EagerStrategy;
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
        results.put("EagerStrategy", 0);
        int allRun = 10_000;

        int allRobbersCount = 5;

        for (int i = 0; i < allRun; i++) {
            var building = Building.ofSize(allRobbersCount);

            var eagerOfficer = new Officer(new EagerStrategy(), allRobbersCount);

            while (!building.robbers().isEmpty()) {
                var robber = building.robberLeave();
                var intercept = eagerOfficer.intercept(robber);

                if (intercept) {
                    if (robber.equals(building.leader())) {
                        var currentSuccessCount = results.get("EagerStrategy");
                        results.put("EagerStrategy", ++currentSuccessCount);
                    }
                    break;
                }
            }
        }

        System.out.println(results);
    }
}
