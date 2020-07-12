package com.ps.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class CommonDynaPtc extends DynamicMethodMatcherPointcut {
	private String methodName;
	private Class clazz;
	private float rangeAmt;

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public void setRangeAmt(float rangeAmt) {
		this.rangeAmt = rangeAmt;
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		if(method.getName().equalsIgnoreCase(methodName) && targetClass==clazz && (Float)args[0]>rangeAmt)
			return true;
		else
			return false;
	}

}
