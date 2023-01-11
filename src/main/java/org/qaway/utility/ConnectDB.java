package org.qaway.utility;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectDB {

    // pour lire dans une base de données, on a besoin d'une dependency "mysql"
    MongoDatabase mongoDatabase = null;
    public Connection connection = null; // objet de la connexion
    Statement statement = null;
    ResultSet resultSet = null;

    public ConnectDB() throws ClassNotFoundException {
    }

    public Connection connectToMySql() throws ClassNotFoundException, SQLException {
        Properties prop = Utility.loadProperties();
        String driverClass = prop.getProperty("MYSQLJDBC.driver"); // driver c'est une propertie de my sql,
        // pour donner son existance pour my sql je dois lui donner le nom "driver Class
        String url = prop.getProperty("MYSQLJDBC.url");
        String username = Utility.decode(prop.getProperty("MYSQLJDBC.username")); // décoder
        String password = Utility.decode(prop.getProperty("MYSQLJDBC.password")); // décoder
//        Class.forName(driverClass);
//        connection = DriverManager.getConnection(url, username, password);
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(url, username, password); // récupérer DriverManager...
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("database is connected");
        return connection;
    }

    // comment se connecter à ma base
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ConnectDB connectDB = new ConnectDB();
//        Statement statement = connectDB.connectToMySql().createStatement();
        // une fois la connexion établie
//        ResultSet rs = statement.executeQuery("select * from cred");
//        while (rs.next()){ // on récupère soit une valeur ou plusieurs
//           System.out.println(rs.getString("username")); // je récupère la colonne que je veux
//        }
        // si mon tableau a plusieurs données
//        ResultSet rs = statement.executeQuery("select * from items");
//        List<String> list = new ArrayList<>();
//        while (rs.next()){
//            list.add(rs.getString("username"));
//            list.add(rs.getString("items"));
//        }
//        System.out.println(list);
//        connectDB.connectToMySql().close();
        // avant que j'utilise ma base de données faut que je la démmare sur términal
        /*
        mysql.server start
        mysql -u root –p
        show databases
        uqe myDB
        show tables
        select * from crad

         */
//    }

    public MongoDatabase connectToMongoDB(String dbName) { // MongoDtabase elle n'a pas besoin de paramètres
        MongoClient mongoClient = new MongoClient();
        mongoDatabase = mongoClient.getDatabase(dbName);
        System.out.println("Database Connected");
        return mongoDatabase;
    }

    public List<String> getTableColumnData(String query, String columnName) throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        try {
            statement = connectToMySql().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                list.add(resultSet.getString(columnName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
