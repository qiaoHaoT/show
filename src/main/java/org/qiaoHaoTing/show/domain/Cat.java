package org.qiaoHaoTing.show.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Cat implements Serializable {

    private int age;
    private String name;

    private LocalDateTime birthday;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}
