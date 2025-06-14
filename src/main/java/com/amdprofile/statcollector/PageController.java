package com.amdprofile.statcollector;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final RecordService recordService;

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("records", recordService.getAllRecords());
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}