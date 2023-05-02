package com.sysmap.demo.api;

import com.sysmap.demo.services.security.IJwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    public BaseController(){
        _jwtService.isValidToken();
    }

}
