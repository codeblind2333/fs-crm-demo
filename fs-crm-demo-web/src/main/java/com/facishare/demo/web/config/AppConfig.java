package com.facishare.demo.web.config;

import com.facishare.paas.appframework.resource.ObjectInnerAPIResource;
import com.facishare.paas.appframework.resource.ObjectResource;
import com.facishare.paas.appframework.resource.ObjectRestAPIResource;
import com.github.autoconf.spring.reloadable.ReloadablePropertyPostProcessor;
import com.github.autoconf.spring.reloadable.ReloadablePropertySourcesPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;

import javax.ws.rs.Path;

/**
 * create by zhaoju on 2021/03/12
 */
@Configuration
@ComponentScan(basePackages = {"com.facishare.demo", "com.facishare.paas.appframework"},
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Path.class))
@ImportResource({"classpath:spring/common.xml", "classpath:spring/metadata.xml", "classpath:spring/log.xml",
        "classpath:spring/flow.xml", "classpath:spring/privilege.xml", "classpath:spring/licence.xml",
        "classpath:spring/fsi.xml", "classpath:spring/payment.xml", "classpath:spring/restdriver.xml",
        "classpath:spring/dubbo.xml", "classpath:spring/config.xml", "classpath:spring/function-service.xml",
        "classpath:spring/idempotent.xml", "classpath:privilege-temp.xml", "classpath:action.xml"})
public class AppConfig {

    @Bean("objectResource")
    public ObjectResource objectResource() {
        return new ObjectResource();
    }

    @Bean("objectInnerAPIResource")
    public ObjectInnerAPIResource objectInnerAPIResource() {
        return new ObjectInnerAPIResource();
    }

    @Bean("objectRestAPIResource")
    public ObjectRestAPIResource objectRestAPIResource() {
        return new ObjectRestAPIResource();
    }

    @Bean("autoConf")
    public ReloadablePropertySourcesPlaceholderConfigurer autoConf() {
        ReloadablePropertySourcesPlaceholderConfigurer autoConf = new ReloadablePropertySourcesPlaceholderConfigurer();
        autoConf.setConfigName("dubbo-common,fs-paas-appframework-rest,fs-metadata,fs-crm-icon-path");
        autoConf.setFileEncoding("UTF-8");
        autoConf.setIgnoreResourceNotFound(true);
        autoConf.setIgnoreUnresolvablePlaceholders(false);
        autoConf.setLocation(new ClassPathResource("application.properties"));
        return autoConf;
    }

    @Bean
    public ReloadablePropertyPostProcessor reloadablePropertyPostProcessor(ReloadablePropertySourcesPlaceholderConfigurer autoConf) {
        return new ReloadablePropertyPostProcessor(autoConf);
    }
}