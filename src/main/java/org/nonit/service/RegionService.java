package org.nonit.service;

import org.nonit.dao.RegionDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RegionService {
    @Inject
    private RegionDAO regionDAO;


}
