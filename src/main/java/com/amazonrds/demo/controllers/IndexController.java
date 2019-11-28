package com.amazonrds.demo.controllers;

import com.amazonrds.demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.amazonrds.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class IndexController {

    private UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("enterData", true);
        model.addAttribute("showData", false);
        return "index";
    }

    @RequestMapping(value = "/savedata", method = RequestMethod.POST)
    public String savedata(Model model,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "lastname", required = false) String lastname){

        model.addAttribute("enterData", true);
        model.addAttribute("showData", false);

        userService.addUser(name,lastname);
        return "index";

    }


    @RequestMapping(value = "/showData")
    public String showdata(Model model){

        model.addAttribute("enterData", false);
        model.addAttribute("showData", true);

        model.addAttribute("userList", userService.getAllUsers());

        return "index";

    }


}
