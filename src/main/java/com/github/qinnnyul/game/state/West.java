package com.github.qinnnyul.game.state;

import com.github.qinnnyul.game.domain.Landscape;

import static com.github.qinnnyul.game.constant.Directive.WEST;

public class West extends Direction
{

    public West(Landscape landscape)
    {
        super(landscape);
    }

    @Override
    public String getDescription()
    {
        return WEST.getDescription();
    }

    @Override
    public Direction turnLeft()
    {
        return new South(landscape);
    }

    @Override
    public Direction turnRight()
    {
        return new North(landscape);
    }

    @Override
    public void move()
    {
        landscape.moveXbackward();
    }
}
