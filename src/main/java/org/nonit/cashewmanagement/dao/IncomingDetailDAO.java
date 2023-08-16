package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.IncomingDetailEntity;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

public class IncomingDetailDAO extends BaseDAO<IncomingDetailEntity> {

    public IncomingDetailDAO(){
        super(IncomingDetailEntity.class);
    }
}
