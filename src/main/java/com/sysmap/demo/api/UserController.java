package com.sysmap.demo.api;

import com.sysmap.demo.services.user.CreateUserRequest;
import com.sysmap.demo.services.user.FindUserResponse;
import com.sysmap.demo.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private IUserService _userService;
    @PostMapping("create")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) {
        var response = _userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<FindUserResponse> getUser(String email) {
        return ResponseEntity.ok().body(_userService.findUserByEmail(email));
    }

    @PostMapping("/photo/upload")
    public ResponseEntity uploadPhotoProfile(@RequestParam("photo") MultipartFile photo) {
        try {
            _userService.uploadPhotoProfile(photo);

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
