package org.example.security.servlets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BarevBarlusController {

    @GetMapping("/barlus")
    public String barlus() {
        return "barlus";
    }

    @GetMapping("/hajox")
    public String hajox() {
        return "hajox";
    }

}
