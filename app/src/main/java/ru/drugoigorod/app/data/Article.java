package ru.drugoigorod.app.data;

public class Article {

    private final String id;
    private final String title;
    private final String content;
    private final String views;
    private final String description;
    private final String author;
    private String categoryTitle;
    private String headerBackgroundColor;
    private String dateTime;
    private String headerImageUrl;

    public Article(ArticleBuilder articleBuilder) {
        this.headerBackgroundColor = articleBuilder.headerBackgroundColor;
        this.categoryTitle = articleBuilder.categoryTitle;
        this.id = articleBuilder.id;
        this.title = articleBuilder.title;
        this.content = articleBuilder.content;
        this.views = articleBuilder.views;
        this.dateTime = articleBuilder.dateTime;
        this.description = articleBuilder.description;
        this.author = articleBuilder.author;
        this.headerImageUrl = articleBuilder.headerImageUrl;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getViewsCount() {
        return views;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishDateTime() {
        return dateTime;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getHeaderImageUrl() {
        return headerImageUrl;
    }

    public String getHeaderBackgroundColor() {
        return headerBackgroundColor;
    }

    public static class ArticleBuilder {

        private String dateTime;
        private String id;
        private String title;
        private String content;
        private String views;
        private String description;
        private String author;
        private String headerBackgroundColor;
        private String categoryTitle;
        public String headerImageUrl;


        public ArticleBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public ArticleBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ArticleBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public ArticleBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ArticleBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public ArticleBuilder setViews(String views) {
            this.views = views;
            return this;
        }

        public ArticleBuilder setDateTime(String dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Article build() {
            return new Article(this);
        }


        public ArticleBuilder setCategoryTitle(String category) {
            this.categoryTitle = category;
            return this;
        }

        public ArticleBuilder setHeaderImageUrl(String s) {
            this.headerImageUrl = s;
            return this;
        }

        public ArticleBuilder setHeaderBackgroundColor(String headerBackgroundColor) {
            this.headerBackgroundColor = headerBackgroundColor;
            return this;
        }

    }


}
