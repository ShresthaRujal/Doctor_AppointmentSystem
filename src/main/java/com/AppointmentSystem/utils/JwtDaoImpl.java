package com.AppointmentSystem.utils;

import com.AppointmentSystem.model.Doctor;
import com.AppointmentSystem.model.Patient;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Created by Ruzal on 8/26/2017.
 */
@Repository
public class JwtDaoImpl implements JwtDao {

    private String generatedToken=null;
    public String createJWT(Patient patient) {


        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Date date = new Date();
        System.out.println(date);
        long t = date.getTime();
        Date expirationTime = new Date(t + 1836 * 1000);
        System.out.println(expirationTime);

        byte[] apiKeySecrete = DatatypeConverter.parseBase64Binary("*AppointmentManagement#");
        Key signingKey = new SecretKeySpec(apiKeySecrete, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setId(String.valueOf(patient.getId()))
                .setIssuedAt(now)
                .setSubject(patient.getName())
                .setIssuer(patient.getEmail())
                .setExpiration(expirationTime)
                .signWith(signatureAlgorithm, signingKey);
        generatedToken = builder.compact();
        System.out.println(generatedToken);
        return generatedToken;
    }

    public Patient verifyToken(String token) {

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary("*AppointmentManagement#"))
                    .parseClaimsJws(token).getBody();
            Patient patient= new Patient();
            System.out.println(claims.getSubject());
            System.out.println(claims.getIssuer());
            patient.setName(claims.getSubject().toUpperCase());
            patient.setEmail(claims.getIssuer());
            return patient;
        }catch (Exception e ){
            e.getMessage();
            return null;
        }
    }

    public String createJWT(Doctor doctor) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Date date = new Date();
        System.out.println(date);
        long t = date.getTime();
        Date expirationTime = new Date(t + 1836 * 1000);
        System.out.println(expirationTime);

        byte[] apiKeySecrete = DatatypeConverter.parseBase64Binary("*AppointmentManagement#");
        Key signingKey = new SecretKeySpec(apiKeySecrete, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setId(String.valueOf(doctor.getDid()))
                .setIssuedAt(now)
                .setSubject(doctor.getDname())
                .setIssuer(doctor.getDphone())
                .setExpiration(expirationTime)
                .signWith(signatureAlgorithm, signingKey);
        generatedToken = builder.compact();
        System.out.println(generatedToken);
        return generatedToken;
    }

    public boolean verifyToken(String token, Doctor doctor) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary("*AppointmentManagement#"))
                    .parseClaimsJws(token).getBody();
            System.out.println(doctor.getDname());
            System.out.println(claims.getSubject());
            if (doctor.getDname().equals(claims.getSubject()) && doctor.getDid()==Integer.parseInt(claims.getId())) {
                System.out.println("true");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("false");
            return false;
        }
//        System.out.println(patient.getName());
//        System.out.println(claims.getSubject());
//        if (patient.getName().equals(claims.getSubject()) && patient.getEmail().equals(claims.getIssuer())) {
//            System.out.println("true");
//            return true;
//        } else {
//            System.out.println("false");
//            return false;
//        }
//    }
        return false;
    }
}