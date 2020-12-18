package net.hunau.goodsmanager.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 保存网页信息工具类
 * 可以保存cookies和session信息
 */
public class SaveInfoUtils {
    public static void saveCookies(HttpServletResponse response,String cookieName,String cookieValue){
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
    }

    public static void saveCookiesByTime(HttpServletResponse response,String cookieName,String cookieValue,int time){
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(time);
        response.addCookie(cookie);
    }

    public static Cookie findCookie(HttpServletRequest request,String cookieName){
        Cookie TargetCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName))
                    TargetCookie = cookie;
            }
        }
        return TargetCookie;
    }

    public static void saveSession(HttpServletRequest request,String SessionName,Object SessionValue){
        HttpSession session = request.getSession();
        synchronized(session) {
            session.setAttribute(SessionName, SessionValue);
        }
    }

    public static Object getSession(HttpServletRequest request,String SessionName){
        HttpSession session = request.getSession();
        Object value = session.getAttribute(SessionName);
        return value;
    }
}
