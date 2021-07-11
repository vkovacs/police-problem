package com.crs.policeproblem.policeproblem.domain;

import org.hamcrest.comparator.ComparatorMatcherBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

class BuildingTest {

    private Building underTest;

    @Test
    void shouldGenerateGivenNumberRobbers() {
        var building = Building.of(200, 190, 180, 170, 160);
        assertThat(building.robbers(), hasSize(5));
    }

    @Test
    void shouldBeFewerRobbersInBuildingWhenOneComesOut() {
        var building = Building.of(200, 190, 180, 170, 160);
        var robber = building.robberLeave();
        assertThat(robber, is(both(ComparatorMatcherBuilder.<Integer>usingNaturalOrdering().greaterThanOrEqualTo(160)).and(ComparatorMatcherBuilder.<Integer>usingNaturalOrdering().lessThanOrEqualTo(200))));
        assertThat(building.robbers(), hasSize(4));
        assertThat(building.robbers(), not(hasItem(robber)));
    }

    @Test
    void shouldBeFewerRobbersInBuildingWhenOneComesOutMultipleTimes() {
        var building = Building.of(200, 190, 180, 170, 160);
        var robber = building.robberLeave();
        assertThat(robber, is(both(ComparatorMatcherBuilder.<Integer>usingNaturalOrdering().greaterThanOrEqualTo(160)).and(ComparatorMatcherBuilder.<Integer>usingNaturalOrdering().lessThanOrEqualTo(200))));
        assertThat(building.robbers(), hasSize(4));
        assertThat(building.robbers(), not(hasItem(robber)));

        var robber2 = building.robberLeave();
        assertThat(robber2, is(both(ComparatorMatcherBuilder.<Integer>usingNaturalOrdering().greaterThanOrEqualTo(160)).and(ComparatorMatcherBuilder.<Integer>usingNaturalOrdering().lessThanOrEqualTo(200))));
        assertThat(building.robbers(), hasSize(3));
        assertThat(building.robbers(), not(hasItem(robber2)));
    }

    @Test
    void shouldThrowExceptionWhenRemovingRobberFromEmptyBuilding() {
        var building = Building.of(200);
        var robber = building.robberLeave();

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, building::robberLeave);
        assertThat(exception.getMessage(), is("The building is empty!"));
    }
}