package com.github.qinnnyul.game.command;

import com.github.qinnnyul.game.domain.Rover;

public class TurnLeftCommand implements Command
{
    @Override
    public void operate(Rover rover)
    {
        rover.turnLeft();
    }
}
