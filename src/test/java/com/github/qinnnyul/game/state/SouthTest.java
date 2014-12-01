package com.github.qinnnyul.game.state;

import com.github.qinnnyul.game.constant.Directive;
import com.github.qinnnyul.game.domain.Landscape;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SouthTest
{

    private Landscape landscape;

    @Before
    public void setUp() throws Exception
    {
        landscape = new Landscape(0, 0, 5, 5);
    }

    @Test
    public void should_get_east_when_it_turns_to_left() throws Exception
    {
        // given
        South south = new South(landscape);
        // when
        Direction direction = south.turnLeft();

        // then
        assertThat(direction.getDescription(), is(Directive.EAST.getDescription()));
    }


    @Test
    public void should_get_west_when_it_turns_to_right() throws Exception
    {
        // given
        South south = new South(landscape);
        // when
        Direction direction = south.turnRight();

        // then
        assertThat(direction.getDescription(), is(Directive.WEST.getDescription()));
    }
}