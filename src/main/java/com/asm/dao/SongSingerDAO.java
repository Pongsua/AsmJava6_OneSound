package com.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.SongSinger;

public interface SongSingerDAO extends JpaRepository<SongSinger, Long> {

}
