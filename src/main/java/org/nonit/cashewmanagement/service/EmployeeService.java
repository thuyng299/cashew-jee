package org.nonit.cashewmanagement.service;

import org.nonit.cashewmanagement.dao.EmployeeDAO;
import org.nonit.cashewmanagement.entity.EmployeeEntity;
import org.nonit.cashewmanagement.mapper.EmployeeMapper;
import org.nonit.cashewmanagement.utils.exception.ErrorMessage;
import org.nonit.cashewmanagement.utils.exception.InputValidationException;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EmployeeService {

    @Inject
    private EmployeeDAO employeeDAO;

    @Inject
    private EmployeeMapper employeeMapper;

    public EmployeeEntity getEntityByUsername(String username) throws InputValidationException {
        return employeeDAO.findByUsername(username)
                .orElseThrow(() -> new InputValidationException(ErrorMessage.KEY_EMPLOYEE_USERNAME_PASSWORD_INVALID, ErrorMessage.EMPLOYEE_USERNAME_PASSWORD_INVALID));
    }
}
