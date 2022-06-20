package com.example.testingfacebookv2.controller;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@Controller
public class HomeController {

    private final Facebook facebook;

    @Inject
    public HomeController(Facebook facebook) {
        this.facebook = facebook;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Reference> friends = facebook.friendOperations().getFriends();
        model.addAttribute("friends", friends);
        return "home";
    }
}
