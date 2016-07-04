package ru.drugoigorod.app.data;

public class Article {

    private final String id;
    private final String title;
    private final String content;
    private final int views;
    private final String description;
    private final String author;
    private String categoryTitle;
    private String headerBackgroundColor;

    public Article(ArticleBuilder articleBuilder) {
        this.id = articleBuilder.id;
        this.title = articleBuilder.title;
        this.content = articleBuilder.content;
        this.views = articleBuilder.views;
        this.description = articleBuilder.description;
        this.author = articleBuilder.author;
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

    public int getViewsCount() {
        return views;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishDateTime() {
        return null;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getHeaderImageUrl() {
        return null;
    }

    public String getHeaderBackgroundColor() {
        return headerBackgroundColor;
    }

    public static class ArticleBuilder {

        private String id;
        private String title;
        private String content;
        private int views;
        private String description;
        private String author;
        private String headerBackgroundColor;

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

        public ArticleBuilder setViews(int views) {
            this.views = views;
            return this;
        }

        public Article build(){
            return new Article(this);
        }

        public ArticleBuilder setPublichDateTime(String s) {
            return this;
        }

        public ArticleBuilder setCategoryTitle(String category) {
            return this;
        }

        public ArticleBuilder setHeaderImageUrl(String s) {
            return this;
        }

        public ArticleBuilder setHeaderBackgroundColor(String headerBackgroundColor) {
            this.headerBackgroundColor = headerBackgroundColor;
            return this;
        }

    }


}
