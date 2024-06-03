package com.fabless.clothlogix.controller;
import com.fabless.clothlogix.Entity.LoginEntity;
import com.fabless.clothlogix.service.Impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/login")
public class LoginController {
    @PostMapping("/authentication/login")
    public String login() {
        return "authentication/login"; // Nome del template Thymeleaf
    }
}