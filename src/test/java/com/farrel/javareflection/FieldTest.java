package com.farrel.javareflection;

import com.farrel.javareflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class FieldTest {

    @Test
    void testGetFields() {
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + ": " + declaredField.getType().getName());
        }
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Person person = new Person("Farrel", "Putra");
        Person person2 = new Person("Tasya", "Aulia");


        // WITHOUT REFLECTION
        //String firstNameValue = person.getFirstName();


        // REFLECTION
        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        //Object firstNameValue = firstName.get(person);
        String firstNameValue = String.valueOf(firstName.get(person));
        System.out.println(firstNameValue);

        String firstName2Value = String.valueOf(firstName.get(person2));
        System.out.println(firstName2Value);
    }

    @Test
    void testSetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Person person = new Person("Farrel", "Putra");
        Person person2 = new Person("Tasya", "Aulia");


        // WITHOUT REFLECTION
        System.out.println(person.getFirstName());
        System.out.println(person2.getFirstName());
        //person.setFirstName("Lerraf");
        //person2.setFirstName("AysaT");


        // REFLECTION
        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        firstName.set(person, "Lerraf");
        String firstNameValue = String.valueOf(firstName.get(person));
        System.out.println(firstNameValue);
        System.out.println(person.getFirstName());

        firstName.set(person2, "Aysat");
        String firstName2Value = String.valueOf(firstName.get(person2));
        System.out.println(firstName2Value);
        System.out.println(person2.getFirstName());
    }
}
