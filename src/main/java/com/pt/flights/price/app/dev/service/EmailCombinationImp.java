package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.interfaces.DBCommonInterface;
import com.pt.flights.price.app.dev.model.EmailCombination;
import com.pt.flights.price.app.dev.repository.EmailCombinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmailCombinationImp implements DBCommonInterface<EmailCombination, Long, Date> {

    @Autowired
    private EmailCombinationRepository emailPreferenceRepository;

    @Override
    public EmailCombination save(EmailCombination entity) {
        return emailPreferenceRepository.save(entity);
    }

    @Override
    public EmailCombination update(EmailCombination entity) {
        return null;
    }

    @Override
    public EmailCombination findById(Long aLong) {
        return null;
    }

    @Override
    public Page<EmailCombination> findAll(Pageable pageable) {
        return (pageable.getPageNumber() == 0) ? new PageImpl<>(emailPreferenceRepository.findAll()) : emailPreferenceRepository.findAll(pageable);
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) {
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
    public EmailCombination saveIfNotExist(EmailCombination entity) {
        return null;
    }
}
