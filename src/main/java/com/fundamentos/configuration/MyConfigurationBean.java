package com.fundamentos.configuration;

import com.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBeanTwoImpl();
    }

    @Bean
    public MyOperation beanOperationOp(){
        return new MyOperationImpl();
    }

    @Bean
    public MyBeanWithDependency beanOperationDepend(MyOperation myOperation){
        return new MyBeanWithDependencyImpl(myOperation);
    }
}
