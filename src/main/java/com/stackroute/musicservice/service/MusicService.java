package com.stackroute.musicservice.service;

import com.stackroute.musicservice.domain.Music;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MusicService {

    Music saveMusic(Music music);
    List<Music> getAllMusic();
    Optional<Music> getMusicById(int trackid);
    Music updateMusic(Music music, int trackid);
    void deleteMusicById(int trackid);
}
