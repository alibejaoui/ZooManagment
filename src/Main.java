public class Main {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Belvedere Zoo", "Tunis", 3); // 3 cages to see the limit quickly

        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Animal tiger = new Animal("Felidae", "Shere Khan", 7, true);
        Animal zebra = new Animal("Equidae", "Marty", 4, true);
        Animal wolf = new Animal("Canidae", "Akela", 6, true);

        System.out.println(myZoo.addAnimal(lion));
        System.out.println(myZoo.addAnimal(tiger));
        System.out.println(myZoo.addAnimal(zebra));
        System.out.println(myZoo.addAnimal(wolf));

        myZoo.displayAnimals();

        System.out.println(myZoo.searchAnimal(tiger));

        Animal lion2 = new Animal("Felidae", "Simba", 5, true);
        System.out.println(myZoo.searchAnimal(lion2));
        System.out.println(myZoo.addAnimal(lion2));

        // Instruction 13: remove
        System.out.println(myZoo.removeAnimal(tiger));
        System.out.println(myZoo.removeAnimal(tiger));
        myZoo.displayAnimals();
    }
}