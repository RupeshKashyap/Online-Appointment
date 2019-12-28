package com.appointment.app.service;

public interface HomePageService {
	
	public Boolean mobileNumberregistration(Long mnumber);
	
	public void saveMobileNumber(Integer otp, Long mNumber);

}
