package com.example.csvupload.controller;

import com.example.csvupload.model.Csv;
import com.example.csvupload.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/csv")
public class CsvController {

	@Autowired
	private CsvService csvService;
	
	@PostMapping(value="/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file){
		try {
			csvService.saveCsv(file);
			return ResponseEntity.ok("File Uploaded successfully");
		}catch(IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
		}
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<List<Csv>> fetchAll(){
		return ResponseEntity.ok(csvService.fetchAll());
	}
	
	@GetMapping("/fetch/{code}")
	public ResponseEntity<List<Csv>> fetchByCode(@PathVariable String code){
		return ResponseEntity.ok(csvService.fetchByCode(code));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAll(){
		csvService.deleteAll();
		return ResponseEntity.ok("All data deleted");
	}

}
