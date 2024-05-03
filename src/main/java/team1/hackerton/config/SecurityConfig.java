package team1.hackerton.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import team1.hackerton.security.CustomUserDetailService;
import team1.hackerton.security.JwtAuthFilter;
import team1.hackerton.security.JwtUtil;


    @Configuration
    @EnableWebSecurity
    @RequiredArgsConstructor
    @EnableMethodSecurity(securedEnabled = true)
    public class SecurityConfig {

        private final CustomUserDetailService customUserDetailService;
        private final JwtUtil jwtUtil;

        private static final String[] AUTH_WHITELIST = {
                "/auth/**",
                "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**",
        };

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
            // CSRF, CORS
            http.csrf(AbstractHttpConfigurer::disable); // CSRF 토큰 사용 X -> disable 설정
            http.cors(Customizer.withDefaults()); // 다른 도메인의 웹 페이지에서 리소스에 접근할 수 있도록 허용

            // 세션 관리 상태 없음으로 구성, SpringSecurity가 세션 생성
            http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS));
            // FormLogin, BasicHttp 비활성화
            http.formLogin(AbstractHttpConfigurer::disable);
            http.httpBasic(AbstractHttpConfigurer::disable);

            // JwtAuthFilter를 먼저 거치고
            http.addFilterBefore(new JwtAuthFilter(jwtUtil, customUserDetailService), UsernamePasswordAuthenticationFilter.class);

            // 권한 규칙 생성
            http.authorizeHttpRequests(authorize -> authorize
                            .requestMatchers(AUTH_WHITELIST).permitAll() // 로그인 없이 접근이 가능한 api
                            .requestMatchers("/api/v1/member/**").hasRole("USER")
                            .anyRequest().permitAll()
                    /**
                     * 권한 규칙 요구사항
                     * SUPER 모든 API에 접근 허용
                     * BE는 읽기조회 + 수정 API까지 접근 허용
                     * FE는 읽기 조회 API만 */
            );

            return http.build();
        }

}
