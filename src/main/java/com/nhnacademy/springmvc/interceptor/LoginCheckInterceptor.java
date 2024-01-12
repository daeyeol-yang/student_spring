package com.nhnacademy.springmvc.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("SESSION".equals(cookie.getName())) {
                    String sessionId = cookie.getValue();

                     if(isValidSession(sessionId)){
                         return true;
                     }else {
                         response.sendRedirect("/login");
                     }
                }



            }


        }
        response.sendRedirect("/login");
        return false;
    }



    private static boolean isValidSession(String sessionId) {
        // 실제 프로젝트에서는 세션을 관리하는 방법에 따라 세션의 유효 여부를 확인해야 합니다.
        // 여기서는 세션 ID가 비어 있지 않으면 유효한 세션이라고 간주합니다.
        return sessionId != null && !sessionId.isEmpty();
    }
}
