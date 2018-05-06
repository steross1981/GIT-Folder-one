/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionModel;

import dataModel.Customer;
import dataModel.Event;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ste
 */
public class EventConnection extends DBConnection {

    ResultSet op;

    public EventConnection(String dbName) {
        this.connectDatabase(dbName);

    }

    public void addEvent(Event ev, Customer cus, String entName, String eventName) {
        try {

            final String stmt01 = "SELECT * FROM coursework.Address WHERE postcode_FK = ? And HouseNumber = ?";
            PreparedStatement ps = getConnection().prepareStatement(stmt01);
            ps.setString(1, cus.getPostcode());
            ps.setInt(2, cus.getNum());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                final String stmt4 = "INSERT INTO coursework.customers (firstNme,LastNam,Email,idAddress_FK) \n"
                        + "VALUES (?, ?, ?,(SELECT idAddress from coursework.Address where Postcode_FK = ?))";
                PreparedStatement pstmt4 = getConnection().prepareStatement(stmt4);
                pstmt4.setString(1, cus.getFirstName());
                pstmt4.setString(2, cus.getLastName());
                pstmt4.setString(3, cus.geteMail());
                pstmt4.setString(4, cus.getPostcode());
                pstmt4.execute();

                final String stmt5 = "SELECT last_insert_id() INTO @CUSID;";
                this.setQuery(stmt5);
                this.runQuery();

                final String stmt7
                        = "INSERT INTO coursework.event (EventName,EventType,Date,customerCharge,idCustomer_FK)\n"
                        + "VALUES (?,?, ?, (Select Fee from coursework.entertainers where Name = ?)+10, (SELECT idCustomer from coursework.customers \n"
                        + "where email = ?))";

                PreparedStatement pstmt7 = getConnection().prepareStatement(stmt7);
                pstmt7.setString(1, ev.getEventName());
                pstmt7.setString(2, ev.getEventType());
                pstmt7.setDate(3, ev.getDate());
                pstmt7.setString(4, entName);
                pstmt7.setString(5, cus.geteMail());

                pstmt7.execute();

                final String stmt11 = "INSERT INTO coursework.engagement (idEvent_FK,EntertainerName_FK) \n"
                        + "VALUES ((Select idEvent FROM coursework.Event WHERE EventName = ? AND idCustomer_FK = ? AND Date = ?),?);";
                PreparedStatement pstmt11 = getConnection().prepareStatement(stmt11);
                pstmt11.setString(1, ev.getEventName());
                pstmt11.setInt(2, ev.getCustomerID());
                pstmt11.setDate(3, ev.getDate());
                pstmt11.setString(4, entName);
                pstmt11.execute();
            } else {

                final String stmt0 = "INSERT INTO \n"
                        + "coursework.Postcode (Postcode, City)\n"
                        + "VALUES (?, ?)";
                PreparedStatement pstmt0 = getConnection().prepareStatement(stmt0);
                pstmt0.setString(1, cus.getPostcode());
                pstmt0.setString(2, cus.getCity());
                pstmt0.execute();

                final String stmt3 = "INSERT INTO \n"
                        + "coursework.Address (HouseNumber, Postcode_FK)\n"
                        + "VALUES (?, ?)";
                PreparedStatement pstmt3 = getConnection().prepareStatement(stmt3);
                pstmt3.setInt(1, cus.getNum());
                pstmt3.setString(2, cus.getPostcode());
                pstmt3.execute();

                final String stmt4 = "INSERT INTO coursework.customers (firstNme,LastNam,Email,idAddress_FK) \n"
                        + "VALUES (?, ?, ?,last_insert_id())";
                PreparedStatement pstmt4 = getConnection().prepareStatement(stmt4);
                pstmt4.setString(1, cus.getFirstName());
                pstmt4.setString(2, cus.getLastName());
                pstmt4.setString(3, cus.geteMail());
                pstmt4.execute();

                final String stmt7
                        = "INSERT INTO coursework.event (EventName,EventType,Date,customerCharge,idCustomer_FK)\n"
                        + "VALUES (?,?, ?, (Select Fee from coursework.entertainers where Name = ?)+10, (SELECT idCustomer from coursework.customers \n"
                        + "where idAddress_FK = (SELECT idAddress from coursework.address \n" + "where HouseNumber  = ? AND Postcode_FK = ?)))";

                PreparedStatement pstmt7 = getConnection().prepareStatement(stmt7);
                pstmt7.setString(1, ev.getEventName());
                pstmt7.setString(2, ev.getEventType());
                pstmt7.setDate(3, ev.getDate());
                pstmt7.setString(4, entName);
                pstmt7.setInt(5, cus.getNum());
                pstmt7.setString(6, cus.getPostcode());

                pstmt7.execute();

                final String stmt11 = "INSERT INTO coursework.engagement (idEvent_FK,EntertainerName_FK) \n"
                        + "VALUES ((Select idEvent FROM coursework.Event WHERE EventName = ?), ? );";
                PreparedStatement pstmt11 = getConnection().prepareStatement(stmt11);
                pstmt11.setString(1, ev.getEventName());
                pstmt11.setString(2, entName);
                pstmt11.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error Creating Event" + ex.toString());
        }
    }

    public void addEventFromExistingCustomer(Event ev, String entNm, String email) {
        try {
            final String stmt
                    = "INSERT INTO coursework.event (EventName,EventType,Date,customerCharge,idCustomer_FK)\n"
                    + "VALUES (?,?, ?, (Select Fee from coursework.entertainers where Name = ?)+10, (SELECT idCustomer from coursework.customers \n"
                    + "where Email = ? ))";

            PreparedStatement pstmt = getConnection().prepareStatement(stmt);
            pstmt.setString(1, ev.getEventName());
            pstmt.setString(2, ev.getEventType());
            pstmt.setDate(3, ev.getDate());
            pstmt.setString(4, entNm);
            pstmt.setString(5, email);

            pstmt.execute();

           final String stmt11 = "INSERT INTO coursework.engagement (idEvent_FK,EntertainerName_FK) \n"
                        + "VALUES ((Select idEvent FROM coursework.Event WHERE EventName = ? AND idCustomer_FK = ? AND Date = ?),?);";
                PreparedStatement pstmt11 = getConnection().prepareStatement(stmt11);
                pstmt11.setString(1, ev.getEventName());
                pstmt11.setInt(2, ev.getCustomerID());
                pstmt11.setDate(3, ev.getDate());
                pstmt11.setString(4, entNm);
                pstmt11.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EventConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewCustomerToDatabase(Customer cus) {

        try {

            final String stmt3 = "INSERT INTO \n"
                    + "coursework.city (City,Postcode)\n"
                    + "VALUES (?, ?, ?)";
            PreparedStatement pstmt3 = getConnection().prepareStatement(stmt3);

            try {
                pstmt3.setString(1, cus.getCity());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please Enter a Value For City");
            }

            try {
                pstmt3.setString(2, cus.getPostcode());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please Enter a Value For Postcode");
            }

            final String stmtA = "INSERT INTO \n"
                    + "coursework.Address (HouseNumber, Postcode_FK)\n"
                    + "VALUES (?, ?)";

            try {
                PreparedStatement pstmtA = getConnection().prepareStatement(stmtA);
                pstmtA.setInt(1, cus.getNum());
                pstmtA.setString(2, cus.getPostcode());
                pstmtA.execute();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please Enter a Value For both HouseNumber and");
            }

            final String stmt4 = "INSERT INTO coursework.customers (firstNme,LastNam,Email,idAddress_FK) \n"
                    + "VALUES (?, ?, ?,last_insert_id())";
            PreparedStatement pstmt4 = getConnection().prepareStatement(stmt4);
            try {
                pstmt4.setString(1, cus.getFirstName());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please Enter a Value For FirstName");
            }
            try {
                pstmt4.setString(2, cus.getLastName());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please Enter a Value For Last Name");
            }
            try {
                pstmt4.setString(3, cus.geteMail());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Please Enter a Value For Email");
            }
            try {
                pstmt4.execute();
            } catch (SQLException ex) {
                Logger.getLogger(EventConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getEventTypes(JComboBox eNam) {
        try {
            String query = "SELECT EventType FROM coursework.Event GROUP BY EventType;";

            this.setQuery(query);
            this.runQuery();
            ResultSet output = this.getResultset();

            while (output.next()) {
                String v = output.getString(1);
                eNam.addItem(v);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error getting Event Types" + ex.toString());
        }
    }

    public void getEventNames(JComboBox ellNam) {
        try {
            String query = "SELECT eventName FROM coursework.event";

            this.setQuery(query);
            this.runQuery();
            ResultSet output = this.getResultset();

            while (output.next()) {
                String r = output.getString(1);
                System.out.println("1");
                ellNam.addItem(r);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error getting Event Names" + ex.toString());
        }
    }

    public void getEngagementCostsForDate(Date date1, Date date2, JTable jTable1) throws SQLException {
        int profit;

        final String stmt1 = "Select Sum(CostofEngagement) AS Cost, date   FROM coursework.engagement "
                + "JOIN coursework.event "
                + "ON engagement.idEvent_FK = idEvent "
                + "Where Date between ? "
                + "AND ?";
        PreparedStatement pstmt1 = getConnection().prepareStatement(stmt1);
        pstmt1.setDate(1, date1);
        pstmt1.setDate(2, date2);
        ResultSet rs = pstmt1.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        jTable1.setVisible(true);

    }

    public void determineProfit(JTable jTable1, JTable jTable3,Date date1, Date date2) {
        try {
            String stmt
                    = "SELECT idcustomer_FK, Date,SUM(Fee)  AS EntertainersFees,\n"
                    + "customerCharge AS CustomerCharge ,\n"
                    + "SUM(FixedFee) AS Profit FROM entertainers as x \n"
                    + "JOIN engagement ON Name = EntertainerName_FK\n"
                    + "JOIN event ON idEvent_FK = idEvent \n"
                    + "WHERE event.Date BETWEEN ? AND ? \n"
                    + "group by customercharge\n"
                    + "\n"
                    + " ";
            PreparedStatement pstmt = getConnection().prepareStatement(stmt);
            pstmt.setDate(1, date1);
            pstmt.setDate(2, date2);
            ResultSet rs = pstmt.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            jTable1.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(EventConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
                try {
            String query = "SELECT SUM(Profit) as OverallProfitForPeriod FROM(\n" +
"SELECT idcustomer_FK, Date,SUM(Fee)  AS EntertainersFees,\n" +
"customerCharge AS CustomerCharge ,\n" +
"SUM(FixedFee) AS Profit FROM entertainers \n" +
"JOIN engagement ON Name = EntertainerName_FK\n" +
"JOIN event ON idEvent_FK = idEvent \n" +
"WHERE event.Date BETWEEN ? AND ?\n" +
"group by customercharge) as x ";
           
            PreparedStatement pnot = getConnection().prepareStatement(query);
             pnot.setDate(1, date1);
            pnot.setDate(2, date2);

            ResultSet nut = pnot.executeQuery();

            jTable3.setModel(DbUtils.resultSetToTableModel(nut));

            jTable3.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void countEventTypesByDate(String evType, JTable jTable2, Date date1, Date date2) {

        try {
            String query = "SELECT Date, EventType, COUNT(EventType)\n"
                    + " FROM coursework.event\n"
                    + " WHERE EventType =  ?  AND  Date between ? \n"
                    + "AND ?  ORDER BY Date desc";
            PreparedStatement pot = getConnection().prepareStatement(query);
            pot.setString(1, evType);
            pot.setDate(2, date1);
            pot.setDate(3, date2);
            ResultSet num = pot.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(num));
            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void countEventTypes(String evttType, JTable jTable2) {

        try {
            String query = "SELECT EventType, COUNT(EventType)\n"
                    + " FROM coursework.event\n"
                    + " WHERE EventType =  ?";
            PreparedStatement pot = getConnection().prepareStatement(query);
            pot.setString(1, evttType);

            ResultSet num = pot.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(num));
            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showEventTypePopularity(JTable jTable2, Date te1, Date te2) {

        try {
            String query = "Select EventType, count(*) AS NumberOFBookings  from coursework.event\n"
                    + "WHERE  Date between ? \n"
                    + "AND ?\n"
                    + "group by count(*)\n"
                    + "order by count(*) desc";
            PreparedStatement pot = getConnection().prepareStatement(query);

            pot.setDate(1, te1);
            pot.setDate(2, te2);
            ResultSet nut = pot.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(nut));
            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showMostPopularEventType(JTable jTable2, Date te1, Date te2) {
        try {
            String query = "SELECT EventType, MAX(x.NumberOfBookings) AS MostPopularEventType FROM(\n"
                    + "Select EventType, count(*) AS NumberOFBookings  from coursework.event\n"
                    + "WHERE  Date between ? AND ?\n"
                    + "GROUP BY EventType\n"
                    + "ORDER BY count(*) desc) AS x;";
            PreparedStatement pot = getConnection().prepareStatement(query);

            pot.setDate(1, te1);
            pot.setDate(2, te2);
            ResultSet nut = pot.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(nut));
            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showLeastPopularEventType(JTable jTable2, Date te1, Date te2) {
        try {
            String query = "SELECT EventType, MIN(y.NumberOfBookings) AS MostPopularEventType FROM(\n"
                    + "Select EventType, count(*) AS NumberOFBookings  from coursework.event\n"
                    + "WHERE  Date between ? AND ?\n"
                    + "GROUP BY EventType\n"
                    + "ORDER BY count(*) desc) AS y;";
            PreparedStatement pot = getConnection().prepareStatement(query);

            pot.setDate(1, te1);
            pot.setDate(2, te2);
            ResultSet nut = pot.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(nut));
            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showAllCustomers(JTable jTable) {
        String query = "Select concat(firstNme,\" \",LastNam)as CustomerNames, Email FROM coursework.customers ;";
        this.setQuery(query);
        this.runQuery();
        ResultSet output = this.getResultset();
        jTable.setModel(DbUtils.resultSetToTableModel(output));
        jTable.setVisible(true);
    }

    public void showCustomerInvoice(JTable jTable2,  String evhhName) {

        try {
            String query = "SELECT idEvent EventID, EventName, idCustomer CustomerID, CONCAT(FirstNme, \" \", LastNam) CustomerName, Date, EventType, SUM(Fee) EntertainersFee,SUM(FixedFee) OurFee, customerCharge OverallCharge\n"
                    + "FROM (( coursework.customers  \n"
                    + "INNER JOIN coursework.event  ON idCustomer_FK = idCustomer\n"
                    + "INNER JOIN coursework.engagement ON idEvent_FK = idEvent\n"
                    + "INNER JOIN coursework.entertainers ON EntertainerName_FK = Name\n"
                    + ")) WHERE EventName = ?\n";
           
            PreparedStatement pnot = getConnection().prepareStatement(query);
            pnot.setString(1, evhhName);

            ResultSet ut = pnot.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(ut));

            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCustomerEmails(JComboBox jc) {
        {
            try {
                String query = "SELECT Email FROM coursework.customers";
                this.setQuery(query);
                this.runQuery();
                ResultSet nt = this.getResultset();

                while (nt.next()) {
                    String r = nt.getString(1);
                    System.out.println("1");
                    jc.addItem(r);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void showCustomerNamesToCombo(JComboBox jc) {
        {
            try {
                String query = "SELECT CONCAT(firstNme, \" \" , LastNam)  FROM coursework.customers";
                this.setQuery(query);
                this.runQuery();
                ResultSet nt = this.getResultset();

                while (nt.next()) {
                    String r = nt.getString(1);
                    System.out.println("1");
                    jc.addItem(r);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void showCustomersByLoyalty(JTable jTable) {
        String query = "SELECT \n"
                + "    CONCAT(firstNme, ' ', LastNam) AS CusNames,\n"
                + "    COUNT(idCustomer_FK) AS NumberOfBookings\n"
                + "FROM\n"
                + "    coursework.customers\n"
                + "        JOIN\n"
                + "    coursework.event ON idCustomer_FK = idCustomer\n"
                + "GROUP BY CusNames\n"
                + "ORDER BY COUNT(idCustomer_FK) DESC";
        this.setQuery(query);
        this.runQuery();
        ResultSet output = this.getResultset();
        jTable.setModel(DbUtils.resultSetToTableModel(output));
        jTable.setVisible(true);

    }

    public void showCustomerNames(JTable jTable) {
        String query = "SELECT \n"
                + "    CONCAT(firstNme, ' ', LastNam) AS Customers From coursework.customers";

        this.setQuery(query);
        this.runQuery();
        ResultSet output = this.getResultset();
        jTable.setModel(DbUtils.resultSetToTableModel(output));
        jTable.setVisible(true);
    }

    public void showCustomerWithAddresses(JTable jTable) {
        String query = "SELECT CONCAT(firstNme,\" \",LastNam) as CustomerName, Email, HouseNumber, City, Postcode  FROM coursework.customers\n"
                + "JOIN coursework.address on idAddress = idAddress_FK "
                + "JOIN coursework.postcode on postcode = postcode_FK";
         

        this.setQuery(query);
        this.runQuery();
        ResultSet output = this.getResultset();
        jTable.setModel(DbUtils.resultSetToTableModel(output));
        jTable.setVisible(true);
    }

    public ResultSet getDatesOfEntertainerEngagement(String entName, Date date1) {
        try {
            String query = "SELECT Name from coursework.entertainers\n"
                    + "join coursework.engagement on EntertainerName_FK = Name\n"
                    + "join coursework.event on idEvent = idEvent_FK WHERE name = ? AND  Date =?";

            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, entName);
            pstmt.setDate(2, date1);
            System.out.println("eeee");
            ResultSet output = pstmt.executeQuery();
            String o = output.toString();
            System.out.println(o);

            op = output;

        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return op;
    }
}
