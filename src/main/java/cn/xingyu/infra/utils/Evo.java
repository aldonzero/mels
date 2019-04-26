package cn.xingyu.infra.utils;

import java.lang.reflect.Field;

public class Evo {


    public static Object toEvo(Object objE, Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            Field evof = null;
            try {
                evof = objE.getClass().getDeclaredField(f.getName());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            evof.setAccessible(true);
            try {
                evof.set(objE, f.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return objE;
    }
}
