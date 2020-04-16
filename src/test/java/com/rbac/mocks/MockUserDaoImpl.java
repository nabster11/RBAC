package com.rbac.mocks;

import com.rbac.dao.UserDao;
import com.rbac.models.Role;
import com.rbac.models.User;
import java.util.List;
import java.util.Optional;

/**
 * The type Mock user dao.
 */
public class MockUserDaoImpl implements UserDao {

  @Override
  public boolean addNewRole(Role newRole, long userId) {
    return false;
  }

  @Override
  public boolean appendRole(int role, long userId) {
    return false;
  }

  @Override
  public boolean removeRole(int roleId, long userId) {
    return false;
  }

  @Override
  public Optional<User> get(long id) {
    return Optional.empty();
  }

  @Override
  public List<User> getAll() {
    return null;
  }

  @Override
  public boolean save(User user) {
    return false;
  }

  @Override
  public boolean update(User user) {
    return false;
  }

  @Override
  public boolean delete(long id) {
    return false;
  }
}
