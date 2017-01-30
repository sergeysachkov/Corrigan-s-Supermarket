package com.ait.corrigan.services;

import java.util.List;

import com.ait.corrigan.models.user.Manager;

public interface ManagerService {

    long addManager(Manager manager);
    long updateManager(Manager manager);
    void deleteManager();
    Manager getManager(long managerId);
    List<Manager> getManagers();
}
