package com.doufu.blog.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 标签(BlogTags)表实体类
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description 标签(BlogTags)表实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogTagsDTO {
    /**
     * 标签ID
     */
    @Schema(name = "tagId", description = "标签ID")
    private Long tagId;

    /**
     * 标签名称
     */
    @Schema(name = "tagName", description = "标签名称")
    private String tagName;
    /**
     * 标签描述
     */
    @Schema(name = "tagDesc", description = "标签描述")
    private String tagDesc;


}

