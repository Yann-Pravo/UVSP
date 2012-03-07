package persistance;

import java.sql.Connection;
import java.util.ArrayList;
import jdbc.ConnectionToOracle;

public abstract class DAO<T> {

	public Connection connect = ConnectionToOracle.getInstance();

	public abstract boolean create(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract boolean update(T ancien, T nouveau);
	
	public abstract T find(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract ArrayList<T> getListe();
}