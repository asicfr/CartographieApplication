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

import com.projet.dao.ProduitDao;
import com.projet.model.Produit;
import com.projet.model.Produit;

public class ProduitDaoImpl implements ProduitDao {

	private final String INSERT_SQL = "INSERT INTO PRODUITS(id,titre,prix) values(?,?,?)";
	private final String FETCH_SQL = "select id, titre, prix from produits";
	private final String FETCH_SQL_BY_ID = "select * from produits where id = ?";
	private final String UPDATE_SQL = "UPDATE produits SET id=?, titre=?, prix=?;";
	private final String DELETE_SQL = "DELETE FROM `produits` WHERE id=?;";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Produit create(Produit produit) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, produit.getId());
				ps.setString(2, produit.getTitre());
				ps.setDouble(3, produit.getPrix());
				return ps;
			}
		});
		
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		return jdbcTemplate.query(FETCH_SQL, new ProduitMapper());
	}

	@Override
	public Produit findProduitById(int id) {
		return jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[] { id }, new ProduitMapper());
	}

	@Override
	public void updateProduit(Produit produit) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(UPDATE_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, produit.getId());
				ps.setString(2, produit.getTitre());
				ps.setDouble(3, produit.getPrix());
				return ps;
			}
		});
	}

	@Override
	public void deleteProduit(String id) {
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

class ProduitMapper implements RowMapper<Produit> {

	@Override
	public Produit mapRow(ResultSet rs, int rowNum) throws SQLException {
		Produit produit = new Produit();
		produit.setId(rs.getString("id"));
		produit.setTitre(rs.getString("titre"));
		produit.setPrix(rs.getDouble("prix"));
		return produit;
	}

}
