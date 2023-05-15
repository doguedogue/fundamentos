package com.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImpl implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Greetings from Component");
    }
}
