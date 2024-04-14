package com.linkedbear.springboot.practice.bean;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

//@Component
//@ConfigurationProperties(prefix = "person")
@Validated
public class Person {

    @NotNull
    private String name;
    
    @Min(0)
    @Max(100)
    private Integer age;
    
    private Date birthday;
    
    private List<String> alias;
    
    private String[] tels;
    
    private List<Cat> cats;
    
    private Map<String, String> events;
    
    private Map<String, Dog> dogs;
    
    @Override
    public String toString() {
        return "Person{"
                + "name='"
                + name
                + '\''
                + ", age="
                + age
                + ", birthday="
                + birthday
                + ", alias="
                + alias
                + ", tels="
                + Arrays.toString(tels)
                + ", cats="
                + cats
                + ", events="
                + events
                + ", dogs="
                + dogs
                + '}';
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public List<String> getAlias() {
        return alias;
    }
    
    public void setAlias(List<String> alias) {
        this.alias = alias;
    }
    
    public String[] getTels() {
        return tels;
    }
    
    public void setTels(String[] tels) {
        this.tels = tels;
    }
    
    public List<Cat> getCats() {
        return cats;
    }
    
    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
    
    public Map<String, String> getEvents() {
        return events;
    }
    
    public void setEvents(Map<String, String> events) {
        this.events = events;
    }
    
    public Map<String, Dog> getDogs() {
        return dogs;
    }
    
    public void setDogs(Map<String, Dog> dogs) {
        this.dogs = dogs;
    }
}
