/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author V&V
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        EntityManager em = em();
        Query query = em.createQuery("select us from UserSkill us where us.id = :userId", UserSkillDaoInter.class);
        query.setParameter("userId", userId);
        em.close();
        return query.getResultList();

    }

    @Override
    public boolean removeUserSkill(int userSkillId) {
        EntityManager em = em();
        UserSkill userskill = em.find(UserSkill.class, userSkillId);

        em.getTransaction().begin();
        em.remove(userskill);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public boolean addUserSkill(UserSkill userskill) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(userskill);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(userSkill);
        em.getTransaction().commit();

        em.close();
        return true;
    }

}
