package net.lkrnac.blog.testing.mockbeanv2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//@Aspect
@Component
@Slf4j
public class AddressLogger {
	//@Before("execution(* *(..))")
	public void logAddressCall(JoinPoint jp){
		log.info("Executing method {} on bean {}", jp.getSignature(), jp.getThis());
	}
}
