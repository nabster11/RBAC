package com.rbac.models;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.Set;

/**
 * The type User.
 */
public class User {

  /**
   * The Id.
   */
  final long id;
  /**
   * The User name.
   */
  final String userName;
  /**
   * The Password.
   */
  final String password;
  /**
   * The Role id set.
   */
  Set<Integer> roleIdSet;

  /**
   * Instantiates a new User.
   *
   * @param id        the id
   * @param userName  the user name
   * @param password  the password
   * @param roleIdSet the role id set
   */
  public User(long id, String userName, String password, Set<Integer> roleIdSet) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.roleIdSet = roleIdSet;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Gets user name.
   *
   * @return the user name
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Gets password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Gets role id set.
   *
   * @return the role id set
   */
  public Set<Integer> getRoleIdSet() {
    return roleIdSet;
  }

  /**
   * Sets role id set.
   *
   * @param roleIdSet the role id set
   */
  public void setRoleIdSet(Set<Integer> roleIdSet) {
    this.roleIdSet = roleIdSet;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return getId() == user.getId() &&
        Objects.equal(getUserName(), user.getUserName()) &&
        Objects.equal(getPassword(), user.getPassword()) &&
        Objects.equal(getRoleIdSet(), user.getRoleIdSet());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId(), getUserName(), getPassword(), getRoleIdSet());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("userName", userName)
        .add("password", password)
        .add("roleIdSet", roleIdSet)
        .toString();
  }
}
