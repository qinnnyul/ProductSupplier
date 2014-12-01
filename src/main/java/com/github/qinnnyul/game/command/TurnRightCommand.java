package com.github.qinnnyul.game.command;

import com.github.qinnnyul.game.domain.Rover;

public class TurnRightCommand implements Command
{
    @Override
    public void operate(Rover rover)
    {
        rover.turnRight();
    }
}
