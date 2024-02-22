package com.doufu.blog.domain.vo;

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
public class BlogCategoryVo {
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
    /**
     * 创建者
     */
    @Schema(name = "createBy", description = "创建者")
    private String createBy;
    /**
     * 创建时间
     */
    @Schema(name = "createTime", description = "创建时间")
    private Date createTime;
    /**
     * 更新者
     */
    @Schema(name = "updateBy", description = "更新者")
    private String updateBy;
    /**
     * 更新时间
     */
    @Schema(name = "updateTime", description = "更新时间")
    private Date updateTime;

}

