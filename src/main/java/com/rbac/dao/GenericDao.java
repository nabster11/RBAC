package com.rbac.dao;

import java.util.List;
import java.util.Optional;

/**
 * The interface Generic dao.
 *
 * @param <T> the type parameter
 */
public interface GenericDao<T> {

  /**
   * Get optional.
   *
   * @param id the id
   * @return the optional
   */
  Optional<T> get(long id);

  /**
   * Gets all.
   *
   * @return the all
   */
  List<T> getAll();

  /**
   * Save boolean.
   *
   * @param t the t
   * @return the boolean
   */
  boolean save(T t);

  /**
   * Update boolean.
   *
   * @param t the t
   * @return the boolean
   */
  boolean update(T t);

  /**
   * Delete boolean.
   *
   * @param id the id
   * @return the boolean
   */
  boolean delete(long id);
}
