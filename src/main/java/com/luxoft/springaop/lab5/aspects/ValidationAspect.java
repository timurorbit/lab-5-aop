package com.luxoft.springaop.lab5.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

@Aspect
@Service
public class ValidationAspect {

    @Pointcut("execution(* *.setAge*(int))")
    public void setAge(){ }

    @Around("setAge()")
    public Object setAgeValidator(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        Integer age = (Integer) (thisJoinPoint.getArgs())[0];
        if (age > 100) {
            throw new ValidationException("age is more than 100");
        }
        return thisJoinPoint.proceed();
    }

}
