package n1exercici5;

import java.io.Serializable;
import java.util.Objects;

public class SerializableClass implements Serializable {

    public String nom;
    public Integer value;

    public SerializableClass(String nom, Integer value) {
        this.nom = nom;
        this.value = value;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerializableClass that = (SerializableClass) o;
        return Objects.equals(nom, that.nom) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, value);
    }

    @Override
    public String toString() {
        return "SerializableClass{" +
                "nom='" + nom + '\'' +
                ", value=" + value +
                '}';
    }
}
