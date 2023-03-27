package proxy;

import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import proxy.remote.*;

public class Application {

	public static void main(String[] args) {

		try {
			// This fragment creates a proxy for a MyInterface object.
			// We take advantage of Java here 
			MyInterface myintf = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),
					new Class[] { MyInterface.class }, new ProxyClass(new MyInterfaceImpl()));

			// Invoke the method
			String out = myintf.method();
			System.out.println("Appl: " + out);

			// Invoke the method with param
			out = myintf.method("Allowed");
			System.out.println("Appl: " + out);


			// Invoke the method with forbidden param
			out = myintf.method("secretForbidden");
			System.out.println("Appl: " + out);

		} catch (UndeclaredThrowableException e) {
			System.out.println("Appl: Undeclared Error: " + e.getCause().getMessage());
		} catch (Exception e) {
			System.out.println("Appl: Error: " + e.getMessage());
		}
	}
}
