package DAOpattern;

import db.Connector;
import hotel.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderRepository implements IRepository<Order>{
    private static OrderRepository instance;

    private OrderRepository() {

    }

    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }
        return instance;
    }

    @Override
    public ArrayList<Order> getAll() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "select * from orders";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
            }
            String nameR = rs.getString("roomName");
            String priceR = rs.getString("roomPrice");
            String nameC = rs.getString("customerName");
            String idC = rs.getString("customerID");
            String phoneC = rs.getString("customerPhone");
            Date dateIn = rs.getDate("dateIN");
            Order o = new Order(nameR, priceR, nameC, idC, phoneC, dateIn);
            orders.add(o);
        } catch (Exception e) {

        System.out.println(e.getMessage());
    }
        return orders;
    }

    @Override
    public Boolean create(Order o) {
        try {
            Connection conn = Connector.getInstance().getConn();
            String sql = "insert into orders(roomName,roomPrice,customerName,customerID,customerPhone,dateIN) values(?,?,?,?,?,?)";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,o.getNameRoom());
            stt.setString(2,o.getPriceRoom());
            stt.setString(3,o.getNameCus());
            stt.setString(4,o.getIdCus());
            stt.setString(5,o.getPhoneCus());
            stt.setDate(6,o.getDateIn());
            stt.executeUpdate();
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());

        }
        return false;
    }

    @Override
    public Boolean update(Order o) {
        return null;
    }

    @Override
    public Boolean delete(Order o) {
        return null;
    }

    @Override
    public Order find(Integer id) {
        return null;
    }
}

