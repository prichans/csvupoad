package com.example.csvupload.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="entries")
public class Csv {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id;

private String source;
private String codeListCode;
private String code;
private String displayValue;
private String longDescription;
private LocalDate fromDate;
private LocalDate toDate;
private Integer sortingPriority;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getCodeListCode() {
	return codeListCode;
}
public void setCodeListCode(String codeListCode) {
	this.codeListCode = codeListCode;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getDisplayValue() {
	return displayValue;
}
public void setDisplayValue(String displayValue) {
	this.displayValue = displayValue;
}
public String getLongDescription() {
	return longDescription;
}
public void setLongDescription(String longDescription) {
	this.longDescription = longDescription;
}
public LocalDate getFromDate() {
	return fromDate;
}
public void setFromDate(LocalDate fromDate) {
	this.fromDate = fromDate;
}
public LocalDate getToDate() {
	return toDate;
}
public void setToDate(LocalDate toDate) {
	this.toDate = toDate;
}
public Integer getSortingPriority() {
	return sortingPriority;
}
public void setSortingPriority(Integer sortingPriority) {
	this.sortingPriority = sortingPriority;
}





}
