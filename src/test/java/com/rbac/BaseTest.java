package com.rbac;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.rbac.dao.RoleDao;
import com.rbac.dao.UserDao;
import com.rbac.dao.impl.RoleDaoImpl;
import com.rbac.dao.impl.UserDaoImpl;
import com.rbac.service.PermissionService;
import org.junit.After;
import org.junit.Before;

/**
 * The type Base test.
 */
public class BaseTest {

  /**
   * The Injector.
   */
  public Injector injector;
  /**
   * The Permission service.
   */
  public PermissionService permissionService;
  /**
   * The User dao.
   */
  public UserDao userDao;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    injector = Guice.createInjector(new AbstractModule() {

      @Override
      protected void configure() {
        bind(UserDao.class).to(UserDaoImpl.class);
        bind(RoleDao.class).to(RoleDaoImpl.class);
      }
    });
    this.permissionService = injector.getInstance(PermissionService.class);
    this.userDao = injector.getInstance(UserDao.class);
  }

  /**
   * Tear down.
   */
  @After
  public void tearDown() {
    injector = null;
  }
}
