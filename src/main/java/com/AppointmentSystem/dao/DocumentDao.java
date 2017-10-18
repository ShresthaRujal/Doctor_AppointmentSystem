package com.AppointmentSystem.dao;

import com.AppointmentSystem.model.Document;

import java.util.List;

/**
 * Created by Ruzal on 8/24/2017.
 */
public interface DocumentDao {
    void insert(Document document);
    Document viewByIdd(long id);
    List<String> viewById(long id);
    void deleteById(Long id);
    void append(Document document);

    boolean checkId(long id);

    void updateD(Document documents,long id);
}
