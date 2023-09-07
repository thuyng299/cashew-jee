package org.nonit.cashewmanagement.service;

import org.nonit.cashewmanagement.dao.IncomingDetailDAO;
import org.nonit.cashewmanagement.mapper.IncomingDetailMapper;
import org.nonit.cashewmanagement.service.model.StockAmountOfCategoryStat;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class IncomingDetailService {

    @Inject
    private IncomingDetailDAO incomingDetailDAO;

    @Inject
    private IncomingDetailMapper incomingDetailMapper;

    public List<StockAmountOfCategoryStat> getTotalStockAmountOfFinishedGood(){
        return incomingDetailDAO.getTotalStockAmountOfFinishedGood();
    }
}
