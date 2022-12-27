package africa.semicolon.noteapp.data.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Note {
    private String id;
    private String name;
    private List<Page> pages;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Note(String name) {
        this.name = name;
        pages = new ArrayList<>();
    }

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
        this.name = name;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
