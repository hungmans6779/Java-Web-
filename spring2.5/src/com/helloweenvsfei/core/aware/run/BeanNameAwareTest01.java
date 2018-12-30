package com.helloweenvsfei.core.aware.run;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helloweenvsfei.core.aware.WhatsTheNameBean;

/*
   BeanNameAware ������oBean��id
   BeanNameAware ������ JavaBean ���D�ۤv�b�]�w�ɤ���id�C��{BeanNameAware �����A��{��k�W��setBeanName() ��k�A
        ��l�ƸӪ����Spring �N�|����Ӧ^�ɤ�k�A�Nid�]�w�i�ӡCBean���]�w�@�Ӽg�k�A����id �W�٧Y�i�C
 */
public class BeanNameAwareTest01 {

  /**
   * @param args
  */
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-core.xml");
    WhatsTheNameBean bean = (WhatsTheNameBean)context.getBean("whatsTheNameBean");
    System.out.println(context);
    bean.setBeanName("whatsTheNameBean");
    bean.showBean();
  }
  

}
