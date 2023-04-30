package priv.klochkov.constructionwork.config;

import org.mapstruct.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import priv.klochkov.constructionwork.dao.CustomerDao;
import priv.klochkov.constructionwork.dao.OrderDao;
import priv.klochkov.constructionwork.sevice.impl.CustomerServiceImpl;
import priv.klochkov.constructionwork.sevice.impl.OrderServiceImpl;
//import priv.klochkov.constructionwork.sevice.utils.OrderMapper;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("priv.klochkov.constructionwork")
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @Bean
//    public OrderMapper orderMapper() {
//        return OrderMapper.INSTANCE;
//    }

    @Bean("orderService")
    public OrderServiceImpl orderService(CustomerServiceImpl customerService) {
        OrderDao orderDao = new OrderDao();
        return new OrderServiceImpl(orderDao, customerService);
    }


    @Bean(name = "customerService")
    public CustomerServiceImpl customerService() {
        CustomerDao customerDao = new CustomerDao();
        return new CustomerServiceImpl(customerDao);
    }


}

