package com.doufu.blog.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class BlogArticleDTO {
    /**
     * 标签ID
     */
    @Schema(name = "articleId", description = "标签ID")
    private Long articleId;
    /**
     * 分类ID
     */
    @Schema(name = "categoryId", description = "分类ID")
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

}

