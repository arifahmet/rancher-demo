package com.example.rancher_demo.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hello")
public class HelloController {
    @GetMapping
    public ResponseEntity<String> hello(@RequestParam(required = false) String name) {
        return ResponseEntity.ok("Hello " + (StringUtils.hasText(name) ? name: "world") + "!");
    }
}
