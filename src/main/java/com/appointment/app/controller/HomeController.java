package com.appointment.app.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping (value = "/getotp")
	public String sendSms() {
		try {
			System.out.println("sendsms executing");
			// Construct data
			String apiKey = "apikey=" + URLEncoder.encode("kjaAhCeTgjw-HTgDJY2VhQ3SCbQ0K5azw1gwectKd0", "UTF-8");
			Random rand = new Random();
			Integer OTP = rand.nextInt(9999);
			System.out.println("OTP ="+OTP);
			String message = "&message=" + URLEncoder.encode("This is your "+OTP+ "?", "UTF-8");
			System.out.println("message ="+message);
			String sender = "&sender=" + URLEncoder.encode("availinfo", "UTF-8");
			System.out.println("sender ="+sender);

			String numbers = "&numbers=" + URLEncoder.encode("8252545886", "UTF-8");
			System.out.println("numbers ="+numbers);
			
			// Send data
			String data = "https://api.txtlocal.com/send/?" + apiKey + numbers + message + sender;
			System.out.println("data ="+data);
			URL url = new URL(data);
			System.out.println("url ="+url);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			System.out.println("rd ="+rd);
			String line;
			String sResult="";
			while ((line = rd.readLine()) != null) {
			// Process line...
				sResult=sResult+line+" ";
			}
			rd.close();
			
			return sResult;
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	
	@GetMapping("/index")
	public String Hello() {
		System.out.println("Hello Executing");
		return "index";
	}
	
	@GetMapping("/")
	public String Welcome() {
		
	return"error";
	}

}
