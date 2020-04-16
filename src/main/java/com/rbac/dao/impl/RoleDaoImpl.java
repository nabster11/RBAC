package com.rbac.dao.impl;

import com.google.inject.Inject;
import com.rbac.dao.RoleDao;
import com.rbac.db.RoleDB;
import com.rbac.models.Role;
import java.util.List;
import java.util.Optional;

/**
 * The type Role dao.
 */
public class RoleDaoImpl implements RoleDao {

  private final RoleDB rolesDB;

  /**
   * Instantiates a new Role dao.
   *
   * @param rolesDB the roles db
   */
  @Inject
  public RoleDaoImpl(final RoleDB rolesDB) {
    this.rolesDB = rolesDB;
  }

  @Override
  public Optional<Role> get(final long id) {
    return rolesDB.getRoleById(id);
  }

  @Override
  public List<Role> getAll() {
    return rolesDB.getAllRoles();
  }

  @Override
  public boolean save(final Role role) {
    return rolesDB.saveRole(role);
  }

  @Override
  public boolean update(final Role role) {
    return rolesDB.updateRole(role);
  }

  @Override
  public boolean delete(long id) {
    return rolesDB.removeRole(id);
  }
}
