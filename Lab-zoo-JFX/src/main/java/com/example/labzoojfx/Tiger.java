package com.example.labzoojfx;

import com.example.labzoojfx.Animal;
import com.example.labzoojfx.Walk;

import java.io.Serial;
import java.io.Serializable;

public class Tiger extends Animal implements Walk, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int numberOfStripes;
    private int speed;
    private int soundLevel;

    public Tiger()
    {
        super("Tiger");
    }

    public int getNumberOfStripes() {
        return numberOfStripes;
    }

    public void setNumberOfStripes(int numberOfStripes) {
        this.numberOfStripes = numberOfStripes;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSoundLevel() {
        return soundLevel;
    }

    public void setSoundLevel(int soundLevel) {
        this.soundLevel = soundLevel;
    }

    @Override
    public String eatingCompleted()
    {
        return "Tiger: eu me alimentei de carne.";
    }

    @Override
    public String walking()
    {

        return "Tigre: eu estou me movimentando em " + speed + " km por hora";
    }

    @Override
    public String toString() {
        return "Tigre{" +
                "numero de listras=" + numberOfStripes +
                ", velocidade=" + speed +
                ", Nivel de som=" + soundLevel +
                '}';
    }
}
