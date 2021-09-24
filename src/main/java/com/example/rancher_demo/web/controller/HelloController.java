package com.example.rancher_demo.web.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("api/v1/hello")
public class HelloController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> hello(@RequestParam(required = false) String name) {

        return ResponseEntity.ok("{\"Message\":\"Hello " + (StringUtils.hasText(name) ? name : "world") + "!\"" +
                getInfo() + "}");
    }

    private String getInfo() {
        String res = "";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            res = ",\"Hostname\" : \"" + inetAddress.getHostName() + "\"" +
                    ", \"HostAddress\" : \"" + inetAddress.getHostAddress() + "\"" +
                    ", \"CanonicalHostName\" : \"" + inetAddress.getCanonicalHostName() + "\"" +
                    ", \"HostAddress\" : \"" + inetAddress.getHostAddress() + "\"";
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return res;
    }
}
