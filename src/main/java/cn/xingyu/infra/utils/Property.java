package cn.xingyu.infra.utils;

import javax.persistence.Id;
import java.lang.reflect.Field;

public class Property {
    /**
     * 对有Id注解的属性赋值
     * @param obj
     * @param id
     * @return
     */
   public Object idSet(Object obj,Object id)  {
       Field field = getField(obj,Id.class);
       if (field != null){
           field.setAccessible(true);
           try {
               field.set(obj,id);
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }
       }
        return obj;
    }

    /**
     * 根据注解得到Field（只取第一个）
     * @param obj
     * @param annotationClass
     * @return
     */
    public Field getField(Object obj,Class annotationClass){
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(annotationClass)) {
                return f;
            }
        }
        return null;
    }

    public String getPropertyName(Object obj, Class annotationClass){
        return getField(obj,annotationClass).getName();
    }


}
