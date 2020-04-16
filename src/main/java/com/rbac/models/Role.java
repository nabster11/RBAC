package com.rbac.models;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.rbac.enums.ActionTypes;
import java.util.Set;

/**
 * The type Role.
 */
public class Role {

  /**
   * The Id.
   */
  final int id;
  /**
   * The Action types.
   */
  final Set<ActionTypes> actionTypes;
  /**
   * The Resource id.
   */
  final long ResourceId;

  /**
   * Instantiates a new Role.
   *
   * @param id          the id
   * @param actionTypes the action types
   * @param resourceId  the resource id
   */
  public Role(int id, Set<ActionTypes> actionTypes, long resourceId) {
    this.id = id;
    this.actionTypes = actionTypes;
    ResourceId = resourceId;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Gets action types.
   *
   * @return the action types
   */
  public Set<ActionTypes> getActionTypes() {
    return actionTypes;
  }

  /**
   * Gets resource id.
   *
   * @return the resource id
   */
  public long getResourceId() {
    return ResourceId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Role)) {
      return false;
    }
    Role role = (Role) o;
    return getId() == role.getId() &&
        getResourceId() == role.getResourceId() &&
        Objects.equal(getActionTypes(), role.getActionTypes());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId(), getActionTypes(), getResourceId());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("actionTypes", actionTypes)
        .add("ResourceId", ResourceId)
        .toString();
  }
}
