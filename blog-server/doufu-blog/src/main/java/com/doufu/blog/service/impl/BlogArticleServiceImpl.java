package com.doufu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doufu.blog.domain.dto.BlogArticleDTO;
import com.doufu.blog.domain.entity.BlogArticleEntity;
import com.doufu.blog.mapper.BlogArticleMapper;
import com.doufu.blog.service.BlogArticleService;
import com.doufu.common.utils.bean.BeanCopy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (BlogArticle)表服务实现类
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description (BlogArticle)表服务实现类
 */
@Service("blogArticleService")
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticleEntity> implements BlogArticleService {

    /**
     * 分页查询所有数据
     *
     * @param blogArticleDto 查询实体
     * @return 所有数据
     */
    @Override
    public List<BlogArticleEntity> list(BlogArticleDTO blogArticleDto) {
        BlogArticleEntity blogArticleEntity = BeanCopy.convert(blogArticleDto, BlogArticleEntity.class);
        return list(new QueryWrapper<>(blogArticleEntity));
    }

    @Override
    public Boolean save(BlogArticleDTO blogArticleDto) {
        BlogArticleEntity blogArticleEntity = BeanCopy.convert(blogArticleDto, BlogArticleEntity.class);
        return save(blogArticleEntity);
    }

    @Override
    public Boolean updateById(BlogArticleDTO blogArticleDto) {
        BlogArticleEntity blogArticleEntity = BeanCopy.convert(blogArticleDto, BlogArticleEntity.class);
        return updateById(blogArticleEntity);
    }
}

