package co.edu.poli.ces3.universitas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql {

    private int port;
    private String host;
    private String user;
    private String password;
    private String dataBaseName;
    public static final long SERIAL = 1L;

    ConexionMySql(String host){
        user = "root";
        password = "";
        this.host= host != null ? host : "127.0.0.1";
        this.dataBaseName = "ces3-universitas";
    }


    public void disconect(){
    }
    public Connection conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection( "jdbc:mysql://" +host+":"+port+"/"+ dataBaseName, user, password)
        }catch (ClassNotFoundException | SQLException exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public static int sum(int a, int b){
        return a + b;
    }
    public static void main(String[] args) {

        ConexionMySql con = new ConexionMySql();

        System.out.println("la suma es " + ConexionMySql.sum(3,4));
        System.out.println(ConexionMySql.SERIAL);
        System.out.println("Hello Conection MySQL");
    }


}