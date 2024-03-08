import {Tag} from "@/types/tags";
import {Category} from "@/types/category";

export interface Article {
    articleId: string,
    categoryId: string,
    articleTitle: string,
    articleSummary: string,
    articleContent: string,
    articleCover: string,
    viewsCount: number,
    commentsCount: number,
    isPublish: boolean,
    isTop: boolean,
    isHot: boolean,
    isRecommend: boolean,
    reprint: string,
    editType: string,
    createTime: string,
    updateTime: string,
    tags: Array<Tag>,
    category?: Category,
}

export interface PostMeta{
    createTime: string,
    viewsCount: number,
    commentsCount: number,
}
