package com.github.qinnnyul.game.command;

import com.github.qinnnyul.game.domain.Rover;

import java.util.List;

public class CommandsExecutor
{
    private final Rover rover;

    public CommandsExecutor(Rover rover)
    {
        this.rover = rover;
    }

    public void run(List<Command> commands)
    {
        for (Command command : commands) {
            command.operate(rover);
        }

    }
}
