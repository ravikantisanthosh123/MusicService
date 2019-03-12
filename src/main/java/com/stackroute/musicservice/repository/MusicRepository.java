package com.stackroute.musicservice.repository;

import com.stackroute.musicservice.domain.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends CrudRepository<Music,Integer>
{

}
