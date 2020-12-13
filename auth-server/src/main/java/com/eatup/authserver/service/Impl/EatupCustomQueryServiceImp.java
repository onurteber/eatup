package com.eatup.authserver.service.Impl;

import com.eatup.authserver.model.LoginUserModel;
import com.eatup.authserver.service.EatupCustomQueryService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EatupCustomQueryServiceImp implements EatupCustomQueryService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<LoginUserModel> getUserAndRolesByUsername(String username) {
        try {
            List<LoginUserModel> query = em.createNativeQuery("select u.id, u.user_name, u.password, u.active, r.name from users u " +
                    "inner join user_role ur on u.id=ur.user_id inner join roles r on ur.role_id=r.id " +
                    "where u.user_name=:username", LoginUserModel.class)
                    .setParameter("username", username)
                    .getResultList();
            return query;
        } catch (Exception e) {
            throw  e;
        }
    }

}
