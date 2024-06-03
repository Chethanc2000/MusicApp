package com.project.musicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.musicapp.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{

	Song findByName(String name);

}
