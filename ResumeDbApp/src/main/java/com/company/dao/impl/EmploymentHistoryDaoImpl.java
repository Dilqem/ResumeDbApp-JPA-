/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author V&V
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        EntityManager em = em();
        Query query = em.createQuery("select eh from EmploymentHistory eh where eh.id =:userId", EmploymentHistory.class);
        query.setParameter("userId", userId);
        List<EmploymentHistory> ehList = query.getResultList();
        em.close();
        return ehList;
    }
    
}
