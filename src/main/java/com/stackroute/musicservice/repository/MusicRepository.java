package com.stackroute.musicservice.repository;

import com.stackroute.musicservice.domain.Music;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends CrudRepository<Music,Integer>
{
 @Query("select m.trackName from Music m where m.trackName=?1")
    List<Music> findbyName(String Name);
}
