package com.thoughtworks.trains.domain;

import com.thoughtworks.trains.domain.DistancesCondition;
import com.thoughtworks.trains.domain.Operator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DistancesConditionTest
{
    @Test
    public void should_compare_if_the_value_meet_the_lessthan_condition() throws Exception
    {
        // given
        DistancesCondition distancesCondition = new DistancesCondition(Operator.LESSTHAN, 3);
        // when
        boolean check = distancesCondition.check(3);
        // then
        assertThat(check, is(false));
    }


    @Test
    public void should_compare_if_the_value_meet_the_equals_condition() throws Exception
    {
        // given
        DistancesCondition distancesCondition = new DistancesCondition(Operator.EQUALS, 3);
        // when
        boolean check = distancesCondition.check(3);
        // then
        assertThat(check, is(true));
    }


    @Test
    public void should_compare_if_the_value_meet_the_largerthan_condition() throws Exception
    {
        // given
        DistancesCondition distancesCondition = new DistancesCondition(Operator.LAEGERTHAN, 3);
        // when
        boolean check = distancesCondition.check(4);
        // then
        assertThat(check, is(true));
    }
}