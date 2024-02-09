package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest  // Simulate the actual process of "mvn spring-boot:run"
//Testing @SpringBootApplication -> @ComponentScan
//To trigger @SpringBootTest, we use "mvn clean test"
class BootcampSbFakeDatabaseApplicationTests {


	//In @SpringBootTest environment, the Spring Context will contain all your custom beans

	@Test  //At least one @Test to start up the test environment
	void contextLoads() {
	}



}
