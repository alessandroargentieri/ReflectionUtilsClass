Skip to content
This repository
Search
Pull requests
Issues
Marketplace
Explore
 @alessandroargentieri
 Sign out
 Unwatch 1
  Star 0  Fork 0 alessandroargentieri/SpringBootJWTRest
 Code  Issues 0  Pull requests 0  Projects 0  Wiki  Insights  Settings
Branch: master Find file Copy pathSpringBootJWTRest/src/main/java/com/example/bytecode/SpringBootJWT/SpringBootJwtApplication.java
4a3691f  on Sep 8
 Alessandro Argentieri front end single page app improved
0 contributors
RawBlameHistory     
111 lines (82 sloc)  4.65 KB
package com.quicktutorialz.learntesting.DemoTest;

import com.quicktutorialz.learntesting.DemoTest.utilities.ReflectionTestClass;
import com.quicktutorialz.learntesting.DemoTest.utilities.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJwtApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {

        // classe a cui accedere con la Reflection
		ReflectionTestClass myinstance = new ReflectionTestClass();
		
        // get private field
        String privateFieldValue = (String) ReflectionUtils.getPrivateField(myinstance, "myField");
		log.info("privateField (1): " + privateFieldValue);

        // set private field
		ReflectionUtils.setPrivateField(myinstance, "myField", "Hello!");

        // get private field modified
		privateFieldValue = (String) ReflectionUtils.getPrivateField(myinstance, "myField");
		log.info("privateField (2): " + privateFieldValue);

        // prepare parameters to invoke private method
        Object[] params = {"come", "stai", 34};
        Class[] argTypes = new Class[] { String.class, String.class, int.class };

        // invoke private method with parameters
        String greetz = (String) ReflectionUtils.invokePrivateMethod(myinstance, "ciao", params, argTypes);

        // invoke private method without parameters
        String greetz = (String) ReflectionUtils.invokePrivateMethod(myinstance, "hello", null, null);


	}


	

}
