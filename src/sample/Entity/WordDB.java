package sample.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="vocabulary")
public class WordDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="engVerb")
    private String engVerb;
    @Column(name ="rusVerb")
    private String rusVerb;

    public WordDB(String engVerb, String rusVerb) {
        this.engVerb = engVerb;
        this.rusVerb = rusVerb;
    }

    public WordDB() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEngVerb() {
        return engVerb;
    }

    public void setEngVerb(String engVerb) {
        this.engVerb = engVerb;
    }

    public String getRusVerb() {
        return rusVerb;
    }

    public void setRusVerb(String rusVerb) {
        this.rusVerb = rusVerb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordDB wordDB = (WordDB) o;
        return id == wordDB.id &&
                Objects.equals(engVerb, wordDB.engVerb) &&
                Objects.equals(rusVerb, wordDB.rusVerb);
    }

    @Override
    public String toString() {
        return "WordDB{" +
                "id=" + id +
                ", engVerb='" + engVerb + '\'' +
                ", rusVerb='" + rusVerb + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, engVerb, rusVerb);
    }
}
