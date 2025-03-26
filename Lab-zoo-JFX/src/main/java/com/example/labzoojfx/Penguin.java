package com.example.labzoojfx;

import com.example.labzoojfx.Animal;
import com.example.labzoojfx.Swim;
import com.example.labzoojfx.Walk;

import java.io.Serial;
import java.io.Serializable;

public class Penguin extends Animal implements Walk, Swim, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    boolean isSwimming;
    int walkSpeed;
    int swimSpeed;

    public Penguin()
    {
        super("Penguin");
    }

    public boolean isSwimming() {
        return isSwimming;
    }

    public void setSwimming(boolean swimming) {
        isSwimming = swimming;
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public int getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    @Override
    public String eatingFood()
    {
        return "Pinguin: eu estou me alimentando com peixe";
    }

    @Override
    public String eatingCompleted()
    {

        return "Pinguin: eu me alimentei com peixe";
    }

    @Override
    public String swimming()
    {
       return "Pinguin: eu estou nadando em " + swimSpeed + " km por hora";
    }

    @Override
    public String walking()
    {
        return "Pinguin: eu estou caminhando em " + walkSpeed + " km por hora";
    }


    @Override
    public String toString() {
        return "Pinguin{" +
                "esta nadando=" + isSwimming +
                ", velocidade de caminhada=" + walkSpeed +
                ", velocidade de mergulho=" + swimSpeed +
                '}';
    }
}
