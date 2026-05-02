package com.example.java.basics;

// Simple class inheritance
class Animal {
    void eat() {
        System.out.println("Animal is eating.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking.");
    }
}

// Multiple inheritance using interfaces
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck is flying.");
    }

    public void swim() {
        System.out.println("Duck is swimming.");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        // Simple inheritance
        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        // Multiple interface inheritance
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
    }
}

