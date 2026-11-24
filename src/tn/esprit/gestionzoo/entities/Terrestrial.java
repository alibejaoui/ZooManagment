package tn.esprit.gestionzoo.entities;

public class Terrestrial extends Animal implements Omnivore<Food> {
    private int nbrLegs;

    public Terrestrial() {
    }

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs)
            throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }

    public int getNbrLegs() {
        return nbrLegs;
    }

    public void setNbrLegs(int nbrLegs) {
        this.nbrLegs = nbrLegs;
    }

    @Override
    public String toString() {
        return "Terrestrial{family=" + getFamily() + ", name=" + getName()
                + ", age=" + getAge() + ", isMammal=" + isMammal()
                + ", nbrLegs=" + nbrLegs + "}";
    }

    // From Carnivore<Food>
    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT) {
            System.out.println(getName() + " (terrestrial) is eating meat");
        } else {
            System.out.println(getName() + " cannot eat " + meat + " as meat");
        }
    }

    // From Herbivore<Food>
    @Override
    public void eatPlant(Food plant) {
        if (plant == Food.PLANT) {
            System.out.println(getName() + " (terrestrial) is eating plants");
        } else {
            System.out.println(getName() + " cannot eat " + plant + " as a plant");
        }
    }

    // From Omnivore<Food>
    @Override
    public void eatPlantAndMeet(Food food) {
        if (food == Food.BOTH) {
            System.out.println(getName() + " (terrestrial) is eating plants and meat");
        } else {
            System.out.println(getName() + " needs " + Food.BOTH + " here, not " + food);
        }
    }
}