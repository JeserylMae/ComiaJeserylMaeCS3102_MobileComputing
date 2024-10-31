package com.example.androidLab.utils;

import com.example.androidLab.models.RegistrationModel;

import java.lang.reflect.Field;

public class Validation {
    public static boolean hasNullOrEmptyValue(RegistrationModel model)  {
        Field[] fields = model.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = null;

            try {
                value = field.get(model);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if (value == null || (value instanceof String && ((String) value).isEmpty())) {
                return true;
            }
        }
        return false;
    }
}
