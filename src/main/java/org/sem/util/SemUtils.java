package org.sem.util;

import java.lang.reflect.Field;
import java.util.List;

public class SemUtils {

    public static Field[] getFields(List<?> dataList) {
        Object data = dataList.get(0);
        return data.getClass().getDeclaredFields();
    }

}
