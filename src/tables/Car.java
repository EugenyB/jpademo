package tables;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "marka")
    private String marka;

    @Basic
    @Column(name = "nomer")
    private String nomer;

    @ManyToOne
    private Person owner;

    public Car() {
    }

    public Car(String marka, String nomer, Person owner) {
        this.marka = marka;
        this.nomer = nomer;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Objects.equals(marka, car.marka) &&
                Objects.equals(nomer, car.nomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marka, nomer);
    }
}
