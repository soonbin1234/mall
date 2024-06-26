package com.himedia.shopping;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class ErrorHandler implements ErrorController {

//     @Override
//     public String getErrorPath() {
//         return null;
//     }
    
    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        // error로 들어온 에러의 status를 불러온다 (ex:404,500,403...)
        
        if(status != null){
            int statusCode = Integer.valueOf(status.toString());
            
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
            	System.out.println("1");
                return "404";
            } else {
            	System.out.println("2");
                return "error";
            }
        }
        System.out.println("3");
        return "error";
    }
}
