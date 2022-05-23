package model;

import java.sql.Timestamp;

public class Store {
    private long id;
    private String name;
    private String description;
    private String address;
    private String picture;
    private long favoriteStore;
    private User author;
    private final Timestamp created = new Timestamp(System.currentTimeMillis());
    private Timestamp modified = new Timestamp(System.currentTimeMillis());

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getFavoriteStore() {
        return favoriteStore;
    }

    public void setFavoriteStore(long favoriteStore) {
        this.favoriteStore = favoriteStore;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
}
