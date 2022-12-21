package com.facishare.demo.predefine.action;

import com.alibaba.fastjson.annotation.JSONField;
import com.facishare.paas.appframework.core.model.PreDefineAction;
import com.facishare.paas.metadata.impl.ObjectData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class AccountAddAction extends PreDefineAction<AccountAddAction.Arg, AccountAddAction.Result> {
    public AccountAddAction() {
        this.argClass = Arg.class;
    }

    @Override
    protected List<String> getFuncPrivilegeCodes() {
        return null;
    }

    @Override
    protected List<String> getDataPrivilegeIds(Arg arg) {
        return null;
    }

    @Data
    public static class Arg {
        @JSONField(name = "M1")
        String object_data; //数据格式向前兼容

        public ObjectData getObjectData() {
            ObjectData objectData = new ObjectData();
            objectData.fromJsonString(object_data);
            return objectData;
        }
    }

    @Override
    protected Result doAct(Arg arg) {
        //进行自身定制化的业务逻辑
        String message = AccountAddAction.class.getName();
        log.debug("A Custom Action: {}", message);
        return new Result("custom action: " + message);
//        return null;
    }

    @Override
    protected void before(Arg arg) {
        //走父类的通用逻辑
        super.before(arg);
    }

    @Override
    protected Result after(Arg arg, Result result) {
        //走父类的通用逻辑
        return super.after(arg, result);
    }

    @Data
    @Builder
    public static class Result {
        @JSONField(name = "M3")
        Object objectData;
    }
}