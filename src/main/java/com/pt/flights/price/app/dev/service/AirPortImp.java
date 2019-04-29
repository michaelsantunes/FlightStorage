package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.interfaces.DBCommonInterface;
import com.pt.flights.price.app.dev.model.AirPort;
import com.pt.flights.price.app.dev.model.CombinationFlight;
import com.pt.flights.price.app.dev.repository.AirPortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AirPortImp implements DBCommonInterface<AirPort, Long, Date> {

    @Autowired
    AirPortRepository airPortRepository;



    @Override
    public AirPort save(AirPort entity) {
        return null;
    }

    @Override
    public AirPort update(AirPort entity) {
        return null;
    }

    @Override
    public AirPort findById(Long aLong) {
        return airPortRepository.findById(aLong).get();
    }

    @Override
    public Page<AirPort> findAll(Pageable pageable) {
        return (pageable.getPageNumber() == 0) ? new PageImpl<>(airPortRepository.findAll()) : airPortRepository.findAll(pageable);
    }

    public AirPort findIdByIata(String iata) {
        return airPortRepository.findByIata(iata);
    }

    public List<AirPort> findByPersonalPreferenceIsTrue() {
       return airPortRepository.findByPersonalPreferenceIsTrue();
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
    public Long countByCriteriaQueryWithoutParameter() {
        return null;
    }

    @Override
    public Long countByCriteriaQueryGreaterThanOrEqualToDate(Date date) {
        return null;
    }

    @Override
    public AirPort saveIfNotExist(AirPort entity) {
        return null;
    }
}
