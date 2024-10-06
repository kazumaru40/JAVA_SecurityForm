package com.example.its.web.user;


import com.example.its.domain.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
//@RequestMapping("/users") すべてのリクエストがhttp://localhost:8080/usersに続くように設定
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //@GetMapping("/")　　にすると http://localhost:8080/users/ のURLに対してのみ対応
    //@GetMapping　　　　 にすると　http://localhost:8080/users　と
    // 　　　　　　　　　　　　　  　http://localhost:8080/users/ の両方に対応

    //   GETリクエスト→　　http://localhost:8080/users
    @GetMapping
    public  String showList (Model model) {
        model.addAttribute("userList",userService.findAll());
        return "users/list";
    }

    //   GETリクエスト→　　http://localhost:8080/users/creationForm
    @GetMapping("/creationForm")
    public  String showCreationForm() {
        return "users/creationForm";
    }
}
