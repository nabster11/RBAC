package com.rbac.db;

import com.google.inject.Inject;
import com.rbac.models.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Singleton;

/**
 * The type Resource db.
 */
@Singleton
public class ResourceDB {

  private final List<Resource> listOfResources = new ArrayList<>();

  /**
   * Instantiates a new Resource db.
   */
  @Inject
  public ResourceDB() {
    listOfResources.add(new Resource(1, "testResource1"));
    listOfResources.add(new Resource(2, "testResource2"));
    listOfResources.add(new Resource(3, "testResource3"));
    listOfResources.add(new Resource(4, "testResource4"));
  }

  /**
   * Gets all resources.
   *
   * @return the all resources
   */
  public List<Resource> getAllResources() {
    return this.listOfResources;
  }

  /**
   * Gets resource by id.
   *
   * @param id the id
   * @return the resource by id
   */
  public Optional<Resource> getResourceById(long id) {
    int resourceId = (int) (id - 1);
    return Optional.ofNullable(listOfResources.get(resourceId));
  }

  /**
   * Remove resource boolean.
   *
   * @param id the id
   * @return the boolean
   */
  public boolean removeResource(long id) {
    return listOfResources.removeIf(x -> listOfResources.get((int) id) != null);
  }

  /**
   * Save resource boolean.
   *
   * @param resource the resource
   * @return the boolean
   */
  public boolean saveResource(Resource resource) {
    return listOfResources.add(resource);
  }

  /**
   * Update resource boolean.
   *
   * @param resource the resource
   * @return the boolean
   */
  public boolean updateResource(Resource resource) {
    if (listOfResources.get(resource.getId()) != null) {
      listOfResources.set(resource.getId() - 1, resource);
    }
    return false;
  }
}
