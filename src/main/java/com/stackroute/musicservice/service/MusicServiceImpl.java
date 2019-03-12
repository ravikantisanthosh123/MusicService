package com.stackroute.musicservice.service;
import com.stackroute.musicservice.domain.Music;
import com.stackroute.musicservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService{
    private MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }


    @Override
    public Music saveMusic(Music music) {
        Music saveMusic=musicRepository.save(music);
        return saveMusic;
    }

    @Override
    public List<Music> getAllMusic() {
        return (List<Music>)musicRepository.findAll();
    }

    @Override
    public Optional<Music> getMusicById(int trackid) {
        return musicRepository.findById(trackid);
    }

    @Override
    public Music updateMusic(Music music, int trackid) {
        music.setTrackId(trackid);
        Music updateUser =  musicRepository.save(music);
        return updateUser;
    }

    @Override
    public void deleteMusicById(int trackid) {
        musicRepository.deleteById(trackid);
    }
}
