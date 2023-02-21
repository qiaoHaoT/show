package org.qiaoHaoTing.show.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

//@Component
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new MyFactoryBean();
    }

    @Override
    public Class<?> getObjectType() {
        return MyFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
