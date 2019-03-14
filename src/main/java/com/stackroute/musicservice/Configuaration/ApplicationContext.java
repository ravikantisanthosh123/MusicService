package com.stackroute.musicservice.Configuaration;

import com.stackroute.musicservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
/* *Running Logic on Startup in Spring. Create seed data to pre-fill the database with music information whenever the application starts.
        * Use both approaches:
            Approach-1: ApplicationListener<ContextRefreshedEvent>
            Approach-2: CommandLineRunner (Find out how it differs from ApplicationRunner)
    *Remove all hard coded data from the application code to application.properties
    a)by using @Value.
    b)by using @PropertySource
    c)by using Environment (https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.htm
*/
@Component
@PropertySource("classpath:application.properties")
public class ApplicationContext implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    Environment environment;
    @Value("${trackid1}")
    int trackid;

    @Value("Application is running")
    private String name;
    private MusicRepository musicRepository;

    @Autowired
    public ApplicationContext(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("ApplicationListener");
        //musicRepository.save(new Music(trackid,environment.getProperty("trackName"),environment.getProperty("overview")));
    }
}
