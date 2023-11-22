package com.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.SingerAlbum;

public interface SingerAlbumDAO extends JpaRepository<SingerAlbum, Long> {

}
