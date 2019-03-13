package com.stackroute.musicservice.Configuaration;

import com.stackroute.musicservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/* Running Logic on Startup in Spring. Create seed data to pre-fill the database with music information whenever the application starts.
    Use both approaches:
      Approach 1: ApplicationListener<ContextRefreshedEvent>
      Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)
      *differences
        * By default applicationListener will executes first after commandLineRunner
        * applicationListener takes arguments as parameters where as CLR will take string args as parameters.
*/

@Component
public class CommandLine implements CommandLineRunner {
    private String name;
    private MusicRepository musicRepository;

    @Autowired
    public CommandLine(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    @Order(1)
    public void run(String... args) throws Exception {
        System.out.println("CommandLine Arguments");
        //musicRepository.save(new Music(2,"punja","plus"));
    }
}
