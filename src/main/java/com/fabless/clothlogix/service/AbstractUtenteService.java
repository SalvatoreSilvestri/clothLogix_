package com.fabless.clothlogix.service;




import com.fabless.clothlogix.Entity.UtenteEntity;
import org.hibernate.exception.DataException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AbstractUtenteService {

    UtenteEntity findByUsername(String username);
}
