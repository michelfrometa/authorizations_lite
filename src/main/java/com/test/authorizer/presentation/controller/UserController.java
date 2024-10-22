package com.test.authorizer.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.authorizer.application.input.CreateUserDto;
import com.test.authorizer.application.input.UserDto;
import com.test.authorizer.application.usecase.user.IUserUserCasesService;
import com.test.authorizer.presentation.output.ResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    
    private final IUserUserCasesService userService;
    
    @PostMapping
    public ResponseEntity<ResponseDto<UserDto>> saveAnalysisDocument(@ModelAttribute CreateUserDto dto) {
        return ResponseEntity.ok(userService.create(dto));
    }

}
