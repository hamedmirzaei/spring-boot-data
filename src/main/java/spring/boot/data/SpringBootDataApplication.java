package spring.boot.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.boot.data.model.Customer;
import spring.boot.data.repository.CustomerRepository;

@SpringBootApplication
@Slf4j
public class SpringBootDataApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // save a couple of customers
        customerRepository.save(new Customer("Jack", "Bauer"));
        customerRepository.save(new Customer("Chloe", "O'Brian"));
        customerRepository.save(new Customer("Kim", "Bauer"));
        customerRepository.save(new Customer("David", "Palmer"));
        customerRepository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        log.info("Customers found with findAll():");
        for (Customer customer : customerRepository.findAll()) {
            log.info(customer.toString());
        }
        log.info("");

        // fetch an individual customer by ID
        customerRepository.findById(1L).ifPresent(customer -> {
                    log.info("Customer found with findById(1L):");
                    log.info(customer.toString());
                    log.info("");
                });

        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):");
        customerRepository.findByLastName("Bauer").forEach(bauer -> {
            log.info(bauer.toString());
        });
        log.info("");
    }
}
