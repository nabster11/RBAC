package com.rbac;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.rbac.dao.UserDao;
import com.rbac.enums.ActionTypes;
import com.rbac.guice.AppInjector;
import com.rbac.service.PermissionService;


/**
 * The type Main.
 */
public class Main {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    System.out.println("Starting the system");
    Injector injector = Guice.createInjector(new AppInjector());

    PermissionService permissionService = injector.getInstance(PermissionService.class);

    // basic test
    boolean isAllowed = permissionService.ResourceAccessAllowed(1, 1, ActionTypes.READ);
    boolean isAllowed1 = permissionService.ResourceAccessAllowed(2, 2, ActionTypes.READ);
    boolean isAllowed2 = permissionService.ResourceAccessAllowed(3, 3, ActionTypes.READ);

    // testing with combination of resources
    boolean isAllowed3 = permissionService.ResourceAccessAllowed(3, 1, ActionTypes.DELETE);
    boolean isAllowed4 = permissionService.ResourceAccessAllowed(2, 1, ActionTypes.READ);
    boolean isAllowed5 = permissionService.ResourceAccessAllowed(1, 2, ActionTypes.WRITE);
    boolean isAllowed6 = permissionService.ResourceAccessAllowed(2, 1, ActionTypes.READ);

    // testing after assigning roles.
    UserDao userDao = injector.getInstance(UserDao.class);

    boolean isUserRoleAdded = userDao.appendRole(2, 1);
    boolean isAllowed7 = permissionService.ResourceAccessAllowed(2, 1, ActionTypes.READ);

    boolean isUserRoleRemoved = userDao.removeRole(2, 1);
    boolean isAllowed8 = permissionService.ResourceAccessAllowed(2, 1, ActionTypes.READ);

    System.out.println(" ------ Printing the output here ----------");
    System.out.println(isAllowed);
    System.out.println(isAllowed1);
    System.out.println(isAllowed2);
    System.out.println(isAllowed3);
    System.out.println(isAllowed4);
    System.out.println(isAllowed5);
    System.out.println(isAllowed6);

    // This should print true as the access was given to userId: 1
    System.out.println(isUserRoleAdded);
    System.out.println(isAllowed7);

    // This should print false as the access was removed for userId: 1
    System.out.println(isUserRoleRemoved);
    System.out.println(isAllowed8);

    System.out.println("--------- System Stop ----------------");
  }
}
