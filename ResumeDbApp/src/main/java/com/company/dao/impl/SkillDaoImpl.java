/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.Skill;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author V&V
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getAllSkill() {
        EntityManager em = em();
        Query query = em.createQuery("select s from Skill s", Skill.class);
        List<Skill> skillList = query.getResultList();
        em.close();
        return skillList;
    }

    @Override
    public boolean removeUserSkill(int skillId) {
        EntityManager em = em();
        Skill skill = em.find(Skill.class, skillId);
        em.getTransaction().begin();
        em.remove(skill);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        EntityManager em =em();
        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
