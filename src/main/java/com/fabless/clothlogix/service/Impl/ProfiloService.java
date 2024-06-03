package com.fabless.clothlogix.service.Impl;



import com.fabless.clothlogix.Entity.ProfiloEntity;
import com.fabless.clothlogix.DAO.ProfiloDAO;
import com.fabless.clothlogix.service.AbstractProfiloService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProfiloService implements AbstractProfiloService {

    @Autowired
    private ProfiloDAO profiliDao;

    @Override
    public ProfiloEntity findById(Long id) {
        return profiliDao.findById(id);
    }

    @Override
    public List<ProfiloEntity> findAll() {
        return profiliDao.findAll();
    }


    @Override
    public void update(ProfiloEntity profilo) {
        profiliDao.update(profilo);
    }

}
