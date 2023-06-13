package org.example.model;

import static org.example.common.ExceptionMessages.INVALID_DESCRIPTION;
import static org.example.common.ExceptionMessages.INVALID_TITLE;

public class Task {
    private String title;
    private String description;
    private boolean isActive;

    public Task(String title, String description) {
        setTitle(title);
        setDescription(description);
        this.isActive = true;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_TITLE);
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_DESCRIPTION);
        }
        this.description = description;
    }
}
