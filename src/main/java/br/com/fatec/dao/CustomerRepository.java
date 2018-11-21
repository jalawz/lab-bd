package br.com.fatec.dao;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.fatec.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByEmail(String email);
	
	List<Customer> findByDate(Date date);
	
	// custom query
	@Query("select c from Customer c where c.email = :email")
	Stream<Customer> findByEmailReturnStream(@Param("email") String email);
}
