package com.blogspot.mikler.java;

import org.apache.log4j.Logger;

public class Bean1 {

    Logger logger = Logger.getLogger(Bean1.class);

    Bean2 bean2;

    public void entryPoint(){
        bean2.importantMethod();
        bean2.doSomethingQuick("a job");
        logger.info("All jobs done");
    }

    public void setBean2(Bean2 bean2) {
        this.bean2 = bean2;
    }

}
