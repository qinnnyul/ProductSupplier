package com.github.qinnnyul.game.domain;

public class Landscape
{
    private int x;
    private int y;
    private int maxX;
    private int maxY;

    public Landscape(int x, int y, int maxX, int maxY)
    {
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
    }


    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }


    public void moveYbackward()
    {
        if (y > 0) {
            y--;
        }
    }

    public void moveYforward()
    {
        if (y < maxY) {
            y++;
        }
    }

    public void moveXbackward()
    {
        if (x > 0) {
            x--;
        }
    }

    public void moveXforward()
    {
        if (x < maxX) {
            x++;
        }
    }
}
