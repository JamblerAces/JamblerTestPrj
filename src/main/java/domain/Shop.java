package domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String mainDomen;

    public Shop() {
    }

    public Shop(String name, String mainDomen) {
        this.name = name;
        this.mainDomen = mainDomen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainDomen() {
        return mainDomen;
    }

    public void setMainDomen(String mainDomen) {
        this.mainDomen = mainDomen;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop that = (Shop) o;

        return Objects.equal(this.name, that.name) &&
                Objects.equal(this.mainDomen, that.mainDomen) &&
                Objects.equal(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, mainDomen, id);
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("mainDomen", mainDomen)
                .add("id", id)
                .toString();
    }
}
