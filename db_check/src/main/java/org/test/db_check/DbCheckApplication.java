package org.test.db_check;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javafx.application.Application;

@SpringBootApplication
@ComponentScan(basePackages = "org.test.db_check")
public class DbCheckApplication {

	public static void main(String[] args) {
		Application.launch(javafx_main.class,args);
	}

}
