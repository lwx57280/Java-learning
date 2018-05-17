package com;

public class TrainingSchedule {

    private String id;

    private String Title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public String toString() {
        return "TrainingSchedule{" +
                "id='" + id + '\'' +
                ", Title='" + Title + '\'' +
                '}';
    }
}
