package com.github.qinnnyul.game.state;

import com.github.qinnnyul.game.constant.Directive;
import com.github.qinnnyul.game.domain.Landscape;

public class East extends Direction
{

    public East(Landscape landscape)
    {
        super(landscape);
    }

    @Override
    public String getDescription()
    {
        return Directive.EAST.getDescription();
    }

    @Override
    public Direction turnLeft()
    {
        return new North(landscape);
    }

    @Override
    public Direction turnRight()
    {
        return new South(landscape);
    }

    @Override
    public void move()
    {
        landscape.moveXforward();
    }
}
