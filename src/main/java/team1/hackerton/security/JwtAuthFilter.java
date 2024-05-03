package team1.hackerton.security;


import io.jsonwebtoken.JwtException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthFilter extends GenericFilter {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailService customUserDetailService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try{
            String requestURI = ((HttpServletRequest) request).getRequestURI(); // 스웨거, 로그인 페이지만 토큰없이 접근
            if(requestURI.contains("/auth/sign-up")
                    || requestURI.contains("/auth/login")
                    || requestURI.contains("/swagger-ui/")
                    || requestURI.contains("/v3/api-docs")
                    || requestURI.contains("/swagger-resources")
                    || requestURI.equals("/swagger-ui.html"))
            {
                chain.doFilter(request,response);
                return;
            }

            // 토큰 추출
            String token = jwtUtil.resolveToken((HttpServletRequest) request);

            // 토큰 유효성 검증
            if(jwtUtil.validateToken(token)){
                Long memberId = jwtUtil.getUserId(token);
                CustomUserDetails userDetails = customUserDetailService.loadUserByUsername(memberId.toString());
                if(userDetails != null){
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    // 현재 Request의 Security Context에 접근권한 설정
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }

            }
            chain.doFilter(request,response);
        } catch (JwtException e){

        }
    }

}
