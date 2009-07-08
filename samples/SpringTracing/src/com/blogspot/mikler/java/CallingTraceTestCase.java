package com.blogspot.mikler.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Mikler
 */
public class CallingTraceTestCase {
    private void initContext(){
         ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{
            "beans/com/blogspot/mikler/java/TraceSample.xml"
        });
        Bean1 bean1 = (Bean1) context.getBean("bean1");
        bean1.entryPoint();
    }

    public static void main(String[] args) {
        new CallingTraceTestCase().initContext();
    }
}
