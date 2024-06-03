package com.project.musicapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.musicapp.entity.Playlist;
import com.project.musicapp.entity.Song;
import com.project.musicapp.service.PlaylistService;
import com.project.musicapp.service.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistService playlistService;
	
	@GetMapping("/createplaylists")
	public String createPlaylists(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylists";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		playlistService.addplaylist(playlist);
		
		//updating the song playlist table
	    List<Song> songs = playlist.getSongs();
	    for(Song song : songs) {
	    	song.getPlaylists().add(playlist);
	    	songService.updateSong(song);
	    }
		
		return "adminhome";
	}
	
}