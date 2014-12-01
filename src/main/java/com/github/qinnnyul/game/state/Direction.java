package com.github.qinnnyul.game.state;

import com.github.qinnnyul.game.domain.Landscape;

public abstract class Direction
{
    protected Landscape landscape;

    protected Direction(Landscape landscape)
    {
        this.landscape = landscape;
    }

    public Landscape getLandscape()
    {
        return landscape;
    }

    public abstract String getDescription();

    public abstract Direction turnLeft();

    public abstract Direction turnRight();

    public abstract void move();
}
