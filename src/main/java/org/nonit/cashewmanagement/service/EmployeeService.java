package org.nonit.cashewmanagement.service;

import org.nonit.cashewmanagement.dao.EmployeeDAO;
import org.nonit.cashewmanagement.mapper.EmployeeMapper;

import javax.inject.Inject;

public class EmployeeService {

    @Inject
    private EmployeeDAO employeeDAO;

    @Inject
    private EmployeeMapper employeeMapper;
}
