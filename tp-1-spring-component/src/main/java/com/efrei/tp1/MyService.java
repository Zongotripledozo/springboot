package com.efrei.tp1;

import org.springframework.stereotype.Component;

@Component
public class MyService implements ActionService {
    @Override
    public String performAction(){
        return "je fonctionne bien mon gars";
    }
}
