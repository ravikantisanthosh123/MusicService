package com.stackroute.musicservice.controller;
import com.stackroute.musicservice.domain.Music;
import com.stackroute.musicservice.service.MusicService;
import com.stackroute.musicservice.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MusicController {
    private MusicService musicService;

    @Autowired
    public MusicController(MusicServiceImpl musicServiceImpl) {
        this.musicService = musicServiceImpl;
    }

    @PostMapping("/user")
    public ResponseEntity<Music> saveMusic(@RequestBody Music music) {
        Music saveMusic = musicService.saveMusic(music);
        return new ResponseEntity<Music>(saveMusic, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Music>> getAllMusic() {
        return new ResponseEntity<List<Music>>(musicService.getAllMusic(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<Music>> getMusicById(@PathVariable int trackid) {
        return new ResponseEntity<Optional<Music>>(musicService.getMusicById(trackid), HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable int trackid, @RequestBody Music music) {
        Music updateMusic = musicService.updateMusic(music, trackid);
        return new ResponseEntity<Music>(updateMusic, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public void deleteMusicById(@PathVariable int trackid) {
        musicService.deleteMusicById(trackid);
    }
}
