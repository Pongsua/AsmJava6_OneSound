package com.asm.restController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.asm.dao.AlbumDAO;
import com.asm.entity.Album;
import com.asm.service.FileManagerService;
import com.asm.service.ParamService;


@RestController
public class AlbumRestController {

	@Autowired
	AlbumDAO dao;
	
	@Autowired
    FileManagerService fileService;
	
	@Autowired
	ParamService paS;
	@GetMapping("/rest/albums")
	public ResponseEntity<List<Album>> getAll(Model model){
		return ResponseEntity.ok(dao.findAll());
	}
	
	@GetMapping("/rest/albums/{id}")
	public ResponseEntity<Album> getOne(@PathVariable("id") Long id){
		if(!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dao.findById(id).get());
	}
	
	@PostMapping("/rest/albums")
	public ResponseEntity<Album> post(@RequestParam("image") MultipartFile file ,@RequestBody Album album){
		 paS.save(file, "/images/"); // Lưu tệp hình ảnh và nhận đường dẫn
		 String imagePath = file.getOriginalFilename();
		    album.setImage(imagePath); // Đặt đường dẫn hình ảnh vào album
		    dao.save(album); // Lưu thông tin album vào cơ sở dữ liệu
		    return ResponseEntity.ok(album);
	}
	
	@PutMapping("/rest/albums/{id}")
	public ResponseEntity<Album> put(@PathVariable("id") Long id, @RequestBody Album album){
		if(!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		dao.save(album);
		return ResponseEntity.ok(album);
	}
	
	@DeleteMapping("/rest/albums/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		if(!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		dao.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
