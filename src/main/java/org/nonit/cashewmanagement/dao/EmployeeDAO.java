package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.EmployeeEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;

@Stateless
public class EmployeeDAO extends BaseDAO<EmployeeEntity> {

    public EmployeeDAO(){
        super(EmployeeEntity.class);
    }
}
