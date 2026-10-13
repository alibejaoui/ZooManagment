public class Zoo {
    static final int MAX_ANIMALS = 25;

    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private int animalCount = 0;

    public Zoo() {
        this.nbrCages = MAX_ANIMALS;
        this.animals = new Animal[nbrCages];
    }

    public Zoo(String name, String city, int nbrCages) {
        setName(name);               // goes through the rule
        this.city = city;
        this.nbrCages = Math.min(nbrCages, MAX_ANIMALS);
        this.animals = new Animal[this.nbrCages];
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: the zoo name must not be empty");
        } else {
            this.name = name;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;             // no setter: it is a constant
    }

    public int getAnimalCount() {
        return animalCount;          // no setter: only add/remove change it
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void displayZoo() {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Number of cages: " + nbrCages);
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
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
            System.out.println(i + " - " + animals[i].getName() + " (" + animals[i].getFamily() + ", " + animals[i].getAge() + " years)");
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
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
        return animalCount >= nbrCages;
    }

    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount >= z2.animalCount) {
            return z1;
        }
        return z2;
    }
}