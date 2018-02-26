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
import org.springframework.stereotype.Repository;

import com.projet.dao.CommandeDao;
import com.projet.model.Commande;

@Repository
public class CommandeDaoImpl implements CommandeDao{

	private final String INSERT_SQL = "INSERT INTO COMMANDES(id,client_id,produit_id,date_commande) values(?,?,?,?)";
	private final String FETCH_SQL = "select id, client_id, produit_id, date_commande from commandes";
	private final String FETCH_SQL_BY_ID = "select * from commandes where id = ?";
	private final String UPDATE_SQL = "UPDATE commandes SET client_id=?, produit_id=?, date_commande=? WHERE id=?;";
	private final String DELETE_SQL = "DELETE FROM `commandes` WHERE id=?;";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Commande create(Commande commande) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, commande.getId());
				ps.setInt(2, commande.getClientId());
				ps.setString(3, commande.getProduitId());
				ps.setString(4, commande.getDateCommande());
				return ps;
			}
		});
		
		return commande;
	}

	@Override
	public List<Commande> findAll() {
		return jdbcTemplate.query(FETCH_SQL, new CommandeMapper());
	}

	@Override
	public Commande findCommandeById(String id) {
		return jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[] { id }, new CommandeMapper());
	}

	@Override
	public void updateCommande(Commande commande) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, commande.getClientId());
				ps.setString(2, commande.getProduitId());
				ps.setString(3, commande.getDateCommande());
				ps.setString(4,  commande.getDateCommande());
				return ps;
			}
		});
	}

	@Override
	public void deleteCommande(String id) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(DELETE_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, id);
				return ps;
			}
		});		
	}

}

class CommandeMapper implements RowMapper<Commande> {

	@Override
	public Commande mapRow(ResultSet rs, int rowNum) throws SQLException {
		Commande commande = new Commande();
		commande.setId(rs.getString("id"));
		commande.setClientId(rs.getInt("client_id"));
		commande.setProduitId(rs.getString("produit_id"));
		commande.setDateCommande(rs.getString("date_commande"));
		return commande;
	}

}