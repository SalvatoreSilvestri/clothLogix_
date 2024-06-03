package com.fabless.clothlogix.DAO;
import com.fabless.clothlogix.Entity.LoginEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;
public interface LoginDAO  {
    List<LoginEntity> getListLoing(Map<String, Object> risposta);
    void inserisciLogin(LoginEntity loginEntity, Map<String, Object> risposta );
    void aggiornaLogin(LoginEntity loginEntity, Map<String, Object> risposta );
    void eliminaLogin(Long id, Map<String, Object> risposta );
    Optional<LoginEntity> loginFindById(Long id, Map<String, Object> risposta);

}
