package com.doufu.web.controller.blog;


import com.doufu.blog.domain.dto.BlogTagsDTO;
import com.doufu.blog.domain.entity.BlogTagsEntity;
import com.doufu.blog.service.BlogTagsService;
import com.doufu.common.annotation.Anonymous;
import com.doufu.common.core.controller.BaseController;
import com.doufu.common.core.domain.AjaxResult;
import com.doufu.common.core.page.TableDataInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 标签(BlogTags)表控制层
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description 标签(BlogTags)表控制层
 */
@RestController
@RequestMapping("/blog/tags")
@Tag(name = "BlogTagsController", description = "")
public class BlogTagsController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private BlogTagsService blogTagsService;

    /**
     * @param blogTagsDto 查询实体
     * @return 所有数据
     */
    @Anonymous
    @GetMapping
    public TableDataInfo select(BlogTagsDTO blogTagsDto) {
        startPage();
        List<BlogTagsEntity> list = this.blogTagsService.list(blogTagsDto);
        return getDataTable(list);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param tagsId 主键
     * @return 单条数据
     */
    @Anonymous
    @GetMapping("{tagsId}")
    public AjaxResult selectOne(@PathVariable("tagsId") Serializable tagsId) {
        return AjaxResult.success(this.blogTagsService.getById(tagsId));
    }

    /**
     * 新增数据
     *
     * @param blogTagsDto 实体对象
     * @return 新增结果
     */
    @Anonymous
    @PostMapping
    public AjaxResult insert(@RequestBody BlogTagsDTO blogTagsDto) {
        return toAjax(this.blogTagsService.save(blogTagsDto));
    }

    /**
     * 修改数据
     *
     * @param blogTagsDto 实体对象
     * @return 修改结果
     */
    @Anonymous
    @PutMapping
    public AjaxResult update(@RequestBody BlogTagsDTO blogTagsDto) {
        return toAjax(this.blogTagsService.updateById(blogTagsDto));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @Anonymous
    @DeleteMapping
    public AjaxResult remove(@RequestBody Set<Long> idList) {
        return toAjax(this.blogTagsService.removeByIds(validatedRemoveIds(idList)));
    }
}

