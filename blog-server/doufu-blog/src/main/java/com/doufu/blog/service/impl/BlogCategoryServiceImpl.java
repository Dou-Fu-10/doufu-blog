package com.doufu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doufu.blog.domain.dto.BlogCategoryDTO;
import com.doufu.blog.domain.entity.BlogCategoryEntity;
import com.doufu.blog.mapper.BlogCategoryMapper;
import com.doufu.blog.service.BlogCategoryService;
import com.doufu.common.exception.ServiceException;
import com.doufu.common.exception.WarnException;
import com.doufu.common.utils.StringUtils;
import com.doufu.common.utils.bean.BeanCopy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (BlogCategory)表服务实现类
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description (BlogCategory)表服务实现类
 */
@Service("blogCategoryService")
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategoryEntity> implements BlogCategoryService {
    @Override
    public List<BlogCategoryEntity> list(BlogCategoryDTO blogCategoryDTO) {
        BlogCategoryEntity blogCategoryEntity = BeanCopy.convert(blogCategoryDTO, BlogCategoryEntity.class);
        return list(new QueryWrapper<>(blogCategoryEntity));
    }

    @Override
    public Boolean save(BlogCategoryDTO blogCategoryDto) {
        if (!checkCategoryNameUnique(blogCategoryDto.getCategoryName())) {
            throw new WarnException("新增分类'" + blogCategoryDto.getCategoryName() + "'失败，分类名称已存在");
        }
        BlogCategoryEntity blogCategoryEntity = BeanCopy.convert(blogCategoryDto, BlogCategoryEntity.class);
        return save(blogCategoryEntity);
    }

    @Override
    public Boolean updateById(BlogCategoryDTO blogCategoryDto) {
        BlogCategoryEntity blogCategoryEntity = BeanCopy.convert(blogCategoryDto, BlogCategoryEntity.class);
        return updateById(blogCategoryEntity);
    }

    /**
     * 校验分类名称是否唯一
     *
     * @param categoryName 分类名称
     * @return 结果
     */
    @Override
    public Boolean checkCategoryNameUnique(String categoryName) {
        if (StringUtils.isEmpty(categoryName)) {
            throw new ServiceException("请输入正确的分类名");
        }
        LambdaQueryWrapper<BlogCategoryEntity> blogCategoryEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        blogCategoryEntityLambdaQueryWrapper.eq(BlogCategoryEntity::getCategoryName, categoryName);
        return list(blogCategoryEntityLambdaQueryWrapper).isEmpty();
    }
}

