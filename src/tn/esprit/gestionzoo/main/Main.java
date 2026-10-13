package tn.esprit.gestionzoo.main;
import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class Main {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Belvedere Zoo", "Tunis", 3);
        Animal lion = new Animal("Felidae", "Simba", 5, true);

        System.out.println(lion.getName());
        lion.setAge(-3);
        System.out.println(lion.getAge());

        try {
            myZoo.setName("");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(myZoo.getName());
    }
}