package com.javastudio.shiro.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;

@Singleton
public class EntityManagerProvider {
    @PersistenceContext(unitName = "primary-persistence-unit")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    @Default
    public EntityManager getEntityManager() {
        entityManager.setFlushMode(FlushModeType.COMMIT);
        return entityManager;
    }
}
