package org.qiaoHaoTing.show.entity;

import java.util.Collection;
import java.util.Map;

public class BaseEntity {


    /**
     * 获取类 类型
     * 集合类：0
     * 基本数据类型：1
     * 一般对象类型：2
     * @param clazz
     * @return
     */
    private static int getType(Class clazz) {
        if(Collection.class.isAssignableFrom(clazz) || Map.class.isAssignableFrom(clazz)) {
            return 0;
        } else if(String.class.isAssignableFrom(clazz) || Number.class.isAssignableFrom(clazz) || clazz.isEnum() || clazz.isPrimitive()) {
            return 1;
        } else {
            return 2;
        }
    }
}
