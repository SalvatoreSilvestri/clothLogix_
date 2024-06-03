package com.fabless.clothlogix.service.Impl;



import com.fabless.clothlogix.Entity.UtenteEntity;
import com.fabless.clothlogix.DAO.UtenteDAO;
import com.fabless.clothlogix.service.AbstractUtenteService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UtenteService implements AbstractUtenteService {

    private UtenteDAO repo;

    @Autowired
    public  UtenteService(UtenteDAO repo){
        this.repo = repo;
    }
    @Autowired
    private UtenteDAO utenteDao;

    @Override
    public UtenteEntity findByUsername(String username) {
        return utenteDao.findByUsername(username);
    }
}
