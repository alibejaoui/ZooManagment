public class Main {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Belvedere Zoo", "Tunis", 3);
        Animal lion = new Animal("Felidae", "Simba", 5, true);

        System.out.println(lion.getName());      // Simba
        lion.setAge(-3);                         // Error message, age stays 5
        System.out.println(lion.getAge());       // 5

        myZoo.setName("");                       // Error message, name stays the same
        System.out.println(myZoo.getName());     // Belvedere Zoo
    }
}