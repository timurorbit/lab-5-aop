package com.luxoft.springaop.lab5.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

@Aspect
@Service
public class ValidationLoggingAspect {

    @AfterThrowing(pointcut = "execution(* *.setAge*(int))", throwing = "exception")
    public void onValidationException(ValidationException exception) {
        System.out.println("Validation Exception occurred!");
    }
}
