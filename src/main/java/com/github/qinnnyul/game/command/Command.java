package com.github.qinnnyul.game.command;

import com.github.qinnnyul.game.domain.Rover;

public interface Command
{
    void operate(Rover rover);
}
