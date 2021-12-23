package com.hanifiamdev.reflection;

import com.hanifiamdev.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class FieldTest {

    @Test
    void testGetFields() {

        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true); // mendapatkan hak akses jika field nya privte

        Person person1 = new Person("Hanif", "Amrullah");

        String result = (String) firstName.get(person1);
        System.out.println(result);

        Person person2 = new Person("Fachri",  "Amrullah");
        String result2 = (String) firstName.get(person2);
        System.out.println(result2);

    }

    @Test
    void testSetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true); // mendapatkan hak akses jika field nya privte

        Person person1 = new Person("Hanif", "Amrullah");
        firstName.set(person1, "Orkhan");// sama halnya jika melakukan setter objek person1.setFirstNamr("Orkhan")
        String result = (String) firstName.get(person1);
        System.out.println(result);

        Person person2 = new Person("Fachri",  "Amrullah");
        firstName.set(person2, "Hafizah");
        System.out.println(person2.getFirstName());

    }
}
