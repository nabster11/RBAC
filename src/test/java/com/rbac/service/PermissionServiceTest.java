package com.rbac.service;

import com.rbac.BaseTest;
import com.rbac.enums.ActionTypes;
import com.rbac.models.Role;
import java.util.Collections;
import java.util.HashSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * The type Permission service test.
 */
public class PermissionServiceTest extends BaseTest {

  /**
   * Resource access allowed.
   */
  @Test
  public void resourceAccessAllowed() {
    Assert.assertEquals(true, permissionService.ResourceAccessAllowed(1, 1, ActionTypes.READ));
  }

  /**
   * User 1 allowed test.
   */
  @Test
  public void user1AllowedTest() {
    Assert.assertEquals(true, permissionService.ResourceAccessAllowed(1, 1, ActionTypes.READ));
    Assert.assertEquals(true, permissionService.ResourceAccessAllowed(1, 1, ActionTypes.WRITE));
    Assert.assertEquals(true, permissionService.ResourceAccessAllowed(1, 1, ActionTypes.DELETE));
  }

  /**
   * User 1 not allowed test.
   */
  @Test
  public void user1NotAllowedTest() {
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.READ));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.WRITE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.DELETE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.READ));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.WRITE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.DELETE));
  }

  /**
   * User 1 updated role test.
   */
  @Test
  public void user1UpdatedRoleTest() {

    Assert.assertEquals(true, userDao.appendRole(2, 1));

    Assert.assertEquals(true, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.READ));
    Assert.assertEquals(true, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.WRITE));
    Assert.assertEquals(true, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.DELETE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.READ));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.WRITE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.DELETE));
  }


  /**
   * User 1 new role test.
   */
  @Test
  public void user1NewRoleTest() {

    final Role role = new Role(4, new HashSet<>(Collections.singletonList(ActionTypes.READ)), 2);
    Assert.assertEquals(true, userDao.addNewRole(role, 1));

    Assert.assertEquals(true, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.READ));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.WRITE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.DELETE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.READ));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.WRITE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.DELETE));

    // now removing the above assigned role for userid:1
    Assert.assertEquals(true, userDao.removeRole(4, 1));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.READ));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.WRITE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(2, 1, ActionTypes.DELETE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.READ));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.WRITE));
    Assert.assertEquals(false, permissionService.ResourceAccessAllowed(3, 1, ActionTypes.DELETE));
  }

}