package com.example.flowershop.config;


import com.example.flowershop.models.account.Account;
import com.example.flowershop.models.products.Product;
import com.example.flowershop.repositories.AccountRepository;
import com.example.flowershop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class FirstData {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProductRepository productRepository;

    @Bean
    public void initiateFirstParam() {
        if (accountRepository.findAccountByUsername("admin") == null && accountRepository.findAccountByUsername("user") == null) {
            Account account = new Account();
            account.setRole(1);
            //password: 12345
            account.setPassword("$2a$10$SMyaYwkvyAIX9fHFywD7beG6yiIarJ3PoR9yg/UWB6TOMCZiel5ci");
            account.setUsername("admin");
            account.setAddress("Q9");
            accountRepository.save(account);

            Account account2 = new Account();
            account2.setRole(2);
            account2.setPassword("$2a$10$Az4E.v3uneDHol4zJsNlee3Diu8bTXQ4q1qCf0eNFdSc2H1g.WGLG");
            account2.setUsername("user");
            account2.setAddress("Q9");
            accountRepository.save(account2);
        }
        if (!productRepository.findById(1L).isPresent() || !productRepository.findById(2L).isPresent()) {
            Product product = new Product();
            product.setBasePrice(10000);
            product.setDescription("Hoa Hồng Tím");
            product.setType("Hoa Hồng");
            productRepository.save(product);

            Product product2 = new Product();
            product2.setBasePrice(10000);
            product2.setDescription("Hoa Ly Trắng");
            product2.setType("Hoa Ly");
            productRepository.save(product2);
        }

    }

}