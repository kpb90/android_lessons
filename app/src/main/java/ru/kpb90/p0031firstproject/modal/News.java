package ru.kpb90.p0031firstproject.modal;

/**
 * Created by eMachines on 25.01.2015.
 */
public class News {
    private final String imageUrl;
    private final String title;

    public News(String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }
}
