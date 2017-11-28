package com.joyowo.mytest.config;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * User: chenby
 * Date: 2017-11-08
 */
@Component
@Aspect
public class ControllerAspect {

    @Pointcut("execution(* com.joyowo.mytest.controller..*.*(..))")
    public void execution1() {}

    @Before("execution1()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("我是前置通知!!!");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        System.out.println(signature.getName());
        //AOP代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String str = JSON.toJSONString(parameterMap);
        if(obj.length > 0) {
            System.out.println("请求的参数信息为："+str);
        }
    }

    @AfterReturning(value = "execution1()",returning = "keys")
    public void doAfterReturning(JoinPoint joinPoint, Object keys) {
        System.out.println(keys);
    }

    @AfterThrowing(value = "execution1()",throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println(joinPoint.getSignature().getName());
        if (exception instanceof NullPointerException) {
            System.out.println("发生了空指针异常!!!!!");
        }
    }

    @Around(value = "execution(* com.joyowo.mytest.controller..*.doAround(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        System.out.println("I am a Around");
        try {
            Long start = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            Long end = System.currentTimeMillis();
            System.out.println(end-start);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}
