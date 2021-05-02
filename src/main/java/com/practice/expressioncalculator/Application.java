package com.practice.expressioncalculator;

import com.practice.expressioncalculator.model.BooleanIndicator;
import com.practice.expressioncalculator.model.HistoricIndicator;
import com.practice.expressioncalculator.model.Indicator;
import com.practice.expressioncalculator.model.NumericIndicator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-bean-config.xml");

		Map<String, Double> params = new HashMap<String, Double>();

		params.put("OPEN", Double.valueOf(11));
		params.put("CLOSE", Double.valueOf(10));
		params.put("CLOSE_MINUS_1", Double.valueOf(9));

		System.out.println("params = " + params.toString());

		Indicator mid = (NumericIndicator)context.getBean("MID");
		System.out.println("mid = [" + mid.calculate(params) + "]");

		Indicator prevClose = (HistoricIndicator)context.getBean("CLOSE_MINUS_1");
		System.out.println("prevClose = [" + prevClose.calculate(params) + "]");

		Indicator openLessThanClose = (BooleanIndicator)context.getBean("OPEN < CLOSE");
		System.out.println("OPEN < CLOSE = [" + openLessThanClose.calculate(params) + "]");
	}
}
