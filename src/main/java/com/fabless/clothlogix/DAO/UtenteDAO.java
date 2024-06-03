package com.fabless.clothlogix.DAO;
import com.fabless.clothlogix.Entity.UtenteEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;
public interface UtenteDAO {
    UtenteEntity findByUsername(String username);
}
