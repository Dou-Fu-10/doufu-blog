package com.doufu.web.controller.blog;


import com.doufu.blog.domain.dto.BlogCategoryDTO;
import com.doufu.blog.domain.entity.BlogCategoryEntity;
import com.doufu.blog.service.BlogCategoryService;
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
 * (BlogCategory)表控制层
 * Created by Dou-Fu-10 2024-01-30 00:39:19
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:19
 * @Description (BlogCategory)表控制层
 */
@RestController
@RequestMapping("/blog/category")
@Tag(name = "BlogCategoryController", description = "")
public class BlogCategoryController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private BlogCategoryService blogCategoryService;

    /**
     * 分页查询所有数据
     *
     * @param blogCategoryDto 查询实体
     * @return 所有数据
     */
    @Anonymous
    @GetMapping
    public TableDataInfo select(BlogCategoryDTO blogCategoryDto) {
        startPage();
        List<BlogCategoryEntity> list = this.blogCategoryService.list(blogCategoryDto);
        return getDataTable(list);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param categoryId 主键
     * @return 单条数据
     */
    @Anonymous
    @GetMapping("{categoryId}")
    public AjaxResult selectOne(@PathVariable("categoryId") Serializable categoryId) {
        return AjaxResult.success(this.blogCategoryService.getById(categoryId));
    }

    /**
     * 新增数据
     *
     * @param blogCategoryDto 实体对象
     * @return 新增结果
     */
    @Anonymous
    @PostMapping
    public AjaxResult insert(@RequestBody BlogCategoryDTO blogCategoryDto) {
        return toAjax(this.blogCategoryService.save(blogCategoryDto));
    }

    /**
     * 修改数据
     *
     * @param blogCategoryDto 实体对象
     * @return 修改结果
     */
    @Anonymous
    @PutMapping
    public AjaxResult update(@RequestBody BlogCategoryDTO blogCategoryDto) {
        return toAjax(this.blogCategoryService.updateById(blogCategoryDto));
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

        return toAjax(this.blogCategoryService.removeByIds(validatedRemoveIds(idList)));
    }
}

