package org.learn.securebyjwt.controller;

import org.learn.securebyjwt.service.AuthenticationResponse;
import org.learn.securebyjwt.service.AutheticationRequest;
import org.learn.securebyjwt.service.JwtUtil;
import org.learn.securebyjwt.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager mgr;

    @Autowired
    private MyUserDetailsService userServiceDetails ;

    @Autowired
    private JwtUtil util;


    @RequestMapping(value = "/hello" )
    public String sayHello(){
        return "Hello, Alpha Sovereign!, Welcome back.";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AutheticationRequest req, HttpServletRequest request) throws Exception {

        UsernamePasswordAuthenticationToken authentication = null;
        try {
             authentication = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
            mgr.authenticate(authentication);
        }catch (Exception e){
            throw new Exception( "INVALID CREDENTIALS",e);
        }

        UserDetails userDetails = userServiceDetails.loadUserByUsername(req.getUsername());

        String jwt = util.generateToken(userDetails);

        return new ResponseEntity( new AuthenticationResponse(jwt), HttpStatus.OK);
    }
}
