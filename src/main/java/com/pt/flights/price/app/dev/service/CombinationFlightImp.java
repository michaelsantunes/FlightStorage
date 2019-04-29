package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.interfaces.DBCommonInterface;
import com.pt.flights.price.app.dev.model.CombinationFlight;
import com.pt.flights.price.app.dev.model.CombinationFlight_;
import com.pt.flights.price.app.dev.repository.CombinationFlightRepository;
import com.pt.flights.price.app.dev.job.JobListDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CombinationFlightImp implements DBCommonInterface<CombinationFlight, Long, Date> {

    private final Logger logger = LoggerFactory.getLogger(CombinationFlightImp.class);

    @Autowired
    private CombinationFlightRepository repository;

    @Autowired
    private JobListDate jobByDayImplements;

    @PersistenceContext
    private EntityManager entityManager;

    public CombinationFlightImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public CombinationFlight save(CombinationFlight combinationFlight) {
        return repository.save(combinationFlight);
    }

    @Override
    public CombinationFlight update(CombinationFlight entity) {
        return null;
    }

    @Override
    public CombinationFlight findById(Long aLong) {
        Optional<CombinationFlight> combinationFlight = repository.findById(aLong);
        return ( combinationFlight.isPresent() ) ? combinationFlight.get() : null;
    }

    @Override
    public Page<CombinationFlight> findAll(Pageable pageable) {
        return (pageable.getPageNumber() == 0) ? new PageImpl<>(repository.findAll()) : repository.findAll(pageable);
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
    public CombinationFlight saveIfNotExist(CombinationFlight entity) {
        return null;
    }

    @Override
    @Transactional
    public synchronized Long countByCriteriaQueryGreaterThanOrEqualToDate(Date parameter) throws InterruptedException{
        long rows = 0L;
        try {
            CriteriaBuilder criteriaBuilder   = entityManager.getCriteriaBuilder();
            CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
            criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(CombinationFlight.class)));
            Root<CombinationFlight> root      = criteriaQuery.from(CombinationFlight.class);
            criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(root.get(CombinationFlight_.initialDate), parameter));
            rows = entityManager.createQuery(criteriaQuery).getSingleResult();
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return rows;
    }


    @Override
    @Transactional
    public synchronized Long countByCriteriaQueryWithoutParameter() throws InterruptedException  {
        long rows = 0L;
        try {
            CriteriaQuery<CombinationFlight> criteriaQuery;
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            criteriaQuery                   = criteriaBuilder.createQuery(CombinationFlight.class);
            Root<CombinationFlight> root    = criteriaQuery.from(CombinationFlight.class);
            criteriaQuery.select(root);
            Date value  = new Date();
            criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(root.get(CombinationFlight_.initialDate), value));
            rows   = (long) entityManager.createQuery(criteriaQuery).getResultList().size();
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return rows;
    }

    public List<CombinationFlight> findByDateFirstAndLastEntityByCombinationFlight(Date date) {
        List<CombinationFlight> dateList = new ArrayList<>();
        dateList.add(repository.findFirstOneInitialDateByInitialDateGreaterThanEqualOrderByInitialDate(date));
        dateList.add(repository.findTopFinalDateByFinalDateGreaterThanEqualOrderByFinalDateDesc(date));
        return dateList;
    }

    @Transactional
    public synchronized List<CombinationFlight> findCombinationFlightByInitialAndFinalDate(Date initialDate, Date finalDate) {
        return repository.findByInitialDateGreaterThanEqualAndFinalDateLessThanEqual(initialDate, finalDate);
    }
}