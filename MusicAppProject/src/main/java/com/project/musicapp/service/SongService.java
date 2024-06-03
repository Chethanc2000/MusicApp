package com.project.musicapp.service;

import java.util.List;

import com.project.musicapp.entity.Song;

public interface SongService {

	void saveSong(Song song);

	boolean songExists(String name);

	List<Song> fetchAllSongs();

	void updateSong(Song song);



	

}
