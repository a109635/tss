package com.baizhi.entity;

import java.io.Serializable;

public class Poetry implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private Poets poets;

    @Override
    public String toString() {
        return "Poetry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", poets=" + poets +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Poets getPoets() {
        return poets;
    }

    public void setPoets(Poets poets) {
        this.poets = poets;
    }

    public Poetry(Integer id, String title, String content, Poets poets) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.poets = poets;
    }

    public Poetry() {
    }
}
