package com.queueup.qup.controller;

import com.queueup.qup.dto.UserDto;
import com.queueup.qup.repository.UserRepo;
import com.queueup.qup.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;
    private final UserServiceImpl userService;

    public IndexController(UserServiceImpl userService) {

        this.userService = userService;
    }

    @GetMapping()
    public String openMainPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "index";

    }

    @PostMapping("create")
    public String createUser(@ModelAttribute UserDto userDto, RedirectAttributes redirectAttributes){


        userDto.setRole("ROLE_USER");
        userDto.setEnable(true);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));


        userDto = userService.save(userDto);
        if(userDto != null){
            redirectAttributes.addFlashAttribute("message","User Registered Successfully");
        }else{
            redirectAttributes.addFlashAttribute("message","User Registration Failed");
        }
        return "index";
    }
}
