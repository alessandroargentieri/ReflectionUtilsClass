package com.quicktutorialz.learntesting.DemoTest.utilities;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {

    /**
     *
     * @param instance istanza della classe su cui implementare la reflection
     * @param fieldName stringa che riporta il nome del campo privato da leggere o settare
     * @return privateValue valore del campo privato
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static Object getPrivateField(Object instance, String fieldName) throws NoSuchFieldException, IllegalAccessException{
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        Object privateValue = field.get(instance);
        return privateValue;
    }

    /**
     *
     * @param instance istanza della classe su cui implementare la reflection
     * @param fieldName stringa che riporta il nome del campo privato da leggere o settare
     * @param value valore del campo privato da settare
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void setPrivateField(Object instance, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException{
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(instance, value);
    }


    /**
     *
     * @param instance
     * @param methodName
     * @param params
     * @param argTypes
     * @return Object
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     *
     * example of usage:
     * Object[] params = {"come", "stai", 34};
       Class[] argTypes = new Class[] { String.class, String.class, int.class };
       ReflectionUtils.invokePrivateMethod(userService, "ciao", params, argTypes);

     it calls private method userService.ciao(String a, String b, int c);
     */
    public static Object invokePrivateMethod(Object instance, String methodName, Object[] params, Class[] argTypes) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Method method = instance.getClass().getDeclaredMethod(methodName, argTypes );
        method.setAccessible(true);
        return method.invoke(instance, params);
    }

}
