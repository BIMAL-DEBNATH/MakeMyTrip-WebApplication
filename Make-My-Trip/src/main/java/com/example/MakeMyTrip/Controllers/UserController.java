package com.example.MakeMyTrip.Controllers;

import com.example.MakeMyTrip.Services.UserService;
import com.example.MakeMyTrip.requestDTO.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public ResponseEntity<String>addUser(@RequestBody AddUserDto addUserDto){

        String res=userService.addUser(addUserDto);
        return new ResponseEntity<>(res, HttpStatus.FOUND);
    }
}
