package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarApi {
    @Autowired
    MailHandlerBase mailHandlerBase;


    @Autowired
    Car car;
     @GetMapping("car")
    public Car getCar(){

         mailHandlerBase.sendMail();
          return car;
    }

}
