package com.doufu.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.doufu.common.core.domain.entity.CommonEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
@TableName("blog_article_tags")
@Schema(name = "blog_article_tags", description = "(BlogArticleTags)表实体类")
public class BlogArticleTagsEntity extends CommonEntity<BlogArticleTagsEntity> implements Serializable {
    /**
     * ID
     */
    @TableId
    @Schema(name = "id", description = "ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 文章id
     */
    @Schema(name = "articleId", description = "文章id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long articleId;
    /**
     * 标签id
     */
    @Schema(name = "tagId", description = "标签id")
    @JsonSerialize(using = ToStringSerializer.class)
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

