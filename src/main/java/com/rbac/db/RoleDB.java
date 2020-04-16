package com.rbac.db;

import com.google.inject.Inject;
import com.rbac.enums.ActionTypes;
import com.rbac.models.Role;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.inject.Singleton;

/**
 * The type Role db.
 */
@Singleton
public class RoleDB {

  private final List<Role> listOfRoles = new ArrayList<>();

  /**
   * Instantiates a new Role db.
   */
  @Inject
  public RoleDB() {
    final Set<ActionTypes> role1AllowedActionTypes = new HashSet<>(
        Arrays.asList(ActionTypes.READ, ActionTypes.WRITE, ActionTypes.DELETE));

    final Set<ActionTypes> role2AllowedActionTypes = new HashSet<>(
        Arrays.asList(ActionTypes.READ, ActionTypes.WRITE, ActionTypes.DELETE));

    final Set<ActionTypes> role3AllowedActionTypes = new HashSet<>(
        Arrays.asList(ActionTypes.READ, ActionTypes.WRITE, ActionTypes.DELETE));

    final Role role1 = new Role(1, role1AllowedActionTypes, 1);
    final Role role2 = new Role(2, role2AllowedActionTypes, 2);
    final Role role3 = new Role(3, role3AllowedActionTypes, 3);

    // adding roles to the list
    listOfRoles.addAll(Arrays.asList(role1, role2, role3));
  }

  /**
   * Gets all roles.
   *
   * @return the all roles
   */
  public List<Role> getAllRoles() {
    return this.listOfRoles;
  }

  /**
   * Gets role by id.
   *
   * @param id the id
   * @return the role by id
   */
  public Optional<Role> getRoleById(long id) {
    int roleId = (int) (id - 1);
    return Optional.ofNullable(listOfRoles.get(roleId));
  }

  /**
   * Remove role boolean.
   *
   * @param id the id
   * @return the boolean
   */
  public boolean removeRole(long id) {
    return listOfRoles.removeIf(x -> listOfRoles.get((int) id) != null);
  }

  /**
   * Save role boolean.
   *
   * @param role the role
   * @return the boolean
   */
  public boolean saveRole(Role role) {
    return listOfRoles.add(role);
  }

  /**
   * Update role boolean.
   *
   * @param role the role
   * @return the boolean
   */
  public boolean updateRole(Role role) {
    if (listOfRoles.get(role.getId()) != null) {
      listOfRoles.set(role.getId() - 1, role);
    }
    return false;
  }

}
