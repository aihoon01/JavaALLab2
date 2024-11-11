package org.exercises.mainservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainServiceController {

    @GetMapping
    public String mainService() {
        return "Hello from Main Service!";
    }
}
