package com.AppointmentSystem.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * Created by Ruzal on 8/23/2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.AppointmentSystem")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/resources/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/resources/fonts/**").addResourceLocations("/resources/fonts/");
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(52428800);//5mb
        return resolver;
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        return messageSource;
    }


    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        //Using gmail
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("zeroxlucifer24@gmail.com");
        mailSender.setPassword("asdfghjkl9843049192");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

//    @Bean
//    public URI dbUrl(){
//        try {
//            return new URI("${DATABASE_URL}");
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//            System.out.println("NOT FOUND~");
//            return null;
//        }
//    }

}
