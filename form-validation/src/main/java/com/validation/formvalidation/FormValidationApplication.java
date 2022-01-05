package com.validation.formvalidation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@Slf4j
public class FormValidationApplication {

	private ObjectError eo;

	public static void main(String[] args) {
		SpringApplication.run(FormValidationApplication.class, args);
	}


	@GetMapping(path = "/greet")
	public String testService(){
		return "Hello Alpha, Good Morning!";
	}

	@PostMapping(path = "/postgreet" )
	public List<String> validatePersonalForm(@Valid @RequestBody PersonalForm psersonalForm, BindingResult results){


		if(results.hasFieldErrors()){
			 results.getAllErrors().stream().forEach(System.out::println) ;
			return results.getFieldErrors().stream()
					.map(fe ->
							String.format("%s --> %s",fe.getField(),fe.getDefaultMessage()))
					.collect(Collectors.toList());
		}
		return null;
	}

}
