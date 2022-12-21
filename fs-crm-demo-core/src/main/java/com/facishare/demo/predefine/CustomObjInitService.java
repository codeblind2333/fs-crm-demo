package com.facishare.demo.predefine;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CustomObjInitService extends ApplicationObjectSupport {

    @PostConstruct
    public void init() {
        CustomObjPreDefineObject.init();
    }

}
