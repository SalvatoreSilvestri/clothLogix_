package com.fabless.clothlogix.DAO.impl;
import com.fabless.clothlogix.Entity.ProfiloEntity;
import com.fabless.clothlogix.DAO.ProfiloDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class ProfiloDAOImpl implements ProfiloDAO {
        @Autowired
        private JdbcTemplate jdbcTemplate;
        @Override
        public ProfiloEntity findById(Long id) {
            String sql = "SELECT * FROM profili WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(ProfiloEntity.class));
        }
        @Override
        public List<ProfiloEntity> findAll() {
            String sql = "SELECT * FROM profili";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfiloEntity.class));
        }
        @Override
        public void update(ProfiloEntity profilo) {
            String sql = "UPDATE profili SET descrizione = ?, can_create = ?, can_read = ?, can_update = ?, can_delete = ? WHERE id = ?";
            jdbcTemplate.update(sql, profilo.getDescrizione(), profilo.getCanCreate(), profilo.getCanRead(), profilo.getCanUpdate(), profilo.getCanDelete(), profilo.getId());
        }
}
