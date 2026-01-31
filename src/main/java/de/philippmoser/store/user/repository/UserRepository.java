package de.philippmoser.store.user.repository;

import de.philippmoser.store.user.User;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}
