package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.*;

public class Main {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Belvedere Zoo", "Tunis", 3);
        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Aquatic aquatic = new Aquatic("Fish", "Nemo", 2, false, "Ocean");
        Terrestrial terrestrial = new Terrestrial("Felidae", "Simba", 5, true, 4);
        Dolphin dolphin = new Dolphin("Delphinidae", "Flipper", 8, true, "Ocean", 35.5f);
        Penguin penguin = new Penguin("Spheniscidae", "Pingu", 3, false, "Antarctica", 120.0f);

        System.out.println(lion.getName());
        lion.setAge(-3);
        System.out.println(lion.getAge());

        try {
            myZoo.setName("");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(myZoo.addAnimal(dolphin));   // true
        System.out.println(myZoo.addAnimal(penguin));   // true
        myZoo.displayAnimals();

        System.out.println(myZoo.getName());
        System.out.println(aquatic);
        System.out.println(terrestrial);
        System.out.println(dolphin);
        System.out.println(penguin);



        aquatic.swim();
        dolphin.swim();
        penguin.swim();
    }

}