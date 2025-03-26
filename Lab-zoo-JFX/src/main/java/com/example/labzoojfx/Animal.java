package com.example.labzoojfx;

public abstract class Animal implements Eat{
    private String name;
    private float weight;
    private float height;
    private int age;

    public Animal()
    {
        name = "Unknow Animal";
    }

    public Animal(String name)
    {
        this.name = name;
        this.weight = 10;
        this.height = 10;
        this.age = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String eatingFood(){
        return "The animal: " + name + "is eating";
    }


}
