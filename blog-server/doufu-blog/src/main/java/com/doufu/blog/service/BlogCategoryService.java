package com.doufu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.doufu.blog.domain.dto.BlogCategoryDTO;
import com.doufu.blog.domain.entity.BlogCategoryEntity;

import java.util.List;

/**
 * (BlogCategory)表服务接口
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description (BlogCategory)表服务接口
 */
public interface BlogCategoryService extends IService<BlogCategoryEntity> {
    /**
     * 分页查询所有数据
     *
     * @param blogCategoryDTO 查询实体
     * @return 所有数据
     */
    List<BlogCategoryEntity> list(BlogCategoryDTO blogCategoryDTO);

    /**
     * 新增数据
     *
     * @param blogCategoryDto 实体对象
     * @return 新增结果
     */
    Boolean save(BlogCategoryDTO blogCategoryDto);

    /**
     * 修改数据
     *
     * @param blogCategoryDto 实体对象
     * @return 修改结果
     */
    Boolean updateById(BlogCategoryDTO blogCategoryDto);

    /**
     * 校验分类名称是否唯一
     *
     * @param categoryName 分类名称
     * @return 结果
     */
    Boolean checkCategoryNameUnique(String categoryName);

}
