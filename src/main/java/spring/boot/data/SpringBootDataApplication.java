package spring.boot.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.data.model.Customer;
import spring.boot.data.repository.CustomerRepository;

import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class SpringBootDataApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataApplication.class, args);
    }

    @Transactional(readOnly = true)
    @Override
    public void run(String... args) throws Exception {
        // save a couple of customers
        customerRepository.save(new Customer("Farshad", "Mirzaei 2"));
        customerRepository.save(new Customer("Reza", "Mirzaei 2"));
        customerRepository.save(new Customer("Rasoul", "Mirzaei 3"));
        customerRepository.save(new Customer("Sadjad", "Mirzaei 3"));
        customerRepository.save(new Customer("Mehrdad", "Mirzaei 3"));

        // fetch all customers
        log.info("");
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
        log.info("Customer found with findByLastName('Mirzaei 2'):");
        customerRepository.findByLastName("Mirzaei 2").forEach(mirzaeiCustomer -> {
            log.info(mirzaeiCustomer.toString());
        });
        log.info("");

        // for stream, need @Transactional
        log.info("Customer found with findByFirstNameReturnStream(@Param(\"firstName\") String firstName):");
        try (Stream<Customer> stream = customerRepository.findByFirstNameReturnStream("Hamed")) {
            stream.forEach(x -> log.info(x.toString()));
        }
        log.info("");
    }
}
