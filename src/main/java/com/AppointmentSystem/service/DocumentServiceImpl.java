package com.AppointmentSystem.service;

import com.AppointmentSystem.dao.DocumentDao;
import com.AppointmentSystem.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruzal on 8/24/2017.
 */
@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentDao documentDao;

    public void insert(Document document) {
        documentDao.insert(document);
    }

    public Document viewByIdd(long id) {
        return documentDao.viewByIdd(id);
    }

    public List<String> viewById(long id) {
        return documentDao.viewById(id);
    }

    public List<String> viewByIdForjson(long id){
        List<String> strings= viewById(id);
        List<String> list =new ArrayList<String>();
        for (String s:strings){
            list.add("http://10.10.20.109:8520/resources/image/"+s);
        }
        return list;
    }

    public void deleteById(Long id) {
        documentDao.deleteById(id);
    }

    public void append(Document document) {
        documentDao.append(document);
    }

    public boolean checkId(long id) {
        return documentDao.checkId(id);
    }

    public void updateD(Document documents,long id) {
        documentDao.updateD(documents,id);
    }
}
