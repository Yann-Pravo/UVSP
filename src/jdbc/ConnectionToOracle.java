package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe qui permet la connection à la base de donnée Oracle
 * @authors Ahardane Abdeslam, Balestrat Clément, Pravossoudovitch Yann
 * @version 1.0
 */
public class ConnectionToOracle{

	/**
	 * URL de connection
	 */
	private static String url = "jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ORA10";
	/**
	 * Nom du user
	 */
	private static String user = "yann.pravossoudovitch";
	/**
	 * Mot de passe du user
	 */
	private static String passwd = "oracle";
	/**
	 * Objet Connection
	 */
	private static Connection connect;

	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return
	 */
	public static Connection getInstance(){
		if(connect == null){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connect = DriverManager.getConnection(url, user, passwd);
                                //System.out.println("Connection effectuée !");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connect;
	}


        public static void main(String[] args) {
            try {
                      Connection con=null;
                      Class.forName("oracle.jdbc.driver.OracleDriver");
                      System.out.println("DRIVER OK ! ");

                      con=DriverManager.getConnection(
                        "jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ORA10",
                        "yann.pravossoudovitch",
                        "oracle");
                      System.out.println("Connection effectuée !");

                      //Création d'un objet Statement
			Statement state = con.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery("SELECT * from user_tables");
			//ResultSetMetaData resultMeta = result.getMetaData();


			System.out.println("Voici les tables presentes");
                        System.out.println("\n----------------------------------------------------");
			while(result.next()){
				System.out.print("\t" + result.getObject(1).toString() + "\t |");

			}
                        System.out.println("\n----------------------------------------------------\n");
          
                      con.close();
                   } catch(Exception e){e.printStackTrace();}
        }

}