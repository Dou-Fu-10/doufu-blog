package com.doufu.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doufu.blog.domain.entity.BlogArticleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (BlogArticle)表数据库访问层
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description (BlogArticle)表数据库访问层
 */
@Mapper
public interface BlogArticleMapper extends BaseMapper<BlogArticleEntity> {

}

