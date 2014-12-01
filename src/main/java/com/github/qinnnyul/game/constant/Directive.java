package com.github.qinnnyul.game.constant;

public enum Directive
{
    WEST("W"), EAST("E"), NORTH("N"), SOUTH("S");


    private final String description;

    Directive(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
}
