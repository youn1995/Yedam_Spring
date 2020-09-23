package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //aspect로 등록
@Component //빈등록
public class LogAdvice {

	@Pointcut("execution(*  com.yedam.app..*Impl.*(..))") //pointcut의 id가 메소드명으로 오면됨
	public void allpointcut() {}
	
	@Before("allpointcut()") //어느시점에 할건지와 무슨 포인트컷 메소드명
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[공통 로그] 로직 수행 전 "+
							method +  " : " + 
			((args != null && args.length>0) ? args[0] : "") );
		System.out.println(jp.toLongString());
		System.out.println(jp.toShortString());
	}
}
