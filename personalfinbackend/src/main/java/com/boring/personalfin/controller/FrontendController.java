package com.boring.personalfin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {
    @RequestMapping(value={"/", "/home","/login","/signup"})
    public String indexHtml(){
        return "index";
    }
}
