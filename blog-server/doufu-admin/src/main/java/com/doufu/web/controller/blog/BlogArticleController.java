package com.doufu.web.controller.blog;

import com.doufu.blog.domain.dto.BlogArticleDTO;
import com.doufu.blog.domain.entity.BlogArticleEntity;
import com.doufu.blog.service.BlogArticleService;
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
 * (BlogArticle)表控制层
 * Created by Dou-Fu-10 2024-01-30 00:39:18
 *
 * @author Dou-Fu-10
 * @date 2024-01-30 00:39:18
 * @Description (BlogArticle)表控制层
 */
@RestController
@RequestMapping("/blog/article")
@Tag(name = "BlogArticleController", description = "")
public class BlogArticleController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private BlogArticleService blogArticleService;

    /**
     * 分页查询所有数据
     *
     * @param blogArticleDTO 查询实体
     * @return 所有数据
     */
    @Anonymous
    @GetMapping
    public TableDataInfo select(BlogArticleDTO blogArticleDTO) {
        startPage();
        List<BlogArticleEntity> list = this.blogArticleService.list(blogArticleDTO);
        return getDataTable(list);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param articleId 主键
     * @return 单条数据
     */
    @Anonymous
    @GetMapping("{articleId}")
    public AjaxResult selectOne(@PathVariable("articleId") Serializable articleId) {
        return AjaxResult.success(this.blogArticleService.getById(articleId));
    }

    /**
     * 新增数据
     *
     * @param blogArticleDto 实体对象
     * @return 新增结果
     */
    @Anonymous
    @PostMapping
    public AjaxResult insert(@RequestBody BlogArticleDTO blogArticleDto) {
        return toAjax(this.blogArticleService.save(blogArticleDto));
    }

    /**
     * 修改数据
     *
     * @param blogArticleDto 实体对象
     * @return 修改结果
     */
    @Anonymous
    @PutMapping
    public AjaxResult update(@RequestBody BlogArticleDTO blogArticleDto) {
        return toAjax(this.blogArticleService.updateById(blogArticleDto));
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
        return toAjax(this.blogArticleService.removeByIds(validatedRemoveIds(idList)));
    }
}

