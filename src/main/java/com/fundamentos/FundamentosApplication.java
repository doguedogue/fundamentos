package com.fundamentos;

import com.fundamentos.bean.MyBean;
import com.fundamentos.bean.MyBeanProperties;
import com.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.component.ComponentDependency;
import com.fundamentos.entity.User;
import com.fundamentos.pojo.UserPojo;
import com.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanProperties myBeanProperties;

	private MyBeanWithDependency myBeanWithDependency;

	private UserPojo userPojo;

	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImpl") ComponentDependency componentDependency,
								  MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency,
								  MyBeanProperties myBeanProperties,
								  UserPojo userPojo,
								  UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanProperties = myBeanProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//clases_anteriores();
		saveUsersInDB();
		imprimeUsuarios();
		getInformacionJPQL();
	}

	private void getInformacionJPQL(){
		String email = "noob@mk.com";
		LOGGER.info("Buscando usuario con email:  "+ email );
		LOGGER.info("Salida: " + userRepository.findByUserEmail(email).
				orElseThrow( ()-> new RuntimeException("No se encontró el usuario")));

		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach( user -> LOGGER.info("Usuario con método SORT: "+user));

		userRepository.findByName("user")
				.stream()
				.forEach( user -> LOGGER.info("QueryMethod findByName: "+user));

		LOGGER.info("QueryMethod findByNameAndEmail: " + userRepository.findByNameAndEmail("Noob", "noob@mk.com").
				orElseThrow( ()-> new RuntimeException("No se encontró el usuario")));

	}

	private void imprimeUsuarios(){
		userRepository.findAll().stream().forEach(usuario -> System.out.println(usuario));
	}
	private void saveUsersInDB(){
		User user1 = new User("Johnny", "johnny@mk.com", LocalDate.of(2000, 3, 25));
		User user2 = new User("Melina", "melina@mk.com", LocalDate.of(1999, 4, 10));
		User user3 = new User("Noob", "noob@mk.com", LocalDate.of(1979, 7, 24));
		User user4 = new User("user4", "user4@mk.com", LocalDate.of(1979, 7, 4));
		User user5 = new User("user5", "user5@mk.com", LocalDate.of(1979, 7, 5));
		User user6 = new User("user6", "user6@mk.com", LocalDate.of(1979, 7, 6));
		User user7 = new User("user7", "user7@mk.com", LocalDate.of(1979, 7, 1));
		User user8 = new User("user8", "user8@mk.com", LocalDate.of(1979, 7, 2));
		User user9 = new User("user9", "user9@mk.com", LocalDate.of(1979, 7, 3));
		User user10 = new User("user10", "user10@mk.com", LocalDate.of(1979, 7, 7));
		List<User> usuarios = Arrays.asList(user1,user2,user3,user4,user5,
				user6,user7,user8,user9,user10);
		usuarios.stream().forEach(userRepository::save);
	}

	private void clases_anteriores() {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println("Hola "+myBeanProperties.function());
		System.out.println(userPojo.toString());
		try{
			int value = 10/0;
			LOGGER.debug("Nunca llega");
		}catch (Exception e) {
			LOGGER.error("Esto es un error: "+e.getMessage());
			e.printStackTrace();
		}
	}
}
