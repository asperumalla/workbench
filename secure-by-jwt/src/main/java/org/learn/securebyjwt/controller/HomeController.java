package org.learn.securebyjwt.controller;

import org.learn.securebyjwt.service.AuthenticationResponse;
import org.learn.securebyjwt.service.AutheticationRequest;
import org.learn.securebyjwt.service.JwtUtil;
import org.learn.securebyjwt.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

   /* @Autowired
    private AuthenticationManager mgr;

    @Autowired
    private MyUserDetailsService userServiceDetails ;*/

    @Autowired
    private JwtUtil util;

    @RequestMapping("/")
    public String hello(){
        return "Hello, Alpha Sovereign.";
    }

    /*@RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AutheticationRequest req) throws Exception {

        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
            mgr.authenticate(authentication);
        }catch (Exception e){
            throw new Exception( "INVALID CREDENTIALS",e);
        }

        UserDetails userDetails = userServiceDetails.loadUserByUsername(req.getUsername());

        String s = util.generateToken(userDetails);

        return new ResponseEntity( new AuthenticationResponse(s), HttpStatus.OK);
    }*/
}
