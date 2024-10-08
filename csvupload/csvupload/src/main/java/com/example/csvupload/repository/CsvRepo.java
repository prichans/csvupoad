package com.example.csvupload.repository;

import com.example.csvupload.model.Csv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsvRepo extends JpaRepository<Csv,Long> {
  List<Csv> findByCode(String code);
}
