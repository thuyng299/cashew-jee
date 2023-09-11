package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.EmployeeEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class EmployeeDAO extends BaseDAO<EmployeeEntity> {

    public EmployeeDAO(){
        super(EmployeeEntity.class);
    }

    public Optional<EmployeeEntity> findByUsername(String username) {
        List<EmployeeEntity> employeeEntityList = em.createQuery("SELECT e FROM EmployeeEntity e " +
                        "WHERE LOWER(trim(both from e.username)) LIKE LOWER(trim(both from :username))", EmployeeEntity.class)
                .setParameter("username", username)
                .getResultList();

        return employeeEntityList.isEmpty() ? Optional.empty() : Optional.of(employeeEntityList.get(0));
    }
}
