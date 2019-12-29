package com.appointment.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appointment.app.modaldto.MobileNmber;
import com.appointment.app.service.HomePageService;

@Controller
public class HomeController {
	private static Logger LOGGER = LogManager.getLogger(HomeController.class);

	@Autowired
	private HomePageService homePageService;

	@GetMapping("/")
	public String Hello() {
		LOGGER.debug("Home page executing");
		System.out.println("Hello Executing");
		return "index";
	}
	@GetMapping("/error")
	public String errorPage() {
		LOGGER.debug("error executing");
		return "error";
	}
	@GetMapping("/registrationpage")
	public String registerRedirect() {
		LOGGER.debug("Home page executing");
		System.out.println("Hello Executing");
		return "registrationpage";
	}

	// this method is only for testing purpose
	@RequestMapping(value = {"/getotp"},method = RequestMethod.POST)
	public ResponseEntity sendOTP(@RequestBody String Json ,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("Json = "+Json);
		try {
			if(Json != null ) {
				Long mNumber = Long.parseLong(Json);
				System.out.println("hello"+homePageService.mobileNumberregistration(mNumber));
				if(homePageService.mobileNumberregistration(mNumber)) {
				Random rand = new Random();
				Integer IOTP = rand.nextInt(9999);
				String OTP = Integer.toString(IOTP);
				System.out.println("OTP ="+OTP);
				LOGGER.debug("OTP generated");
				homePageService.saveMobileNumber(IOTP, mNumber);
				}
				else {
					System.out.println("mobile number already exist");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body("OTP send sucessfully");
	}

	@RequestMapping(value = {"/otpverify"} , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity vefifyOTP(@RequestBody Map<String,Object> map, HttpServletRequest request,HttpServletResponse response){
		LOGGER.info("json",map.toString());
		LOGGER.info("json",map.get("otp"));
		System.out.println("map "+map);
		System.out.println(map.get("otp"));
		System.out.println(map.get("mobileNumber"));
		try{
		if(map.get("mobileNumber")!=null && map.get("mobileNumber")!=null){
			System.out.println("otp verifying");
			// find my mobile number and verify the new otp and saves atp

		}
		else{
			return ResponseEntity.status(HttpStatus.OK).body("enternal server error");
		}
	}
	catch(Exception ex){
		return ResponseEntity.status(HttpStatus.OK).body("enternal server error");
	}
		return ResponseEntity.status(HttpStatus.OK).body("verified");
	}

	// this method can sent actual otp to the customer mobile number authenticatation
	// @GetMapping(value = "/getotp")
	// public String sendSms() {
	// 	try {
	// 		// Construct data
	// 		String apiKey = "apikey=" + "kjaAhCeTgjw-HTgDJY2VhQ3SCbQ0K5azw1gwectKd0";

	// 		Random rand = new Random();
	// 		Integer OTP = rand.nextInt(9999);
	// 		String SOTP = Integer.toString(OTP);
	// 		System.out.println("OTP ="+OTP);

	// 		String message = "&message=" + "Dear Customer your otp is " +SOTP+" authenticate your M.No";
	// 		System.out.println("message - "+message);
	// 		String sender = "&sender=" + "TXTLCL";
	// 		String numbers = "&numbers=" + "918252545886";

	// 		// Send data
	// 		HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
	// 		String data = apiKey + numbers + message + sender;
	// 		conn.setDoOutput(true);
	// 		conn.setRequestMethod("POST");
	// 		conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
	// 		conn.getOutputStream().write(data.getBytes("UTF-8"));
	// 		final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	// 		final StringBuffer stringBuffer = new StringBuffer();
	// 		String line;
	// 		while ((line = rd.readLine()) != null) {
	// 			stringBuffer.append(line);
	// 		}
	// 		rd.close();

	// 		return stringBuffer.toString();
	// 	} catch (Exception e) {
	// 		System.out.println("Error SMS "+e);
	// 		return "Error "+e;
	// 	}
	// }


	// @GetMapping (value = "/getotp")
	// public String sendSms() {
	// 	try {
	// 		System.out.println("sendsms executing");
	// 		// Construct data
	// 		final String apiKey = "apikey=" + URLEncoder.encode("kjaAhCeTgjw-Q62WSNXClw5lOFy1dnYHSJPU0udQSj", "UTF-8");
	// 		final Random rand = new Random();
	// 		final Integer OTP = rand.nextInt(9999);
	// 		System.out.println("OTP ="+OTP);
	// 		final String message = "&message=" + URLEncoder.encode("This is your ?", "UTF-8");
	// 		System.out.println("message ="+message);
	// 		final String sender = "&sender=" + URLEncoder.encode("availinfo", "UTF-8");
	// 		System.out.println("sender ="+sender);

	// 		final String numbers = "&numbers=" + URLEncoder.encode("918210693542", "UTF-8");
	// 		System.out.println("numbers ="+numbers);

	// 		// Send data
	// 		final String data = "https://api.txtlocal.com/send/?" + apiKey + numbers + message + sender;
	// 		System.out.println("data ="+data);
	// 		final URL url = new URL(data);
	// 		System.out.println("url ="+url);
	// 		final URLConnection conn = url.openConnection();
	// 		System.out.println("con ="+conn);

	// 		conn.setDoOutput(true);
	// 		System.out.println(conn.getDoOutput());

	// 		// Get the response
	// 		final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	// 		System.out.println("rd ="+rd.toString());
	// 		String line;
	// 		String sResult="";
	// 		while ((line = rd.readLine()) != null) {
	// 		// Process line...
	// 			sResult=sResult+line+" ";
	// 			System.out.println("sResult ="+sResult);
	// 		}
	// 		rd.close();

	// 		return "index";
	// 	} catch (final Exception e) {
	// 		System.out.println("Error SMS "+e);
	// 		return "index";
	// 	}
	// }

}
