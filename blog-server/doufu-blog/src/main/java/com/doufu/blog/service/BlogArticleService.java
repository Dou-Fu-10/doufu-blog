package com.doufu.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doufu.blog.domain.dto.BlogArticleDTO;
import com.doufu.blog.domain.dto.BlogTagsDTO;
import com.doufu.blog.domain.entity.BlogArticleEntity;
import com.doufu.blog.domain.entity.BlogTagsEntity;
import com.doufu.blog.domain.vo.BlogArticleVo;

import java.util.List;

/**
 * (BlogArticle)表服务接口
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description (BlogArticle)表服务接口
 */
public interface BlogArticleService extends IService<BlogArticleEntity> {
    /**
     * 分页查询所有数据
     *
     * @param blogArticleDto 查询实体
     * @return 所有数据
     */
    List<BlogArticleEntity> list(BlogArticleDTO blogArticleDto);
    /**
     * 新增数据
     *
     * @param blogArticleDto 实体对象
     * @return 新增结果
     */
    Boolean save(BlogArticleDTO blogArticleDto);

    /**
     * 修改数据
     *
     * @param blogArticleDto 实体对象
     * @return 修改结果
     */
    Boolean updateById(BlogArticleDTO blogArticleDto);
}
