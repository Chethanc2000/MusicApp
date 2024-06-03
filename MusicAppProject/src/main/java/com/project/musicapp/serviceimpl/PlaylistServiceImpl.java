package com.project.musicapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.musicapp.entity.Playlist;
import com.project.musicapp.repository.PlaylistRepository;
import com.project.musicapp.service.PlaylistService;
import com.project.musicapp.service.SongService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addplaylist(Playlist playlist) {
		
		Playlist exiplaylist = playlistRepository.findByName(playlist.getName());
		if(exiplaylist == null) {
		playlistRepository.save(playlist);
		}else {
			System.out.println("Playlist already exists");
		}
	}

}