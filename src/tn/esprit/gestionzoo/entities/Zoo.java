package tn.esprit.gestionzoo.entities;

public class Zoo {
    private static final int NBR_CAGES = 3;       // instruction 33: reduced to 3
    static final int MAX_AQUATICS = 10;

    private Animal[] animals;
    private String name;
    private String city;
    private int animalCount;

    private Aquatic[] aquaticAnimals = new Aquatic[MAX_AQUATICS];
    private int aquaticCount = 0;

    public Zoo(String name, String city) {
        animals = new Animal[NBR_CAGES];
        setName(name);               // goes through the setter so the validation applies
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The zoo name must not be empty");
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public static int getNbrCages() {
        return NBR_CAGES;
    }

    public void displayZoo() {
        System.out.println("Name  : " + name);
        System.out.println("City  : " + city);
        System.out.println("Cages : " + NBR_CAGES);
    }

    @Override
    public String toString() {
        return "Zoo [name=" + name + ", city=" + city + ", nbrCages=" + NBR_CAGES + "]";
    }

    // Instructions 32 and 33: returns void and throws ZooFullException when full
    public void addAnimal(Animal animal) throws ZooFullException {
        if (animalCount >= animals.length) {
            throw new ZooFullException("The zoo is full, cannot add " + animal.getName());
        }
        if (searchAnimal(animal) != -1) {
            return;                  // animal already in the zoo: ignored
        }
        animals[animalCount] = animal;
        animalCount++;
    }

    public void displayAnimals() {
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i]);
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

    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount >= z2.animalCount) {
            return z1;
        }
        return z2;
    }

    // ----- Aquatic animals -----

    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquaticCount >= aquaticAnimals.length) {
            System.out.println("No more room for aquatic animals.");
            return;
        }
        aquaticAnimals[aquaticCount] = aquatic;
        aquaticCount++;
    }

    public Aquatic[] getAquaticAnimals() {
        return aquaticAnimals;
    }

    public int getAquaticCount() {
        return aquaticCount;
    }

    public float maxPenguinSwimmingDepth() {
        float max = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin p = (Penguin) aquaticAnimals[i];
                if (p.getSwimmingDepth() > max) {
                    max = p.getSwimmingDepth();
                }
            }
        }
        return max;
    }

    public void displayNumberOfAquaticsByType() {
        int dolphins = 0;
        int penguins = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphins++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguins++;
            }
        }
        System.out.println("Dolphins: " + dolphins);
        System.out.println("Penguins: " + penguins);
    }
}