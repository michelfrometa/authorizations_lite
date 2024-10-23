package com.test.authorizer.presentation.controller;

import com.test.authorizer.application.input.user.CreateUserDto;
import com.test.authorizer.application.input.user.UserDto;
import com.test.authorizer.application.usecase.user.IUserUserCaseService;
import com.test.authorizer.presentation.output.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final IUserUserCaseService userCaseService;
    
    @PostMapping
    public ResponseEntity<ResponseDto<UserDto>> create(@ModelAttribute CreateUserDto dto) {
        return Optional.of(dto)
                .map(userCaseService::create)
                .map(ResponseDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}
