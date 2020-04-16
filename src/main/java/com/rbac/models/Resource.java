package com.rbac.models;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * The type Resource.
 */
public class Resource {

  /**
   * The Id.
   */
  final int id;
  /**
   * The Name.
   */
  final String name;

  /**
   * Instantiates a new Resource.
   *
   * @param id   the id
   * @param name the name
   */
  public Resource(final int id, final String name) {
    this.id = id;
    this.name = name;
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
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Resource)) {
      return false;
    }
    Resource resource = (Resource) o;
    return getId() == resource.getId() &&
        Objects.equal(getName(), resource.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId(), getName());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("name", name)
        .toString();
  }
}
