package com.stackroute.musicservice.repository;

import com.stackroute.musicservice.domain.Music;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends MongoRepository<Music, Integer> {
    /*Add an endpoint to search trackByName.
       Understand @Query and parameter passing to @Query
*/
//    @Query("select m.trackName from Music m where m.trackName=?1")
    @Query("{trackName:'?0'}")
    List<Music> findbyName(String Name);

}
