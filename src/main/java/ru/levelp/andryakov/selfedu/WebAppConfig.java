package ru.levelp.andryakov.selfedu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.levelp.andryakov.selfedu.common.model.User;
import ru.levelp.andryakov.selfedu.dao.HibernateHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.levelp.andryakov.selfedu")
public class WebAppConfig {

    @Bean
    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("TestPersistenceUnit");
    }

    @Bean
    public EntityManager getEntityManager(EntityManagerFactory factory) {
        EntityManager em = factory.createEntityManager();

        //TODO: убрать костыль после изучения регистрации и аутентификации
        User user = new User();
        user.setLogin("admin");
        user.setPassword("password");
        try {
            HibernateHelper.persistInstance(user, em);
        } catch (Throwable t) {
            System.out.println("Error while adding user\n\t" + t.getStackTrace());
        }
        return em;
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
