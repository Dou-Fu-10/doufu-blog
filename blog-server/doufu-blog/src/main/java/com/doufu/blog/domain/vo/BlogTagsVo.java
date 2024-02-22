package com.doufu.blog.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
public class BlogTagsVo {
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

