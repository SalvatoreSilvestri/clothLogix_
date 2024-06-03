package com.fabless.clothlogix.DAO.impl;
import com.fabless.clothlogix.Entity.UtenteEntity;
import com.fabless.clothlogix.DAO.UtenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class UtenteDAOImpl implements UtenteDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public UtenteEntity findByUsername(String username) {
        String sql = "SELECT u.* FROM utente u JOIN login l ON u.id_login = l.id WHERE l.username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<>(UtenteEntity.class));
    }
}
