package gof.prototype;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface IPrototype<T> {

    default T shallowClone() {
        T clone_obj = null;
        try {
            Class c = Class.forName(this.getClass().getName());
            Method method = c.getMethod("clone");
            clone_obj = (T) method.invoke(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clone_obj;
    }
    default T deepClone() {
        T clone = null;
        try {
            ByteArrayOutputStream baOUT = new ByteArrayOutputStream();
            ObjectOutputStream oOUT = new ObjectOutputStream(baOUT);
            oOUT.writeObject(this);

            ByteArrayInputStream baIN = new ByteArrayInputStream(baOUT.toByteArray());
            ObjectInputStream oIN = new ObjectInputStream(baIN);
            clone = (T) oIN.readObject();
        } catch (IOException | ClassNotFoundException e) {//Java 7 required
            e.printStackTrace();
        }
        return clone;
    }
}
