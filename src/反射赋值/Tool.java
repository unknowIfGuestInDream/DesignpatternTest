package 反射赋值;

import java.lang.reflect.Field;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:03
 * @since: 1.0
 */
public class Tool {
    public void setProperty(Object obj, String propertyName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Class c = obj.getClass();
        Field field = c.getDeclaredField(propertyName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
