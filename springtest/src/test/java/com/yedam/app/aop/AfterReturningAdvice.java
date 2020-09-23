package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAdvice {
	
	@Pointcut("execution(* com.yedam.app..*Impl.select*(..))")
	public void selectPointcut() {}
	
	
	//@AfterReturning(value = "execution(* com.test.controller.TestController.*(..))", returning = "returnValue")
	//pointcut method 없애고 위와 같은 형식으로도 쓸수 있네
	
	//@AfterReturning(pointcut= "selectPointcut()", returning = "returnObj")
	@AfterReturning(pointcut= "LogAdvice.allpointcut()", returning = "returnObj")
	//다른클래스에 있는 포인트컷 사용방법
	public void afterLog(JoinPoint jp, Object returnObj){
		String method = jp.getSignature().getName();
		String result = returnObj != null ? returnObj.toString() : "";
		System.out.println("[사후처리] 로직 수행 후 동작" +
		                    method + " : " + 
		                    result );
	}
}
