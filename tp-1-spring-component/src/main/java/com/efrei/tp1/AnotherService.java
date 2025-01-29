package com.efrei.tp1;

import org.springframework.stereotype.Component;

@Component
public class AnotherService implements ActionService {
    @Override
    public String performAction(){
        return "Hello World from AnotherService";
    }
}
