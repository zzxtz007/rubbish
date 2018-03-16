package com.keji.washer.common.aspect;

import com.google.gson.Gson;
import com.keji.washer.common.annotation.NeedRole;
import com.keji.washer.common.enumeration.UserRoleEnum;
import com.keji.washer.common.utils.AppContextUtils;
import com.keji.washer.common.utils.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Session 切面
 *
 * @author XLY
 * @author Brendan Lee
 */
@Aspect
@Component
public class SessionAspect {
    private static final Gson GSON = new Gson();
    private static final String UID_FIELD_NAME = "uid";

    /**
     * session 拥有的参数名列表
     */
    private static final String[] SESSION_ATTR_ARR = {"uid", "role"};

    /**
     * 水印过期时间
     * <p>
     * 4 分钟内有效
     */
    private static final int WATERMARK_EXPIRE_TIME = 4 * 60;

    /**
     * 检查用户是否已登录
     * <p>
     * 已登录时进入方法，未登录时直接返回
     *
     * @param joinPoint 连接点
     * @return 未登录时返回状态码 2，已登录时返回连接点方法的返回值
     * @throws Throwable 发生异常时抛出
     */
    @Around("@annotation(com.keji.washer.common.annotation.NeedLogin)")
    private Object aspect001checkLogin(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取 session
        HttpSession session = AppContextUtils.getSession();

        // 检查 session 中是否含有 UID，不含说明未登录，直接返回
        if (session.getAttribute(UID_FIELD_NAME) == null) {
            return GSON.toJson(new Response(2));
        }

        // 已登录时正常执行
        return joinPoint.proceed();
    }

    /**
     * 检查用户的角色是否合法
     * <p>
     * 登录用户的角色合法时正常执行方法，非法时直接返回
     *
     * @param joinPoint 连接点
     * @return 角色合法时返回连接点方法的返回值，非法时返回状态码 3
     * @throws Throwable 发生异常时抛出
     */
    @Around("@annotation(com.keji.washer.common.annotation.NeedRole)")
    public Object aspect002checkRole(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取当前登录用户的角色
        HttpSession session = AppContextUtils.getSession();
        UserRoleEnum role = (UserRoleEnum) session.getAttribute("role");

        // 获取方法需求的角色列表
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        UserRoleEnum[] neededRoleArr = signature.getMethod().getAnnotation(NeedRole.class).value();

        // 遍历所需的角色，如果登录用户的角色符合要求，则正常执行方法
        for (UserRoleEnum neededRole : neededRoleArr) {
            if (neededRole.equals(role)) {
                return joinPoint.proceed();
            }
        }

        // 角色非法，返回状态码 3
        return GSON.toJson(new Response(3));
    }



    /**
     * 从 session 中解析用户信息、并赋给相应的参数
     * <p>
     * 参数的匹配通过参数变量名进行
     *
     * @param joinPoint 连接点
     * @return 连接点方法的返回值
     * @throws Throwable 发生异常时抛出
     */
    @Around("@annotation(com.keji.washer.common.annotation.GetUserInfo)")
    public Object aspect003parseSession(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取连接点参数变量名列表
        LocalVariableTableParameterNameDiscoverer pnd = new
                LocalVariableTableParameterNameDiscoverer();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String[] paramNames = pnd.getParameterNames(method);

        // 获取 session
        HttpSession session = AppContextUtils.getSession();

        // 遍历变量名列表，为变量名匹配的参数赋值
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < paramNames.length; i++) {
            String paramName = paramNames[i];

            for (String attr : SESSION_ATTR_ARR) {
                if (attr.equals(paramName)) {
                    args[i] = session.getAttribute(attr);
                }
            }
        }

        // 使用赋值后的参数执行连接点方法
        return joinPoint.proceed(args);
    }
}
