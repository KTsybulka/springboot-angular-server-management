package com.example.server;

import com.example.server.enumeration.Status;
import com.example.server.model.Server;
import com.example.server.repository.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.server.enumeration.Status.SERVER_DOWN;
import static com.example.server.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepo serverRepo){
		// CommandLineRunner is used to execute code after the application starts.
		return args -> {
			// Save the first server to the database
			serverRepo.save(new Server(null,
					"192.168.1.160",
					"Ubuntu Linux",
					"16 GB",
					"Personal PC",
					"http://localhost:8080/server/image/server1.png",
					SERVER_UP));

			serverRepo.save(new Server(null,
					"192.168.1.161",
					"Windows 10",
					"8 GB",
					"Workstation",
					"http://localhost:8080/server/image/server2.png",
					SERVER_DOWN));

			serverRepo.save(new Server(null,
					"192.168.1.162",
					"MacBook Pro",
					"32 GB",
					"Laptop",
					"http://localhost:8080/server/image/server3.png",
					SERVER_UP));

			serverRepo.save(new Server(null,
					"192.168.1.163",
					"CentOS Server",
					"64 GB",
					"Data Center",
					"http://localhost:8080/server/image/server4.png",
					SERVER_UP));
		};
	}

}
