package com.bit.exam01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ProfilingAdvice {
	
	public void afterThrowing(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().toShortString();
		System.out.println(methodName+"�� ������������ �Ǿ����ϴ�.");
	}
	
	public void afterReturning(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().toShortString();
		System.out.println(methodName+"�� ����Ϸ� �Ǿ����ϴ�.");
	}
	
	/*
	public void before() {
		System.out.println("Ÿ���� �Ǵ� �޼ҵ� �����ϱ� ���Դϴ�.");
	}
	*/
	public void after(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().toShortString();
		System.out.println(methodName+"�� �Ϸ����Դϴ�.");
	}
	
	/*
	public void before(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().toShortString();
		System.out.println("Ÿ���� �Ǵ� �޼ҵ� �����ϱ� ���Դϴ�.");
	}
	*/
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object re = null;
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"����");
		long start = System.currentTimeMillis();
		try {
			re = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(methodName+"����");
		long finish = System.currentTimeMillis();
		System.out.println("�ɸ��ð�:" + (finish-start));
		return re;
	}
}
