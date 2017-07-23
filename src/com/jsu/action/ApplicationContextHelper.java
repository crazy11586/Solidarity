package com.jsu.action;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHelper  implements ApplicationContextAware
{
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException
    {
        this.applicationContext = applicationContext;
        System.out.println("OK");

    	System.out.println("load"+System.currentTimeMillis());
    }

    public void test()
    {
        // ʹ��ApplicationContext ��ʵ����������������,^_^
        // �緢���¼���:applicationContext.publishEvent(event);
    }
    
    public static Object getBean(String beanName) {  
    	
        return applicationContext.getBean(beanName);  
    }  
}
