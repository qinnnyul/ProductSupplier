package com.github.qinnnyul.game.domain;

import com.github.qinnnyul.game.state.Direction;

public class Rover
{
    private Direction direction;

    public Rover(Direction direction)
    {
        this.direction = direction;
    }

    public void move()
    {
        direction.move();
    }

    public int getX()
    {
        return direction.getLandscape().getX();
    }

    public int getY()
    {
        return direction.getLandscape().getY();
    }

    public void turnLeft()
    {
        direction = direction.turnLeft();
    }

    public String getDirection()
    {
        return direction.getDescription();
    }

    public void turnRight()
    {
        direction = direction.turnRight();
    }
}
