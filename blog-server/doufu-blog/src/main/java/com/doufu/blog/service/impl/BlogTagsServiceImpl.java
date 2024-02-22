package com.doufu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doufu.blog.domain.dto.BlogTagsDTO;
import com.doufu.blog.domain.entity.BlogTagsEntity;
import com.doufu.blog.mapper.BlogTagsMapper;
import com.doufu.blog.service.BlogTagsService;
import com.doufu.common.exception.ServiceException;
import com.doufu.common.exception.WarnException;
import com.doufu.common.utils.StringUtils;
import com.doufu.common.utils.bean.BeanCopy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签(BlogTags)表服务实现类
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description 标签(BlogTags)表服务实现类
 */
@Service("blogTagsService")
public class BlogTagsServiceImpl extends ServiceImpl<BlogTagsMapper, BlogTagsEntity> implements BlogTagsService {
    @Override
    public Boolean save(BlogTagsDTO blogTagsDto) {
        if (!checkTagNameUnique(blogTagsDto.getTagName())) {
            throw new WarnException("新增标签'" + blogTagsDto.getTagName() + "'失败，标签名称已存在");
        }
        BlogTagsEntity blogTagsEntity = BeanCopy.convert(blogTagsDto, BlogTagsEntity.class);
        return save(blogTagsEntity);
    }

    @Override
    public Boolean updateById(BlogTagsDTO blogTagsDto) {
        BlogTagsEntity blogTagsEntity = BeanCopy.convert(blogTagsDto, BlogTagsEntity.class);
        return updateById(blogTagsEntity);
    }

    @Override
    public List<BlogTagsEntity> list(BlogTagsDTO blogTagsDto) {
        BlogTagsEntity blogTagsEntity = BeanCopy.convert(blogTagsDto, BlogTagsEntity.class);
        return list(new QueryWrapper<>(blogTagsEntity));
    }

    /**
     * 校验标签名称是否唯一
     *
     * @param tagName 标签名称
     * @return 结果
     */
    @Override
    public Boolean checkTagNameUnique(String tagName) {
        if (StringUtils.isEmpty(tagName)) {
            throw new ServiceException("请输入正确的标签名");
        }
        LambdaQueryWrapper<BlogTagsEntity> blogTagsEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        blogTagsEntityLambdaQueryWrapper.eq(BlogTagsEntity::getTagName, tagName);
        return list(blogTagsEntityLambdaQueryWrapper).isEmpty();
    }
}

