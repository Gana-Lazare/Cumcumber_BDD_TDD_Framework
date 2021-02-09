package Utility;
import common.WebAPI;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectToDB extends WebAPI {
    public static Connection connection=null;
    public static Statement statement=null;
    public static ResultSet resultSet=null;
    public Properties loadPropreties() throws IOException {
        File file = new File("C:\\Users\\micromedia\\IdeaProjects\\SeleniumFrameWorkGana\\Generic\\src\\main\\java\\Utility\\secret.propreties");
        FileInputStream fis = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fis);
        return properties;
    }

    public  Connection connectToDb() throws Exception{
       Properties properties = loadPropreties();
        String driverClass = properties.getProperty("MYSQLJDBC.driver");
        String url = properties.getProperty("MYSQLJDBC.url");
        String user = properties.getProperty("MYSQLJDBC.userName");
        String password = properties.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connection=DriverManager.getConnection(url,user,password);
        if (connection!=null) System.out.println("Connected to DataBase SQL");
        else System.out.println("Try TO Connect to DB");
        return connection;
    }

    public List<String> readDataFromDB(String tableName,String columnName){
        List<String> data =new ArrayList<>();
        try {
            connectToDb();
            statement=connection.createStatement();
            resultSet = statement.executeQuery("select * from "+tableName);
data = getResultSetData(columnName);
        }
        catch (Exception e){ e.getStackTrace();
        e.getMessage();
          //  System.out.println("Error DB");
        }
        return data;
    }
    public List<String> getResultSetData(String ColumnName) throws SQLException {
        List<String> data= new ArrayList<>();
        while(resultSet.next()){
            String itemName = resultSet.getString(ColumnName);
            data.add(itemName);
        }
        return  data;
    }

}
