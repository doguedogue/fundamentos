package com.fundamentos;

import com.fundamentos.bean.MyBean;
import com.fundamentos.bean.MyBeanProperties;
import com.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.component.ComponentDependency;
import com.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanProperties myBeanProperties;

	private MyBeanWithDependency myBeanWithDependency;

	private UserPojo userPojo;

	public FundamentosApplication(@Qualifier("componentTwoImpl") ComponentDependency componentDependency,
								  MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency,
								  MyBeanProperties myBeanProperties,
								  UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanProperties = myBeanProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println("Hola "+myBeanProperties.function());
		System.out.println(userPojo.toString());
	}
}
