package com.example.csvupload.service;

import com.example.csvupload.model.Csv;
import com.example.csvupload.repository.CsvRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class CsvService {

 @Autowired
 private CsvRepo repo;
 
 public void saveCsv(MultipartFile file) throws IOException{
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	 if(file.isEmpty()) {
		 throw new IOException("File is empty");
	 }
	 try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(),StandardCharsets.UTF_8))){
		 String line;
		 while((line=reader.readLine())!= null) {
			 String[] data = line.split(",");

			 if(data.length<8){
				 throw new IOException("Insufficient data" +line);
			 }
			 Csv entry = new Csv();
			 entry.setSource(data[0]);
			 entry.setCodeListCode(data[1]);
			 entry.setCode(data[2]);
			 entry.setDisplayValue(data[3]);
			 entry.setLongDescription(data[4]);
				try {
					entry.setFromDate(LocalDate.parse(data[5], formatter));
					entry.setToDate(LocalDate.parse(data[6], formatter));
				}catch(DateTimeParseException e){
					throw new IOException("Invalid date format in csv:"+e.getMessage());
				}

			 entry.setSortingPriority(Integer.parseInt(data[7]));
			 repo.save(entry);
		 }
	 }
	 catch(IOException e){
		 throw new IOException("Error while saving csv:"+e.getMessage());
	 }
 }
 
 public List<Csv> fetchAll(){
	 return repo.findAll();
 }
 
 public List<Csv> fetchByCode(String code){
	 return repo.findByCode(code);
 }
 
 public void deleteAll() {
	 repo.deleteAll();
 }

}
