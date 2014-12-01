package com.github.qinnnyul.game.state;

import com.github.qinnnyul.game.domain.Landscape;
import org.junit.Before;
import org.junit.Test;

import static com.github.qinnnyul.game.constant.Directive.NORTH;
import static com.github.qinnnyul.game.constant.Directive.SOUTH;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WestTest
{

    private Landscape landscape;

    @Before
    public void setUp() throws Exception
    {
        landscape = new Landscape(0, 0, 5, 5);
    }

    @Test
    public void should_get_south_when_it_turns_to_left() throws Exception
    {
        // given
        West west = new West(landscape);
        // when
        Direction direction = west.turnLeft();

        // then
        assertThat(direction.getDescription(), is(SOUTH.getDescription()));
    }

    @Test
    public void should_get_north_when_it_turns_to_right() throws Exception
    {
        // given
        West west = new West(landscape);
        // when
        Direction direction = west.turnRight();

        // then
        assertThat(direction.getDescription(), is(NORTH.getDescription()));
    }
}
