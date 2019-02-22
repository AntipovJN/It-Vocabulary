package sample.Entity;

import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Objects;


public class Word {
    private int id;


    private SimpleStringProperty engVerb = new SimpleStringProperty("");

    private SimpleStringProperty rusVerb = new SimpleStringProperty("");



    public Word() {
    }

    public Word(WordDB word) {
        this.id = word.getId();
        this.engVerb = new SimpleStringProperty(word.getEngVerb());
        this.rusVerb = new SimpleStringProperty(word.getRusVerb());
    }

    public String getEngVerb() {
        return this.engVerb.get();
    }

    public void setEngVerb(String engVerb) {
        this.engVerb.set(engVerb);
    }

    public String getRusVerb() {
        return this.rusVerb.get();
    }

    public void setRusVerb(String rusVerb) {
        this.rusVerb.set(rusVerb);
    }

    public SimpleStringProperty engVerbProperty() {
        return engVerb;
    }

    public SimpleStringProperty rusVerbProperty() {
        return rusVerb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return engVerb.equals(word.engVerb) &&
                rusVerb.equals(word.rusVerb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engVerb, rusVerb);
    }

    @Override
    public String toString() {
        return "Word{" +
                "engVerb='" + engVerb + '\'' +
                ", rusVerb='" + rusVerb + '\'' +
                '}';
    }
}
