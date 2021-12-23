package com.hanifiamdev.reflection;

import com.hanifiamdev.reflection.data.Person;
import com.hanifiamdev.reflection.data.validation.Validator;
import org.junit.jupiter.api.Test;

public class AnnotationTest {

    @Test
    void testValidateUsingAnnotation() throws IllegalAccessException {

        Person person = new Person(" ", "Amrullah");
        Validator.validateNotBlank(person);

    }
}
