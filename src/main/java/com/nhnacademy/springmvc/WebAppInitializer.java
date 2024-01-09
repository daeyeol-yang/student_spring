package com.nhnacademy.springmvc;

import com.nhnacademy.springmvc.config.RootConfig;
import com.nhnacademy.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings(){ return  new String[] {"/"};}

    @Override
    protected Class<?>[] getRootConfigClasses(){ return new Class[] {RootConfig.class};}

    @Override
    protected Class<?>[] getServletConfigClasses(){ return new Class[] {WebConfig.class};}
}
