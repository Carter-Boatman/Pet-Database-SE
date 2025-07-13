package com.mycompany.seassignment1part2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Release 2: Your program should allow searching of pets. 

public class SEAssignment1Part2 {
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        List<Pet> petArray = new ArrayList<Pet>();
        boolean done = false;
        boolean running = true;
        int option;
        
        /* Main menu */
        System.out.println("Pet Database Program.");
        while (running == true) {
            System.out.print("""

                           What would you like to do?
                           1) View all pets
                           2) Add more pets
                           3) Update an existing pet
                           4) Remove an existing pet
                           5) Search pets by name
                           6) Search pets by age
                           7) Exit program

                           Your choice: """);
           // gets user choice
           option = scnr.nextInt();

           switch (option) {
                case 1 -> {
                    int rowCount = 0;
                    /* Prints table of pets */
                    System.out.printf("+------------------------+\n");
                    System.out.printf("| %-3S | %-10S | %3s |\n", "ID", "NAME", "AGE");
                    System.out.printf("+------------------------+\n");
                    for (Pet chosenPet : petArray) {
                        System.out.printf("| %-3S | %-10S | %3s |\n", petArray.indexOf(chosenPet), chosenPet.name, chosenPet.age);
                        rowCount += 1;
                    }
                    System.out.println("+------------------------+\n" + rowCount + " rows in set.");
                }
                case 2 -> {
                    /* Add pets loop */
                    int numPetsAdded = 0;
                    
                    while (done == false){
                        System.out.print("add pet (name, age): ");
                        String inputName = scnr.next();
                        
                        if (inputName.equals("done")) {
                            System.out.println(numPetsAdded + " pets added.");
                            //done = true;
                            break;
                        }
                        
                        int inputAge = scnr.nextInt();
                        
                        
                        petArray.add(new Pet(inputName, inputAge));
                        numPetsAdded += 1;
                    }
                    done = false; // boolean changed so the loop can be reentered
                }
                case 3 -> {
                    /* Update an existing pet */
                    System.out.println("Update an existing pet feature coming in next release!");
                }
                case 4 -> {
                    /* Remove an existing pet */
                    System.out.println("Remove an existing pet feature coming in next release!");
                }
                case 5 -> {
                    /* Search pets by name */
                    System.out.print("Enter a name to search: ");
                    String searchName = scnr.next();
                    
                    /* Prints table with pets having the searched name */
                    int rowCount = 0;
                    System.out.printf("+------------------------+\n");
                    System.out.printf("| %-3S | %-10S | %3s |\n", "ID", "NAME", "AGE");
                    System.out.printf("+------------------------+\n");
                    for (Pet petFound : petArray) {
                        if (petFound.name.equalsIgnoreCase(searchName)) {
                            System.out.printf("| %-3S | %-10S | %3s |\n", petArray.indexOf(petFound), petFound.name, petFound.age);
                            rowCount += 1;
                        }                          
                    }
                    System.out.println("+------------------------+\n" + rowCount + " rows in set.");
                }
                case 6 -> {
                    /* Search pets by age */
                    System.out.print("Enter an age to search: ");
                    int searchAge = scnr.nextInt();
                    
                    /* Prints table with pets having the searched age */
                    int rowCount = 0;
                    System.out.printf("+------------------------+\n");
                    System.out.printf("| %-3S | %-10S | %3s |\n", "ID", "NAME", "AGE");
                    System.out.printf("+------------------------+\n");
                    for (Pet petFound : petArray) {
                        if (petFound.age == searchAge){
                            System.out.printf("| %-3S | %-10S | %3s |\n", petArray.indexOf(petFound), petFound.name, petFound.age);
                            rowCount += 1;
                        }
                    }
                    System.out.println("+------------------------+\n" + rowCount + " rows in set.");
                }
                case 7 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid input.");
           } 
        }
    }
}
