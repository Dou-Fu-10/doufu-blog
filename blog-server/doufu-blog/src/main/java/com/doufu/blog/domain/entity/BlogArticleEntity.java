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
 * (BlogArticle)表实体类
 * Created by Dou-Fu-10 2024-01-30 00:39:18
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:18
 * @Description (BlogArticle)表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("blog_article")
@Schema(name = "blog_article", description = "(BlogArticle)表实体类")
public class BlogArticleEntity extends CommonEntity<BlogArticleEntity> implements Serializable {
    /**
     * 标签ID
     */
    @TableId
    @Schema(name = "articleId", description = "标签ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long articleId;
    /**
     * 分类ID
     */
    @Schema(name = "categoryId", description = "分类ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;

    /**
     * 文章标题
     */
    @Schema(name = "articleTitle", description = "文章标题")
    private String articleTitle;
    /**
     * 文章摘要
     */
    @Schema(name = "articleSummary", description = "文章摘要")
    private String articleSummary;
    /**
     * 文章内容
     */
    @Schema(name = "articleContent", description = "文章内容")
    private String articleContent;
    /**
     * 文章封面
     */
    @Schema(name = "articleCover", description = "文章封面")
    private String articleCover;
    /**
     * 文章浏览量
     */
    @Schema(name = "viewsCount", description = "文章浏览量")
    private Integer viewsCount;
    /**
     * 文章评论数
     */
    @Schema(name = "commentsCount", description = "文章评论数")
    private Integer commentsCount;
    /**
     * 是否发布
     */
    @Schema(name = "isPublish", description = "是否发布")
    private Boolean isPublish;
    /**
     * 是否顶置
     */
    @Schema(name = "isTop", description = "是否顶置")
    private Boolean isTop;
    /**
     * 是否火热
     */
    @Schema(name = "isHot", description = "是否火热")
    private Boolean isHot;
    /**
     * 是否推荐
     */
    @Schema(name = "isRecommend", description = "是否推荐")
    private Boolean isRecommend;
    /**
     * 转载地址
     */
    @Schema(name = "reprint", description = "转载地址")
    private String reprint;
    /**
     * 编辑器类型
     */
    @Schema(name = "editType", description = "编辑器类型")
    private String editType;
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

