package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

public class Main {

    // Adds an animal and ALWAYS displays the number of animals afterwards
    private static void tryAddAnimal(Zoo zoo, Animal animal) {
        try {
            zoo.addAnimal(animal);
            System.out.println("Animal added: " + animal.getName());
        } catch (ZooFullException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Number of animals: " + zoo.getAnimalCount());
        }
    }

    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Belvedere Zoo", "Tunis");   // 3 cages (NBR_CAGES = 3)

        try {
            Animal lion = new Animal("Felidae", "Simba", 5, true);
            Aquatic aquatic = new Dolphin("Delphinidae", "Nemo", 2, true, "Ocean", 20f);
            Terrestrial terrestrial = new Terrestrial("Felidae", "Tigrou", 5, true, 4);
            Dolphin dolphin = new Dolphin("Delphinidae", "Flipper", 8, true, "Ocean", 35.5f);
            Penguin penguin = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 120.0f);
            Penguin penguin1 = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 120.0f);
            Penguin penguin2 = new Penguin("Spheniscidae", "Skipper", 5, false, "Antarctica", 150.0f);

            // Aquatic animals (instructions 25 to 31)
            myZoo.addAquaticAnimal(dolphin);
            myZoo.addAquaticAnimal(penguin1);
            myZoo.addAquaticAnimal(penguin2);

            // Instruction 33: the 4th animal must fail (3 cages)
            tryAddAnimal(myZoo, dolphin);
            tryAddAnimal(myZoo, penguin);
            tryAddAnimal(myZoo, lion);
            tryAddAnimal(myZoo, terrestrial);   // ZooFullException

            myZoo.displayAnimals();

            // Instruction 34: negative age through the setter
            try {
                lion.setAge(-3);
            } catch (InvalidAgeException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println(lion.getAge());   // still 5

            // Zoo name must not be empty
            try {
                myZoo.setName("");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println(myZoo.getName());

            System.out.println(aquatic);
            System.out.println(terrestrial);
            System.out.println(dolphin);
            System.out.println(penguin);

            aquatic.swim();
            dolphin.swim();
            penguin.swim();

            for (int i = 0; i < myZoo.getAquaticCount(); i++) {
                System.out.println(myZoo.getAquaticAnimals()[i]);
            }
            for (int i = 0; i < myZoo.getAquaticCount(); i++) {
                myZoo.getAquaticAnimals()[i].swim();
            }

            System.out.println("Max depth: " + myZoo.maxPenguinSwimmingDepth());
            myZoo.displayNumberOfAquaticsByType();

            Dolphin dolphinCopy = new Dolphin("Delphinidae", "Flipper", 8, true, "Ocean", 50f);
            System.out.println(dolphin == dolphinCopy);        // false
            System.out.println(dolphin.equals(dolphinCopy));   // true
            System.out.println(dolphin.equals(penguin1));      // false

            // ----- Instruction 38: test the Food-based methods -----
            System.out.println("--- Carnivore tests (Aquatic, Dolphin, Penguin) ---");
            aquatic.eatMeat(Food.MEAT);      // eats meat
            aquatic.eatMeat(Food.PLANT);     // refused
            dolphin.eatMeat(Food.MEAT);
            penguin.eatMeat(Food.MEAT);
            penguin.eatMeat(Food.BOTH);      // refused

            System.out.println("--- Omnivore tests (Terrestrial) ---");
            terrestrial.eatMeat(Food.MEAT);
            terrestrial.eatMeat(Food.PLANT);          // refused
            terrestrial.eatPlant(Food.PLANT);
            terrestrial.eatPlant(Food.MEAT);          // refused
            terrestrial.eatPlantAndMeet(Food.BOTH);
            terrestrial.eatPlantAndMeet(Food.MEAT);   // refused

        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Instruction 34: negative age in a constructor
        try {
            Animal baby = new Animal("Felidae", "Baby", -2, true);
            System.out.println(baby);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}