package com.argProgramaSpallione.ArgentinaPrograma.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    
    @GetMapping("")
    public String decirHola() {
        return "hola <b>como</b> tas";
    }
    
}