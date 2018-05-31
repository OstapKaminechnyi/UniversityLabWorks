package com.persistance.dao;

import com.filmstudio.Worker;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;


@Named
@Dependent
public class WorkerDaoImpl extends AbstractDao<Worker> implements WorkerDao, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Worker> getEntityClass() {
        return Worker.class;
    }

    //@Resource
    //private UserTransaction userTransaction;
    


}
