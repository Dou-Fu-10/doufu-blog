package com.doufu.blog.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (BlogCategory)表实体类
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description (BlogCategory)表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogCategoryDTO {
    /**
     * 分类id
     */
    @Schema(name = "categoryId", description = "分类id")
    private Long categoryId;

    /**
     * 分类名称
     */
    @Schema(name = "categoryName", description = "分类名称")
    private String categoryName;
    /**
     * 分类描述
     */
    @Schema(name = "categoryDesc", description = "分类描述")
    private String categoryDesc;
    /**
     * 分类页面路径
     */
    @Schema(name = "categoryPath", description = "分类页面路径")
    private String categoryPath;

}

