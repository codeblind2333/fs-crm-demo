package com.facishare.demo.predefine.controller;

import com.facishare.paas.appframework.core.model.AbstractController;
import com.facishare.paas.appframework.core.model.PreDefineController;

import java.util.List;

public class AccountListController extends PreDefineController<AccountListController.AccountArg, AccountListController.AccountResult> {

    @Override
    protected List<String> getFuncPrivilegeCodes() {
        return null;
    }

    @Override
    protected void before(AccountArg arg) {
        //前置自定义处理
        super.before(arg);
    }

    @Override
    protected void pluginBefore(AccountArg accountArg) {

    }

    @Override
    protected void pluginAfter(AccountArg accountArg, AccountResult accountResult) {

    }

    @Override
    protected AccountResult doService(AccountArg arg) {
        //自身业务逻辑
        String message = AccountListController.class.getName();
        log.debug("A Custom Controller: {}", message);
        return new AccountResult();
    }
 
    @Override
    protected AccountResult after(AccountArg arg, AccountResult result) {
        //后置业务逻辑
        return super.after(arg, result);
    }
    //自定义参数扩展
    static class AccountArg {
        private String name;
    }
 
    static class AccountResult {
        private String value;
    }
}