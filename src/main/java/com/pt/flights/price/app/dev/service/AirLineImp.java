package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.interfaces.DBCommonInterface;
import com.pt.flights.price.app.dev.model.AirLine;
import com.pt.flights.price.app.dev.model.CombinationFlight;
import com.pt.flights.price.app.dev.repository.AirLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AirLineImp implements DBCommonInterface<AirLine, Long, Date> {

    @Autowired
    AirLineRepository airLineRepository;

    @Override
    public AirLine save(AirLine entity) {
        return airLineRepository.save(entity);
    }

    @Override
    public AirLine update(AirLine entity) {
        return (airLineRepository.existsById(entity.getIdAirLine())) ? airLineRepository.save(entity) : null;
    }

    @Override
    public AirLine findById(Long aLong) {
        Optional<AirLine> airLine = airLineRepository.findById(aLong);
        return ( airLine.isPresent() ) ? airLine.get() : null;
    }

    @Override
    public AirLine saveIfNotExist(AirLine airLine) {
        AirLine verify = airLineRepository.findAirLineByName(airLine.getName());
        if ( verify != null ) {
            return verify;
        } else {
            return save(airLine);
        }
    }

    @Override
    public Page<AirLine> findAll(Pageable pageable) {
        return (pageable.getPageNumber() == 0) ? new PageImpl<>(airLineRepository.findAll()) : airLineRepository.findAll(pageable);
    }


    @Override
    public boolean deleteById(Long aLong) {
        airLineRepository.deleteById(aLong);
        return airLineRepository.existsById(aLong);
    }

    @Override
    public boolean deleteAll() {
        airLineRepository.deleteAll();
        return airLineRepository.findAll().isEmpty();
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
