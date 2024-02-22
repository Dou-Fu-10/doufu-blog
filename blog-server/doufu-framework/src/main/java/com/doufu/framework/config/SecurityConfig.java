package com.doufu.framework.config;

import com.doufu.framework.config.properties.PermitAllUrlProperties;
import com.doufu.framework.security.filter.JwtAuthenticationTokenFilter;
import com.doufu.framework.security.handle.AuthenticationEntryPointImpl;
import com.doufu.framework.security.handle.LogoutSuccessHandlerImpl;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;

/**
 * spring security配置
 *
 * @author doufu
 */
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@EnableMethodSecurity
public class SecurityConfig {
    /**
     * 自定义用户认证逻辑
     */
    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 认证失败处理类
     */
    @Resource
    private AuthenticationEntryPointImpl unauthorizedHandler;

    /**
     * 退出处理类
     */
    @Resource
    private LogoutSuccessHandlerImpl logoutSuccessHandler;

    /**
     * token认证过滤器
     */
    @Resource
    private JwtAuthenticationTokenFilter authenticationTokenFilter;

    /**
     * 跨域过滤器
     */
    @Resource
    private CorsFilter corsFilter;

    /**
     * 允许匿名访问的地址
     */
    @Resource
    private PermitAllUrlProperties permitAllUrl;


    /**
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // 身份认证接口
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());

        httpSecurity
                // 禁用 CSRF
                .csrf(csrfCustomizer())
                // 授权Http请求定制器
                .authorizeHttpRequests(authorizeHttpRequestsCustomizer())
                // 添加Logout filter
                .logout(logoutCustomizer())
                // 认证失败处理类
                .exceptionHandling(exceptionHandlingCustomizer())
                // 会话管理定制器
                .sessionManagement(sessionManagementCustomizer())
                .authenticationManager(authenticationManagerBuilder.build())
                // 防止 iframe 造成跨域
                .headers(headersCustomizer())
                // 添加JWT filter
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 添加CORS filter
                .addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class)
                .addFilterBefore(corsFilter, LogoutFilter.class);
        return httpSecurity.build();
    }

    /**
     * 强散列哈希加密实现
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private Customizer<SessionManagementConfigurer<HttpSecurity>> sessionManagementCustomizer() {
        // 在这里进行会话管理的自定义配置
        return (sessionManagement) -> {
            // 添加自定义的会话管理配置
            sessionManagement
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 设置会话创建策略为无状态
//                    .maximumSessions(1) // 设置最大允许的会话数为1
//                    .maxSessionsPreventsLogin(true); // 设置超过最大会话数时阻止登录
            ;
        };
    }

    private Customizer<HeadersConfigurer<HttpSecurity>.FrameOptionsConfig> frameOptionsCustomizer() {
        // 在这里进行X-Frame-Options的自定义配置
        // 添加自定义的X-Frame-Options配置
        // 设置X-Frame-Options为SAMEORIGIN
        return HeadersConfigurer.FrameOptionsConfig::disable;
    }

    private Customizer<HeadersConfigurer<HttpSecurity>.CacheControlConfig> cacheControlCustomizer() {
        // 禁用HTTP响应标头
        return HeadersConfigurer.CacheControlConfig::disable;
    }

    private Customizer<HeadersConfigurer<HttpSecurity>> headersCustomizer() {
        return (headers) -> {
            // 配置其他的响应头选项
            headers.frameOptions(frameOptionsCustomizer())
                    .cacheControl(cacheControlCustomizer());
        };
    }

    private Customizer<ExceptionHandlingConfigurer<HttpSecurity>> exceptionHandlingCustomizer() {
        // 在这里进行异常处理的自定义配置
        return (exceptionHandling) -> {
            // 添加自定义的异常处理配置
            exceptionHandling.authenticationEntryPoint(unauthorizedHandler); // 身份验证入口点
        };
    }

    private Customizer<LogoutConfigurer<HttpSecurity>> logoutCustomizer() {
        return (logout) -> {
            // 添加自定义的请求授权配置
            logout
                    .logoutUrl("/logout")
                    .logoutSuccessHandler(logoutSuccessHandler);
        };
    }

    private Customizer<CsrfConfigurer<HttpSecurity>> csrfCustomizer() {
        // 在这里进行CSRF相关的自定义配置
        // 添加自定义的CSRF配置
        // 禁用CSRF保护
        return AbstractHttpConfigurer::disable;
    }

    private Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> authorizeHttpRequestsCustomizer() {
        String[] array = permitAllUrl.getUrls().toArray(new String[0]);
        // 在这里进行请求授权的自定义配置
        return (authorizeRequests) -> {
            // 添加自定义的请求授权配置
            authorizeRequests
                    // 静态资源等等
                    .requestMatchers(
                            HttpMethod.GET,
                            "/",
                            "/*.html",
                            "/*/*.html",
                            "/*/*.css",
                            "/*/*.css",
                            "/*/*.js",
                            "/webSocket/**",
                            "/profile/**"
                    ).permitAll()
                    // swagger 文档
                    .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                    // 对于登录login 注册register 验证码captchaImage 允许匿名访问
                    .requestMatchers("/login",
                            "/register",
                            "/captchaImage",
                            "/druid/**").permitAll()
                    // 所有类型的接口都放行
                    .requestMatchers(array).permitAll()
                    // 所有请求都需要认证
                    .anyRequest().authenticated(); // 其他所有路径禁止访问
        };
    }
}
