package com.AppointmentSystem.dao;

import com.AppointmentSystem.model.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Ruzal on 8/24/2017.
 */
@Repository
public class DocumentDaoImpl extends AbstractDao<Long,Document> implements DocumentDao {
    public void insert(Document document) {
        persist(document);
    }

    public Document viewByIdd(long id){
        System.out.println("view by id");
        Document document= (Document) getEntityManager()
                .createQuery("SELECT d FROM Document d WHERE d.id=:id")
                .setParameter("id", id)
                .getSingleResult();
        return document;
    }

    public List<String> viewById(long id) {
        Document document=viewByIdd(id);
        System.out.println(document.toString());

        List<String> imageStr=new ArrayList<String>();
        if (document.getDocuemnt()==null) {
            System.out.println("document doesnot contain any image.");
            imageStr=null;
        }else {
            StringTokenizer t = new StringTokenizer(document.getDocuemnt());
            String word = "";
            while (t.hasMoreTokens()) {
                word = t.nextToken();
                imageStr.add(word);
            }
        }
        return imageStr;
    }

    public void deleteById(Long id) {
        Document document= (Document) entityManager.createQuery("select d from Document d where d.id=:id").setParameter("id",id)
                .getSingleResult();
        delete(document);
    }

    public void append(Document document) {

    }


    public boolean checkId(long id) {
        System.out.println("checking");
        Document document= (Document) entityManager.createQuery("select d from Document d where d.id=:id").setParameter("id",id)
                .getSingleResult();
        if (document.getDocuemnt()==null){
            System.out.println("true");
            return true;
        }else {
            System.out.println("false");
            return false;
        }
    }

    public void updateD(Document documents,long id) {
        System.out.println("updating");
        Document document=viewByIdd(id);
        String imgstr=document.getDocuemnt();
        if (imgstr==null){
            update(documents);
        }else {
            String imgstr2 = documents.getDocuemnt();
            System.out.println("image String" + imgstr + imgstr2);
            String img = imgstr + imgstr2;
            documents.setDocuemnt(img);
            update(documents);
        }
    }
}
