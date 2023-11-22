package com.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.Song;

public interface SongDAO extends JpaRepository<Song, Long> {

}
