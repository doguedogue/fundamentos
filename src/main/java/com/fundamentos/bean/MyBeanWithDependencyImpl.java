package com.fundamentos.bean;

import com.fundamentos.FundamentosApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    private Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImpl.class);
    private MyOperation myOperation;

    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Desde printWithDependency");
        LOGGER.debug("Debug printWithDependency");
        System.out.println("Greeting from MyBeanWithDependency: "+myOperation.sum(1));
    }
}
