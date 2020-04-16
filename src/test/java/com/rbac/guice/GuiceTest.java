package com.rbac.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.rbac.BaseTest;
import com.rbac.dao.RoleDao;
import com.rbac.dao.UserDao;
import com.rbac.enums.ActionTypes;
import com.rbac.mocks.MockRoleDaoImpl;
import com.rbac.mocks.MockUserDaoImpl;
import com.rbac.service.PermissionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Guice test.
 */
public class GuiceTest extends BaseTest {

  @Before
  public void setUp() {
    injector = Guice.createInjector(new AbstractModule() {

      @Override
      protected void configure() {
        bind(UserDao.class).to(MockUserDaoImpl.class);
        bind(RoleDao.class).to(MockRoleDaoImpl.class);
      }
    });
    this.permissionService = injector.getInstance(PermissionService.class);
  }

  /**
   * Main.
   */
  @Test
  public void main() {
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(1, 1, ActionTypes.READ));
  }
}