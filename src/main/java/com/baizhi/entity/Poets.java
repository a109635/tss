package com.baizhi.entity;

public class Poets {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Poets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Poets(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Poets() {
    }
}
