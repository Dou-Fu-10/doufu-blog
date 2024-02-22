package com.doufu.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doufu.blog.domain.dto.BlogArticleTagsDTO;
import com.doufu.blog.domain.entity.BlogArticleTagsEntity;
import com.doufu.blog.domain.vo.BlogArticleTagsVo;

/**
 * (BlogArticleTags)表服务接口
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description (BlogArticleTags)表服务接口
 */
public interface BlogArticleTagsService extends IService<BlogArticleTagsEntity> {
    /**
     * 新增数据
     *
     * @param blogArticleTagsDto 实体对象
     * @return 新增结果
     */
    Boolean save(BlogArticleTagsDTO blogArticleTagsDto);

    /**
     * 修改数据
     *
     * @param blogArticleTagsDto 实体对象
     * @return 修改结果
     */
    Boolean updateById(BlogArticleTagsDTO blogArticleTagsDto);

    /**
     * 分页查询所有数据
     *
     * @param page               分页对象
     * @param blogArticleTagsDto 查询实体
     * @return 所有数据
     */
    Page<BlogArticleTagsVo> page(Page<BlogArticleTagsEntity> page, BlogArticleTagsDTO blogArticleTagsDto);
}
