package com.pranav.github_activity_cli.model;

public class Repo {

    private String id;
    private String name;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String formattedName = "";
        int index = name.lastIndexOf('/');
        if (index != -1) {
            formattedName = name.substring(index + 1);
        }
        this.name = formattedName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
