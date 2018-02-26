package com.projet.dao;


public class ClientDAOFactory {
	
	public static ClientDao getClientDAO()  {
		ClientDao clientDAO=null;
		try {
			clientDAO=(ClientDao) Class.forName("com.projet.dao.impl.ClientDaoImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientDAO; 
	}

}
