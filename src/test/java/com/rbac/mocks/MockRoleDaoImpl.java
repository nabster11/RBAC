package com.rbac.mocks;

import com.rbac.dao.RoleDao;
import com.rbac.models.Role;
import java.util.List;
import java.util.Optional;

/**
 * The type Mock role dao.
 */
public class MockRoleDaoImpl implements RoleDao {

  @Override
  public Optional<Role> get(long id) {
    return Optional.empty();
  }

  @Override
  public List<Role> getAll() {
    return null;
  }

  @Override
  public boolean save(Role role) {
    return false;
  }

  @Override
  public boolean update(Role role) {
    return false;
  }

  @Override
  public boolean delete(long id) {
    return false;
  }
}
