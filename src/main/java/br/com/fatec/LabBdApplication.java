package br.com.fatec;

import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatec.dao.CustomerRepository;
import br.com.fatec.model.Customer;

@SpringBootApplication
public class LabBdApplication implements CommandLineRunner {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LabBdApplication.class, args);
	}
	
	@Transactional(readOnly = true)
	@Override
	public void run(String... args) throws Exception {
		System.out.println("DATASOURCE = " + this.dataSource);	
		
		System.out.println("1. findAll()...");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer.getName());
		}
		
		try (Stream<Customer> stream = customerRepository.findByEmailReturnStream("333@yahoo.com")) {
			stream.forEach(x -> System.out.println(x.getName()));
		}
	}
}
