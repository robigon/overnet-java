package it.clever.spring.ui;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Application {

	public static void main(String[] args) {
		
		AbstractApplicationContext  context = null;
		try {

			context = new ClassPathXmlApplicationContext(
					"/spring/application-context.xml");
			
			Bean2 bean2 = (Bean2) context.getBean("bean2");
			bean2.method1();
			
			Class2 c2 = (Class2)context.getBean("class2");
			c2.faiQualcosa();
			
			Class2 c2New = (Class2)context.getBean("class2");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// Spegnimento controllato del contesto;
			if(context != null)
				context.registerShutdownHook();
			
			System.exit(0);
		}
		
	}
}
