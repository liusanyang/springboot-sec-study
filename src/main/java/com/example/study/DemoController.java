package com.example.study;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test Endpoint";
    }

    @GetMapping("/printGetRequestURI")
    public String printGetRequestURI(HttpServletRequest request,
                                     @RequestParam(name = "param1", required = false) String param1,
                                     @RequestParam(name = "param2", required = false) String param2) {
        String getRequestURI = request.getRequestURI();
        System.out.println("GetRequestURI: " + getRequestURI);
        String getServletPath = request.getServletPath();
        System.out.println("GetServletPath: " + getServletPath);

        if (param1 != null) {
            System.out.println("param1: " + param1);
        }

        if (param2 != null) {
            System.out.println("param2: " + param2);
        }

        return "Printed GET Request URI. Check console for details.";
    }
}
