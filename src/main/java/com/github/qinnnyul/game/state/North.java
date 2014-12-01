package com.github.qinnnyul.game.state;

import com.github.qinnnyul.game.domain.Landscape;

import static com.github.qinnnyul.game.constant.Directive.NORTH;

public class North extends Direction
{
    public North(Landscape landscape)
    {
        super(landscape);
    }

    public Direction turnLeft()
    {
        return new West(landscape);
    }

    public Direction turnRight()
    {
        return new East(landscape);
    }

    @Override
    public void move()
    {
        landscape.moveYforward();

    }

    @Override
    public String getDescription()
    {
        return NORTH.getDescription();
    }
}
