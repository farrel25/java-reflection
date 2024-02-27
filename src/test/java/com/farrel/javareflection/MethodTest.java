package com.farrel.javareflection;

import com.farrel.javareflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

    @Test
    void testGetMethods() {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
            System.out.println(declaredMethod.getReturnType().getName());
            System.out.println(Arrays.toString(declaredMethod.getParameterTypes()));
            System.out.println(Arrays.toString(declaredMethod.getExceptionTypes()));
            System.out.println("===========");
        }
    }

    @Test
    void testInvokeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person("Farrel", "Putra");

        Class<Person> personClass = Person.class;

        Method getFirstName = personClass.getDeclaredMethod("getFirstName");
        Method setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

        //Object firstName = getFirstName.invoke(person);
        String firstName = String.valueOf(getFirstName.invoke(person));
        System.out.println(firstName);
        System.out.println(person.getFirstName());

        setFirstName.invoke(person, "Lerraf");

        String firstNameUpdated = String.valueOf(getFirstName.invoke(person));
        System.out.println(firstNameUpdated);
        System.out.println(person.getFirstName());
    }
}
