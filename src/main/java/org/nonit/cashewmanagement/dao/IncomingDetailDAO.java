package org.nonit.cashewmanagement.dao;

import org.nonit.cashewmanagement.entity.IncomingDetailEntity;
import org.nonit.cashewmanagement.service.model.StockAmountOfCategoryStat;
import org.nonit.cashewmanagement.utils.dao.BaseDAO;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class IncomingDetailDAO extends BaseDAO<IncomingDetailEntity> {

    public IncomingDetailDAO() {
        super(IncomingDetailEntity.class);
    }

    public List<StockAmountOfCategoryStat> getTotalStockAmountOfFinishedGood() {
        return em.createQuery("SELECT NEW org.nonit.cashewmanagement.service.model.StockAmountOfCategoryStat(p.id, p.code, p.productCategory, SUM(id.remainingAmount)) " +
                        "FROM IncomingDetailEntity id, ProductEntity p " +
                        "WHERE p.id = id.product.id AND p.productCategory LIKE '%FINISHED_GOODS%' " +
                        "GROUP BY p.productCategory, p.code, p.id", StockAmountOfCategoryStat.class)
                .getResultList();
    }
}
