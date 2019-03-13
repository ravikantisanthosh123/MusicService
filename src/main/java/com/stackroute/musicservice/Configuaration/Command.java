package com.stackroute.musicservice.Configuaration;
import com.stackroute.musicservice.domain.Music;
import com.stackroute.musicservice.repository.MusicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

    @Component
    public class Command implements CommandLineRunner {
    private String name;
    private MusicRepository musicRepository;

    public Command(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    @Order(1)
    public void run(String... args) throws Exception {
        System.out.println("CommandLine Arguments");
        musicRepository.save(new Music(2,"punja","plus"));
    }
}
