package com.fundamentos.bean;

public class MyBeanPropertiesImpl implements MyBeanProperties{

    private String name;

    private String apellido;

    public MyBeanPropertiesImpl(String name, String apellido) {
        this.name = name;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return name + "-" + apellido;
    }
}
