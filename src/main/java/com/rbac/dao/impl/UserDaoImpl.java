package com.rbac.dao.impl;

import com.google.inject.Inject;
import com.rbac.dao.UserDao;
import com.rbac.db.RoleDB;
import com.rbac.db.UsersDB;
import com.rbac.models.Role;
import com.rbac.models.User;
import java.util.List;
import java.util.Optional;

/**
 * The type User dao.
 */
public class UserDaoImpl implements UserDao {

  private final UsersDB usersDB;
  private final RoleDB roleDB;

  /**
   * Instantiates a new User dao.
   *
   * @param usersDB the users db
   * @param roleDB  the role db
   */
  @Inject
  public UserDaoImpl(final UsersDB usersDB, RoleDB roleDB) {
    this.usersDB = usersDB;
    this.roleDB = roleDB;
  }

  @Override
  public Optional<User> get(final long id) {
    return usersDB.getUserById(id);
  }

  @Override
  public List<User> getAll() {
    return usersDB.getAllUsers();
  }

  @Override
  public boolean save(final User user) {
    return usersDB.saveUser(user);
  }

  @Override
  public boolean update(final User user) {
    return usersDB.updateUser(user);
  }

  @Override
  public boolean delete(long id) {
    return usersDB.removeUser(id);
  }

  @Override
  public boolean addNewRole(final Role newRole, long userId) {
    final Optional<User> user = get(userId);
    if (user.isPresent()) {
      // add role-id to the roleIdSet in users
      user.get().getRoleIdSet().add(newRole.getId());
      // pass a new role to roleDao and update the roleIdSet in users
      return roleDB.saveRole(newRole);
    }
    return false;
  }

  @Override
  public boolean appendRole(int roleId, long userId) {

    //assert if the role-id is present
    if (roleDB.getRoleById(roleId).isPresent()) {
      final Optional<User> user = usersDB.getUserById(userId);
      if (user.isPresent()) {
        return user.get().getRoleIdSet().add(roleId);
      }
    }
    return false;
  }

  public boolean removeRole(final int roleId, long userId) {
    final Optional<User> user = get(userId);

    // add role-id to the roleIdSet in users
    return user.map(value -> value.getRoleIdSet().remove(roleId)).orElse(false);
  }
}
