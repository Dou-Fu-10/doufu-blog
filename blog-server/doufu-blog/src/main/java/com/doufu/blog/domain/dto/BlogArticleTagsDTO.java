package com.doufu.blog.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (BlogArticleTags)表实体类
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description (BlogArticleTags)表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogArticleTagsDTO {
    /**
     * ID
     */
    @Schema(name = "id", description = "ID")
    private Long id;
    /**
     * 文章id
     */
    @Schema(name = "articleId", description = "文章id")
    private Long articleId;
    /**
     * 标签id
     */
    @Schema(name = "tagId", description = "标签id")
    private Long tagId;

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

