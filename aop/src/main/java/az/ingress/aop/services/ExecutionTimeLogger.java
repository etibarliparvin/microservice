package az.ingress.aop.services;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

@Slf4j
@Aspect
@Component
public class ExecutionTimeLogger {

    @Pointcut(value = "execution(* az.ingress.aop.services.HelloServiceImpl.*(..))")
    private void logExecutionTimePc() {
    }

    @SneakyThrows
    @Around(value = "logExecutionTimePc()")
    public void logExecutionTime(ProceedingJoinPoint jp) {
        long started = System.currentTimeMillis();

        jp.proceed();
        long ended = System.currentTimeMillis();
        log.info("Elapsed time {}", ended - started);
    }

    @SneakyThrows
    @Before(value = "logExecutionTimePc()")
    public void logExecutionTime(JoinPoint jp) {
        Arrays.stream(jp.getArgs()).forEach((arg) -> log.info("arguments are {}", arg));
    }
}
