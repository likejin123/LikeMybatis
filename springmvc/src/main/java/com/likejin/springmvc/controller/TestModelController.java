package com.likejin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 李柯锦
 * @Date 2023/5/29 19:38
 * @Description 测试model使用
 */

@Controller
@RequestMapping("/model")
public class TestModelController {

    @GetMapping("/model")
    public String testModel(Model model){
        model.addAttribute("name","like");
        return "model";
    }

}
