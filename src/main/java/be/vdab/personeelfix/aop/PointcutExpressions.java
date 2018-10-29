package be.vdab.personeelfix.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressions {

	@Pointcut("execution(* be.vdab.personeelfix.services.*.*(..))")
	public void services() {}
	
	@Pointcut("execution(* be.vdab.personeelfix.web.*.*(..))")
	public void web() {}
	
	@Pointcut("execution(* be.vdab.personeelfix.converters.*.*(..))")
	public void conversions() {}
	
	@Pointcut("execution(* be.vdab.personeelfix.constraints.*.*(..))")
	public void constraints() {}
	
	@Pointcut("execution(* be.vdab.personeelfix.services.*.*(..)) || " +
				"execution(* be.vdab.personeelfix.web.*.*(..)) || " +
				"execution(* be.vdab.personeelfix.converters.*.*(..))" +
				"execution(* be.vdab.personeelfix.constraints.*.*(..))")
	public void everything() {}
}
