package com.doufu.web.controller.system;

import com.doufu.common.config.DouFuConfig;
import com.doufu.common.utils.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author doufu
 */
@RestController
public class SysIndexController {
    /**
     * 系统基础配置
     */
    @Resource
    private DouFuConfig doufuConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。", doufuConfig.getName(), doufuConfig.getVersion());
    }
}
