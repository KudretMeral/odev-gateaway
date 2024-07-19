package com.vehicle.microservice_gateaway.controller;

import com.vehicle.microservice_gateaway.entity.AplUser;
import com.vehicle.microservice_gateaway.service.IAplUserService;
import com.vehicle.microservice_gateaway.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController
{
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IAplUserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody AplUser aplUser)
    {
        if (userService.findByUsername(aplUser.getUsername()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(aplUser), HttpStatus.CREATED);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody AplUser aplUser)
    {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(aplUser), HttpStatus.OK);
    }
}
