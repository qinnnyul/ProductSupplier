package com.github.qinnnyul.game.command;

import com.github.qinnnyul.game.constant.Directive;
import com.github.qinnnyul.game.domain.Landscape;
import com.github.qinnnyul.game.domain.Rover;
import com.github.qinnnyul.game.state.East;
import com.github.qinnnyul.game.state.North;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CommandsExecutorTest
{
    @Test
    public void should_be_able_to_execute_turn_left_command() throws Exception
    {
        // given
        List<Command> commands = ImmutableList.<Command>builder().add(new TurnLeftCommand()).build();

        Rover rover = new Rover(new North(new Landscape(0, 0, 5, 5)));
        CommandsExecutor commandsExecutor = new CommandsExecutor(rover);
        // when
        commandsExecutor.run(commands);

        // then
        assertThat(rover.getDirection(), is(Directive.WEST.getDescription()));
    }

    @Test
    public void should_be_able_to_execute_turn_right_command() throws Exception
    {
        // given
        List<Command> commands = ImmutableList.<Command>builder().add(new TurnRightCommand()).build();

        Rover rover = new Rover(new North(new Landscape(0, 0, 5, 5)));
        CommandsExecutor commandsExecutor = new CommandsExecutor(rover);
        // when
        commandsExecutor.run(commands);

        // then
        assertThat(rover.getDirection(), is(Directive.EAST.getDescription()));
    }

    @Test
    public void should_be_able_to_execute_move_command() throws Exception
    {
        // given
        List<Command> commands = ImmutableList.<Command>builder().add(new MoveCommand()).build();

        Rover rover = new Rover(new North(new Landscape(0, 0, 5, 5)));
        CommandsExecutor commandsExecutor = new CommandsExecutor(rover);
        // when
        commandsExecutor.run(commands);

        // then
        assertThat(rover.getDirection(), is(Directive.NORTH.getDescription()));
        assertThat(rover.getX(), is(0));
        assertThat(rover.getY(), is(1));
    }


    @Test
    public void should_be_able_to_execute_a_list_of_commands() throws Exception
    {
        // given
        List<Command> commands = ImmutableList.<Command>builder().add(new TurnLeftCommand()).add(new MoveCommand()).add(new TurnLeftCommand())
                .add(new MoveCommand()).add(new TurnLeftCommand()).add(new MoveCommand()).add(new TurnLeftCommand()).add(new MoveCommand()).add(new
                        MoveCommand()).build();

        Rover rover = new Rover(new North(new Landscape(1, 2, 5, 5)));
        CommandsExecutor commandsExecutor = new CommandsExecutor(rover);
        // when
        commandsExecutor.run(commands);

        // then
        assertThat(rover.getDirection(), is(Directive.NORTH.getDescription()));
        assertThat(rover.getX(), is(1));
        assertThat(rover.getY(), is(3));
    }

    @Test
    public void should_be_able_to_execute_a_list_of_commands2() throws Exception
    {
        // given
        List<Command> commands = ImmutableList.<Command>builder().add(new MoveCommand()).add(new MoveCommand()).add(new TurnRightCommand()).add
                (new MoveCommand()).add(new MoveCommand()).add(new TurnRightCommand()).add(new MoveCommand()).add(new TurnRightCommand()).add(new
                TurnRightCommand()).add(new MoveCommand()).build();

        Rover rover = new Rover(new East(new Landscape(3, 3, 5, 5)));
        CommandsExecutor commandsExecutor = new CommandsExecutor(rover);
        // when
        commandsExecutor.run(commands);

        // then
        assertThat(rover.getDirection(), is(Directive.EAST.getDescription()));
        assertThat(rover.getX(), is(5));
        assertThat(rover.getY(), is(1));
    }

}
