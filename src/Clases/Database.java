/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement; 


public class Database {
    private static Database theInstance;
    public static Database instance(){
        if (theInstance==null){ 
            theInstance=new Database();
        }
        return theInstance;
    }
    public static final String PROPERTIES_FILE_NAME="/db.properties";        
    Connection cnx;
    public Database(){
        cnx=this.getConnection();            
    }
    public Connection getConnection(){
        try {
            Properties prop = new Properties();
            URL resourceUrl = getClass().getResource(PROPERTIES_FILE_NAME);
            File file = new File(resourceUrl.toURI());            
            prop.load(new BufferedInputStream(new FileInputStream(file)));
            String driver = prop.getProperty("database_driver");
            String server = prop.getProperty("database_server");
            String port = prop.getProperty("database_port");
            String user = prop.getProperty("database_user");
            String password = prop.getProperty("database_password");
            String database = prop.getProperty("database_name");
            
            String URL_conexion="jdbc:oracle:thin:@"+server+":"+port+":"+
                    database;        
            Class.forName(driver).newInstance();
            return DriverManager.getConnection(URL_conexion,user,password);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        } 
        return null;
    }
    
    public Statement prepareStatement() throws SQLException {
        return  this.cnx.createStatement();  
    }

    public ResultSet executeQuery(Statement statement,String Query) throws SQLException{
        return statement.executeQuery(Query);
     
    } 
    
    public void close() throws SQLException{
        this.cnx.close();
    }
}
