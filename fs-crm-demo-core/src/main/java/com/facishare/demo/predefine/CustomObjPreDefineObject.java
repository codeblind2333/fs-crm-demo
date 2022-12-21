package com.facishare.demo.predefine;

import com.facishare.paas.appframework.core.model.ActionClassInfo;
import com.facishare.paas.appframework.core.model.ControllerClassInfo;
import com.facishare.paas.appframework.core.model.PreDefineObject;
import com.facishare.paas.appframework.core.model.PreDefineObjectRegistry;

import java.util.Arrays;
import java.util.List;

public enum CustomObjPreDefineObject implements PreDefineObject {
 
    Account("AccountObj");   //客户

    private static String PACKAGE_NAME = CustomObjPreDefineObject.class.getPackage().getName();
    private String apiName;
 
    CustomObjPreDefineObject(String apiName) {
        this.apiName = apiName;
    }
 
    public static CustomObjPreDefineObject getEnum(String apiName) {
        List<CustomObjPreDefineObject> list = Arrays.asList(CustomObjPreDefineObject.values());
        return list.stream().filter(m -> m.getApiName().equalsIgnoreCase(apiName)).findAny().orElse(null);
    }
 
    public static void init() {
        for (CustomObjPreDefineObject object : CustomObjPreDefineObject.values()) {
            PreDefineObjectRegistry.register(object);
        }
    }
 
    @Override
    public String getApiName() {
        return apiName;
    }
 
    @Override
    public ActionClassInfo getDefaultActionClassInfo(String actionCode) {
        String className = PACKAGE_NAME + ".action." + this + actionCode + "Action";
        return new ActionClassInfo(className);
    }
 
    @Override
    public ControllerClassInfo getControllerClassInfo(String methodName) {
        String className = PACKAGE_NAME + ".controller." + this + methodName + "Controller";
        return new ControllerClassInfo(className);
    }
 
    @Override
    public String getPackageName() {
        return PACKAGE_NAME;
    }
}