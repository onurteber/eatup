package com.eatup.authserver.service.Impl;

import com.eatup.authserver.entity.UserEntity;
import com.eatup.authserver.model.LoginUserModel;
import com.eatup.authserver.service.EatupCustomRepository;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EatupCustomRepositoryImp implements EatupCustomRepository {

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
