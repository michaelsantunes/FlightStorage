package com.pt.flights.price.app.util.others;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class REST<T> {

    public ResponseEntity<List<T>> contentCollection(List<T> listToVerify) {
        if ( listToVerify != null && !listToVerify.isEmpty() )
            return new ResponseEntity<>(listToVerify, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Page<T>> contentPageableCollection(Page<T> page) {
        return (page != null && !page.getContent().isEmpty()) ? new ResponseEntity<>(page, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<T> contentEntity(T entity) {
        return (entity != null) ? new ResponseEntity<>(entity, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
