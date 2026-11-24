package tn.esprit.gestionzoo.entities;

import java.util.Objects;

public class Aquatic extends Animal implements Carnivore<Food> {
    private String habitat;

    public Aquatic() {
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat)
            throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Aquatic{family=" + getFamily() + ", name=" + getName()
                + ", age=" + getAge() + ", isMammal=" + isMammal()
                + ", habitat=" + habitat + "}";
    }

    public void swim() {
        System.out.println("This aquatic animal is swimming");
    }

    // Carnivore<Food>: an aquatic animal only eats meat
    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT) {
            System.out.println(getName() + " (aquatic) is eating meat");
        } else {
            System.out.println(getName() + " (aquatic) only eats meat, it cannot eat " + meat);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Aquatic)) {
            return false;
        }
        Aquatic other = (Aquatic) obj;
        return getAge() == other.getAge()
                && Objects.equals(getName(), other.getName())
                && Objects.equals(habitat, other.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), habitat);
    }
}