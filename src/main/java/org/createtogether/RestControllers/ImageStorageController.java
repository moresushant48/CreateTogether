package org.createtogether.RestControllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.createtogether.Models.ImageStorage;
import org.createtogether.Repository.ImageStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ImageStorageController {
	
	@Autowired
	ImageStorageRepository imageStorageRepository; 

	/*
	 * Store the given images and Return True or False
	 * */
	@PostMapping("/post/store")
	public Boolean storeImage(@RequestParam("imgs") MultipartFile[] files) {
		
		for (MultipartFile file : files) {
			try {
				if(imageStorageRepository.save(new ImageStorage(file.getOriginalFilename(), file.getContentType(), file.getBytes())) == null) {
					return false;
				}
			} catch (IOException e) { e.printStackTrace(); }
		}
		
		return true;
	}
	
	/*
	 * Get the Images with the url, appending the provided Image id (uuid).
	 * */
	@GetMapping("/get/storage/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") String id) {
        // Load file from database
        ImageStorage dbFile = imageStorageRepository.getOne(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getImgType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getImgName() + "\"")
                .body(new ByteArrayResource(dbFile.getImgFile()));
    }
	
	/*
	 * Retrieve the JSON String List of Image Ids stored in database.
	 * */
	@GetMapping("/get/store")
	public List<String> retrieveImages(){
		List<String> listImages = new ArrayList<String>();
		List<ImageStorage> imageStorages = imageStorageRepository.findAll();
		
		for (ImageStorage imageStorage : imageStorages) {
			listImages.add(imageStorage.getImgId());
		}
		
		return listImages;
	}
	
}
