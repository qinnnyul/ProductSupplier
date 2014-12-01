package com.github.qinnnyul.game.domain;

import com.github.qinnnyul.game.constant.Directive;
import com.github.qinnnyul.game.state.East;
import com.github.qinnnyul.game.state.North;
import com.github.qinnnyul.game.state.South;
import com.github.qinnnyul.game.state.West;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoverTest
{

    private Landscape landscape;

    @Before
    public void setUp() throws Exception
    {
        landscape = new Landscape(1, 1, 5, 5);
    }

    @Test
    public void should_move_x_forward_when_rover_face_east() throws Exception
    {
        // given
        Rover rover = new Rover(new East(landscape));
        // when
        rover.move();
        // then
        assertThat(rover.getX(), is(2));
        assertThat(rover.getY(), is(1));
    }

    @Test
    public void should_move_x_backward_when_rover_face_west() throws Exception
    {
        // given
        Rover rover = new Rover(new West(landscape));
        // when
        rover.move();
        // then
        assertThat(rover.getX(), is(0));
        assertThat(rover.getY(), is(1));
    }

    @Test
    public void should_move_y_forward_when_rover_face_north() throws Exception
    {
        // given
        Rover rover = new Rover(new North(landscape));
        // when
        rover.move();
        // then
        assertThat(rover.getX(), is(1));
        assertThat(rover.getY(), is(2));
    }

    @Test
    public void should_move_y_backward_when_rover_face_south() throws Exception
    {
        // given
        Rover rover = new Rover(new South(landscape));
        // when
        rover.move();
        // then
        assertThat(rover.getX(), is(1));
        assertThat(rover.getY(), is(0));
    }

    @Test
    public void should_be_west_and_move_x_backward_when_rover_face_north_turn_left_and_move() throws Exception
    {
        // given
        Rover rover = new Rover(new North(landscape));
        // when
        rover.turnLeft();
        rover.move();
        // then
        assertThat(rover.getX(), is(0));
        assertThat(rover.getY(), is(1));
        assertThat(rover.getDirection(), is(Directive.WEST.getDescription()));

    }


    @Test
    public void should_be_east_and_move_x_forward_when_rover_face_north_turn_right_and_move() throws Exception
    {
        // given
        Rover rover = new Rover(new North(landscape));
        // when
        rover.turnRight();
        rover.move();
        // then
        assertThat(rover.getX(), is(2));
        assertThat(rover.getY(), is(1));
        assertThat(rover.getDirection(), is(Directive.EAST.getDescription()));

    }

    @Test
    public void should_not_excess_boundary_when_rover_face_west() throws Exception
    {
        // given
        Rover rover = new Rover(new West(landscape));
        // when
        for (int i = 0; i < 3; i++){
            rover.move();
        }
        // then
        assertThat(rover.getX(), is(0));
        assertThat(rover.getY(), is(1));
        assertThat(rover.getDirection(), is(Directive.WEST.getDescription()));
    }

    @Test
    public void should_not_excess_boundary_when_rover_face_east() throws Exception
    {
        // given
        Rover rover = new Rover(new East(landscape));
        // when
        for (int i = 0; i < 5; i++){
            rover.move();
        }
        // then
        assertThat(rover.getX(), is(5));
        assertThat(rover.getY(), is(1));
        assertThat(rover.getDirection(), is(Directive.EAST.getDescription()));
    }

    @Test
    public void should_not_excess_boundary_when_rover_face_north() throws Exception
    {
        // given
        Rover rover = new Rover(new North(landscape));
        // when
        for (int i = 0; i < 5; i++){
            rover.move();
        }
        // then
        assertThat(rover.getX(), is(1));
        assertThat(rover.getY(), is(5));
        assertThat(rover.getDirection(), is(Directive.NORTH.getDescription()));
    }

    @Test
    public void should_not_excess_boundary_when_rover_face_south() throws Exception
    {
        // given
        Rover rover = new Rover(new South(landscape));
        // when
        for (int i = 0; i < 5; i++){
            rover.move();
        }
        // then
        assertThat(rover.getX(), is(1));
        assertThat(rover.getY(), is(0));
        assertThat(rover.getDirection(), is(Directive.SOUTH.getDescription()));
    }
}
