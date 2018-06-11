package ru.mzainullin.iterators.map;

import java.util.Objects;

public class EffecHashCode {
    private String name;
    private int id;
    private String email;

    public EffecHashCode(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EffecHashCode that = (EffecHashCode) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, email);
    }
}
