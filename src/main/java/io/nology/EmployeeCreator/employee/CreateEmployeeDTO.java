package io.nology.EmployeeCreator.employee;


import java.time.LocalDate;

import org.springframework.lang.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateEmployeeDTO {
	
  @NotBlank
  private String firstName;
  
  private String middleName;
	
  @NotBlank
  private String lastName;
  
  @NotBlank
  @Email(message = "must be a valid email")
  private String email;
  
  @NotBlank
  private String mobileNumber;
  
  @NotBlank
  private String address;
  
  @NotBlank
  private String contractType;
  
  @NotNull
  private LocalDate startDate;
  
  @Nullable
  private LocalDate finishDate;
  
  private Boolean ongoing;
  
   @NotBlank
   private String workType;
	
   @Min(value = 0, message = "Working hours per week must be greater than or equal to 0")
   private Integer hoursPerWeek;

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getContractType() {
	return contractType;
}

public void setContractType(String contractType) {
	this.contractType = contractType;
}

public LocalDate getStartDate() {
	return startDate;
}

public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}

public LocalDate getFinishDate() {
	return finishDate;
}

public void setFinishDate(LocalDate finishDate) {
	this.finishDate = finishDate;
}

public Boolean getOngoing() {
	return ongoing;
}

public void setOngoing(Boolean ongoing) {
	this.ongoing = ongoing;
}

public String getWorkType() {
	return workType;
}

public void setWorkType(String workType) {
	this.workType = workType;
}

public Integer getHoursPerWeek() {
	return hoursPerWeek;
}

public void setHoursPerWeek(Integer hoursPerWeek) {
	this.hoursPerWeek = hoursPerWeek;
}

public CreateEmployeeDTO(String firstName, String middleName, String lastName, String email, String mobileNumber,
		String address, String contractType, LocalDate startDate, LocalDate finishDate, Boolean ongoing, String workType,
		Integer hoursPerWeek) {
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.email = email;
	this.mobileNumber = mobileNumber;
	this.address = address;
	this.contractType = contractType;
	this.startDate = startDate;
	this.finishDate = finishDate;
	this.ongoing = ongoing;
	this.workType = workType;
	this.hoursPerWeek = hoursPerWeek;
}

  
}