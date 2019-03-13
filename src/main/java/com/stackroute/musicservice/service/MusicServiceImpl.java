package com.stackroute.musicservice.service;
import com.stackroute.musicservice.Exceptions.MusicAlreadyExistsException;
import com.stackroute.musicservice.Exceptions.MusicNotFoundException;
import com.stackroute.musicservice.domain.Music;
import com.stackroute.musicservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {
    private MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }


    @Override
    public Music saveMusic(Music music) throws MusicAlreadyExistsException {
        if (musicRepository.existsById(music.getTrackId())) {
            throw new MusicAlreadyExistsException("Music Already Exists");
        }
        Music saveMusic = musicRepository.save(music);
        if (saveMusic == null) {
            throw new MusicAlreadyExistsException("Music Already Exists");
        }
        return saveMusic;
    }
    @Override
    public List<Music> getAllMusic() {
        return (List<Music>) musicRepository.findAll();
    }

    @Override
    public Optional<Music> getMusicById(int trackid) {
        return musicRepository.findById(trackid);
    }

    @Override
    public Music updateMusic(Music music, int trackid) {
        music.setTrackId(trackid);
        Music updateUser = musicRepository.save(music);
        return updateUser;
    }

    @Override
    public void deleteMusicById(int trackid) {
        musicRepository.deleteById(trackid);
    }

    @Override
    public List<Music> findbyName(String Name) throws MusicNotFoundException {
        List<Music> mv = musicRepository.findbyName(Name);
        if (mv.isEmpty()) {
            throw new MusicNotFoundException("Music not found");
        }
        return mv;
    }
}
