package com.mycompany.seassignment1part2;
import java.util.ArrayList;
import java.util.Scanner;
//Release 3: Your program should allow for updating and removing pets. 

public class SEAssignment1Part2 {
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Pet> petArray = new ArrayList<Pet>();
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
                    /* Calls function to display all pets */
                    displayPets(petArray);
                }
                case 2 -> {
                    /* Add pets loop */
                    int numPetsAdded = 0;
                    
                    while (done == false){
                        System.out.print("add pet (name, age): ");
                        String inputName = scnr.next();
                        
                        // if user is done, loop is exited
                        if (inputName.equals("done")) {
                            System.out.println(numPetsAdded + " pets added.");
                            done = true;
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
                    displayPets(petArray); // Display all pets to show Id's available
                    System.out.print("Enter the pet ID you want to update: ");
                    int updateTargetId = scnr.nextInt();
                    
                    System.out.print("Enter new name and new age: ");
                    String newName = scnr.next();
                    int newAge = scnr.nextInt();
                    
                    /* Performs update while informing user */
                    System.out.print(petArray.get(updateTargetId).name + " " + petArray.get(updateTargetId).age + " changed to ");
                    petArray.get(updateTargetId).setName(newName); // name is updated
                    petArray.get(updateTargetId).setAge(newAge); // age is updated
                    System.out.println(petArray.get(updateTargetId).name + " " + petArray.get(updateTargetId).age + ".");  
                }
                case 4 -> {
                    /* Remove an existing pet */
                    displayPets(petArray); // Display all pets to show Id's available
                    System.out.print("Enter the pet ID to remove: ");
                    int removeTargetId = scnr.nextInt();
                    
                    /* Removes pet while informing user */
                    System.out.print(petArray.get(removeTargetId).name + " " + petArray.get(removeTargetId).age);
                    petArray.remove(removeTargetId); // pet is removed
                    System.out.println(" is removed");
                }
                case 5 -> {
                    /* Search pets by name */
                    System.out.print("Enter a name to search: ");
                    String searchName = scnr.next();
                    
                    /* Prints table with pets having the searched name */
                    int rowCount = 0;
                    System.out.printf("+------------------------+\n");
                    System.out.printf("| %3S | %-10S | %3s |\n", "ID", "NAME", "AGE");
                    System.out.printf("+------------------------+\n");
                    for (Pet petFound : petArray) {
                        if (petFound.name.equalsIgnoreCase(searchName)) {
                            System.out.printf("| %3S | %-10S | %3s |\n", petArray.indexOf(petFound), petFound.name, petFound.age);
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
                    System.out.printf("| %3S | %-10S | %3s |\n", "ID", "NAME", "AGE");
                    System.out.printf("+------------------------+\n");
                    for (Pet petFound : petArray) {
                        if (petFound.age == searchAge){
                            System.out.printf("| %3S | %-10S | %3s |\n", petArray.indexOf(petFound), petFound.name, petFound.age);
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
    
    /* Prints the table of all pets in the database */
    public static void displayPets(ArrayList<Pet> petArray){
        int rowCount = 0;
        /* Prints table of pets */
        System.out.printf("\n+------------------------+\n");
        System.out.printf("| %3S | %-10S | %3s |\n", "ID", "NAME", "AGE");
        System.out.printf("+------------------------+\n");
        for (Pet petObj : petArray) {
            System.out.printf("| %3S | %-10S | %3s |\n", petArray.indexOf(petObj), petObj.name, petObj.age);
            rowCount += 1;
        }
        System.out.println("+------------------------+\n" + rowCount + " rows in set.");
    }
}
