package application;


import domain.ClientRepository;
import domain.ClientRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public ClientRepository clientRepository() {
        return new ClientRepositoryImpl();
    }

    @Bean
    public ApplicationService applicationService() {
        return new ApplicationServiceImpl();
    }

}
