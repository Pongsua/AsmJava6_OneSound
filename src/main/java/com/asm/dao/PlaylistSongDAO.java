package com.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.PlaylistSong;

public interface PlaylistSongDAO extends JpaRepository<PlaylistSong, Long> {

}
