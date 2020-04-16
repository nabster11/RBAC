package com.rbac.service;

import com.google.inject.Inject;
import com.rbac.dao.RoleDao;
import com.rbac.dao.UserDao;
import com.rbac.enums.ActionTypes;
import com.rbac.models.Role;
import com.rbac.models.User;
import java.util.Optional;
import java.util.Set;


/**
 * The type Permission service.
 */
public class PermissionService {

  private final UserDao userDao;
  private final RoleDao roleDao;

  /**
   * Instantiates a new Permission service.
   *
   * @param userDao the user dao
   * @param roleDao the role dao
   */
  @Inject
  public PermissionService(UserDao userDao, RoleDao roleDao) {
    this.userDao = userDao;
    this.roleDao = roleDao;
  }

  /**
   * Resource access allowed boolean.
   *
   * @param resourceId the resource id
   * @param userId     the user id
   * @param actionType the action type
   * @return the boolean
   */
/*
    The method to check if the user is allowed access to a given resource with a given actionType
   */
  public boolean ResourceAccessAllowed(final int resourceId, final int userId,
      final ActionTypes actionType) {
    final Optional<User> user = userDao.get(userId);
    if (user.isPresent()) {
      final Set<Integer> roleSet = user.get().getRoleIdSet();

      for (int roleId : roleSet) {
        Optional<Role> role = roleDao.get(roleId);
        if (role.isPresent()) {
          Role roleObj = role.get();
          if (roleObj.getResourceId() == resourceId && roleObj.getActionTypes()
              .contains(actionType)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
