package com.facishare.demo.predefine.service;

import com.facishare.demo.predefine.CustomObjPreDefineObject;
import com.facishare.paas.appframework.core.annotation.ServiceMethod;
import com.facishare.paas.appframework.core.annotation.ServiceModule;
import org.springframework.stereotype.Component;

@Component
@ServiceModule("account")
public class AccountService {

    @ServiceMethod("getAccountInfo")
    public CustomObjPreDefineObject getAccountInfo(){
        return CustomObjPreDefineObject.Account;
    }

}
