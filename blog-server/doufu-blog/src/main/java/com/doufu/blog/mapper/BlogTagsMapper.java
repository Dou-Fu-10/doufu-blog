package com.doufu.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doufu.blog.domain.entity.BlogTagsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 标签(BlogTags)表数据库访问层
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description 标签(BlogTags)表数据库访问层
 */
@Mapper
public interface BlogTagsMapper extends BaseMapper<BlogTagsEntity> {

}

