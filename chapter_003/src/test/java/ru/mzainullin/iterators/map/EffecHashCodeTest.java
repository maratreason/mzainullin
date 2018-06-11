package ru.mzainullin.iterators.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EffecHashCodeTest {

    @Test
    public void check() {
        EffecHashCode hash = new EffecHashCode("alex", 145, "mail@mail.com");
        EffecHashCode hash2 = new EffecHashCode("alex", 145, "mail@mail.com");
        EffecHashCode hash3 = new EffecHashCode("sveta", 34, "sveta@mail.com");

        assertThat(hash.equals(hash2), is(true));

        System.out.printf("хэшкод hash: %s\n", hash.hashCode());
        System.out.printf("хэшкод hash2: %s\n", hash2.hashCode());
        System.out.printf("хэшкод hash3: %s", hash3.hashCode());

    }
}