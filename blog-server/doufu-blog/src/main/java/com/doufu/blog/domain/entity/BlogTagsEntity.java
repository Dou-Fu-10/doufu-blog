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
@TableName("blog_tags")
@Schema(name = "blog_tags", description = "标签(BlogTags)表实体类")
public class BlogTagsEntity extends CommonEntity<BlogTagsEntity> implements Serializable {
    /**
     * 标签ID
     */
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
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

