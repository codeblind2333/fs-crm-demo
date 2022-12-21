package com.facishare.demo.web.config;
 
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
 
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
 
 
public class WebApplicationInitializerConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(ResteasyBootstrap.class);
 
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
 
        servletContext.setInitParameter("resteasy.servlet.mapping.prefix", "/API");
 
 
        ServletRegistration.Dynamic resteasy = servletContext.addServlet("resteasy-dispatcher", new HttpServletDispatcher());
        resteasy.setLoadOnStartup(1);
        resteasy.addMapping("/API/*");
 
        servletContext.addListener(new ResteasyContextLoaderListener(context));
 
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");
 
 
    }
}