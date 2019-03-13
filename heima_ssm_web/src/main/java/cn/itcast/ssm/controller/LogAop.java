package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.SysLog;
import cn.itcast.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;
    //开始时间
    private Date visitTime;
    //访问的类
    private Class clz;
    //访问的方法
    private Method method;


    /**
     * 前置通知,获取开始时间,访问的哪个类的哪个方法
     *
     * @param joinPoint
     */
    @Before("execution(* cn.itcast.ssm.controller.*.*(..))")
    public void beBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = new Date();// 获取访问时间
        clz = joinPoint.getTarget().getClass(); //获取当前访问的类
        String methodName = joinPoint.getSignature().getName();//获取当前访问的类的方法名字
        Object[] args = joinPoint.getArgs();//获取当前访问的类的方法的参数
        if (args == null || args.length == 0) {
            method = clz.getMethod(methodName);
        } else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            method = clz.getMethod(methodName, classes);
        }
    }

    /**
     * 后置通知
     *
     * @param joinPoint
     */
    @After("execution(* cn.itcast.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) {
        long time = new Date().getTime() - visitTime.getTime(); // 获取访问时长
        //获取访问的url
        String url = "";
        if (clz != null && method != null && clz != LogAop.class && clz != SysLogController.class) {
            RequestMapping classAnnotation = (RequestMapping) clz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];


                    //获取访问的IP地址
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户,可以通过securityContext获取，也可以从request.getSession中获取
                    SecurityContext context = SecurityContextHolder.getContext();
                    //也可以当前获取操作的用户名
                    //String username = context.getAuthentication().getName();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    SysLog sysLog = new SysLog();
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setMethod("类名:" + clz.getName() + ",方法名:" + method.getName());


                    sysLogService.save(sysLog);

                }
            }
        }


    }
}
