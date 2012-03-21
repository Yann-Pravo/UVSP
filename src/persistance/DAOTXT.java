package persistance;



import java.util.ArrayList;


public abstract class DAOTXT<T> {


	public abstract boolean create(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract boolean update(T ancien, T nouveau);
	
	public abstract T find(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract ArrayList<T> getListe();
	
	public abstract boolean login(T obj);


}