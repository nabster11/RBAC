package com.rbac.dao.impl;

import com.google.inject.Inject;
import com.rbac.dao.ResourceDao;
import com.rbac.db.ResourceDB;
import com.rbac.models.Resource;
import java.util.List;
import java.util.Optional;

/**
 * The type Resource dao.
 */
public class ResourceDaoImpl implements ResourceDao {

  private final ResourceDB resourceDB;

  /**
   * Instantiates a new Resource dao.
   *
   * @param resourceDB the resource db
   */
  @Inject
  public ResourceDaoImpl(final ResourceDB resourceDB) {
    this.resourceDB = resourceDB;
  }

  @Override
  public Optional<Resource> get(final long id) {
    return resourceDB.getResourceById(id);
  }

  @Override
  public List<Resource> getAll() {
    return resourceDB.getAllResources();
  }

  @Override
  public boolean save(final Resource Resource) {
    return resourceDB.saveResource(Resource);
  }

  @Override
  public boolean update(final Resource Resource) {
    return resourceDB.updateResource(Resource);
  }

  @Override
  public boolean delete(long id) {
    return resourceDB.removeResource(id);
  }
}
