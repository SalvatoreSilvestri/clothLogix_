package com.fabless.clothlogix.DAO;







import com.fabless.clothlogix.Entity.MagazzinoEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface MagazzinoDAO {

    List<MagazzinoEntity> getListMagazzino(Map<String, Object> risposta);

    void inserisciMagazzino(MagazzinoEntity magazzinoEntity, Map<String, Object> risposta );

    void aggiornaMagazzino(MagazzinoEntity magazzinoEntity, Map<String, Object> risposta );

    void eliminaMagazzino(Long id, Map<String, Object> risposta );

    Optional<MagazzinoEntity> magazzinoFindById(Long id, Map<String, Object> risposta);
}
