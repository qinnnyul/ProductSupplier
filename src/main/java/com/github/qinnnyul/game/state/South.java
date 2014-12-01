package com.github.qinnnyul.game.state;

import com.github.qinnnyul.game.constant.Directive;
import com.github.qinnnyul.game.domain.Landscape;

public class South extends Direction
{

    public South(Landscape landscape)
    {
        super(landscape);
    }

    @Override
    public String getDescription()
    {
        return Directive.SOUTH.getDescription();
    }

    @Override
    public Direction turnLeft()
    {
        return new East(landscape);
    }

    @Override
    public Direction turnRight()
    {
        return new West(landscape);
    }

    @Override
    public void move()
    {
        landscape.moveYbackward();
    }
}
