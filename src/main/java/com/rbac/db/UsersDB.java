package com.rbac.db;

import com.google.inject.Inject;
import com.rbac.models.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import javax.inject.Singleton;


/**
 * The type Users db.
 */
@Singleton
public class UsersDB {

  private final List<User> listOfUsers = new ArrayList<>();

  @Inject
  private UsersDB() {
    // creating sample users with id, userName, hashed-password and their roles
    listOfUsers.add(
        new User(1, "testUser1", "qi8H8R7OM4xMUNMPuRAZxlY.", new HashSet<>(
            Collections.singletonList(1))));
    listOfUsers.add(new User(2, "testUser2", "qiyh4XPJGsOZ2MEAyLkfWqeQ", new HashSet<>(
        Collections.singletonList(2))));
    listOfUsers.add(new User(3, "testUser3", "qiyh4XPJGsOZ2MEAyLkfPlkA", new HashSet<>(
        Collections.singletonList(3))));
  }

  /**
   * Gets all users.
   *
   * @return the all users
   */
  public List<User> getAllUsers() {
    return this.listOfUsers;
  }

  /**
   * Gets user by id.
   *
   * @param id the id
   * @return the user by id
   */
  public Optional<User> getUserById(long id) {
    int userId = (int) (id - 1);
    return Optional.ofNullable(listOfUsers.get(userId));
  }

  /**
   * Remove user boolean.
   *
   * @param id the id
   * @return the boolean
   */
  public boolean removeUser(long id) {
    return listOfUsers.removeIf(x -> listOfUsers.get((int) id) != null);
  }

  /**
   * Save user boolean.
   *
   * @param user the user
   * @return the boolean
   */
  public boolean saveUser(User user) {
    return listOfUsers.add(user);
  }

  /**
   * Update user boolean.
   *
   * @param user the user
   * @return the boolean
   */
  public boolean updateUser(User user) {
    if (listOfUsers.get((int) user.getId()) != null) {
      listOfUsers.set((int) user.getId() - 1, user);
      return true;
    }
    return false;
  }
}
