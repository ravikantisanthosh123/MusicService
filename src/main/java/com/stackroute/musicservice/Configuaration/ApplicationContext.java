package com.stackroute.musicservice.Configuaration;
import com.stackroute.musicservice.domain.Music;
import com.stackroute.musicservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationContext implements ApplicationListener {

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
    @Order(2)
    public void onApplicationEvent(ApplicationEvent applicationEvent)
    {
        System.out.println("ApplicationListener");
        musicRepository.save(new Music(trackid,environment.getProperty("trackName"),environment.getProperty("overview")));
    }
}
