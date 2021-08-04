/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author V&V
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    @Override
    public List<Country> getAllCountry() {
        EntityManager em = em();
        Query query = em.createQuery("select c from Country c", Country.class);
        em.close();
        return query.getResultList();
    }

}
