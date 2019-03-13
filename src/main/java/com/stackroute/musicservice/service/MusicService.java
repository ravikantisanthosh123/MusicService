package com.stackroute.musicservice.service;

import com.stackroute.musicservice.Exceptions.MusicAlreadyExistsException;
import com.stackroute.musicservice.Exceptions.MusicNotFoundException;
import com.stackroute.musicservice.domain.Music;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MusicService {

    Music saveMusic(Music music) throws MusicAlreadyExistsException;

    List<Music> getAllMusic();

    Optional<Music> getMusicById(int trackid);

    Music updateMusic(Music music, int trackid);

    void deleteMusicById(int trackid);

    List<Music> findbyName(String Name) throws MusicNotFoundException;

}
