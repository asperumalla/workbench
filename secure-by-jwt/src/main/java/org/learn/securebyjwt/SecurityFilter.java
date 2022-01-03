package org.learn.securebyjwt;

import org.learn.securebyjwt.service.JwtUtil;
import org.learn.securebyjwt.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil util;
    
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //Step 1. Get Authorization
        String authirization = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;


        if( authirization != null && authirization.startsWith("Bearer ") ){
            jwtToken = authirization.substring(7);
            username = util.extractUsername( jwtToken );
       }

        if( username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if(  util.validateToken( jwtToken, userDetails ) ){

                // Form a valid token
                UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                authtoken.setDetails(  new WebAuthenticationDetailsSource().buildDetails( request ));

                SecurityContextHolder.getContext().setAuthentication( authtoken );
            }
        }

        filterChain.doFilter(request, response);

    }
}
