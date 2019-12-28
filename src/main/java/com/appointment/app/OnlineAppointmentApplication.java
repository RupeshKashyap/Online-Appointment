package com.appointment.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan( basePackages = {"com.appointment.app"} )
//@EnableJpaRepositories({"com.appointment.app.repository"})
public class OnlineAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineAppointmentApplication.class, args);
	}

}
