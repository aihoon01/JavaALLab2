package org.exercises.vipservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vip")
public class VipServiceController {

    @GetMapping
    public String vipService() {
        return "Hello from VIP Service!";
    }
}
