package org.example.Models;

import org.example.Models.User;

public class Model {
    private static Model model;
    private User user;

    private Model() {
        this.user = new User();
    }

    public User getCurrentUser() {
        return user;
    }

    public void setCurrentUser(User currentUser) {
        this.user = currentUser;
    }


    public synchronized static Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }
}
