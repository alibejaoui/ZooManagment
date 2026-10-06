public class Zoo {
    static final int Max_ANIMALS = 25;
    Animal[] animals;
    String name;
    String city;
    final int nbrCages;
    int animalCount = 0;

    public Zoo(int nbrCages) {
        this.nbrCages = Max_ANIMALS;
        this.animals = new Animal[nbrCages];
    }

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = Math.min(nbrCages, Max_ANIMALS);
        this.animals = new Animal[this.nbrCages];

    }

    public void displayZoo() {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + nbrCages);
    }

    public boolean addAnimal(Animal animal) {
        if (animalCount >= animals.length) {
            return false;
        }
        if (searchAnimal(animal) != -1) {
            return false;
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    public void displayAnimals() {
        for (int i = 0; i < animalCount; i++) {
            System.out.println(i + " - " + animals[i].name + " (" + animals[i].family + ", " + animals[i].age + " years)");
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].name.equals(animal.name)) {
                return i;
            }
        }
        return -1;
    }


    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    public boolean isZooFull() {
        for (int i = 0; i < nbrCages; i++) {
            if (animals[i] == null) {
                return false;
            }
        }
        return false;
    }

    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount >= z2.animalCount) {
            return z1;
        }
        return z2;
    }
}