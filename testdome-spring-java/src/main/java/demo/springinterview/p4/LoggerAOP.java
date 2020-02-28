package demo.springinterview.p4;
/*
- Add appropriate annotation, so that Spring will inject an instance of Logger in the logger field.
- Using Spring AOP, intercept all calls to the public methods annotated with LogExecution annotation,
  and call log method on the logger field with the intercepted method's name as the data argument.
 */

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.*;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

@Component
@Aspect
public class LoggerAOP {
    @Autowired
    private Logger logger;

    @Around("@annotation(LogExecution))")
    public Object logProcess(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        if (Modifier.isPublic(method.getModifiers())) {
            logger.log(method.getName());
        }

        return pjp.proceed();
    }
}

@Component
class NameRepository {
    @LogExecution
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        return names;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecution {}

interface Logger {
    public void log(String data);
}

@Configuration
@EnableAspectJAutoProxy
@Import({ LoggerAOP.class, NameRepository.class })
class Config {
    @Bean
    public Logger logger() {
        return (message) -> System.out.println(message);
    }
}