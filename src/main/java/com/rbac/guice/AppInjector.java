package com.rbac.guice;

import com.google.inject.AbstractModule;
import com.rbac.dao.ResourceDao;
import com.rbac.dao.RoleDao;
import com.rbac.dao.UserDao;
import com.rbac.dao.impl.ResourceDaoImpl;
import com.rbac.dao.impl.RoleDaoImpl;
import com.rbac.dao.impl.UserDaoImpl;

/**
 * The type App injector.
 */
public class AppInjector extends AbstractModule {

  @Override
  protected void configure() {
    bind(UserDao.class).to(UserDaoImpl.class);
    bind(ResourceDao.class).to(ResourceDaoImpl.class);
    bind(RoleDao.class).to(RoleDaoImpl.class);
  }
}
