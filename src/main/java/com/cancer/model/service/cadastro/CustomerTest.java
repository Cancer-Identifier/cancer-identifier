package com.cancer.model.service.cadastro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerTest {
 
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.cancer.model.service.cadastro");
        appContext.refresh();
 
        BairroService bairroService = (BairroService) appContext.getBean("bairroService");
        bairroService.test();
 
        appContext.close();
    }
 
}
