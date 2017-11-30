package com.projet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.projet.dao.ClientDao;
import com.projet.model.Client;

/**
 * @author only2dhir
 *
 */
@Repository
public class ClientDaoImpl implements ClientDao {

	private final String INSERT_SQL = "INSERT INTO CLIENTS(id,nom,prenom,date_naissance,e_mail) values(?,?,?,?,?)";
	private final String FETCH_SQL = "select id, nom, prenom, date_naissance, e_mail from clients";
	private final String FETCH_SQL_BY_ID = "select * from clients where id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Client create(final Client client) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, client.getId());
				ps.setString(2, client.getNom());
				ps.setString(3, client.getPrenom());
				ps.setString(4, client.getDateNaissance());
				ps.setString(5, client.getEmail());
				return ps;
			}
		}, holder);

/*		int newUserId = holder.getKey().intValue();
		user.setId(newUserId);
*/
		return client;
	}

	public List<Client> findAll() {
		return jdbcTemplate.query(FETCH_SQL, new ClientMapper());
	}

	public Client findClientById(String id) {
		return jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[] { id }, new ClientMapper());
	}

}

class ClientMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client = new Client();
		client.setId(rs.getString("record_id"));
		client.setNom(rs.getString("name"));
		client.setPrenom(rs.getString("prenom"));
		client.setDateNaissance(rs.getString("date_naissance"));
		client.setEmail(rs.getString("e_mail"));
		return client;
	}

}
