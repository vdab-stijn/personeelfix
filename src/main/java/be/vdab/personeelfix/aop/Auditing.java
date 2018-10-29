package be.vdab.personeelfix.aop;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Auditing {

	private static final Logger LOGGER
	= LoggerFactory.getLogger(Auditing.class);
	
	@AfterReturning(
			pointcut = "be.vdab.personeelfix.aop.PointcutExpressions.everything()",
			returning = "returnValue")
	public void writeAudit(
			final JoinPoint joinPoint, final Object returnValue) {
		final StringBuilder builder
		= new StringBuilder("\nTIME\t").append(LocalDateTime.now());
		
		/*
		final Authentication authentication
		= SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication != null)
			builder.append("\nUSER\t").append(authentication.getName());
		*/
		
		builder.append("\nMETHOD\t")
			.append(joinPoint.getSignature().toLongString());
		
		Arrays.stream(joinPoint.getArgs())
			.forEach(object -> builder.append("\nPARAM\t").append(object));
		
		if (returnValue != null) {
			builder.append("\nRETURN\t");
			
			if (returnValue instanceof Collection) {
				final Collection<?> collection = (Collection<?>)returnValue;
				
				builder.append(collection.size()).append(
						" object" + (collection.size() != 1 ? "s" : "") + " (");
				
				final Set<String> classes = new HashSet<>();
				collection.stream()
					.distinct()
					.forEach(c -> classes.add(c.getClass().getSimpleName()));
				
				builder.append(String.join(", ", classes)).append(")");
			}
			else
				builder.append(returnValue.toString());
		}
		
		LOGGER.info(builder.toString());
	}
}
