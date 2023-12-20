package org.rnt.com;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationContext {
	private static String xmlConfigPath = "classpath:context/context-common.xml";
//	private static GenericXmlApplicationContext ctx = null;
//     
//    static {
//        try {
//        	String xmlConfigPath = "classpath:context/context-common.xml";
//        	ctx = new GenericXmlApplicationContext(xmlConfigPath);
////             System.out.println("Aliases mssqlDataLinkageDao : " + ctx.containsBean("mssqlDataLinkageDao"));
//        }catch(Exception e) {
//            System.out.println("오류 내용: " + e);
//        	e.printStackTrace();
//        }
//    }
//    
//    public static Object getBeanInstance(String beanName) {
//        return ctx.getBean(beanName);// SessionFactory에서 SqlSession 얻어오기
//    }
	
	@SuppressWarnings("resource")
	public static Object getBeanInstance(String beanName) {
		return new GenericXmlApplicationContext(xmlConfigPath).getBean(beanName);
	}
}
