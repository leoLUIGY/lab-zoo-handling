package com.example.labzoojfx;

import com.example.labzoojfx.Animal;
import com.example.labzoojfx.Swim;

import java.io.Serial;
import java.io.Serializable;

public class Dolphin extends Animal implements Swim, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String color;
    private int swimmingSpeed;


    public Dolphin()
    {
        super("Dolphin");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public String eatingFood() {
        return "Golfinho: eu estou me alimentando de peixe";
    }

    @Override
    public String eatingCompleted() {

        return "Golfinho: eu me alimentei de peixe.";
    }

    @Override
    public String swimming() {

        return "Golfinho: eu estou nadando na velocidade de " + getSwimmingSpeed() + "km por hora";
    }

    @Override
    public String toString() {
        return "Golfinho{" +
                "cor='" + color + '\'' +
                ", velocidade de mergulho=" + swimmingSpeed +
                '}';
    }
}
