package com.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.SongGenre;

public interface SongGenreDAO extends JpaRepository<SongGenre, Long> {

}
