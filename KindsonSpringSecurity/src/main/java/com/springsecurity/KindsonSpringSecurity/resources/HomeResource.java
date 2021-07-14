package com.springsecurity.KindsonSpringSecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeResource {

    @GetMapping()
    public String getHome(){
        return ("<h1>Welcome Home</h1>");
    }

    @GetMapping("/user")
    public String getUserPage(){
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return ("<h1>Welcome Home</h1>");
    }
}
