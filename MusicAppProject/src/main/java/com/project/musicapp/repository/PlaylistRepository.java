package com.project.musicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.musicapp.entity.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

	Playlist findByName(String string);

}