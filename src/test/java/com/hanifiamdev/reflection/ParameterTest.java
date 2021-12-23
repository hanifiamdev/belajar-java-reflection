package com.hanifiamdev.reflection;

import com.hanifiamdev.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterTest {

    @Test
    void getParameters() {

        Class<Person> personClass =  Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter: parameters) {
                System.out.println("Parameter Name : " + parameter.getName());
                System.out.println("Parameter Name : " + parameter.getType());
            }
            System.out.println("=========");
        }
    }

    @Test
    void testInvokeMethodWithParameter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Method setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

        Person person = new Person("Hanif", "Amrullah");
        setFirstName.invoke(person, "Fachri");

        // check nilai
        System.out.println(person.getFirstName());
    }
}
