package by.it_academy.class_work_1.class_work6;

/**
 * Created by kasarevich on 23.02.2018.
 */

public class User {
    private String imageUrl;
    private String name;
    private String surname;

    public User(String imageUrl, String name, String surname) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.surname = surname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
