package com.cem.monolithichomework.controller;

import com.cem.monolithichomework.dto.response.UserFindAllResponseDto;
import com.cem.monolithichomework.repository.entity.User;
import com.cem.monolithichomework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;

    // http://localhost:9092/user/findall
    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll(){

        return ResponseEntity.ok(userService.findAll()) ;

    }
    // http://localhost:9092/user/findalldto
    @GetMapping ("/findalldto")
    public ResponseEntity<List<UserFindAllResponseDto>> findAllDto(){

        return ResponseEntity.ok(userService.findAllDto()) ;

    }
}
