package com.example.its.web.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/users")
public class UserController {


    //@GetMapping("/")　　にすると http://localhost:8080/users/ のURLに対してのみ対応
    //@GetMapping　　　　 にすると　http://localhost:8080/users　と
    // 　　　　　　　　　　　　　  　http://localhost:8080/users/ の両方に対応
    @GetMapping
    public  String showList (Model model) {
        model.addAttribute("userList",Collections.emptyList());
        return "users/list";
    }
}
