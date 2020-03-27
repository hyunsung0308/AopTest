package com.bit.exam01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ProfilingAdvice {
	
	public void afterThrowing(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().toShortString();
		System.out.println(methodName+"가 비정상적으로 되었습니다.");
	}
	
	public void afterReturning(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().toShortString();
		System.out.println(methodName+"가 정상완료 되었습니다.");
	}
	
	/*
	public void before() {
		System.out.println("타깃이 되는 메소드 실행하기 전입니다.");
	}
	*/
	public void after(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().toShortString();
		System.out.println(methodName+"가 완료후입니다.");
	}
	
	/*
	public void before(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().toShortString();
		System.out.println("타깃이 되는 메소드 실행하기 전입니다.");
	}
	*/
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object re = null;
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"시작");
		long start = System.currentTimeMillis();
		try {
			re = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(methodName+"종료");
		long finish = System.currentTimeMillis();
		System.out.println("걸린시간:" + (finish-start));
		return re;
	}
}
