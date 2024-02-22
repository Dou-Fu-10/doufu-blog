package com.doufu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.doufu.blog.domain.dto.BlogTagsDTO;
import com.doufu.blog.domain.entity.BlogTagsEntity;

import java.util.List;

/**
 * 标签(BlogTags)表服务接口
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description 标签(BlogTags)表服务接口
 */
public interface BlogTagsService extends IService<BlogTagsEntity> {
    /**
     * 分页查询所有数据
     *
     * @param blogTagsDto 查询实体
     * @return 所有数据
     */
    List<BlogTagsEntity> list(BlogTagsDTO blogTagsDto);

    /**
     * 新增数据
     *
     * @param blogTagsDto 实体对象
     * @return 新增结果
     */
    Boolean save(BlogTagsDTO blogTagsDto);

    /**
     * 修改数据
     *
     * @param blogTagsDto 实体对象
     * @return 修改结果
     */
    Boolean updateById(BlogTagsDTO blogTagsDto);

    /**
     * 校验标签名称是否唯一
     *
     * @param tagName 标签名称
     * @return 结果
     */
    Boolean checkTagNameUnique(String tagName);
}
