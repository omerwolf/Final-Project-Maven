package DB.DaoImpl;

import DB.Dao.PreviousCropNCreditDao;
import DB.Entites.PreviousCropNCredit;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreviousCropNCreditDaoImpl implements PreviousCropNCreditDao{
    @Override
    public void insert(PreviousCropNCredit previousCropNCredit) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO `previous_crop_n_credit`" +
                    "(`previous_crop_id`," +
                    "`previous_crop_name`," +
                    "`percent`," +
                    "`ncredit`) " +
                    "VALUES (?,?,?,?)");
            preparedStatement.setInt(1, previousCropNCredit.getPreviousCropId());
            preparedStatement.setString(2, previousCropNCredit.getPreviousCropName());
            if (previousCropNCredit.getPercent()!= null) {
                preparedStatement.setInt(3, previousCropNCredit.getPercent());
            }
            else {
                preparedStatement.setNull(3, Types.INTEGER);
            }
            preparedStatement.setInt(4, previousCropNCredit.getnCredit());
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("Insert: " + previousCropNCredit.getPreviousCropName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public PreviousCropNCredit selectById(int id) {
        PreviousCropNCredit previousCropNCredit = new PreviousCropNCredit();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `previous_crop_n_credit` WHERE previous_crop_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                previousCropNCredit.setPreviousCropId(resultSet.getInt("previous_crop_id"));
                previousCropNCredit.setPreviousCropName(resultSet.getString("previous_crop_name"));
                previousCropNCredit.setPercent(resultSet.getInt("percent"));
                previousCropNCredit.setnCredit(resultSet.getInt("ncredit"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return previousCropNCredit;
    }

    @Override
    public List<PreviousCropNCredit> selectAll() {
        List<PreviousCropNCredit> previousCropNCreditList = new ArrayList<PreviousCropNCredit>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `previous_crop_n_credit`");

            while (resultSet.next()) {
                PreviousCropNCredit previousCropNCredit = new PreviousCropNCredit();
                previousCropNCredit.setPreviousCropId(resultSet.getInt("previous_crop_id"));
                previousCropNCredit.setPreviousCropName(resultSet.getString("previous_crop_name"));
                previousCropNCredit.setPercent(resultSet.getInt("percent"));
                previousCropNCredit.setnCredit(resultSet.getInt("ncredit"));
                previousCropNCreditList.add(previousCropNCredit);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return previousCropNCreditList;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `previous_crop_n_credit` WHERE previous_crop_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(PreviousCropNCredit previousCropNCredit, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `previous_crop_n_credit` SET " +
                    "(`previous_crop_id`," +
                    "`previous_crop_name`," +
                    "`percent`," +
                    "`ncredit`) " +
                    "WHERE previous_crop_id = ?");

            preparedStatement.setInt(1, previousCropNCredit.getPreviousCropId());
            preparedStatement.setString(2, previousCropNCredit.getPreviousCropName());
            preparedStatement.setInt(3, previousCropNCredit.getPercent());
            preparedStatement.setInt(4, previousCropNCredit.getnCredit());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int generateUniqueId() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int emptySpace = 1;
        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `previous_crop_n_credit`");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("previous_crop_id") + 1;

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return emptySpace;
    }

    @Override
    public void insertAll(List<PreviousCropNCredit> previousCropNCreditList) {
        //pheonological_stages.sort((pheonological_stage ps1, pheonological_stage ps2) -> ps1.getPheonological_stage_desc().compareTo(ps2.getPheonological_stage_desc()));

        for (PreviousCropNCredit previousCropNCredit : previousCropNCreditList) {
            //previousCropNCredit.setPreviousCropId(this.generateUniqueId());
            this.insert(previousCropNCredit);
            //System.out.println(previousCropNCredit.getPreviousCropId());
        }
        System.out.println("InsertAll finished");
    }

    @Override
    public void autoInsertAll() {
        //desc, crop_id, phenological_days, gdd
        PreviousCropNCredit pcnc1 = new PreviousCropNCredit(1,"Alfalfa (established more than one year)",50,101);
        PreviousCropNCredit pcnc2 = new PreviousCropNCredit(2,"Alfalfa (established more than one year)",75,129);
        PreviousCropNCredit pcnc3 = new PreviousCropNCredit(3,"Alfalfa (established more than one year)",100,157);

        PreviousCropNCredit pcnc4 = new PreviousCropNCredit(4,"Alfalfa, seeding (6-12 monthes after seeding)",50,73);
        PreviousCropNCredit pcnc5 = new PreviousCropNCredit(5,"Alfalfa, seeding (6-12 monthes after seeding)",75,87);
        PreviousCropNCredit pcnc6 = new PreviousCropNCredit(6,"Alfalfa, seeding (6-12 monthes after seeding)",100,101);

        PreviousCropNCredit pcnc7 = new PreviousCropNCredit(7,"Clover (established more than one year)",50,73);
        PreviousCropNCredit pcnc8 = new PreviousCropNCredit(8,"Clover (established more than one year)",75,87);
        PreviousCropNCredit pcnc9 = new PreviousCropNCredit(9,"Clover (established more than one year)",100,101);

        PreviousCropNCredit pcnc10 = new PreviousCropNCredit(10,"Clover, seeding (6-12 monthes after seeding)",50,50);
        PreviousCropNCredit pcnc11 = new PreviousCropNCredit(11,"Clover, seeding (6-12 monthes after seeding)",75,64);
        PreviousCropNCredit pcnc12 = new PreviousCropNCredit(12,"Clover, seeding (6-12 monthes after seeding)",100,78);

        PreviousCropNCredit pcnc13 = new PreviousCropNCredit(13,"Barley+ legume",75,62);
        PreviousCropNCredit pcnc14 = new PreviousCropNCredit(14,"Barley+ legume",100,76);
        PreviousCropNCredit pcnc15 = new PreviousCropNCredit(15,"Barley+ legume",50,90);

        PreviousCropNCredit pcnc16= new PreviousCropNCredit(16,"Oats+ legume",75,62);
        PreviousCropNCredit pcnc17 = new PreviousCropNCredit(17,"Oats+ legume",100,76);
        PreviousCropNCredit pcnc18 = new PreviousCropNCredit(18,"Oats+ legume",50,90);

        PreviousCropNCredit pcnc19 = new PreviousCropNCredit(19,"Wheat+ legume",75,62);
        PreviousCropNCredit pcnc20 = new PreviousCropNCredit(20,"Wheat+ legume",100,76);
        PreviousCropNCredit pcnc21 = new PreviousCropNCredit(21,"Wheat+ legume",50,90);

        PreviousCropNCredit pcnc22 = new PreviousCropNCredit(22,"Clover-grass hay",null,45);
        PreviousCropNCredit pcnc23 = new PreviousCropNCredit(23,"Grass hay",null,45);
        PreviousCropNCredit pcnc24 = new PreviousCropNCredit(24,"Dry edible beans",null,22);
        PreviousCropNCredit pcnc25 = new PreviousCropNCredit(25,"Soybeans",null,34);
        PreviousCropNCredit pcnc26 = new PreviousCropNCredit(26,"CRP land (whether grass/ legume or just grass)",null,45);
        PreviousCropNCredit pcnc27 = new PreviousCropNCredit(27,"Other",null,0);

        List<PreviousCropNCredit> previousCropNCreditList = new ArrayList<>();
        previousCropNCreditList.add(pcnc1);
        previousCropNCreditList.add(pcnc2);
        previousCropNCreditList.add(pcnc3);
        previousCropNCreditList.add(pcnc4);
        previousCropNCreditList.add(pcnc5);
        previousCropNCreditList.add(pcnc6);
        previousCropNCreditList.add(pcnc7);
        previousCropNCreditList.add(pcnc8);
        previousCropNCreditList.add(pcnc9);
        previousCropNCreditList.add(pcnc10);
        previousCropNCreditList.add(pcnc11);
        previousCropNCreditList.add(pcnc12);
        previousCropNCreditList.add(pcnc13);
        previousCropNCreditList.add(pcnc14);
        previousCropNCreditList.add(pcnc15);
        previousCropNCreditList.add(pcnc16);
        previousCropNCreditList.add(pcnc17);
        previousCropNCreditList.add(pcnc18);
        previousCropNCreditList.add(pcnc19);
        previousCropNCreditList.add(pcnc20);
        previousCropNCreditList.add(pcnc21);
        previousCropNCreditList.add(pcnc22);
        previousCropNCreditList.add(pcnc23);
        previousCropNCreditList.add(pcnc24);
        previousCropNCreditList.add(pcnc25);
        previousCropNCreditList.add(pcnc26);
        previousCropNCreditList.add(pcnc27);
        this.insertAll(previousCropNCreditList);
    }
}
