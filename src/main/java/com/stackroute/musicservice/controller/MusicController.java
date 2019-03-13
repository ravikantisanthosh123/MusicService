package com.stackroute.musicservice.controller;

import com.stackroute.musicservice.Exceptions.MusicAlreadyExistsException;
import com.stackroute.musicservice.Exceptions.MusicNotFoundException;
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

    // To save the music using id to database and throws exception
    @PostMapping("/user")
    public ResponseEntity<Music> saveMusic(@RequestBody Music music) throws MusicAlreadyExistsException {
        return new ResponseEntity<Music>(musicService.saveMusic(music), HttpStatus.CREATED);
    }

    //To Get All Music
    @GetMapping("/users")
    public ResponseEntity<List<Music>> getAllMusic() {
        return new ResponseEntity<List<Music>>(musicService.getAllMusic(), HttpStatus.OK);
    }

    //To get Music based on trackid
    @GetMapping("/user/{trackid}")
    public ResponseEntity<Optional<Music>> getMusicById(@PathVariable int trackid) {
        return new ResponseEntity<Optional<Music>>(musicService.getMusicById(trackid), HttpStatus.OK);
    }

    // Updating the data of particular music using id
    @PutMapping("/users/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable int id, @RequestBody Music music) {
        Music updateMusic = musicService.updateMusic(music, id);
        return new ResponseEntity<Music>(updateMusic, HttpStatus.OK);
    }

    //Deleting the trackid
    @DeleteMapping("/user/{trackid}")
    public void deleteMusicById(@PathVariable int trackid) {
        musicService.deleteMusicById(trackid);
    }

    //To get the track by TrackName
    @GetMapping("/users/{name}")
    public ResponseEntity<List<Music>> findTrackByName(@PathVariable String name) throws MusicNotFoundException {
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<List<Music>>(musicService.findbyName(name), HttpStatus.CREATED);
        return responseEntity;
    }
}
