package com.github.qinnnyul.game.state;

import com.github.qinnnyul.game.constant.Directive;
import com.github.qinnnyul.game.domain.Landscape;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EastTest
{

    private Landscape landscape;

    @Before
    public void setUp() throws Exception
    {
        landscape = new Landscape(0, 0, 5, 5);
    }

    @Test
    public void should_get_north_when_it_turns_to_left() throws Exception
    {
        // given
        East east = new East(landscape);
        // when
        Direction direction = east.turnLeft();

        // then
        assertThat(direction.getDescription(), is(Directive.NORTH.getDescription()));
    }

    @Test
    public void should_get_south_when_it_turns_to_right() throws Exception
    {
        // given
        East east = new East(landscape);
        // when
        Direction direction = east.turnRight();

        // then
        assertThat(direction.getDescription(), is(Directive.SOUTH.getDescription()));
    }

}