package com.mycompany.seassignment1part2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Release 1: Your program should allow adding and displaying of pets 

public class SEAssignment1Part2 {
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        List<Pet> petArray = new ArrayList<Pet>();
        boolean done = false;
        boolean running = true;
        int option;
        
        /* Main menu */
        while (running == true) {
            System.out.print("""
                             
                           Pet Database Program.

                           What would you like to do?
                           1) View all pets
                           2) Add more pets
                           3) Exit

                           Your choice: """);
           // gets user choice
           option = scnr.nextInt();

           switch (option) {
                case 1 -> {
                    System.out.printf("+------------------------+\n");
                    System.out.printf("| %-3S | %-10S | %3s |\n", "ID", "NAME", "AGE");
                    System.out.printf("+------------------------+\n");
                    for (Pet chosenPet : petArray) {
                        System.out.printf("| %-3S | %-10S | %3s |\n", petArray.indexOf(chosenPet), chosenPet.name, chosenPet.age);
                    }
                    System.out.printf("+------------------------+\n");
                }
                case 2 -> {
                    /* Add pets loop */
                    while (done == false){
                        System.out.print("Enter the name of the pet you would like to add (type \"done\" to exit): ");
                        String inputName = scnr.next();
                        
                        if (inputName.equals("done")) {
                            System.out.println("Exiting input...");
                            done = true;
                            break;
                        }
                        
                        System.out.print("Enter the age of " + inputName + ": ");
                        int inputAge = scnr.nextInt();
                        
                        petArray.add(new Pet(inputName, inputAge));
                    }
                    done = false; // boolean changed so the loop can be reentered
                }
                case 3 -> {
                    running = false;
                    System.out.println("Goodbye");
                }
                default -> System.out.println("Invalid input.");
           } 
        }
    }
}
