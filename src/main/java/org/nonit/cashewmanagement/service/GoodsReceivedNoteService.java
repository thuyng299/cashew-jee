package org.nonit.cashewmanagement.service;

import org.nonit.cashewmanagement.dao.GoodsReceivedNoteDAO;
import org.nonit.cashewmanagement.mapper.GoodsReceivedNoteMapper;

import javax.inject.Inject;

public class GoodsReceivedNoteService {

    @Inject
    private GoodsReceivedNoteDAO goodsReceivedNoteDAO;

    @Inject
    private GoodsReceivedNoteMapper goodsReceivedNoteMapper;
}
