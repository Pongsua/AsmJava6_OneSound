package com.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.Playlist;

public interface PlaylistDAO extends JpaRepository<Playlist, Long> {

}
