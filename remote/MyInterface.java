package proxy.remote;

import proxy.ForbiddenException;

public interface MyInterface {

	String method();

	String method(String parameter) throws ForbiddenException;
}
