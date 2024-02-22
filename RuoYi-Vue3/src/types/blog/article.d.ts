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
    editType: string
}
