package com.doufu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doufu.blog.domain.dto.BlogArticleTagsDTO;
import com.doufu.blog.domain.entity.BlogArticleTagsEntity;
import com.doufu.blog.domain.vo.BlogArticleTagsVo;
import com.doufu.blog.mapper.BlogArticleTagsMapper;
import com.doufu.blog.service.BlogArticleTagsService;
import com.doufu.common.utils.bean.BeanCopy;
import org.springframework.stereotype.Service;

/**
 * (BlogArticleTags)表服务实现类
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description (BlogArticleTags)表服务实现类
 */
@Service("blogArticleTagsService")
public class BlogArticleTagsServiceImpl extends ServiceImpl<BlogArticleTagsMapper, BlogArticleTagsEntity> implements BlogArticleTagsService {
    @Override
    public Boolean save(BlogArticleTagsDTO blogArticleTagsDto) {
        BlogArticleTagsEntity blogArticleTagsEntity = BeanCopy.convert(blogArticleTagsDto, BlogArticleTagsEntity.class);
        return save(blogArticleTagsEntity);
    }

    @Override
    public Boolean updateById(BlogArticleTagsDTO blogArticleTagsDto) {
        BlogArticleTagsEntity blogArticleTagsEntity = BeanCopy.convert(blogArticleTagsDto, BlogArticleTagsEntity.class);
        return updateById(blogArticleTagsEntity);
    }

    @Override
    public Page<BlogArticleTagsVo> page(Page<BlogArticleTagsEntity> page, BlogArticleTagsDTO blogArticleTagsDto) {
        BlogArticleTagsEntity blogArticleTagsEntity = BeanCopy.convert(blogArticleTagsDto, BlogArticleTagsEntity.class);
        LambdaQueryWrapper<BlogArticleTagsEntity> blogArticleTagsEntityLambdaQueryWrapper = new LambdaQueryWrapper<>(blogArticleTagsEntity);
        Page<BlogArticleTagsEntity> blogArticleTagsEntityPage = page(page, blogArticleTagsEntityLambdaQueryWrapper);
        IPage<BlogArticleTagsVo> blogArticleTagsEntityPageVoIpage = blogArticleTagsEntityPage.convert(blogArticleTags -> BeanCopy.convert(blogArticleTags, BlogArticleTagsVo.class));
        return (Page) blogArticleTagsEntityPageVoIpage;
    }
}

