package com.thoughtworks.trains.domain;

import com.thoughtworks.trains.exception.NoSuchOperatorException;

import static com.thoughtworks.trains.config.Constant.NO_SUCH_OPERATOR_ERROR;

public class Condition
{
    private final int value;
    private final Operator operator;

    public Condition(Operator operator, int value)
    {
        this.value = value;
        this.operator = operator;
    }

    public boolean check(int value)
    {
        boolean result;

        switch (operator) {
            case LESSTHAN:
                result = (value < this.value);
                break;
            case EQUALS:
                result = (value == this.value);
                break;
            case LAEGERTHAN:
                result = (value > this.value);
                break;
            case LESSER_OR_EQUAL:
                result = (value <= this.value);
                break;
            default:
                throw new NoSuchOperatorException(NO_SUCH_OPERATOR_ERROR);
        }
        return result;
    }


    public int getValue()
    {
        return value;
    }
}
