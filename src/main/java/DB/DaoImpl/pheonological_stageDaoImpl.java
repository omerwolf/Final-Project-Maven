package DB.DaoImpl;

import DB.Dao.pheonological_stageDao;
import DB.Entites.pheonological_stage;
import DB.Util.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class pheonological_stageDaoImpl implements pheonological_stageDao{
    @Override
    public void insert(pheonological_stage pheonological_stage) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
            preparedStatement = connection.prepareStatement("INSERT INTO `pheonological stage`" +
                    "(`pheonological_stage_id`," +
                    "`pheonological stage_desc`," +
                    "`crop_id`," +
                    "`pheonological_stage_duration_days`," +
                    "`pheonological_stage_duration_gdd`) " +
                    "VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, pheonological_stage.getPheonological_stage_id());
            preparedStatement.setString(2, pheonological_stage.getPheonological_stage_desc());
            preparedStatement.setInt(3, pheonological_stage.getCrop_id());
            preparedStatement.setInt(4, pheonological_stage.getPheonological_stage_duration_days());
            if (pheonological_stage.getPheonological_stage_duration_gdd()!= null) {
                preparedStatement.setInt(5, pheonological_stage.getPheonological_stage_duration_gdd());
            }
            else {
                preparedStatement.setNull(5, Types.INTEGER);
            }
            preparedStatement.executeUpdate();
            statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("Insert: " + pheonological_stage.getPheonological_stage_desc());
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
    public pheonological_stage selectById(int id) {
        pheonological_stage pheonological_stage = new pheonological_stage();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM `pheonological stage` WHERE pheonological_stage_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                pheonological_stage.setPheonological_stage_id(resultSet.getInt("pheonological_stage_id"));
                pheonological_stage.setPheonological_stage_desc(resultSet.getString("pheonological stage_desc"));
                pheonological_stage.setCrop_id(resultSet.getInt("crop_id"));
                pheonological_stage.setPheonological_stage_duration_days(resultSet.getInt("pheonological_stage_duration_days"));
                pheonological_stage.setPheonological_stage_duration_gdd(resultSet.getInt("pheonological_stage_duration_gdd"));
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
        return pheonological_stage;
    }

    @Override
    public List<pheonological_stage> selectAll() {
        List<pheonological_stage> pheonological_stages = new ArrayList<pheonological_stage>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `pheonological stage`");

            while (resultSet.next()) {
                pheonological_stage pheonological_stage = new pheonological_stage();
                pheonological_stage.setPheonological_stage_id(resultSet.getInt("pheonological_stage_id"));
                pheonological_stage.setPheonological_stage_desc(resultSet.getString("pheonological stage_desc"));
                pheonological_stage.setCrop_id(resultSet.getInt("crop_id"));
                pheonological_stage.setPheonological_stage_duration_days(resultSet.getInt("pheonological_stage_duration_days"));
                pheonological_stage.setPheonological_stage_duration_gdd(resultSet.getInt("pheonological_stage_duration_gdd"));
                pheonological_stages.add(pheonological_stage);
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
        return pheonological_stages;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM `pheonological stage` WHERE pheonological_stage_id = ?");
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
    public void update(pheonological_stage pheonological_stage, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE `pheonological stage` SET " +
                    "(`pheonological_stage_id`," +
                    "`pheonological stage_desc`," +
                    "`crop_id`," +
                    "`pheonological_stage_duration_days`," +
                    "`pheonological_stage_duration_gdd`) " +
                    "WHERE pheonological_stage_id = ?");

            preparedStatement.setInt(1, pheonological_stage.getPheonological_stage_id());
            preparedStatement.setString(2, pheonological_stage.getPheonological_stage_desc());
            preparedStatement.setInt(3, pheonological_stage.getCrop_id());
            preparedStatement.setInt(4, pheonological_stage.getPheonological_stage_duration_days());
            preparedStatement.setInt(5, pheonological_stage.getPheonological_stage_duration_gdd());
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
            resultSet = statement.executeQuery("SELECT * FROM `pheonological stage`");



            while (resultSet.next()) {
                emptySpace = resultSet.getInt("pheonological_stage_id") + 1;

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
    public void insertAll(List<pheonological_stage> pheonological_stages) {
        //pheonological_stages.sort((pheonological_stage ps1, pheonological_stage ps2) -> ps1.getPheonological_stage_desc().compareTo(ps2.getPheonological_stage_desc()));

        for (pheonological_stage pheonological_stage : pheonological_stages) {
            pheonological_stage.setPheonological_stage_id(this.generateUniqueId());
            this.insert(pheonological_stage);
            System.out.println(pheonological_stage.getPheonological_stage_id());
        }
        System.out.println("InsertAll finished");
    }

    @Override
    public void autoInsertAll() {
        //desc, crop_id, phenological_days, gdd
        pheonological_stage ps1 = new pheonological_stage("Dormancy break",3,15,null);
        pheonological_stage ps2 = new pheonological_stage("Flowering and early leaves", 3, 15, null);
        pheonological_stage ps3 = new pheonological_stage("Yield forming and ripening",	3, 90, null);
        pheonological_stage ps4 = new pheonological_stage("Fruit picking", 3, 30, null);
        pheonological_stage ps5 = new pheonological_stage("Recovery", 3, 60, null);
        pheonological_stage ps6 = new pheonological_stage("Dormancy", 3, 110, null);

        pheonological_stage ps7 = new pheonological_stage("Floral bud break", 4, 30, null);
        pheonological_stage ps8 = new pheonological_stage("Flowering to fruit set",	4, 30, null);
        pheonological_stage ps9 = new pheonological_stage("Fruitlet growth and fruit drop", 4, 60, null);
        pheonological_stage ps10 = new pheonological_stage("Fruit growth", 4, 60, null);
        pheonological_stage ps11 = new pheonological_stage("Fruit growth and flower differentiation", 4, 90, null);
        pheonological_stage ps12 = new pheonological_stage("Harvest and flower development", 4, 95, null);

        pheonological_stage ps13 = new pheonological_stage("Flowering/Vegetation", 15, 45, null);
        pheonological_stage ps14 = new pheonological_stage("Fruit setting/Vegetation", 15, 60, null);
        pheonological_stage ps15 = new pheonological_stage("Vegetation/Fruit Growth", 15, 90, null);
        pheonological_stage ps16 = new pheonological_stage("Dry matter accumulation", 15, 60, null);
        pheonological_stage ps17 = new pheonological_stage("Fruit Growth", 15, 30, null);
        pheonological_stage ps18 = new pheonological_stage("Harvesting", 15, 45, null);

        pheonological_stage ps19 = new pheonological_stage("Pre Flowering", 6, 15, null);
        pheonological_stage ps20 = new pheonological_stage("Flowering", 6, 30, null);
        pheonological_stage ps21 = new pheonological_stage("Fruit set",6,30,null);
        pheonological_stage ps22 = new pheonological_stage("Fruit growth", 6, 150, null);
        pheonological_stage ps23 = new pheonological_stage("Fruit maturation",	6, 60, null);
        pheonological_stage ps24 = new pheonological_stage("Harvest", 6, 30, null);
        pheonological_stage ps25 = new pheonological_stage("Induced stress", 6, 50, null);

        pheonological_stage ps26 = new pheonological_stage("GE", 2, 7, null);
        pheonological_stage ps27 = new pheonological_stage("VE-V7", 2, 24, null);
        pheonological_stage ps28 = new pheonological_stage("V8-V12", 2, 13, null);
        pheonological_stage ps29 = new pheonological_stage("V13-VT", 2, 18, null);
        pheonological_stage ps30 = new pheonological_stage("R1-R2", 2, 18, null);
        pheonological_stage ps31 = new pheonological_stage("R3-R6", 2, 40, null);

        pheonological_stage ps32 = new pheonological_stage("Emergence and eastablishment", 7, 15, null);
        pheonological_stage ps33 = new pheonological_stage("Vegetative growth",	7, 43, null);
        pheonological_stage ps34 = new pheonological_stage("Square formation", 7, 38, null);
        pheonological_stage ps35 = new pheonological_stage("Flowering& boll seting", 7, 38, null);
        pheonological_stage ps36 = new pheonological_stage("Boll developmant", 7, 28, null);
        pheonological_stage ps37 = new pheonological_stage("Maturity & harvest", 7, 18, null);

        pheonological_stage ps38 = new pheonological_stage("Bud breaking to swollen calyx",	14, 60, null);
        pheonological_stage ps39 = new pheonological_stage("Early flowers to young fruits", 14, 25, null);
        pheonological_stage ps40 = new pheonological_stage("Fruit set and fruit growth", 14, 70, null);
        pheonological_stage ps41 = new pheonological_stage("Final Ripening", 14, 30, null);
        pheonological_stage ps42 = new pheonological_stage("Recovery and post harvest", 14, 30, null);
        pheonological_stage ps43 = new pheonological_stage("Dormancy", 14, 150, null);

        pheonological_stage ps44 = new pheonological_stage("Sprout developmant", 1, 15, null);
        pheonological_stage ps45 = new pheonological_stage("Vegetative growth", 1, 20, null);
        pheonological_stage ps46 = new pheonological_stage("Tuber intiation", 1, 20, null);
        pheonological_stage ps47 = new pheonological_stage("Tuber bulking", 1, 35, null);
        pheonological_stage ps48 = new pheonological_stage("tuber maturation",	1, 30, null);

        pheonological_stage ps49 = new pheonological_stage("Vegetative growth", 8, 20, null);
        pheonological_stage ps50 = new pheonological_stage("Flowering", 8, 10, null);
        pheonological_stage ps51 = new pheonological_stage("Fruit set", 8, 10, null);
        pheonological_stage ps52 = new pheonological_stage("Fruit growth phase 1", 8, 20, null);
        pheonological_stage ps53 = new pheonological_stage("Fruit growth phase 2", 8, 10, null);
        pheonological_stage ps54 = new pheonological_stage("Fruit growth phase 3", 8, 10, null);
        pheonological_stage ps55 = new pheonological_stage("10 % red fruit", 8, 10, null);
        pheonological_stage ps56 = new pheonological_stage("40 % red fruit", 8, 10, null);
        pheonological_stage ps57 = new pheonological_stage("90 % red fruit", 8, 10, null);
        pheonological_stage ps58 = new pheonological_stage("Harvest", 8, 10, null);

        pheonological_stage ps59 = new pheonological_stage("VE", 10, 20, null);
        pheonological_stage ps60 = new pheonological_stage("V1", 10, 5, null);
        pheonological_stage ps61 = new pheonological_stage("V2", 10, 5, null);
        pheonological_stage ps62 = new pheonological_stage("V3", 10, 15, null);
        pheonological_stage ps63 = new pheonological_stage("R1", 10, 10, null);
        pheonological_stage ps64 = new pheonological_stage("R3", 10, 32, null);
        pheonological_stage ps65 = new pheonological_stage("R6", 10, 16, null);
        pheonological_stage ps66 = new pheonological_stage("R7", 10, 10, null);
        pheonological_stage ps67 = new pheonological_stage("R8", 10, 10, null);

        pheonological_stage ps68 = new pheonological_stage("Eastablishment",	9, 17, null);
        pheonological_stage ps69 = new pheonological_stage("Vegetative Growth", 9, 13, null);
        pheonological_stage ps70 = new pheonological_stage("Flowering", 9, 30, null);
        pheonological_stage ps71 = new pheonological_stage("1st fruits wave", 9, 60, null);
        pheonological_stage ps72 = new pheonological_stage("2nd fruits wave", 9, 45, null);
        pheonological_stage ps73 = new pheonological_stage("3rd fruits wave", 9, 21, null);
        pheonological_stage ps74 = new pheonological_stage("4th fruits wave", 9, 21, null);

        pheonological_stage ps75 = new pheonological_stage("Ratooning/ germination", 5, 30, null);
        pheonological_stage ps76 = new pheonological_stage("tillering", 5, 60, null);
        pheonological_stage ps77 = new pheonological_stage("grand growth", 5, 120, null);
        pheonological_stage ps78 = new pheonological_stage("ripening",	5, 60, null);
        pheonological_stage ps79 = new pheonological_stage("Maturation", 5, 60, null);
        pheonological_stage ps80 = new pheonological_stage("Harvest/ planting", 5, 30, null);

        pheonological_stage ps81 = new pheonological_stage("Bud break to flowering", 12, 40, null);
        pheonological_stage ps82 = new pheonological_stage("Frutiset and berry enlargemant", 12, 90, null);
        pheonological_stage ps83 = new pheonological_stage("Maturation", 12, 50, null);

        pheonological_stage ps84 = new pheonological_stage("Bud break to flowering", 11, 65, null);
        pheonological_stage ps85 = new pheonological_stage("Flowering to Pea size berry", 11, 50, null);
        pheonological_stage ps86 = new pheonological_stage("Pea size berry to veraison ", 11, 30, null);
        pheonological_stage ps87 = new pheonological_stage("Veraison to 17°Brix", 11, 30, null);
        pheonological_stage ps88 = new pheonological_stage("17°Brix to harvest", 11, 21, null);
        pheonological_stage ps89 = new pheonological_stage("Post harvest", 11, 21, null);

        pheonological_stage ps90 = new pheonological_stage("Seeding to 3-4 leaves", 13, 52, null);
        pheonological_stage ps91 = new pheonological_stage("Vegetative growth", 13, 25, null);
        pheonological_stage ps92 = new pheonological_stage("Begging of bulb", 13, 58, null);
        pheonological_stage ps93 = new pheonological_stage("Canopy senescense",	13, 15, null);

        List<pheonological_stage> pheonological_stages = new ArrayList<>();
        pheonological_stages.add(ps1);
        pheonological_stages.add(ps2);
        pheonological_stages.add(ps3);
        pheonological_stages.add(ps4);
        pheonological_stages.add(ps5);
        pheonological_stages.add(ps6);
        pheonological_stages.add(ps7);
        pheonological_stages.add(ps8);
        pheonological_stages.add(ps9);
        pheonological_stages.add(ps10);
        pheonological_stages.add(ps11);
        pheonological_stages.add(ps12);
        pheonological_stages.add(ps13);
        pheonological_stages.add(ps14);
        pheonological_stages.add(ps15);
        pheonological_stages.add(ps16);
        pheonological_stages.add(ps17);
        pheonological_stages.add(ps18);
        pheonological_stages.add(ps19);
        pheonological_stages.add(ps20);
        pheonological_stages.add(ps21);
        pheonological_stages.add(ps22);
        pheonological_stages.add(ps23);
        pheonological_stages.add(ps24);
        pheonological_stages.add(ps25);
        pheonological_stages.add(ps26);
        pheonological_stages.add(ps27);
        pheonological_stages.add(ps28);
        pheonological_stages.add(ps29);
        pheonological_stages.add(ps30);
        pheonological_stages.add(ps31);
        pheonological_stages.add(ps32);
        pheonological_stages.add(ps33);
        pheonological_stages.add(ps34);
        pheonological_stages.add(ps35);
        pheonological_stages.add(ps36);
        pheonological_stages.add(ps37);
        pheonological_stages.add(ps38);
        pheonological_stages.add(ps39);
        pheonological_stages.add(ps40);
        pheonological_stages.add(ps41);
        pheonological_stages.add(ps42);
        pheonological_stages.add(ps43);
        pheonological_stages.add(ps44);
        pheonological_stages.add(ps45);
        pheonological_stages.add(ps46);
        pheonological_stages.add(ps47);
        pheonological_stages.add(ps48);
        pheonological_stages.add(ps49);
        pheonological_stages.add(ps50);
        pheonological_stages.add(ps51);
        pheonological_stages.add(ps52);
        pheonological_stages.add(ps53);
        pheonological_stages.add(ps54);
        pheonological_stages.add(ps55);
        pheonological_stages.add(ps56);
        pheonological_stages.add(ps57);
        pheonological_stages.add(ps58);
        pheonological_stages.add(ps59);
        pheonological_stages.add(ps60);
        pheonological_stages.add(ps61);
        pheonological_stages.add(ps62);
        pheonological_stages.add(ps63);
        pheonological_stages.add(ps64);
        pheonological_stages.add(ps65);
        pheonological_stages.add(ps66);
        pheonological_stages.add(ps67);
        pheonological_stages.add(ps68);
        pheonological_stages.add(ps69);
        pheonological_stages.add(ps70);
        pheonological_stages.add(ps71);
        pheonological_stages.add(ps72);
        pheonological_stages.add(ps73);
        pheonological_stages.add(ps74);
        pheonological_stages.add(ps75);
        pheonological_stages.add(ps76);
        pheonological_stages.add(ps77);
        pheonological_stages.add(ps78);
        pheonological_stages.add(ps79);
        pheonological_stages.add(ps80);
        pheonological_stages.add(ps81);
        pheonological_stages.add(ps82);
        pheonological_stages.add(ps83);
        pheonological_stages.add(ps84);
        pheonological_stages.add(ps85);
        pheonological_stages.add(ps86);
        pheonological_stages.add(ps87);
        pheonological_stages.add(ps88);
        pheonological_stages.add(ps89);
        pheonological_stages.add(ps90);
        pheonological_stages.add(ps91);
        pheonological_stages.add(ps92);
        pheonological_stages.add(ps93);
        this.insertAll(pheonological_stages);
    }

}
