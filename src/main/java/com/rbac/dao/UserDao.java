package com.rbac.dao;

import com.rbac.models.Role;
import com.rbac.models.User;

/**
 * The interface User dao.
 */
public interface UserDao extends GenericDao<User> {

  /**
   * Add new role boolean.
   *
   * @param newRole the new role
   * @param userId  the user id
   * @return the boolean
   */
  boolean addNewRole(Role newRole, long userId);

  /**
   * Append role boolean.
   *
   * @param role   the role
   * @param userId the user id
   * @return the boolean
   */
  boolean appendRole(int role, long userId);

  /**
   * Remove role boolean.
   *
   * @param roleId the role id
   * @param userId the user id
   * @return the boolean
   */
  boolean removeRole(int roleId, long userId);
}
