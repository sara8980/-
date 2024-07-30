package javaproject.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;
@EnableJpaRepositories//repositories יודע ליצור מופעים לממשקים של ה IoC באמצעות הגדרה זו ה
@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean //ונוכל להזריק אותו איפה שנרצה IoC באופן זה האובייקט שיוחזר מהפונקציה ינוהל על ידי ה
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
	@Bean //ונוכל להזריק אותו איפה שנרצה IoC באופן זה האובייקט שיוחזר מהפונקציה ינוהל על ידי ה
	public ObjectMapper getObjectMapper()
	{
		return new ObjectMapper();
	}

}
