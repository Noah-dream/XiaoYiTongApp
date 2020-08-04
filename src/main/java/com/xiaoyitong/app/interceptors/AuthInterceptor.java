package com.xiaoyitong.app.interceptors;

import com.auth0.jwt.interfaces.Claim;
import com.xiaoyitong.app.utils.JwtUtil;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Method $
 * @Author $
 * @Version 1.0
 * @Description $
 * @Return $
 * @Exception $
 * @Date $ $
 */
public class AuthInterceptor implements HandlerInterceptor {
    private static Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("token");
        if(token.isEmpty()){
            Map<String, Claim> claimMap = JwtUtil.verifyToken(token);
            if(claimMap!=null){
                return true;
            }else{
                response.sendRedirect(request.getContextPath()+"/app/loginById");
                return false;
            }
        }else {
            return false;
        }
    }

}
