package com.mycompany.seassignment1part2;

public class Pet {
    public String name;
    public int age;

    // Constructor
    public Pet(String inputName, int inputAge) {
        this.name = inputName;
        this.age = inputAge;
    }
    
    // Set name
    public void setName(String newName) {
        this.name = newName;
    }
    
    // Set age
    public void setAge  (int newAge) {
        this.age = newAge;
    }
}
