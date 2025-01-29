package com.efrei.tp1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyServiceConsumer {

    private ActionService myService;

    public MyServiceConsumer(@Qualifier("anotherService")ActionService myService){
        this.myService = myService;
    }

    public void useService(){
        System.out.println(myService.performAction());
    }
}
