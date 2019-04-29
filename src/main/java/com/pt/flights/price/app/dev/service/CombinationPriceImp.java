package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.controller.CurrencyExchangeController;
import com.pt.flights.price.app.dev.interfaces.DBCommonInterface;
import com.pt.flights.price.app.dev.model.CombinationPrice;
import com.pt.flights.price.app.dev.properties.PropertiesConfiguration;
import com.pt.flights.price.app.dev.repository.CombinationPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CombinationPriceImp implements DBCommonInterface<CombinationPrice, Long, Date> {

    private final Logger logger = LoggerFactory.getLogger(CombinationPriceImp.class);

    @Autowired
    AirLineImp airLine;

    @Autowired
    CombinationFlightImp combinationFlightImplements;

    @Autowired
    CurrencyExchangeController currency;

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    @Autowired
    CombinationPriceRepository combinationPriceRepository;

    @Override
    public CombinationPrice save(CombinationPrice combinationPrice) {
        return combinationPriceRepository.save(combinationPrice);
    }

    @Override
    public CombinationPrice update(CombinationPrice entity) {
        return null;
    }

    @Override
    public CombinationPrice findById(Long aLong) {
        return null;
    }

    @Override
    public Page<CombinationPrice> findAll(Pageable pageable) {
        return (pageable.getPageNumber() == 0) ? new PageImpl<>(combinationPriceRepository.findAll()) : combinationPriceRepository.findAll(pageable);
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public CombinationPrice saveIfNotExist(CombinationPrice entity) {
        return null;
    }

    @Override
    public Long countByCriteriaQueryWithoutParameter() {
        return null;
    }

    @Override
    public Long countByCriteriaQueryGreaterThanOrEqualToDate(Date date) {
        return null;
    }
}
