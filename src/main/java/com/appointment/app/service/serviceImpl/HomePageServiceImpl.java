package com.appointment.app.service.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.appointment.app.modaldto.MobileNmber;
import com.appointment.app.repository.MobileNumberRepository;
import com.appointment.app.service.HomePageService;

@Service
public class HomePageServiceImpl implements HomePageService {
	private static Logger LOGGER = LogManager.getLogger(HomePageServiceImpl.class);
	
	@Autowired
	private MobileNumberRepository mobileNumberRepository;


	@Override
	public Boolean mobileNumberregistration(Long mnumber) {
		try{
			System.out.println("service executing");
			Optional obj = mobileNumberRepository.findById(mnumber);
			System.out.println("obj = "+obj.isPresent());
			if(!obj.isPresent()){
				// MobileNmber mobileNmber = new MobileNmber();
				// mobileNmber.setMobileNumber(mnumber);
				// mobileNumberRepository.save(mobileNmber);
				return true;
			}
		}
		catch(Exception ex ){
			ex.printStackTrace();
		}
			
			return false;
	}


	@Override
	public void saveMobileNumber(Integer otp, Long mNumber) {
		try {
		if(otp!=null && mNumber!=null) {
		 MobileNmber mobileNmber = new MobileNmber();
		 mobileNmber.setMobileNumber(mNumber);
		 mobileNmber.setOtp(otp);
		 LOGGER.info("mobileNmber {}",mobileNmber);
		 mobileNumberRepository.save(mobileNmber);
		}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
