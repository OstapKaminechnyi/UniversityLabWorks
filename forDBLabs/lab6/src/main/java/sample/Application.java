package sample;

import java.sql.*;
import java.util.Scanner;

public class Application {
    private static final String url = "jdbc:mysql://localhost:3306/mobilestore?serverTimezone=UTC&useSSL=false";
    private static final String user = "ostapkmn";
    private static final String password = "password";

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet rs = null;

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, user, password);

            statement = connection.createStatement();
            Scanner input = new Scanner(System.in);

            int x = 10000;
            while (x != 0) {
                System.out.println("Enter 1-readData(),\n 2 -insertDataMobile()," +
                        "\n 3 - deleteDataMobile(),\n 4 - updateDataMobile(),\n 0 - exit");
                x = input.nextInt();
                switch (x) {
                    case 1: {
                        readData();
                        break;
                    }
                    case 2: {
                        insertDataStore();
                        break;
                    }
                    case 3: {
                        deleteDataStore();
                        break;
                    }
                    case 4: {
                        updateDataStore();
                        break;
                    }
                }
            }


        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver is not loaded");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        } finally {
            //close connection ,statement and resultset
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            } // ignore

            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    private static void readData() throws SQLException {

        rs = statement.executeQuery(" SELECT * FROM mobile");

        System.out.format("%16s", "Table Mobile\n");
        String[] table = {"id", "catery", "mark", "colour", "v_number", "specifics", "image", "cpu_id"};
        for (String i : table) {
            System.out.format("%16s", i);
        }
        System.out.println();
        // 4. Process the result set4d
        while (rs.next()) {
            int id = rs.getInt(table[0]);
            String catery = rs.getString(table[1]);
            String mark = rs.getString(table[2]);
            String color = rs.getString(table[3]);
            String v_number = rs.getString(table[4]);
            String specifics = rs.getString(table[5]);
            String image = rs.getString(table[6]);
            String cpu_id = rs.getString(table[7]);
            // Simplmy Print the results
            System.out.format("%16s%16s%16s%16s%16s%16s%16s%16s\n", id, catery, mark, color,
                    v_number, specifics, image, cpu_id);
        }

        rs = statement.executeQuery("SELECT * FROM cpu");
        System.out.format("%16s", "Table Cpu\n");
        table = new String[]{"ID", "Volume", "prod_year", "Fee"};
        for (String i : table) {
            System.out.format("%16s", i);
        }

        System.out.println();

        while (rs.next()) {
            int id = rs.getInt(table[0]);
            String name = rs.getString(table[1]);
            String address = rs.getString(table[2]);
            int phone_number = rs.getInt(table[3]);

            System.out.format("%16s%16s%16s%16s\n", id, name, address, phone_number);
        }

        rs = statement.executeQuery("SELECT * FROM customer");
        System.out.format("%16s", "Table Customer\n");
        table = new String[]
                {
                        "ID", "SNM", "birth_day", "adress", "number"
                };
        for (String i : table) {
            System.out.format("%16s", i);
        }
        System.out.println();

        while (rs.next()) {
            int id = rs.getInt(table[0]);
            String snm = rs.getString(table[1]);
            Date birth_date = rs.getDate(table[2]);
            String adress = rs.getString(table[3]);
            String number = rs.getString(table[4]);
            System.out.format("%16s%16s%16s%16s%16s\n", id, snm, birth_date, adress, number);
        }

        rs = statement.executeQuery("SELECT * FROM ownership");
        System.out.format("%16s", "Table Ownership\n");
        table = new String[]

                {
                        "ID", "owner_id", "mobile_id"
                }

        ;
        for (
                String i : table) {
            System.out.format("%16s", i);
        }
        System.out.println();

        while (rs.next()) {
            int id = rs.getInt(table[0]);
            int owner_id = rs.getInt(table[1]);
            int mobile_id = rs.getInt(table[2]);

            System.out.format("%16s%16s%16s\n", id, owner_id, mobile_id);
        }}


        private static void updateDataStore () throws SQLException {
            Scanner input = new Scanner(System.in);
            System.out.println("Input id  of mobile what you want to update: ");
            Integer id_mobile = input.nextInt();
            System.out.println("Input new catery of artist for %s: "+ id_mobile);
            String catery_new = input.next();


            statement.execute("UPDATE mobile SET catery='"+catery_new+"' WHERE id='"+id_mobile+"';");


        }

        private static void insertDataStore () throws SQLException {
            Scanner input = new Scanner(System.in);
            System.out.println("Input a new mobile: ");
            String newMobile_catery = input.next();
            String newMobile_mark = input.next();
            String newMobile_colour = input.next();
            String newMobile_v_number = input.next();
            String newMobile_specifics = input.next();
            String newMobile_image = input.next();
            int cpu_id = input.nextInt();


            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("INSERT INTO mobile(catery," +
                    " mark, colour,v_number,specifics,image, cpu_id) VALUES (?,?,?,?,?,?,?)");

            preparedStatement.setString(1, newMobile_catery);
            preparedStatement.setString(2, newMobile_mark);
            preparedStatement.setString(3, newMobile_colour);
            preparedStatement.setString(4, newMobile_v_number);
            preparedStatement.setString(5, newMobile_specifics);
            preparedStatement.setString(6, newMobile_image);
            preparedStatement.setInt(7, cpu_id);

            int n = preparedStatement.executeUpdate();
            System.out.println("Count rows that inserted: " + n);

        }

        private static void deleteDataStore () throws SQLException {
            Scanner input = new Scanner(System.in);
            System.out.println("Input id of artists for delete: ");
            Integer mobile = input.nextInt();

            // 3. executing SELECT query
            //   PreparedStatements can use variables and are more efficient
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM mobile WHERE id=?");
            preparedStatement.setInt(1, mobile);
            int n = preparedStatement.executeUpdate();
            System.out.println("Count rows that deleted: " + n);
        }



    }