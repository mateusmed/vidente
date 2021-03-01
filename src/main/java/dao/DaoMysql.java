package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoMysql {

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;


    static String host = "localhost";
    static String port = "3306";
    static String database = "inteligencia";
    static String user = "root";
    static String password = "root";

    public void open() throws Exception{

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/" + database, user, password);
    }

    public void close()throws Exception{
        stmt.close();
        rs.close();
        con.close();
    }

    public static void main(String[] args) {


        DaoMysql d = new DaoMysql();

        try {

            d.open();
            System.out.println("aberto");
            d.close();
            System.out.println("fechado");

        } catch (Exception e) {
            System.out.println("exception");
            e.printStackTrace();
            e.getMessage();
        }

    }


}
