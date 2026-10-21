package tn.esprit.gestionzoo.entities;
import java.util.Objects;

public class Aquatic extends Animal {
    private String habitat;

    public Aquatic() {
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
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