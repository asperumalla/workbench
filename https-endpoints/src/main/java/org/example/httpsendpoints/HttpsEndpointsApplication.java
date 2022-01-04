package org.example.httpsendpoints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HttpsEndpointsApplication {
	public static void main(String[] args) {
		SpringApplication.run(HttpsEndpointsApplication.class, args);
	}
}

@Controller
@ResponseBody
class Endpoint{

	@RequestMapping(path = "/hello")
	public String greet(){
		return "Hello, Alpha Sovereign.";
	}
}