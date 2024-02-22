package com.doufu.framework.config.properties;

import com.doufu.common.annotation.Anonymous;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RegExUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 设置Anonymous注解允许匿名访问的url
 *
 * @author doufu
 */
@Configuration
public class PermitAllUrlProperties implements InitializingBean, ApplicationContextAware {
    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");
    public String ASTERISK = "*";
    private ApplicationContext applicationContext;
    @Getter
    @Setter
    private List<String> urls = new ArrayList<>();

    @Override
    public void afterPropertiesSet() {
        RequestMappingHandlerMapping mapping = applicationContext.getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

        map.keySet().forEach(info -> {
            HandlerMethod handlerMethod = map.get(info);

            // 获取方法上边的注解 替代path variable 为 *
            Anonymous method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Anonymous.class);
            Optional.ofNullable(method).ifPresent(
                    anonymous -> {
                        PathPatternsRequestCondition pathPatternsCondition = info.getPathPatternsCondition();
                        if (pathPatternsCondition != null) {
                            Objects.requireNonNull(pathPatternsCondition.getPatterns())
                                    .forEach(url -> urls.add(RegExUtils.replaceAll(url.getPatternString(), PATTERN, ASTERISK)));
                        }
                    }
            );

            // 获取类上边的注解, 替代path variable 为 *
            Anonymous controller = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), Anonymous.class);
            Optional.ofNullable(controller).ifPresent(
                    anonymous -> {
                        PathPatternsRequestCondition pathPatternsCondition = info.getPathPatternsCondition();
                        if (pathPatternsCondition != null) {
                            Objects.requireNonNull(pathPatternsCondition.getPatterns())
                                    .forEach(url -> urls.add(RegExUtils.replaceAll(url.getPatternString(), PATTERN, ASTERISK)));
                        }
                    }
            );
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }
}
