package com.sysmap.demo.api;

import com.sysmap.demo.services.authentication.AuthenticateResponse;
import com.sysmap.demo.services.authentication.AuthenticateRequest;
import com.sysmap.demo.services.authentication.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/authentication")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService _authenticateService;
    @PostMapping()
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok().body(_authenticationService.authenticate(request));
    }
}
