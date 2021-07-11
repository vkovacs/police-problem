package com.crs.policeproblem.policeproblem.domain;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class BuildingTest {

    private Building underTest;

    @Test
    void shouldGenerateGivenNumberRobbers() {
        var building = Building.of(200, 190, 180, 170, 160);
        assertThat(building.robbers(), IsCollectionWithSize.hasSize(5));
    }
}