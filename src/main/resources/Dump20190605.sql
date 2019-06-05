-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: lab analysis
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `analysis status type`
--

DROP TABLE IF EXISTS `analysis status type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `analysis status type` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(150) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analysis status type`
--

LOCK TABLES `analysis status type` WRITE;
/*!40000 ALTER TABLE `analysis status type` DISABLE KEYS */;
/*!40000 ALTER TABLE `analysis status type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crop type`
--

DROP TABLE IF EXISTS `crop type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `crop type` (
  `crop_id` int(11) NOT NULL,
  `crop_name` varchar(100) NOT NULL,
  `crop_group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`crop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crop type`
--

LOCK TABLES `crop type` WRITE;
/*!40000 ALTER TABLE `crop type` DISABLE KEYS */;
INSERT INTO `crop type` VALUES (1,'Potato',2),(2,'Corn',2),(3,'Almonds',1),(4,'Avocado',1),(5,'Sugarcane',2),(6,'Coffee',1),(7,'Cotton',2),(8,'Processing Tomatoes',2),(9,'Strawberries',2),(10,'Soybeans',2),(11,'Wine grapes',1),(12,'Table grapes',1),(13,'Onion',2),(14,'Pomegranade',1),(15,'Citrus',1);
/*!40000 ALTER TABLE `crop type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crop_expected_yield_validation`
--

DROP TABLE IF EXISTS `crop_expected_yield_validation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `crop_expected_yield_validation` (
  `validation_id` int(11) NOT NULL,
  `crop_id` int(11) NOT NULL,
  `variety_id` int(11) NOT NULL,
  `min_yield` decimal(10,0) NOT NULL,
  `max_yield` decimal(10,0) NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`validation_id`),
  KEY `idx_crop_expected_yield_validation_crop_id` (`crop_id`),
  KEY `idx_crop_expected_yield_validation_variety_id` (`variety_id`),
  CONSTRAINT `fk_crop_expected_yield_validation_crop type` FOREIGN KEY (`crop_id`) REFERENCES `crop type` (`crop_id`),
  CONSTRAINT `fk_crop_expected_yield_validation_variety type` FOREIGN KEY (`variety_id`) REFERENCES `variety_type` (`variety_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crop_expected_yield_validation`
--

LOCK TABLES `crop_expected_yield_validation` WRITE;
/*!40000 ALTER TABLE `crop_expected_yield_validation` DISABLE KEYS */;
INSERT INTO `crop_expected_yield_validation` VALUES (1,1,15,20,120,NULL,NULL,NULL,NULL,NULL),(2,2,11,6,30,NULL,NULL,NULL,NULL,NULL),(3,3,16,1,4,NULL,NULL,NULL,NULL,NULL),(4,4,1,7,45,NULL,NULL,NULL,NULL,NULL),(5,5,4,40,200,NULL,NULL,NULL,NULL,NULL),(6,6,2,1,6,NULL,NULL,NULL,NULL,NULL),(7,6,3,2,10,NULL,NULL,NULL,NULL,NULL),(8,7,7,1,5,NULL,NULL,NULL,NULL,NULL),(9,8,8,50,170,NULL,NULL,NULL,NULL,NULL),(10,9,20,20,60,NULL,NULL,NULL,NULL,NULL),(11,10,21,4,10,NULL,NULL,NULL,NULL,NULL),(12,11,23,5,45,NULL,NULL,NULL,NULL,NULL),(13,12,22,25,125,NULL,NULL,NULL,NULL,NULL),(14,13,25,25,150,NULL,NULL,NULL,NULL,NULL),(15,14,24,15,50,NULL,NULL,NULL,NULL,NULL),(16,15,26,15,60,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `crop_expected_yield_validation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crop_group`
--

DROP TABLE IF EXISTS `crop_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `crop_group` (
  `crop_group_id` int(11) NOT NULL,
  `crop_group_desc` varchar(50) NOT NULL,
  PRIMARY KEY (`crop_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crop_group`
--

LOCK TABLES `crop_group` WRITE;
/*!40000 ALTER TABLE `crop_group` DISABLE KEYS */;
INSERT INTO `crop_group` VALUES (1,'Orchards'),(2,'Field crops');
/*!40000 ALTER TABLE `crop_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_types`
--

DROP TABLE IF EXISTS `data_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `data_types` (
  `data_type_id` int(11) NOT NULL,
  `data_type_desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`data_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_types`
--

LOCK TABLES `data_types` WRITE;
/*!40000 ALTER TABLE `data_types` DISABLE KEYS */;
INSERT INTO `data_types` VALUES (1,'Macro element'),(2,'Secondary element'),(3,'Micro element'),(4,'element');
/*!40000 ALTER TABLE `data_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dressing_strategy`
--

DROP TABLE IF EXISTS `dressing_strategy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dressing_strategy` (
  `bese_dressing_id` int(11) NOT NULL,
  `base_dressing_name` varchar(100) NOT NULL,
  `dressing_strategy_desc` varchar(1500) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`bese_dressing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dressing_strategy`
--

LOCK TABLES `dressing_strategy` WRITE;
/*!40000 ALTER TABLE `dressing_strategy` DISABLE KEYS */;
/*!40000 ALTER TABLE `dressing_strategy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elements`
--

DROP TABLE IF EXISTS `elements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `elements` (
  `element_id` int(11) NOT NULL,
  `symbol` varchar(10) NOT NULL,
  `description` varchar(20) NOT NULL,
  PRIMARY KEY (`element_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elements`
--

LOCK TABLES `elements` WRITE;
/*!40000 ALTER TABLE `elements` DISABLE KEYS */;
INSERT INTO `elements` VALUES (1,'N','Nitrogen'),(2,'P','Phosphorus'),(3,'K','Potassium'),(4,'Ca','Calcium'),(5,'Mg','Magnesium'),(6,'S','Sulfur'),(7,'Fe','Iron'),(8,'Mn','Manganese'),(9,'B','Boron'),(10,'Zn','Zinc'),(11,'Cu','Copper'),(12,'Mo','Molybdenum'),(13,'N-NH4','Ammoniacal Nitrogen'),(14,'N-NO3','Nitrate Nitrogen'),(15,'N-NH2','Ureic Nitrogen'),(16,'Cl','Chloride'),(17,'Na','Sodium'),(18,'HCO3','Bicarbonate'),(19,'Al','Aluminum'),(20,'Organic-N','Organic Nitrogen');
/*!40000 ALTER TABLE `elements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extraction_lab_analysis`
--

DROP TABLE IF EXISTS `extraction_lab_analysis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `extraction_lab_analysis` (
  `extraction_sample_id` int(11) NOT NULL,
  `farm_id` int(11) NOT NULL,
  `sample_date` datetime NOT NULL,
  `sample_name` varchar(100) DEFAULT NULL,
  `id_status` int(11) NOT NULL,
  `ib_id` int(11) NOT NULL,
  `sample_location_lon` decimal(8,5) DEFAULT NULL,
  `sample_location_lat` decimal(8,5) DEFAULT NULL,
  `extraction_depth` decimal(10,0) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `user_delete` varchar(20) DEFAULT NULL,
  `date_delete` datetime DEFAULT NULL,
  PRIMARY KEY (`extraction_sample_id`),
  KEY `idx_extraction_lab_analysis_id_status` (`id_status`),
  KEY `idx_extraction_lab_analysis_farm_id` (`farm_id`),
  CONSTRAINT `fk_extraction_lab_analysis_farms` FOREIGN KEY (`farm_id`) REFERENCES `farms` (`farm_id`),
  CONSTRAINT `fk_extraction_lab_analysis_lab_analysis__status` FOREIGN KEY (`id_status`) REFERENCES `analysis status type` (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extraction_lab_analysis`
--

LOCK TABLES `extraction_lab_analysis` WRITE;
/*!40000 ALTER TABLE `extraction_lab_analysis` DISABLE KEYS */;
/*!40000 ALTER TABLE `extraction_lab_analysis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extraction_methods`
--

DROP TABLE IF EXISTS `extraction_methods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `extraction_methods` (
  `extraction_method_id` int(11) NOT NULL,
  `extraction_method_desc` varchar(30) NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`extraction_method_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extraction_methods`
--

LOCK TABLES `extraction_methods` WRITE;
/*!40000 ALTER TABLE `extraction_methods` DISABLE KEYS */;
INSERT INTO `extraction_methods` VALUES (1,'Olsen',NULL,NULL,NULL,NULL,NULL),(2,'Ammonium Acetate',NULL,NULL,NULL,NULL,NULL),(3,'KCl 40',NULL,NULL,NULL,NULL,NULL),(4,'DTPA',NULL,NULL,NULL,NULL,NULL),(5,'Hot water',NULL,NULL,NULL,NULL,NULL),(6,'Ammonium Oxalate',NULL,NULL,NULL,NULL,NULL),(7,'Saturated paste',NULL,NULL,NULL,NULL,NULL),(8,'1M KCl',NULL,NULL,NULL,NULL,NULL),(9,'Bray',NULL,NULL,NULL,NULL,NULL),(10,'Melich3',NULL,NULL,NULL,NULL,NULL),(11,'Kjeldahl',NULL,NULL,NULL,NULL,NULL),(12,'2M KCl',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `extraction_methods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farms`
--

DROP TABLE IF EXISTS `farms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `farms` (
  `farm_id` int(11) NOT NULL AUTO_INCREMENT,
  `farm_name` varchar(100) NOT NULL,
  PRIMARY KEY (`farm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farms`
--

LOCK TABLES `farms` WRITE;
/*!40000 ALTER TABLE `farms` DISABLE KEYS */;
/*!40000 ALTER TABLE `farms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fertilization method`
--

DROP TABLE IF EXISTS `fertilization method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fertilization method` (
  `fert_method_id` int(11) NOT NULL AUTO_INCREMENT,
  `fert_method_desc` varchar(100) NOT NULL,
  PRIMARY KEY (`fert_method_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fertilization method`
--

LOCK TABLES `fertilization method` WRITE;
/*!40000 ALTER TABLE `fertilization method` DISABLE KEYS */;
INSERT INTO `fertilization method` VALUES (1,'Soil Application'),(2,'Band Application'),(3,'Drip Fertigation'),(4,'SDI Fertigation'),(5,'Sprinklers Fertigation'),(6,'Pivot Fertigation'),(7,'Flooding');
/*!40000 ALTER TABLE `fertilization method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fertilization_method_efficiency`
--

DROP TABLE IF EXISTS `fertilization_method_efficiency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fertilization_method_efficiency` (
  `fert_method_efficiency_id` int(11) NOT NULL,
  `fert_method_id` int(11) NOT NULL,
  `parameter_id` int(11) NOT NULL,
  `fert_method_efficiency` decimal(10,3) NOT NULL,
  PRIMARY KEY (`fert_method_efficiency_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fertilization_method_efficiency`
--

LOCK TABLES `fertilization_method_efficiency` WRITE;
/*!40000 ALTER TABLE `fertilization_method_efficiency` DISABLE KEYS */;
INSERT INTO `fertilization_method_efficiency` VALUES (1,1,1,0.800),(2,1,2,0.450),(3,1,3,0.700),(4,1,4,0.750),(5,1,5,0.750),(6,1,6,0.850),(7,1,7,0.900),(8,1,8,0.900),(9,1,9,0.900),(10,1,10,0.900),(11,1,11,0.900),(12,1,12,0.900),(13,2,1,0.850),(14,2,2,0.550),(15,2,3,0.750),(16,2,4,0.800),(17,2,5,0.800),(18,2,6,0.800),(19,2,7,0.950),(20,2,8,0.950),(21,2,9,0.950),(22,2,10,0.950),(23,2,11,0.950),(24,2,12,0.950),(25,3,1,0.900),(26,3,2,0.600),(27,3,3,0.800),(28,3,4,0.850),(29,3,5,0.850),(30,3,6,0.850),(31,3,7,1.000),(32,3,8,1.000),(33,3,9,1.000),(34,3,10,1.000),(35,3,11,1.000),(36,3,12,1.000),(37,4,1,0.900),(38,4,2,0.600),(39,4,3,0.800),(40,4,4,0.850),(41,4,5,0.850),(42,4,6,0.850),(43,4,7,1.000),(44,4,8,1.000),(45,4,9,1.000),(46,4,10,1.000),(47,4,11,1.000),(48,4,12,1.000),(49,5,1,0.900),(50,5,2,0.600),(51,5,3,0.800),(52,5,4,0.850),(53,5,5,0.850),(54,5,6,0.850),(55,5,7,1.000),(56,5,8,1.000),(57,5,9,1.000),(58,5,10,1.000),(59,5,11,1.000),(60,5,12,1.000),(61,6,1,0.900),(62,6,2,0.600),(63,6,3,0.800),(64,6,4,0.850),(65,6,5,0.850),(66,6,6,0.850),(67,6,7,1.000),(68,6,8,1.000),(69,6,9,1.000),(70,6,10,1.000),(71,6,11,1.000),(72,6,12,1.000),(73,7,1,0.850),(74,7,2,0.550),(75,7,3,0.750),(76,7,4,0.800),(77,7,5,0.800),(78,7,6,0.800),(79,7,7,0.950),(80,7,8,0.950),(81,7,9,0.950),(82,7,10,0.950),(83,7,11,0.950),(84,7,12,0.950);
/*!40000 ALTER TABLE `fertilization_method_efficiency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `groups` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(100) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups_to_parameters`
--

DROP TABLE IF EXISTS `groups_to_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `groups_to_parameters` (
  `group_to_parameter_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `parameter_id` int(11) NOT NULL,
  `test_type_id` int(11) NOT NULL,
  `is_active` bit(1) NOT NULL DEFAULT b'1',
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`group_to_parameter_id`),
  KEY `idx_groups_to_parameters_group_id` (`group_id`),
  KEY `idx_groups_to_parameters_parameter_id` (`parameter_id`),
  KEY `idx_groups_to_parameters_test_type_id` (`test_type_id`),
  CONSTRAINT `fk_groups_to_parameters_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`),
  CONSTRAINT `fk_groups_to_parameters_parameters_group` FOREIGN KEY (`group_id`) REFERENCES `parameters_group` (`group_id`),
  CONSTRAINT `fk_groups_to_parameters_test_type` FOREIGN KEY (`test_type_id`) REFERENCES `test_type` (`test_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups_to_parameters`
--

LOCK TABLES `groups_to_parameters` WRITE;
/*!40000 ALTER TABLE `groups_to_parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups_to_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interpretation_soil_n_parameter`
--

DROP TABLE IF EXISTS `interpretation_soil_n_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `interpretation_soil_n_parameter` (
  `n_interpretations_id` int(11) NOT NULL AUTO_INCREMENT,
  `farm_id` int(11) NOT NULL,
  `crop_id` int(11) NOT NULL,
  `variety_id` int(11) NOT NULL,
  `phenological_stage_id` int(11) NOT NULL,
  `uom_id` int(11) NOT NULL,
  `very_low_threshold` decimal(10,0) DEFAULT NULL,
  `low_threshold` decimal(10,0) DEFAULT NULL,
  `traget_value` decimal(10,0) DEFAULT NULL,
  `high_threshold` decimal(10,0) DEFAULT NULL,
  `very_high_threshold` decimal(10,0) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `user_delete` varchar(20) DEFAULT NULL,
  `date_delete` datetime DEFAULT NULL,
  PRIMARY KEY (`n_interpretations_id`),
  KEY `idx_interpretation_soil_n_parameter_crop_id` (`crop_id`),
  CONSTRAINT `fk_interpretation_soil_n_parameter` FOREIGN KEY (`crop_id`) REFERENCES `crop type` (`crop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interpretation_soil_n_parameter`
--

LOCK TABLES `interpretation_soil_n_parameter` WRITE;
/*!40000 ALTER TABLE `interpretation_soil_n_parameter` DISABLE KEYS */;
/*!40000 ALTER TABLE `interpretation_soil_n_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `irrigation_blocks`
--

DROP TABLE IF EXISTS `irrigation_blocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `irrigation_blocks` (
  `ib_id` int(11) NOT NULL,
  `ib_name` varchar(100) NOT NULL,
  `crop_id` int(11) NOT NULL,
  `variety_id` int(11) DEFAULT NULL,
  `start_season` datetime NOT NULL,
  PRIMARY KEY (`ib_id`),
  KEY `idx_irrigation_blocks_variety_id` (`variety_id`),
  KEY `idx_irrigation_blocks_crop_id` (`crop_id`),
  CONSTRAINT `fk_irrigation blocks_crop type` FOREIGN KEY (`crop_id`) REFERENCES `crop type` (`crop_id`),
  CONSTRAINT `fk_irrigation blocks_variety type` FOREIGN KEY (`variety_id`) REFERENCES `variety_type` (`variety_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `irrigation_blocks`
--

LOCK TABLES `irrigation_blocks` WRITE;
/*!40000 ALTER TABLE `irrigation_blocks` DISABLE KEYS */;
/*!40000 ALTER TABLE `irrigation_blocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `irrigation_method`
--

DROP TABLE IF EXISTS `irrigation_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `irrigation_method` (
  `irrigation_method_id` int(11) NOT NULL AUTO_INCREMENT,
  `irrigation_method_desc` varchar(30) NOT NULL,
  `irrigation_method_efficiency` decimal(3,2) NOT NULL,
  `irrigation_method_wetted_area` decimal(3,2) NOT NULL,
  PRIMARY KEY (`irrigation_method_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `irrigation_method`
--

LOCK TABLES `irrigation_method` WRITE;
/*!40000 ALTER TABLE `irrigation_method` DISABLE KEYS */;
INSERT INTO `irrigation_method` VALUES (1,'Drip',0.90,0.50),(2,'SDI',0.90,0.50),(3,'Sprinklers',0.75,1.00),(4,'Pivot',0.80,1.00),(5,'Flooding',0.60,1.00);
/*!40000 ALTER TABLE `irrigation_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_analysis__status`
--

DROP TABLE IF EXISTS `lab_analysis__status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lab_analysis__status` (
  `id_status` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(150) DEFAULT NULL,
  `isactive` bit(1) NOT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_analysis__status`
--

LOCK TABLES `lab_analysis__status` WRITE;
/*!40000 ALTER TABLE `lab_analysis__status` DISABLE KEYS */;
/*!40000 ALTER TABLE `lab_analysis__status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_analysis_results`
--

DROP TABLE IF EXISTS `lab_analysis_results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lab_analysis_results` (
  `lab_results_id` int(11) NOT NULL AUTO_INCREMENT,
  `tissue_analysis_id` int(11) DEFAULT NULL,
  `soil_analysis_id` int(11) DEFAULT NULL,
  `water_analysis_id` int(11) DEFAULT NULL,
  `parameter_id` int(11) NOT NULL,
  `parameter_value` int(11) NOT NULL,
  `uom_id` int(11) DEFAULT NULL,
  `extraction_analysis_id` int(11) DEFAULT NULL,
  `extraction_method_id` int(11) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `user_delete` varchar(20) DEFAULT NULL,
  `date_delete` datetime DEFAULT NULL,
  PRIMARY KEY (`lab_results_id`),
  KEY `idx_lab_analysis_results_parameter_id` (`parameter_id`),
  KEY `idx_lab_analysis_results_water_analysis_id` (`water_analysis_id`),
  KEY `idx_lab_analysis_results_soil_analysis_id` (`soil_analysis_id`),
  KEY `idx_lab_analysis_results_extraction_analysis_id` (`extraction_analysis_id`),
  KEY `idx_lab_analysis_results_tissue_analysis_id` (`tissue_analysis_id`),
  CONSTRAINT `fk_lab analysis results_analysis_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`),
  CONSTRAINT `fk_lab analysis results_extraction_lab_analysis` FOREIGN KEY (`extraction_analysis_id`) REFERENCES `extraction_lab_analysis` (`extraction_sample_id`),
  CONSTRAINT `fk_lab analysis results_tissue_lab_analysis_0` FOREIGN KEY (`tissue_analysis_id`) REFERENCES `tissue_lab_analysis` (`tissue_analysis_id`),
  CONSTRAINT `fk_lab analysis results_wataer_lab_analysis` FOREIGN KEY (`water_analysis_id`) REFERENCES `water_lab_analysis` (`water_analysis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_analysis_results`
--

LOCK TABLES `lab_analysis_results` WRITE;
/*!40000 ALTER TABLE `lab_analysis_results` DISABLE KEYS */;
INSERT INTO `lab_analysis_results` VALUES (1,NULL,111,NULL,1,0,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,111,NULL,2,0,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),(3,NULL,111,NULL,3,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,111,NULL,4,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(5,NULL,111,NULL,5,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(6,NULL,111,NULL,6,0,NULL,NULL,3,NULL,NULL,NULL,NULL,NULL,NULL),(7,NULL,111,NULL,7,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(8,NULL,111,NULL,8,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(9,NULL,111,NULL,9,0,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL),(10,NULL,111,NULL,10,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(11,NULL,111,NULL,11,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(12,NULL,111,NULL,12,0,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL),(13,NULL,111,NULL,13,0,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL),(14,NULL,111,NULL,14,0,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL),(15,NULL,111,NULL,15,0,NULL,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL),(16,NULL,111,NULL,16,0,NULL,NULL,7,NULL,NULL,NULL,NULL,NULL,NULL),(17,NULL,111,NULL,17,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(18,NULL,111,NULL,19,0,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL),(19,NULL,NULL,16,1,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,NULL,NULL,16,2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,NULL,NULL,16,3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,NULL,NULL,16,4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,NULL,NULL,16,5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,NULL,NULL,16,6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,NULL,NULL,16,7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,NULL,NULL,16,8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,NULL,NULL,16,9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,NULL,NULL,16,10,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,NULL,NULL,16,11,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,NULL,NULL,16,12,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,NULL,NULL,16,13,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,NULL,NULL,16,14,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,NULL,NULL,16,16,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,NULL,NULL,16,17,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,NULL,NULL,16,18,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,NULL,1231,NULL,1,0,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL),(37,NULL,1231,NULL,2,0,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),(38,NULL,1231,NULL,3,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(39,NULL,1231,NULL,4,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(40,NULL,1231,NULL,5,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(41,NULL,1231,NULL,6,0,NULL,NULL,3,NULL,NULL,NULL,NULL,NULL,NULL),(42,NULL,1231,NULL,7,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(43,NULL,1231,NULL,8,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(44,NULL,1231,NULL,9,0,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL),(45,NULL,1231,NULL,10,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(46,NULL,1231,NULL,11,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(47,NULL,1231,NULL,12,0,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL),(48,NULL,1231,NULL,13,0,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL),(49,NULL,1231,NULL,14,0,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL),(50,NULL,1231,NULL,15,0,NULL,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL),(51,NULL,1231,NULL,16,0,NULL,NULL,7,NULL,NULL,NULL,NULL,NULL,NULL),(52,NULL,1231,NULL,17,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(53,NULL,1231,NULL,19,0,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL),(54,NULL,1231,NULL,1,0,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL),(55,NULL,1231,NULL,2,0,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),(56,NULL,1231,NULL,3,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(57,NULL,1231,NULL,4,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(58,NULL,1231,NULL,5,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(59,NULL,1231,NULL,6,0,NULL,NULL,3,NULL,NULL,NULL,NULL,NULL,NULL),(60,NULL,1231,NULL,7,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(61,NULL,1231,NULL,8,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(62,NULL,1231,NULL,9,0,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL),(63,NULL,1231,NULL,10,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(64,NULL,1231,NULL,11,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(65,NULL,1231,NULL,12,0,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL),(66,NULL,1231,NULL,13,0,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL),(67,NULL,1231,NULL,14,0,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL),(68,NULL,1231,NULL,15,0,NULL,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL),(69,NULL,1231,NULL,16,0,NULL,NULL,7,NULL,NULL,NULL,NULL,NULL,NULL),(70,NULL,1231,NULL,17,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(71,NULL,1231,NULL,19,0,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL),(72,NULL,1231,NULL,1,0,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL),(73,NULL,1231,NULL,2,0,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),(74,NULL,1231,NULL,3,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(75,NULL,1231,NULL,4,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(76,NULL,1231,NULL,5,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(77,NULL,1231,NULL,6,0,NULL,NULL,3,NULL,NULL,NULL,NULL,NULL,NULL),(78,NULL,1231,NULL,7,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(79,NULL,1231,NULL,8,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(80,NULL,1231,NULL,9,0,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL),(81,NULL,1231,NULL,10,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(82,NULL,1231,NULL,11,0,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(83,NULL,1231,NULL,12,0,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL),(84,NULL,1231,NULL,13,0,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL),(85,NULL,1231,NULL,14,0,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL),(86,NULL,1231,NULL,15,0,NULL,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL),(87,NULL,1231,NULL,16,0,NULL,NULL,7,NULL,NULL,NULL,NULL,NULL,NULL),(88,NULL,1231,NULL,17,0,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(89,NULL,1231,NULL,19,0,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL),(90,NULL,NULL,19,1,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(91,NULL,NULL,19,2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(92,NULL,NULL,19,3,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(93,NULL,NULL,19,4,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(94,NULL,NULL,19,5,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(95,NULL,NULL,19,6,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(96,NULL,NULL,19,7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(97,NULL,NULL,19,8,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(98,NULL,NULL,19,9,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(99,NULL,NULL,19,10,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100,NULL,NULL,19,11,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(101,NULL,NULL,19,12,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(102,NULL,NULL,19,13,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(103,NULL,NULL,19,14,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(104,NULL,NULL,19,16,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(105,NULL,NULL,19,17,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(106,NULL,NULL,19,18,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `lab_analysis_results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `labs`
--

DROP TABLE IF EXISTS `labs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `labs` (
  `lab_id` int(11) NOT NULL,
  `lab_name` varchar(100) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `adderss` varchar(500) DEFAULT NULL,
  `country_id` int(11) NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`lab_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labs`
--

LOCK TABLES `labs` WRITE;
/*!40000 ALTER TABLE `labs` DISABLE KEYS */;
/*!40000 ALTER TABLE `labs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layer_depth_type`
--

DROP TABLE IF EXISTS `layer_depth_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `layer_depth_type` (
  `layer_depth_id` int(11) NOT NULL AUTO_INCREMENT,
  `layer_depth_name` varchar(50) DEFAULT NULL,
  `layer_min` smallint(6) NOT NULL,
  `layer_max` smallint(6) NOT NULL,
  `is_active` bit(1) NOT NULL DEFAULT b'1',
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`layer_depth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layer_depth_type`
--

LOCK TABLES `layer_depth_type` WRITE;
/*!40000 ALTER TABLE `layer_depth_type` DISABLE KEYS */;
INSERT INTO `layer_depth_type` VALUES (1,'0-30',0,30,_binary '',NULL,NULL,NULL,NULL),(2,'0-15',0,15,_binary '',NULL,NULL,NULL,NULL),(3,'15-30',15,30,_binary '',NULL,NULL,NULL,NULL),(4,'30-60',30,60,_binary '',NULL,NULL,NULL,NULL),(5,'30-45',30,45,_binary '',NULL,NULL,NULL,NULL),(6,'45-60',45,60,_binary '',NULL,NULL,NULL,NULL),(7,'60-90',60,90,_binary '',NULL,NULL,NULL,NULL),(8,'60-75',60,75,_binary '',NULL,NULL,NULL,NULL),(9,'75-90',75,90,_binary '',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `layer_depth_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter_convertion`
--

DROP TABLE IF EXISTS `parameter_convertion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parameter_convertion` (
  `parameter_convertion_id` int(11) NOT NULL AUTO_INCREMENT,
  `parameter_id` int(11) NOT NULL,
  `parameter_id_converted` int(11) DEFAULT NULL,
  `oxide_form` varchar(20) DEFAULT NULL,
  `elemental_form` varchar(20) DEFAULT NULL,
  `ion_form` varchar(20) DEFAULT NULL,
  `ion_form_active` bit(1) DEFAULT NULL,
  `is_anion` bit(1) DEFAULT NULL,
  `is_cation` bit(1) DEFAULT NULL,
  `equivalent_z` float NOT NULL,
  `molar_weight` decimal(2,2) NOT NULL,
  `convert_to_ppm_elemental` smallint(6) DEFAULT NULL,
  `elemental_to_oxide` decimal(2,1) NOT NULL,
  `ppm_to_mmol/l` decimal(4,1) DEFAULT NULL,
  `ppm_to_meq/l` decimal(4,1) DEFAULT NULL,
  `ppm_to_percent` decimal(4,1) DEFAULT NULL,
  `is_?_active` bit(1) DEFAULT NULL,
  `ppm_to_?mol/l` decimal(3,3) DEFAULT NULL,
  `ppm_to_?eq/l` decimal(3,3) DEFAULT NULL,
  PRIMARY KEY (`parameter_convertion_id`),
  KEY `idx_parameter_convertion_parameter_id` (`parameter_id`),
  CONSTRAINT `fk_parameter_convertion_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter_convertion`
--

LOCK TABLES `parameter_convertion` WRITE;
/*!40000 ALTER TABLE `parameter_convertion` DISABLE KEYS */;
/*!40000 ALTER TABLE `parameter_convertion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter_crop`
--

DROP TABLE IF EXISTS `parameter_crop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parameter_crop` (
  `param_per_crop_id` int(11) NOT NULL,
  `crop_id` int(11) NOT NULL,
  `variety_id` int(11) NOT NULL,
  `parameter_id` int(11) NOT NULL,
  `amount` decimal(6,3) DEFAULT NULL,
  `base_line` decimal(6,3) DEFAULT '0.000',
  `amount2` decimal(6,3) DEFAULT NULL,
  `active` bit(1) DEFAULT b'1',
  `is_active` bit(1) NOT NULL DEFAULT b'1',
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`param_per_crop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter_crop`
--

LOCK TABLES `parameter_crop` WRITE;
/*!40000 ALTER TABLE `parameter_crop` DISABLE KEYS */;
INSERT INTO `parameter_crop` VALUES (1,8,8,1,2.408,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(2,8,8,2,0.193,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(3,8,8,3,2.639,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(4,8,8,4,0.429,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(5,8,8,5,0.188,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(6,8,8,6,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(7,8,8,7,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(8,8,8,8,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(9,8,8,9,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(10,8,8,10,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(11,8,8,11,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(12,8,8,12,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(13,6,2,1,62.510,157.500,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(14,6,2,2,2.958,4.258,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(15,6,2,3,28.955,83.333,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(16,6,2,4,0.000,38.571,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(17,6,2,5,0.000,25.313,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(18,6,2,6,10.420,6.750,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(19,6,2,7,0.000,2.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(20,6,2,8,0.000,2.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(21,6,2,9,0.000,0.750,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(22,6,2,10,0.000,2.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(23,6,2,11,0.000,1.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(24,6,2,12,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(25,6,3,1,24.300,157.500,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(26,6,3,2,2.958,4.258,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(27,6,3,3,28.955,83.333,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(28,6,3,4,0.000,38.571,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(29,6,3,5,0.000,25.313,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(30,6,3,6,5.210,6.750,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(31,6,3,7,0.000,2.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(32,6,3,8,0.000,2.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(33,6,3,9,0.000,0.750,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(34,6,3,10,0.000,2.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(35,6,3,11,0.000,1.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(36,6,3,12,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(37,7,7,1,93.600,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(38,7,7,2,8.650,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(39,7,7,3,68.750,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(40,7,7,4,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(41,7,7,5,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(42,7,7,6,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(43,7,7,7,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(44,7,7,8,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(45,7,7,9,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(46,7,7,10,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(47,7,7,11,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(48,7,7,12,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(49,4,1,1,9.450,32.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(50,4,1,2,0.550,2.100,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(51,4,1,3,7.000,23.330,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(52,4,1,4,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(53,4,1,5,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(54,4,1,6,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(55,4,1,7,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(56,4,1,8,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(57,4,1,9,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(58,4,1,10,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(59,4,1,11,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(60,4,1,12,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(61,2,10,1,14.440,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(62,2,10,2,1.297,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(63,2,10,3,9.817,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(64,2,10,4,1.500,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(65,2,10,5,0.875,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(66,2,10,6,3.200,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(67,2,10,7,0.100,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(68,2,10,8,0.030,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(69,2,10,9,0.055,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(70,2,10,10,0.250,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(71,2,10,11,0.008,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(72,2,10,12,0.004,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(73,1,15,1,4.375,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(74,1,15,2,0.324,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(75,1,15,3,5.447,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(76,1,15,4,0.571,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(77,1,15,5,0.250,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(78,1,15,6,0.500,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(79,1,15,7,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(80,1,15,8,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(81,1,15,9,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(82,1,15,10,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(83,1,15,11,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL),(84,1,15,12,0.000,0.000,0.000,_binary '',_binary '',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `parameter_crop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter_per_stage`
--

DROP TABLE IF EXISTS `parameter_per_stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parameter_per_stage` (
  `nutrient_per_stage_id` int(11) NOT NULL,
  `param_per_crop_id` int(11) NOT NULL,
  `variety_id` int(11) NOT NULL,
  `phenological stage_id` int(11) DEFAULT NULL,
  `percent` decimal(3,2) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`nutrient_per_stage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter_per_stage`
--

LOCK TABLES `parameter_per_stage` WRITE;
/*!40000 ALTER TABLE `parameter_per_stage` DISABLE KEYS */;
INSERT INTO `parameter_per_stage` VALUES (1,1,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(2,1,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(3,1,8,51,0.20,NULL,NULL,NULL,NULL,NULL),(4,1,8,52,0.35,NULL,NULL,NULL,NULL,NULL),(5,1,8,53,0.20,NULL,NULL,NULL,NULL,NULL),(6,1,8,54,0.15,NULL,NULL,NULL,NULL,NULL),(7,1,8,55,0.10,NULL,NULL,NULL,NULL,NULL),(8,1,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(9,1,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(10,1,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(11,2,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(12,2,8,50,0.60,NULL,NULL,NULL,NULL,NULL),(13,2,8,51,0.20,NULL,NULL,NULL,NULL,NULL),(14,2,8,52,0.20,NULL,NULL,NULL,NULL,NULL),(15,2,8,53,0.00,NULL,NULL,NULL,NULL,NULL),(16,2,8,54,0.00,NULL,NULL,NULL,NULL,NULL),(17,2,8,55,0.00,NULL,NULL,NULL,NULL,NULL),(18,2,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(19,2,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(20,2,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(21,3,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(22,3,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(23,3,8,51,0.11,NULL,NULL,NULL,NULL,NULL),(24,3,8,52,0.42,NULL,NULL,NULL,NULL,NULL),(25,3,8,53,0.21,NULL,NULL,NULL,NULL,NULL),(26,3,8,54,0.21,NULL,NULL,NULL,NULL,NULL),(27,3,8,55,0.05,NULL,NULL,NULL,NULL,NULL),(28,3,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(29,3,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(30,3,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(31,4,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(32,4,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(33,4,8,51,0.11,NULL,NULL,NULL,NULL,NULL),(34,4,8,52,0.42,NULL,NULL,NULL,NULL,NULL),(35,4,8,53,0.21,NULL,NULL,NULL,NULL,NULL),(36,4,8,54,0.21,NULL,NULL,NULL,NULL,NULL),(37,4,8,55,0.05,NULL,NULL,NULL,NULL,NULL),(38,4,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(39,4,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(40,4,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(41,5,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(42,5,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(43,5,8,51,0.11,NULL,NULL,NULL,NULL,NULL),(44,5,8,52,0.42,NULL,NULL,NULL,NULL,NULL),(45,5,8,53,0.21,NULL,NULL,NULL,NULL,NULL),(46,5,8,54,0.21,NULL,NULL,NULL,NULL,NULL),(47,5,8,55,0.05,NULL,NULL,NULL,NULL,NULL),(48,5,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(49,5,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(50,5,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(51,6,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(52,6,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(53,6,8,51,0.11,NULL,NULL,NULL,NULL,NULL),(54,6,8,52,0.42,NULL,NULL,NULL,NULL,NULL),(55,6,8,53,0.21,NULL,NULL,NULL,NULL,NULL),(56,6,8,54,0.21,NULL,NULL,NULL,NULL,NULL),(57,6,8,55,0.05,NULL,NULL,NULL,NULL,NULL),(58,6,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(59,6,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(60,6,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(61,7,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(62,7,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(63,7,8,51,0.11,NULL,NULL,NULL,NULL,NULL),(64,7,8,52,0.42,NULL,NULL,NULL,NULL,NULL),(65,7,8,53,0.21,NULL,NULL,NULL,NULL,NULL),(66,7,8,54,0.21,NULL,NULL,NULL,NULL,NULL),(67,7,8,55,0.05,NULL,NULL,NULL,NULL,NULL),(68,7,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(69,7,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(70,7,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(71,8,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(72,8,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(73,8,8,51,0.11,NULL,NULL,NULL,NULL,NULL),(74,8,8,52,0.42,NULL,NULL,NULL,NULL,NULL),(75,8,8,53,0.21,NULL,NULL,NULL,NULL,NULL),(76,8,8,54,0.21,NULL,NULL,NULL,NULL,NULL),(77,8,8,55,0.05,NULL,NULL,NULL,NULL,NULL),(78,8,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(79,8,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(80,8,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(81,9,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(82,9,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(83,9,8,51,0.11,NULL,NULL,NULL,NULL,NULL),(84,9,8,52,0.42,NULL,NULL,NULL,NULL,NULL),(85,9,8,53,0.21,NULL,NULL,NULL,NULL,NULL),(86,9,8,54,0.21,NULL,NULL,NULL,NULL,NULL),(87,9,8,55,0.05,NULL,NULL,NULL,NULL,NULL),(88,9,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(89,9,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(90,9,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(91,10,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(92,10,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(93,10,8,51,0.11,NULL,NULL,NULL,NULL,NULL),(94,10,8,52,0.42,NULL,NULL,NULL,NULL,NULL),(95,10,8,53,0.21,NULL,NULL,NULL,NULL,NULL),(96,10,8,54,0.21,NULL,NULL,NULL,NULL,NULL),(97,10,8,55,0.05,NULL,NULL,NULL,NULL,NULL),(98,10,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(99,10,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(100,10,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(101,11,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(102,11,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(103,11,8,51,0.11,NULL,NULL,NULL,NULL,NULL),(104,11,8,52,0.42,NULL,NULL,NULL,NULL,NULL),(105,11,8,53,0.21,NULL,NULL,NULL,NULL,NULL),(106,11,8,54,0.21,NULL,NULL,NULL,NULL,NULL),(107,11,8,55,0.05,NULL,NULL,NULL,NULL,NULL),(108,11,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(109,11,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(110,11,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(111,12,8,49,0.00,NULL,NULL,NULL,NULL,NULL),(112,12,8,50,0.00,NULL,NULL,NULL,NULL,NULL),(113,12,8,51,0.11,NULL,NULL,NULL,NULL,NULL),(114,12,8,52,0.42,NULL,NULL,NULL,NULL,NULL),(115,12,8,53,0.21,NULL,NULL,NULL,NULL,NULL),(116,12,8,54,0.21,NULL,NULL,NULL,NULL,NULL),(117,12,8,55,0.05,NULL,NULL,NULL,NULL,NULL),(118,12,8,56,0.00,NULL,NULL,NULL,NULL,NULL),(119,12,8,57,0.00,NULL,NULL,NULL,NULL,NULL),(120,12,8,58,0.00,NULL,NULL,NULL,NULL,NULL),(121,1,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(122,1,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(123,1,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(124,1,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(125,1,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(126,1,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(127,1,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(128,2,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(129,2,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(130,2,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(131,2,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(132,2,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(133,2,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(134,2,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(135,3,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(136,3,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(137,3,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(138,3,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(139,3,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(140,3,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(141,3,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(142,4,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(143,4,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(144,4,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(145,4,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(146,4,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(147,4,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(148,4,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(149,5,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(150,5,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(151,5,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(152,5,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(153,5,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(154,5,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(155,5,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(156,6,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(157,6,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(158,6,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(159,6,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(160,6,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(161,6,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(162,6,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(163,7,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(164,7,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(165,7,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(166,7,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(167,7,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(168,7,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(169,7,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(170,8,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(171,8,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(172,8,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(173,8,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(174,8,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(175,8,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(176,8,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(177,9,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(178,9,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(179,9,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(180,9,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(181,9,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(182,9,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(183,9,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(184,10,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(185,10,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(186,10,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(187,10,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(188,10,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(189,10,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(190,10,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(191,11,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(192,11,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(193,11,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(194,11,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(195,11,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(196,11,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(197,11,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(198,12,2,19,0.05,NULL,NULL,NULL,NULL,NULL),(199,12,2,20,0.20,NULL,NULL,NULL,NULL,NULL),(200,12,2,21,0.10,NULL,NULL,NULL,NULL,NULL),(201,12,2,22,0.50,NULL,NULL,NULL,NULL,NULL),(202,12,2,23,0.15,NULL,NULL,NULL,NULL,NULL),(203,12,2,24,0.00,NULL,NULL,NULL,NULL,NULL),(204,12,2,25,0.00,NULL,NULL,NULL,NULL,NULL),(205,1,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(206,1,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(207,1,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(208,1,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(209,1,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(210,1,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(211,1,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(212,2,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(213,2,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(214,2,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(215,2,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(216,2,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(217,2,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(218,2,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(219,3,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(220,3,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(221,3,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(222,3,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(223,3,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(224,3,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(225,3,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(226,4,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(227,4,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(228,4,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(229,4,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(230,4,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(231,4,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(232,4,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(233,5,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(234,5,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(235,5,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(236,5,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(237,5,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(238,5,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(239,5,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(240,6,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(241,6,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(242,6,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(243,6,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(244,6,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(245,6,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(246,6,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(247,7,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(248,7,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(249,7,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(250,7,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(251,7,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(252,7,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(253,7,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(254,8,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(255,8,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(256,8,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(257,8,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(258,8,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(259,8,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(260,8,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(261,9,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(262,9,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(263,9,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(264,9,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(265,9,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(266,9,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(267,9,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(268,10,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(269,10,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(270,10,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(271,10,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(272,10,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(273,10,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(274,10,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(275,11,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(276,11,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(277,11,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(278,11,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(279,11,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(280,11,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(281,11,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(282,12,3,19,0.05,NULL,NULL,NULL,NULL,NULL),(283,12,3,20,0.20,NULL,NULL,NULL,NULL,NULL),(284,12,3,21,0.10,NULL,NULL,NULL,NULL,NULL),(285,12,3,22,0.50,NULL,NULL,NULL,NULL,NULL),(286,12,3,23,0.15,NULL,NULL,NULL,NULL,NULL),(287,12,3,24,0.00,NULL,NULL,NULL,NULL,NULL),(288,12,3,25,0.00,NULL,NULL,NULL,NULL,NULL),(289,1,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(290,1,7,33,0.10,NULL,NULL,NULL,NULL,NULL),(291,1,7,34,0.42,NULL,NULL,NULL,NULL,NULL),(292,1,7,35,0.48,NULL,NULL,NULL,NULL,NULL),(293,1,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(294,1,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(295,2,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(296,2,7,33,0.50,NULL,NULL,NULL,NULL,NULL),(297,2,7,34,0.50,NULL,NULL,NULL,NULL,NULL),(298,2,7,35,0.00,NULL,NULL,NULL,NULL,NULL),(299,2,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(300,2,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(301,3,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(302,3,7,33,0.10,NULL,NULL,NULL,NULL,NULL),(303,3,7,34,0.42,NULL,NULL,NULL,NULL,NULL),(304,3,7,35,0.48,NULL,NULL,NULL,NULL,NULL),(305,3,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(306,3,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(307,4,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(308,4,7,33,0.00,NULL,NULL,NULL,NULL,NULL),(309,4,7,34,0.00,NULL,NULL,NULL,NULL,NULL),(310,4,7,35,0.00,NULL,NULL,NULL,NULL,NULL),(311,4,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(312,4,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(313,5,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(314,5,7,33,0.00,NULL,NULL,NULL,NULL,NULL),(315,5,7,34,0.00,NULL,NULL,NULL,NULL,NULL),(316,5,7,35,0.00,NULL,NULL,NULL,NULL,NULL),(317,5,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(318,5,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(319,6,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(320,6,7,33,0.00,NULL,NULL,NULL,NULL,NULL),(321,6,7,34,0.00,NULL,NULL,NULL,NULL,NULL),(322,6,7,35,0.00,NULL,NULL,NULL,NULL,NULL),(323,6,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(324,6,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(325,7,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(326,7,7,33,0.00,NULL,NULL,NULL,NULL,NULL),(327,7,7,34,0.00,NULL,NULL,NULL,NULL,NULL),(328,7,7,35,0.00,NULL,NULL,NULL,NULL,NULL),(329,7,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(330,7,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(331,8,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(332,8,7,33,0.00,NULL,NULL,NULL,NULL,NULL),(333,8,7,34,0.00,NULL,NULL,NULL,NULL,NULL),(334,8,7,35,0.00,NULL,NULL,NULL,NULL,NULL),(335,8,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(336,8,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(337,9,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(338,9,7,33,0.00,NULL,NULL,NULL,NULL,NULL),(339,9,7,34,0.00,NULL,NULL,NULL,NULL,NULL),(340,9,7,35,0.00,NULL,NULL,NULL,NULL,NULL),(341,9,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(342,9,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(343,10,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(344,10,7,33,0.00,NULL,NULL,NULL,NULL,NULL),(345,10,7,34,0.00,NULL,NULL,NULL,NULL,NULL),(346,10,7,35,0.00,NULL,NULL,NULL,NULL,NULL),(347,10,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(348,10,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(349,11,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(350,11,7,33,0.00,NULL,NULL,NULL,NULL,NULL),(351,11,7,34,0.00,NULL,NULL,NULL,NULL,NULL),(352,11,7,35,0.00,NULL,NULL,NULL,NULL,NULL),(353,11,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(354,11,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(355,12,7,32,0.00,NULL,NULL,NULL,NULL,NULL),(356,12,7,33,0.00,NULL,NULL,NULL,NULL,NULL),(357,12,7,34,0.00,NULL,NULL,NULL,NULL,NULL),(358,12,7,35,0.00,NULL,NULL,NULL,NULL,NULL),(359,12,7,36,0.00,NULL,NULL,NULL,NULL,NULL),(360,12,7,37,0.00,NULL,NULL,NULL,NULL,NULL),(361,1,1,7,0.10,NULL,NULL,NULL,NULL,NULL),(362,1,1,8,0.08,NULL,NULL,NULL,NULL,NULL),(363,1,1,9,0.18,NULL,NULL,NULL,NULL,NULL),(364,1,1,10,0.18,NULL,NULL,NULL,NULL,NULL),(365,1,1,11,0.26,NULL,NULL,NULL,NULL,NULL),(366,1,1,12,0.20,NULL,NULL,NULL,NULL,NULL),(367,2,1,7,0.10,NULL,NULL,NULL,NULL,NULL),(368,2,1,8,0.08,NULL,NULL,NULL,NULL,NULL),(369,2,1,9,0.18,NULL,NULL,NULL,NULL,NULL),(370,2,1,10,0.18,NULL,NULL,NULL,NULL,NULL),(371,2,1,11,0.26,NULL,NULL,NULL,NULL,NULL),(372,2,1,12,0.20,NULL,NULL,NULL,NULL,NULL),(373,3,1,7,0.10,NULL,NULL,NULL,NULL,NULL),(374,3,1,8,0.08,NULL,NULL,NULL,NULL,NULL),(375,3,1,9,0.18,NULL,NULL,NULL,NULL,NULL),(376,3,1,10,0.18,NULL,NULL,NULL,NULL,NULL),(377,3,1,11,0.26,NULL,NULL,NULL,NULL,NULL),(378,3,1,12,0.20,NULL,NULL,NULL,NULL,NULL),(379,4,1,7,0.00,NULL,NULL,NULL,NULL,NULL),(380,4,1,8,0.00,NULL,NULL,NULL,NULL,NULL),(381,4,1,9,0.00,NULL,NULL,NULL,NULL,NULL),(382,4,1,10,0.00,NULL,NULL,NULL,NULL,NULL),(383,4,1,11,0.00,NULL,NULL,NULL,NULL,NULL),(384,4,1,12,0.00,NULL,NULL,NULL,NULL,NULL),(385,5,1,7,0.00,NULL,NULL,NULL,NULL,NULL),(386,5,1,8,0.00,NULL,NULL,NULL,NULL,NULL),(387,5,1,9,0.00,NULL,NULL,NULL,NULL,NULL),(388,5,1,10,0.00,NULL,NULL,NULL,NULL,NULL),(389,5,1,11,0.00,NULL,NULL,NULL,NULL,NULL),(390,5,1,12,0.00,NULL,NULL,NULL,NULL,NULL),(391,6,1,7,0.00,NULL,NULL,NULL,NULL,NULL),(392,6,1,8,0.00,NULL,NULL,NULL,NULL,NULL),(393,6,1,9,0.00,NULL,NULL,NULL,NULL,NULL),(394,6,1,10,0.00,NULL,NULL,NULL,NULL,NULL),(395,6,1,11,0.00,NULL,NULL,NULL,NULL,NULL),(396,6,1,12,0.00,NULL,NULL,NULL,NULL,NULL),(397,7,1,7,0.00,NULL,NULL,NULL,NULL,NULL),(398,7,1,8,0.00,NULL,NULL,NULL,NULL,NULL),(399,7,1,9,0.00,NULL,NULL,NULL,NULL,NULL),(400,7,1,10,0.00,NULL,NULL,NULL,NULL,NULL),(401,7,1,11,0.00,NULL,NULL,NULL,NULL,NULL),(402,7,1,12,0.00,NULL,NULL,NULL,NULL,NULL),(403,8,1,7,0.00,NULL,NULL,NULL,NULL,NULL),(404,8,1,8,0.00,NULL,NULL,NULL,NULL,NULL),(405,8,1,9,0.00,NULL,NULL,NULL,NULL,NULL),(406,8,1,10,0.00,NULL,NULL,NULL,NULL,NULL),(407,8,1,11,0.00,NULL,NULL,NULL,NULL,NULL),(408,8,1,12,0.00,NULL,NULL,NULL,NULL,NULL),(409,9,1,7,0.00,NULL,NULL,NULL,NULL,NULL),(410,9,1,8,0.00,NULL,NULL,NULL,NULL,NULL),(411,9,1,9,0.00,NULL,NULL,NULL,NULL,NULL),(412,9,1,10,0.00,NULL,NULL,NULL,NULL,NULL),(413,9,1,11,0.00,NULL,NULL,NULL,NULL,NULL),(414,9,1,12,0.00,NULL,NULL,NULL,NULL,NULL),(415,10,1,7,0.00,NULL,NULL,NULL,NULL,NULL),(416,10,1,8,0.00,NULL,NULL,NULL,NULL,NULL),(417,10,1,9,0.00,NULL,NULL,NULL,NULL,NULL),(418,10,1,10,0.00,NULL,NULL,NULL,NULL,NULL),(419,10,1,11,0.00,NULL,NULL,NULL,NULL,NULL),(420,10,1,12,0.00,NULL,NULL,NULL,NULL,NULL),(421,11,1,7,0.00,NULL,NULL,NULL,NULL,NULL),(422,11,1,8,0.00,NULL,NULL,NULL,NULL,NULL),(423,11,1,9,0.00,NULL,NULL,NULL,NULL,NULL),(424,11,1,10,0.00,NULL,NULL,NULL,NULL,NULL),(425,11,1,11,0.00,NULL,NULL,NULL,NULL,NULL),(426,11,1,12,0.00,NULL,NULL,NULL,NULL,NULL),(427,12,1,7,0.00,NULL,NULL,NULL,NULL,NULL),(428,12,1,8,0.00,NULL,NULL,NULL,NULL,NULL),(429,12,1,9,0.00,NULL,NULL,NULL,NULL,NULL),(430,12,1,10,0.00,NULL,NULL,NULL,NULL,NULL),(431,12,1,11,0.00,NULL,NULL,NULL,NULL,NULL),(432,12,1,12,0.00,NULL,NULL,NULL,NULL,NULL),(433,1,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(434,1,10,27,0.23,NULL,NULL,NULL,NULL,NULL),(435,1,10,28,0.25,NULL,NULL,NULL,NULL,NULL),(436,1,10,29,0.37,NULL,NULL,NULL,NULL,NULL),(437,1,10,30,0.14,NULL,NULL,NULL,NULL,NULL),(438,1,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(439,2,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(440,2,10,27,0.36,NULL,NULL,NULL,NULL,NULL),(441,2,10,28,0.20,NULL,NULL,NULL,NULL,NULL),(442,2,10,29,0.30,NULL,NULL,NULL,NULL,NULL),(443,2,10,30,0.14,NULL,NULL,NULL,NULL,NULL),(444,2,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(445,3,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(446,3,10,27,0.19,NULL,NULL,NULL,NULL,NULL),(447,3,10,28,0.20,NULL,NULL,NULL,NULL,NULL),(448,3,10,29,0.44,NULL,NULL,NULL,NULL,NULL),(449,3,10,30,0.17,NULL,NULL,NULL,NULL,NULL),(450,3,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(451,4,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(452,4,10,27,0.70,NULL,NULL,NULL,NULL,NULL),(453,4,10,28,0.30,NULL,NULL,NULL,NULL,NULL),(454,4,10,29,0.00,NULL,NULL,NULL,NULL,NULL),(455,4,10,30,0.00,NULL,NULL,NULL,NULL,NULL),(456,4,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(457,5,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(458,5,10,27,0.70,NULL,NULL,NULL,NULL,NULL),(459,5,10,28,0.30,NULL,NULL,NULL,NULL,NULL),(460,5,10,29,0.00,NULL,NULL,NULL,NULL,NULL),(461,5,10,30,0.00,NULL,NULL,NULL,NULL,NULL),(462,5,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(463,6,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(464,6,10,27,0.30,NULL,NULL,NULL,NULL,NULL),(465,6,10,28,0.25,NULL,NULL,NULL,NULL,NULL),(466,6,10,29,0.35,NULL,NULL,NULL,NULL,NULL),(467,6,10,30,0.10,NULL,NULL,NULL,NULL,NULL),(468,6,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(469,7,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(470,7,10,27,0.30,NULL,NULL,NULL,NULL,NULL),(471,7,10,28,0.25,NULL,NULL,NULL,NULL,NULL),(472,7,10,29,0.35,NULL,NULL,NULL,NULL,NULL),(473,7,10,30,0.10,NULL,NULL,NULL,NULL,NULL),(474,7,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(475,8,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(476,8,10,27,0.30,NULL,NULL,NULL,NULL,NULL),(477,8,10,28,0.25,NULL,NULL,NULL,NULL,NULL),(478,8,10,29,0.35,NULL,NULL,NULL,NULL,NULL),(479,8,10,30,0.10,NULL,NULL,NULL,NULL,NULL),(480,8,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(481,9,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(482,9,10,27,0.26,NULL,NULL,NULL,NULL,NULL),(483,9,10,28,0.20,NULL,NULL,NULL,NULL,NULL),(484,9,10,29,0.49,NULL,NULL,NULL,NULL,NULL),(485,9,10,30,0.05,NULL,NULL,NULL,NULL,NULL),(486,9,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(487,10,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(488,10,10,27,0.26,NULL,NULL,NULL,NULL,NULL),(489,10,10,28,0.20,NULL,NULL,NULL,NULL,NULL),(490,10,10,29,0.49,NULL,NULL,NULL,NULL,NULL),(491,10,10,30,0.05,NULL,NULL,NULL,NULL,NULL),(492,10,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(493,11,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(494,11,10,27,0.30,NULL,NULL,NULL,NULL,NULL),(495,11,10,28,0.25,NULL,NULL,NULL,NULL,NULL),(496,11,10,29,0.35,NULL,NULL,NULL,NULL,NULL),(497,11,10,30,0.10,NULL,NULL,NULL,NULL,NULL),(498,11,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(499,12,10,26,0.00,NULL,NULL,NULL,NULL,NULL),(500,12,10,27,0.30,NULL,NULL,NULL,NULL,NULL),(501,12,10,28,0.25,NULL,NULL,NULL,NULL,NULL),(502,12,10,29,0.35,NULL,NULL,NULL,NULL,NULL),(503,12,10,30,0.10,NULL,NULL,NULL,NULL,NULL),(504,12,10,31,0.00,NULL,NULL,NULL,NULL,NULL),(505,1,15,44,0.15,NULL,NULL,NULL,NULL,NULL),(506,1,15,45,0.25,NULL,NULL,NULL,NULL,NULL),(507,1,15,46,0.30,NULL,NULL,NULL,NULL,NULL),(508,1,15,47,0.30,NULL,NULL,NULL,NULL,NULL),(509,1,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(510,2,15,44,0.25,NULL,NULL,NULL,NULL,NULL),(511,2,15,45,0.30,NULL,NULL,NULL,NULL,NULL),(512,2,15,46,0.30,NULL,NULL,NULL,NULL,NULL),(513,2,15,47,0.15,NULL,NULL,NULL,NULL,NULL),(514,2,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(515,3,15,44,0.10,NULL,NULL,NULL,NULL,NULL),(516,3,15,45,0.40,NULL,NULL,NULL,NULL,NULL),(517,3,15,46,0.25,NULL,NULL,NULL,NULL,NULL),(518,3,15,47,0.25,NULL,NULL,NULL,NULL,NULL),(519,3,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(520,4,15,44,0.10,NULL,NULL,NULL,NULL,NULL),(521,4,15,45,0.35,NULL,NULL,NULL,NULL,NULL),(522,4,15,46,0.20,NULL,NULL,NULL,NULL,NULL),(523,4,15,47,0.35,NULL,NULL,NULL,NULL,NULL),(524,4,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(525,5,15,44,0.10,NULL,NULL,NULL,NULL,NULL),(526,5,15,45,0.40,NULL,NULL,NULL,NULL,NULL),(527,5,15,46,0.25,NULL,NULL,NULL,NULL,NULL),(528,5,15,47,0.25,NULL,NULL,NULL,NULL,NULL),(529,5,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(530,6,15,44,0.10,NULL,NULL,NULL,NULL,NULL),(531,6,15,45,0.40,NULL,NULL,NULL,NULL,NULL),(532,6,15,46,0.25,NULL,NULL,NULL,NULL,NULL),(533,6,15,47,0.25,NULL,NULL,NULL,NULL,NULL),(534,6,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(535,7,15,44,0.00,NULL,NULL,NULL,NULL,NULL),(536,7,15,45,0.00,NULL,NULL,NULL,NULL,NULL),(537,7,15,46,0.00,NULL,NULL,NULL,NULL,NULL),(538,7,15,47,0.00,NULL,NULL,NULL,NULL,NULL),(539,7,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(540,8,15,44,0.00,NULL,NULL,NULL,NULL,NULL),(541,8,15,45,0.00,NULL,NULL,NULL,NULL,NULL),(542,8,15,46,0.00,NULL,NULL,NULL,NULL,NULL),(543,8,15,47,0.00,NULL,NULL,NULL,NULL,NULL),(544,8,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(545,9,15,44,0.00,NULL,NULL,NULL,NULL,NULL),(546,9,15,45,0.00,NULL,NULL,NULL,NULL,NULL),(547,9,15,46,0.00,NULL,NULL,NULL,NULL,NULL),(548,9,15,47,0.00,NULL,NULL,NULL,NULL,NULL),(549,9,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(550,10,15,44,0.00,NULL,NULL,NULL,NULL,NULL),(551,10,15,45,0.00,NULL,NULL,NULL,NULL,NULL),(552,10,15,46,0.00,NULL,NULL,NULL,NULL,NULL),(553,10,15,47,0.00,NULL,NULL,NULL,NULL,NULL),(554,10,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(555,11,15,44,0.00,NULL,NULL,NULL,NULL,NULL),(556,11,15,45,0.00,NULL,NULL,NULL,NULL,NULL),(557,11,15,46,0.00,NULL,NULL,NULL,NULL,NULL),(558,11,15,47,0.00,NULL,NULL,NULL,NULL,NULL),(559,11,15,48,0.00,NULL,NULL,NULL,NULL,NULL),(560,12,15,44,0.00,NULL,NULL,NULL,NULL,NULL),(561,12,15,45,0.00,NULL,NULL,NULL,NULL,NULL),(562,12,15,46,0.00,NULL,NULL,NULL,NULL,NULL),(563,12,15,47,0.00,NULL,NULL,NULL,NULL,NULL),(564,12,15,48,0.00,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `parameter_per_stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter_ph_effect`
--

DROP TABLE IF EXISTS `parameter_ph_effect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parameter_ph_effect` (
  `effect_id` int(11) NOT NULL AUTO_INCREMENT,
  `parameter_id` int(11) NOT NULL,
  `range_id` int(11) NOT NULL,
  `effect` decimal(2,2) NOT NULL,
  PRIMARY KEY (`effect_id`),
  KEY `fk_parameter_ph_effect_parameters` (`parameter_id`),
  CONSTRAINT `fk_nutrient_ph_effect_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`),
  CONSTRAINT `fk_parameter_ph_effect_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter_ph_effect`
--

LOCK TABLES `parameter_ph_effect` WRITE;
/*!40000 ALTER TABLE `parameter_ph_effect` DISABLE KEYS */;
INSERT INTO `parameter_ph_effect` VALUES (1,1,1,0.05),(2,2,1,0.10),(3,3,1,0.05),(4,4,1,0.10),(5,5,1,0.10),(6,6,1,0.05),(7,7,1,-0.05),(8,8,1,0.00),(9,9,1,0.05),(10,10,1,0.05),(11,11,1,0.05),(12,12,1,0.10),(13,1,2,0.05),(14,2,2,0.10),(15,3,2,0.05),(16,4,2,0.05),(17,5,2,0.05),(18,6,2,0.00),(19,7,2,0.00),(20,8,2,0.00),(21,9,2,0.00),(22,10,2,0.00),(23,11,2,0.00),(24,12,2,0.05),(25,1,3,0.00),(26,2,3,0.00),(27,3,3,0.00),(28,4,3,0.00),(29,5,3,0.00),(30,6,3,0.00),(31,7,3,0.00),(32,8,3,0.00),(33,9,3,0.00),(34,10,3,0.00),(35,11,3,0.00),(36,12,3,0.00),(37,1,4,0.00),(38,2,4,0.05),(39,3,4,0.00),(40,4,4,0.00),(41,5,4,0.00),(42,6,4,0.00),(43,7,4,0.05),(44,8,4,0.00),(45,9,4,0.05),(46,10,4,0.05),(47,11,4,0.05),(48,12,4,0.00),(49,1,5,0.05),(50,2,5,0.00),(51,3,5,0.00),(52,4,5,0.05),(53,5,5,0.00),(54,6,5,0.00),(55,7,5,0.15),(56,8,5,0.05),(57,9,5,0.00),(58,10,5,0.10),(59,11,5,0.10),(60,12,5,-0.10);
/*!40000 ALTER TABLE `parameter_ph_effect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameters`
--

DROP TABLE IF EXISTS `parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parameters` (
  `parameter_id` int(11) NOT NULL,
  `element_id` int(11) NOT NULL,
  `data_type_id` int(11) DEFAULT NULL,
  `very_low_factor` decimal(3,2) DEFAULT NULL,
  `low_factor` decimal(3,2) DEFAULT NULL,
  `high_factor` decimal(3,2) DEFAULT NULL,
  `very_high_factor` decimal(3,2) DEFAULT NULL,
  `pre_low_factor` decimal(3,2) DEFAULT NULL,
  `pre_high_factor` decimal(3,2) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`parameter_id`),
  KEY `idx_analysis_parameters_data_type_id` (`data_type_id`),
  KEY `idx_analysis_parameters_element_id` (`element_id`),
  CONSTRAINT `fk_analysis_parameters_data_types` FOREIGN KEY (`data_type_id`) REFERENCES `data_types` (`data_type_id`),
  CONSTRAINT `fk_analysis_parameters_elements` FOREIGN KEY (`element_id`) REFERENCES `elements` (`element_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameters`
--

LOCK TABLES `parameters` WRITE;
/*!40000 ALTER TABLE `parameters` DISABLE KEYS */;
INSERT INTO `parameters` VALUES (1,1,1,1.00,1.00,1.00,1.00,1.00,1.00,NULL,NULL,NULL,NULL,NULL),(2,2,1,0.20,0.10,0.10,0.20,0.50,0.50,NULL,NULL,NULL,NULL,NULL),(3,3,1,0.20,0.10,0.10,0.20,0.50,0.50,NULL,NULL,NULL,NULL,NULL),(4,4,2,0.20,0.10,0.10,0.20,0.50,0.50,NULL,NULL,NULL,NULL,NULL),(5,5,2,0.20,0.10,0.10,0.20,0.50,0.50,NULL,NULL,NULL,NULL,NULL),(6,6,2,1.00,1.00,1.00,1.00,1.00,1.00,NULL,NULL,NULL,NULL,NULL),(7,7,3,0.00,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL),(8,8,3,0.00,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL),(9,9,3,0.00,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL),(10,10,3,0.00,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL),(11,11,3,0.00,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL),(12,12,3,0.00,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameters_group`
--

DROP TABLE IF EXISTS `parameters_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parameters_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(100) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameters_group`
--

LOCK TABLES `parameters_group` WRITE;
/*!40000 ALTER TABLE `parameters_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `parameters_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ph_ranges`
--

DROP TABLE IF EXISTS `ph_ranges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ph_ranges` (
  `range_id` int(11) NOT NULL AUTO_INCREMENT,
  `range_desc` varchar(20) NOT NULL,
  `min_ph_range` decimal(4,2) NOT NULL,
  `max_ph_range` decimal(4,2) NOT NULL,
  PRIMARY KEY (`range_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ph_ranges`
--

LOCK TABLES `ph_ranges` WRITE;
/*!40000 ALTER TABLE `ph_ranges` DISABLE KEYS */;
INSERT INTO `ph_ranges` VALUES (1,'Very_Acidic',0.00,4.50),(2,'Acidic',4.51,5.50),(3,'Neutral',5.51,7.50),(4,'Slightly_Alkaline',7.51,8.50),(5,'Alkaline',8.51,14.00);
/*!40000 ALTER TABLE `ph_ranges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pheonological stage`
--

DROP TABLE IF EXISTS `pheonological stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pheonological stage` (
  `pheonological_stage_id` int(11) NOT NULL,
  `pheonological stage_desc` varchar(50) NOT NULL,
  `crop_id` int(11) NOT NULL,
  `pheonological_stage_duration_days` int(11) NOT NULL,
  `pheonological_stage_duration_gdd` int(11) DEFAULT NULL,
  PRIMARY KEY (`pheonological_stage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pheonological stage`
--

LOCK TABLES `pheonological stage` WRITE;
/*!40000 ALTER TABLE `pheonological stage` DISABLE KEYS */;
INSERT INTO `pheonological stage` VALUES (1,'Dormancy break',3,15,NULL),(2,'Flowering and early leaves',3,15,NULL),(3,'Yield forming and ripening',3,90,NULL),(4,'Fruit picking',3,30,NULL),(5,'Recovery',3,60,NULL),(6,'Dormancy',3,110,NULL),(7,'Floral bud break',4,30,NULL),(8,'Flowering to fruit set',4,30,NULL),(9,'Fruitlet growth and fruit drop',4,60,NULL),(10,'Fruit growth',4,60,NULL),(11,'Fruit growth and flower differentiation',4,90,NULL),(12,'Harvest and flower development',4,95,NULL),(13,'Flowering/Vegetation',15,45,NULL),(14,'Fruit setting/Vegetation',15,60,NULL),(15,'Vegetation/Fruit Growth',15,90,NULL),(16,'Dry matter accumulation',15,60,NULL),(17,'Fruit Growth',15,30,NULL),(18,'Harvesting',15,45,NULL),(19,'Pre Flowering',6,15,NULL),(20,'Flowering',6,30,NULL),(21,'Fruit set',6,30,NULL),(22,'Fruit growth',6,150,NULL),(23,'Fruit maturation',6,60,NULL),(24,'Harvest',6,30,NULL),(25,'Induced stress',6,50,NULL),(26,'GE',2,7,NULL),(27,'VE-V7',2,24,NULL),(28,'V8-V12',2,13,NULL),(29,'V13-VT',2,18,NULL),(30,'R1-R2',2,18,NULL),(31,'R3-R6',2,40,NULL),(32,'Emergence and eastablishment',7,15,NULL),(33,'Vegetative growth',7,43,NULL),(34,'Square formation',7,38,NULL),(35,'Flowering& boll seting',7,38,NULL),(36,'Boll developmant',7,28,NULL),(37,'Maturity & harvest',7,18,NULL),(38,'Bud breaking to swollen calyx',14,60,NULL),(39,'Early flowers to young fruits',14,25,NULL),(40,'Fruit set and fruit growth',14,70,NULL),(41,'Final Ripening',14,30,NULL),(42,'Recovery and post harvest',14,30,NULL),(43,'Dormancy',14,150,NULL),(44,'Sprout developmant',1,15,NULL),(45,'Vegetative growth',1,20,NULL),(46,'Tuber intiation',1,20,NULL),(47,'Tuber bulking',1,35,NULL),(48,'tuber maturation',1,30,NULL),(49,'Vegetative growth',8,20,NULL),(50,'Flowering',8,10,NULL),(51,'Fruit set',8,10,NULL),(52,'Fruit growth phase 1',8,20,NULL),(53,'Fruit growth phase 2',8,10,NULL),(54,'Fruit growth phase 3',8,10,NULL),(55,'10 % red fruit',8,10,NULL),(56,'40 % red fruit',8,10,NULL),(57,'90 % red fruit',8,10,NULL),(58,'Harvest',8,10,NULL),(59,'VE',10,20,NULL),(60,'V1',10,5,NULL),(61,'V2',10,5,NULL),(62,'V3',10,15,NULL),(63,'R1',10,10,NULL),(64,'R3',10,32,NULL),(65,'R6',10,16,NULL),(66,'R7',10,10,NULL),(67,'R8',10,10,NULL),(68,'Eastablishment',9,17,NULL),(69,'Vegetative Growth',9,13,NULL),(70,'Flowering',9,30,NULL),(71,'1st fruits wave',9,60,NULL),(72,'2nd fruits wave',9,45,NULL),(73,'3rd fruits wave',9,21,NULL),(74,'4th fruits wave',9,21,NULL),(75,'Ratooning/ germination',5,30,NULL),(76,'tillering',5,60,NULL),(77,'grand growth',5,120,NULL),(78,'ripening',5,60,NULL),(79,'Maturation',5,60,NULL),(80,'Harvest/ planting',5,30,NULL),(81,'Bud break to flowering',12,40,NULL),(82,'Frutiset and berry enlargemant',12,90,NULL),(83,'Maturation',12,50,NULL),(84,'Bud break to flowering',11,65,NULL),(85,'Flowering to Pea size berry',11,50,NULL),(86,'Pea size berry to veraison ',11,30,NULL),(87,'Veraison to 17°Brix',11,30,NULL),(88,'17°Brix to harvest',11,21,NULL),(89,'Post harvest',11,21,NULL),(90,'Seeding to 3-4 leaves',13,52,NULL),(91,'Vegetative growth',13,25,NULL),(92,'Begging of bulb',13,58,NULL),(93,'Canopy senescense',13,15,NULL);
/*!40000 ALTER TABLE `pheonological stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `previous_crop_n_credit`
--

DROP TABLE IF EXISTS `previous_crop_n_credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `previous_crop_n_credit` (
  `previous_crop_id` int(11) NOT NULL AUTO_INCREMENT,
  `previous_crop_name` varchar(50) NOT NULL,
  `percent` int(11) DEFAULT NULL,
  `ncredit` int(11) NOT NULL,
  PRIMARY KEY (`previous_crop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `previous_crop_n_credit`
--

LOCK TABLES `previous_crop_n_credit` WRITE;
/*!40000 ALTER TABLE `previous_crop_n_credit` DISABLE KEYS */;
INSERT INTO `previous_crop_n_credit` VALUES (1,'Alfalfa (established more than one year)',50,101),(2,'Alfalfa (established more than one year)',75,129),(3,'Alfalfa (established more than one year)',100,157),(4,'Alfalfa, seeding (6-12 monthes after seeding)',50,73),(5,'Alfalfa, seeding (6-12 monthes after seeding)',75,87),(6,'Alfalfa, seeding (6-12 monthes after seeding)',100,101),(7,'Clover (established more than one year)',50,73),(8,'Clover (established more than one year)',75,87),(9,'Clover (established more than one year)',100,101),(10,'Clover, seeding (6-12 monthes after seeding)',50,50),(11,'Clover, seeding (6-12 monthes after seeding)',75,64),(12,'Clover, seeding (6-12 monthes after seeding)',100,78),(13,'Barley+ legume',75,62),(14,'Barley+ legume',100,76),(15,'Barley+ legume',50,90),(16,'Oats+ legume',75,62),(17,'Oats+ legume',100,76),(18,'Oats+ legume',50,90),(19,'Wheat+ legume',75,62),(20,'Wheat+ legume',100,76),(21,'Wheat+ legume',50,90),(22,'Clover-grass hay',NULL,45),(23,'Grass hay',NULL,45),(24,'Dry edible beans',NULL,22),(25,'Soybeans',NULL,34),(26,'CRP land (whether grass/ legume or just grass)',NULL,45),(27,'Other',NULL,0);
/*!40000 ALTER TABLE `previous_crop_n_credit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommendations`
--

DROP TABLE IF EXISTS `recommendations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recommendations` (
  `recommendation_id` int(11) NOT NULL AUTO_INCREMENT,
  `recommendation` json DEFAULT NULL,
  `is_edited_by_user` bit(1) NOT NULL,
  `org_recommendations` json NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime DEFAULT NULL,
  `is_nutrient_recommendation` bit(1) NOT NULL,
  `is_fertilizer_recommendation` bit(1) DEFAULT NULL,
  PRIMARY KEY (`recommendation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendations`
--

LOCK TABLES `recommendations` WRITE;
/*!40000 ALTER TABLE `recommendations` DISABLE KEYS */;
/*!40000 ALTER TABLE `recommendations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soil_interpretation`
--

DROP TABLE IF EXISTS `soil_interpretation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `soil_interpretation` (
  `soil_interpretation_id` int(11) NOT NULL AUTO_INCREMENT,
  `farm_id` int(11) NOT NULL,
  `soil_analysis_id` int(11) NOT NULL,
  `is_extraction` bit(1) NOT NULL,
  `parameter_id` int(11) NOT NULL,
  `uom_id` int(11) NOT NULL,
  `interpretation` tinyint(4) DEFAULT NULL COMMENT 'ENUM :\n1 - Very low\n2- Low\n3- Sufficent\n4- High\n5 - Very high',
  `user_insert` varchar(15) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(15) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`soil_interpretation_id`),
  KEY `idx_tissue_interpretation_parameter_id_1` (`parameter_id`),
  KEY `idx_tissue_interpretation_uom_id_1` (`uom_id`),
  CONSTRAINT `fk_soil_interpretation_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`),
  CONSTRAINT `fk_soil_interpretation_uom` FOREIGN KEY (`uom_id`) REFERENCES `uom` (`uom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soil_interpretation`
--

LOCK TABLES `soil_interpretation` WRITE;
/*!40000 ALTER TABLE `soil_interpretation` DISABLE KEYS */;
/*!40000 ALTER TABLE `soil_interpretation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soil_interpretation_parameters`
--

DROP TABLE IF EXISTS `soil_interpretation_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `soil_interpretation_parameters` (
  `interpretation_id` int(11) NOT NULL,
  `parameter_id` int(11) NOT NULL,
  `vl_threshold` varchar(15) DEFAULT 'Very Low',
  `l_threshold` varchar(15) DEFAULT 'Low',
  `h_threshold` varchar(15) DEFAULT 'High',
  `vh_threshold` varchar(15) DEFAULT 'Very High',
  `target_value` decimal(10,0) DEFAULT NULL,
  `notification_string_when_very_low` varchar(15) DEFAULT 'Very Low',
  `notification_string_when_low` varchar(15) DEFAULT 'Low',
  `notification_string_when_high` varchar(15) DEFAULT 'High',
  `notification_string_when_very_high` varchar(15) DEFAULT 'Very High',
  PRIMARY KEY (`interpretation_id`),
  KEY `idx_soil_interpretation_parameters_parameter_id` (`parameter_id`),
  CONSTRAINT `fk_soil_interpretation_parameters_analysis_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soil_interpretation_parameters`
--

LOCK TABLES `soil_interpretation_parameters` WRITE;
/*!40000 ALTER TABLE `soil_interpretation_parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `soil_interpretation_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soil_lab_analysis`
--

DROP TABLE IF EXISTS `soil_lab_analysis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `soil_lab_analysis` (
  `soil_analysis_id` int(11) NOT NULL AUTO_INCREMENT,
  `farm_id` int(11) NOT NULL,
  `sample_date` datetime NOT NULL,
  `lab_id` int(11) DEFAULT NULL,
  `test_type_id` int(11) NOT NULL,
  `id_status` int(11) DEFAULT NULL,
  `sample_name` varchar(100) DEFAULT NULL,
  `irrigation_block_id` int(11) NOT NULL,
  `phenological_stage_id` int(11) DEFAULT NULL,
  `soil_pH` decimal(10,3) DEFAULT NULL,
  `soil_EC` decimal(10,3) DEFAULT NULL,
  `soil_CEC` decimal(10,3) DEFAULT NULL,
  `longitude` decimal(10,0) DEFAULT NULL,
  `latitude` decimal(10,0) DEFAULT NULL,
  `layer_depth_id` int(11) NOT NULL,
  `soil_type_id` int(11) NOT NULL,
  `bulk_density` decimal(5,4) DEFAULT NULL,
  `organic_matter` decimal(5,4) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `user_delete` varchar(20) DEFAULT NULL,
  `date_delete` datetime DEFAULT NULL,
  PRIMARY KEY (`soil_analysis_id`),
  KEY `idx_tissue_lab_analysis_phenological_stage_id_0` (`phenological_stage_id`),
  KEY `idx_tissue_lab_analysis_irrigation_block_id_0` (`irrigation_block_id`),
  KEY `idx_tissue_lab_analysis_test_type_id_0` (`test_type_id`),
  KEY `idx_soil_lab_analysis_lab_id` (`lab_id`),
  KEY `idx_soil_lab_analysis_id_status` (`id_status`),
  KEY `idx_soil_lab_analysis_farm_id` (`farm_id`),
  KEY `idx_soil_lab_analysis_layer_depth_id` (`layer_depth_id`),
  CONSTRAINT `fk_soil_lab_analysis_farms` FOREIGN KEY (`farm_id`) REFERENCES `farms` (`farm_id`),
  CONSTRAINT `fk_soil_lab_analysis_irrigation_blocks` FOREIGN KEY (`irrigation_block_id`) REFERENCES `irrigation_blocks` (`ib_id`),
  CONSTRAINT `fk_soil_lab_analysis_lab_analysis__status` FOREIGN KEY (`id_status`) REFERENCES `analysis status type` (`id_status`),
  CONSTRAINT `fk_soil_lab_analysis_labs` FOREIGN KEY (`lab_id`) REFERENCES `labs` (`lab_id`),
  CONSTRAINT `fk_soil_lab_analysis_layer_depth_type` FOREIGN KEY (`layer_depth_id`) REFERENCES `layer_depth_type` (`layer_depth_id`),
  CONSTRAINT `fk_soil_lab_analysis_pheonological_stage` FOREIGN KEY (`phenological_stage_id`) REFERENCES `pheonological stage` (`pheonological_stage_id`),
  CONSTRAINT `fk_soil_lab_analysis_test_type` FOREIGN KEY (`test_type_id`) REFERENCES `test_type` (`test_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22223 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soil_lab_analysis`
--

LOCK TABLES `soil_lab_analysis` WRITE;
/*!40000 ALTER TABLE `soil_lab_analysis` DISABLE KEYS */;
INSERT INTO `soil_lab_analysis` VALUES (111,222,'2018-03-01 00:00:00',333,1,NULL,'aaa',4444,NULL,5.000,2.000,3.000,NULL,NULL,1,11,1.3000,1.2000,NULL,NULL,NULL,NULL,NULL,NULL),(1231,222,'2018-03-01 00:00:00',333,1,NULL,'aaa',4444,NULL,0.000,0.000,0.000,NULL,NULL,1,11,0.0000,1.1000,NULL,NULL,NULL,NULL,NULL,NULL),(22222,12,'2019-05-02 00:00:00',11,1,NULL,'test',2,NULL,2.000,3.000,4.000,NULL,NULL,1,11,0.0000,0.0000,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `soil_lab_analysis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soil_thresholds`
--

DROP TABLE IF EXISTS `soil_thresholds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `soil_thresholds` (
  `soil_threshold_id` int(11) NOT NULL AUTO_INCREMENT,
  `lab_id` int(11) DEFAULT NULL,
  `extraction_method_id` int(11) NOT NULL,
  `soil_analysis_id` int(11) DEFAULT NULL,
  `parameter_id` int(11) DEFAULT NULL,
  `uom_id` int(11) NOT NULL,
  `farm_id` int(11) DEFAULT NULL,
  `other_lab_name` varchar(200) DEFAULT NULL,
  `lab_website` varchar(100) DEFAULT NULL,
  `lab_phone` varchar(15) DEFAULT NULL,
  `lab_address` varchar(250) DEFAULT NULL,
  `very_low_threshold` decimal(10,3) DEFAULT NULL,
  `low_threshold` decimal(10,3) DEFAULT NULL,
  `high_threshold` decimal(10,3) DEFAULT NULL,
  `very_high_threshold` decimal(10,3) DEFAULT NULL,
  `target_value` decimal(10,3) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `user_delete` varchar(20) DEFAULT NULL,
  `date_delete` datetime DEFAULT NULL,
  PRIMARY KEY (`soil_threshold_id`),
  KEY `idx_soil_thresholds_lab_id` (`lab_id`),
  KEY `idx_soil_thresholds_soil_analysis_id` (`soil_analysis_id`),
  KEY `idx_soil_thresholds_parameter_id` (`parameter_id`),
  CONSTRAINT `fk_soil_thresholds_analysis_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`),
  CONSTRAINT `fk_soil_thresholds_labs` FOREIGN KEY (`lab_id`) REFERENCES `labs` (`lab_id`),
  CONSTRAINT `fk_soil_thresholds_soil_lab_analysis` FOREIGN KEY (`soil_analysis_id`) REFERENCES `soil_lab_analysis` (`soil_analysis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soil_thresholds`
--

LOCK TABLES `soil_thresholds` WRITE;
/*!40000 ALTER TABLE `soil_thresholds` DISABLE KEYS */;
INSERT INTO `soil_thresholds` VALUES (1,1,1,NULL,2,1,NULL,NULL,NULL,NULL,NULL,3.000,7.000,13.000,22.000,11.200,NULL,NULL,NULL,NULL,NULL,NULL),(2,1,2,NULL,3,18,NULL,NULL,NULL,NULL,NULL,0.005,0.020,0.050,0.150,0.041,NULL,NULL,NULL,NULL,NULL,NULL),(3,1,2,NULL,4,18,NULL,NULL,NULL,NULL,NULL,0.350,0.650,0.800,0.950,0.755,NULL,NULL,NULL,NULL,NULL,NULL),(4,1,2,NULL,5,18,NULL,NULL,NULL,NULL,NULL,0.040,0.100,0.150,0.230,0.135,NULL,NULL,NULL,NULL,NULL,NULL),(5,1,3,NULL,6,1,NULL,NULL,NULL,NULL,NULL,5.000,10.000,30.000,40.000,24.000,NULL,NULL,NULL,NULL,NULL,NULL),(6,1,4,NULL,7,1,NULL,NULL,NULL,NULL,NULL,1.200,2.500,4.500,20.000,3.900,NULL,NULL,NULL,NULL,NULL,NULL),(7,1,4,NULL,8,1,NULL,NULL,NULL,NULL,NULL,0.500,1.000,2.000,3.500,1.700,NULL,NULL,NULL,NULL,NULL,NULL),(8,1,5,NULL,9,1,NULL,NULL,NULL,NULL,NULL,0.300,0.750,1.500,5.000,1.275,NULL,NULL,NULL,NULL,NULL,NULL),(9,1,4,NULL,10,1,NULL,NULL,NULL,NULL,NULL,0.200,0.500,0.800,2.000,0.710,NULL,NULL,NULL,NULL,NULL,NULL),(10,1,4,NULL,11,1,NULL,NULL,NULL,NULL,NULL,0.150,0.300,0.600,0.900,0.510,NULL,NULL,NULL,NULL,NULL,NULL),(11,1,6,NULL,12,1,NULL,NULL,NULL,NULL,NULL,0.090,0.150,0.300,0.600,0.255,NULL,NULL,NULL,NULL,NULL,NULL),(12,1,9,NULL,2,1,NULL,NULL,NULL,NULL,NULL,8.000,17.000,26.000,39.000,22.000,NULL,NULL,NULL,NULL,NULL,NULL),(13,1,10,NULL,2,1,NULL,NULL,NULL,NULL,NULL,5.000,15.000,31.000,51.000,22.000,NULL,NULL,NULL,NULL,NULL,NULL),(14,1,8,NULL,1,1,NULL,NULL,NULL,NULL,NULL,5.000,10.000,25.000,40.000,17.000,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `soil_thresholds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soil_types`
--

DROP TABLE IF EXISTS `soil_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `soil_types` (
  `soil_type_id` int(11) NOT NULL,
  `soil_type_desc` varchar(30) NOT NULL,
  `saturation` decimal(2,0) DEFAULT NULL,
  `field_capacity` decimal(2,0) DEFAULT NULL,
  `permanent_wilting_point` decimal(2,0) DEFAULT NULL,
  `saturated_hydraulic_conductivity` decimal(10,0) DEFAULT NULL,
  `n_percent_for_base_dressing` decimal(5,4) NOT NULL,
  `p_percent_for_base_dressing` decimal(5,4) NOT NULL,
  `k_percent_for_base_dressing` decimal(5,4) NOT NULL,
  `annual_som_decomposition_high_temp` decimal(5,4) NOT NULL,
  `annual_som_decomposition_moderate_temp` decimal(5,4) NOT NULL,
  `annual_som_decomposition_low_temp` decimal(5,4) NOT NULL,
  `base_dressing_strategy_id` int(11) NOT NULL,
  `rain effect` decimal(5,4) NOT NULL,
  `default cec` decimal(10,0) NOT NULL,
  `lower cec` decimal(10,0) NOT NULL,
  `upper cec` decimal(10,0) NOT NULL,
  `default bulk density` decimal(5,4) NOT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `user_delete` varchar(20) DEFAULT NULL,
  `date_delete` datetime DEFAULT NULL,
  PRIMARY KEY (`soil_type_id`),
  KEY `idx_soil_types_base_dressing_strategy_id` (`base_dressing_strategy_id`),
  CONSTRAINT `fk_soil_types_base_dressing_strategys` FOREIGN KEY (`base_dressing_strategy_id`) REFERENCES `dressing_strategy` (`bese_dressing_id`),
  CONSTRAINT `fk_soil_types_soil_lab_analysis` FOREIGN KEY (`soil_type_id`) REFERENCES `soil_lab_analysis` (`soil_analysis_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soil_types`
--

LOCK TABLES `soil_types` WRITE;
/*!40000 ALTER TABLE `soil_types` DISABLE KEYS */;
INSERT INTO `soil_types` VALUES (1,'Clay',NULL,NULL,NULL,NULL,0.2500,0.4000,0.3000,0.0150,0.0100,0.0050,2,0.1000,27,18,35,1.1900,NULL,NULL,NULL,NULL,NULL,NULL),(2,'Clay_Loam',NULL,NULL,NULL,NULL,0.3000,0.6000,0.4000,0.0150,0.0100,0.0050,2,0.1000,27,20,35,1.3200,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Loam',NULL,NULL,NULL,NULL,0.2500,0.4000,0.3000,0.0150,0.0100,0.0050,1,0.3500,10,5,18,1.4200,NULL,NULL,NULL,NULL,NULL,NULL),(4,'Loamy_sand',NULL,NULL,NULL,NULL,0.1000,0.1500,0.1500,0.0150,0.0100,0.0050,1,0.4500,8,5,13,1.6300,NULL,NULL,NULL,NULL,NULL,NULL),(5,'Sand',NULL,NULL,NULL,NULL,0.0000,0.1500,0.1500,0.0150,0.0100,0.0050,1,0.5000,5,1,10,1.7100,NULL,NULL,NULL,NULL,NULL,NULL),(6,'Sandy_Clay',NULL,NULL,NULL,NULL,0.3000,0.4500,0.3500,0.0150,0.0100,0.0050,2,0.1000,27,20,35,1.3200,NULL,NULL,NULL,NULL,NULL,NULL),(7,'Sandy_Clay_Loam',NULL,NULL,NULL,NULL,0.1500,0.2500,0.2500,0.0150,0.0100,0.0050,3,0.2500,18,13,27,1.4000,NULL,NULL,NULL,NULL,NULL,NULL),(8,'Sandy_Loam',NULL,NULL,NULL,NULL,0.1000,0.2000,0.2000,0.0150,0.0100,0.0050,1,0.3500,10,5,13,1.5600,NULL,NULL,NULL,NULL,NULL,NULL),(9,'Silt',NULL,NULL,NULL,NULL,0.2000,0.2500,0.2500,0.0150,0.0100,0.0050,3,0.3000,13,8,18,1.5200,NULL,NULL,NULL,NULL,NULL,NULL),(10,'Silt_Loam',NULL,NULL,NULL,NULL,0.2000,0.3000,0.3000,0.0150,0.0100,0.0050,3,0.3000,15,8,22,1.4200,NULL,NULL,NULL,NULL,NULL,NULL),(11,'Silty_Clay',NULL,NULL,NULL,NULL,0.3000,0.5000,0.3500,0.0150,0.0100,0.0050,2,0.1000,27,20,35,1.2100,NULL,NULL,NULL,NULL,NULL,NULL),(12,'Silty_Clay_Loam',NULL,NULL,NULL,NULL,0.3000,0.4500,0.3500,0.0150,0.0100,0.0050,2,0.1500,23,18,30,1.2700,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `soil_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soil_user_interpretation_parameters`
--

DROP TABLE IF EXISTS `soil_user_interpretation_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `soil_user_interpretation_parameters` (
  `user_interpretation_id` int(11) NOT NULL,
  `parameter_id` int(11) NOT NULL,
  `uom_id` int(11) NOT NULL,
  `extraction_method_id` int(11) NOT NULL,
  `vl_threshold` varchar(15) DEFAULT 'Very Low',
  `l_threshold` varchar(15) DEFAULT 'Low',
  `h_threshold` varchar(15) DEFAULT 'High',
  `vh_threshold` varchar(15) DEFAULT 'Very High',
  `target_value` decimal(10,0) DEFAULT NULL,
  `notification_string_when_very_low` varchar(15) DEFAULT 'Very Low',
  `notification_string_when_low` varchar(15) DEFAULT 'Low',
  `notification_string_when_high` varchar(15) DEFAULT 'High',
  `notification_string_when_very_high` varchar(15) DEFAULT 'Very High',
  PRIMARY KEY (`user_interpretation_id`),
  KEY `idx_soil_interpretation_parameters_parameter_id_0` (`parameter_id`),
  KEY `idx_soil_user_interpretation_parameters_uom_id` (`uom_id`),
  KEY `idx_soil_user_interpretation_parameters_extraction_method_id` (`extraction_method_id`),
  CONSTRAINT `fk_soil_user_interpretation_parameters_extraction_methods` FOREIGN KEY (`extraction_method_id`) REFERENCES `extraction_methods` (`extraction_method_id`),
  CONSTRAINT `fk_soil_user_interpretation_parameters_uom` FOREIGN KEY (`uom_id`) REFERENCES `uom` (`uom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soil_user_interpretation_parameters`
--

LOCK TABLES `soil_user_interpretation_parameters` WRITE;
/*!40000 ALTER TABLE `soil_user_interpretation_parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `soil_user_interpretation_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_type`
--

DROP TABLE IF EXISTS `test_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `test_type` (
  `test_type_id` int(11) NOT NULL,
  `test_type_name` varchar(100) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`test_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_type`
--

LOCK TABLES `test_type` WRITE;
/*!40000 ALTER TABLE `test_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testtype_to_parameters`
--

DROP TABLE IF EXISTS `testtype_to_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `testtype_to_parameters` (
  `testtype_to_parameters_id` int(11) NOT NULL,
  `test_type_id` int(11) NOT NULL,
  `parameter_id` int(11) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`testtype_to_parameters_id`),
  KEY `idx_testtype_to_parameters_parameter_id` (`parameter_id`),
  KEY `idx_testtype_to_parameters_test_type_id` (`test_type_id`),
  CONSTRAINT `fk_testtype_to_parameters_analysis_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`),
  CONSTRAINT `fk_testtype_to_parameters_test_type` FOREIGN KEY (`test_type_id`) REFERENCES `test_type` (`test_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testtype_to_parameters`
--

LOCK TABLES `testtype_to_parameters` WRITE;
/*!40000 ALTER TABLE `testtype_to_parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `testtype_to_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tissue type`
--

DROP TABLE IF EXISTS `tissue type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tissue type` (
  `tissue_type_id` int(11) NOT NULL,
  `tissue_type_name` varchar(100) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`tissue_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tissue type`
--

LOCK TABLES `tissue type` WRITE;
/*!40000 ALTER TABLE `tissue type` DISABLE KEYS */;
/*!40000 ALTER TABLE `tissue type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tissue_interpretation`
--

DROP TABLE IF EXISTS `tissue_interpretation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tissue_interpretation` (
  `tissue_interpretation_id` int(11) NOT NULL AUTO_INCREMENT,
  `farm_id` int(11) NOT NULL,
  `tissue_analysis_id` int(11) NOT NULL,
  `parameter_id` int(11) NOT NULL,
  `uom_id` int(11) NOT NULL,
  `interpretation` tinyint(4) DEFAULT NULL COMMENT 'ENUM :\n1 - Very low\n2- Low\n3- Sufficient\n4- High\n5 - Very high',
  `user_insert` varchar(15) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(15) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`tissue_interpretation_id`),
  KEY `idx_tissue_interpretation_parameter_id` (`parameter_id`),
  KEY `idx_tissue_interpretation_uom_id` (`uom_id`),
  CONSTRAINT `fk_tissue_interpretation_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`),
  CONSTRAINT `fk_tissue_interpretation_uom` FOREIGN KEY (`uom_id`) REFERENCES `uom` (`uom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tissue_interpretation`
--

LOCK TABLES `tissue_interpretation` WRITE;
/*!40000 ALTER TABLE `tissue_interpretation` DISABLE KEYS */;
/*!40000 ALTER TABLE `tissue_interpretation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tissue_interpretation_parameters`
--

DROP TABLE IF EXISTS `tissue_interpretation_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tissue_interpretation_parameters` (
  `interpretations_id` int(11) NOT NULL,
  `crop_id` int(11) NOT NULL,
  `sampled_tissue_id` int(11) DEFAULT NULL,
  `phenological_stage_id` int(11) NOT NULL,
  `parameter_id` int(11) DEFAULT NULL,
  `uom_id` int(11) NOT NULL,
  `lower_threshold` decimal(10,0) DEFAULT NULL,
  `upper_threshold` decimal(10,0) DEFAULT NULL,
  `target_value` decimal(10,0) DEFAULT NULL,
  `low_correction_factor` decimal(10,0) DEFAULT NULL,
  `high_correction_factor` decimal(10,0) DEFAULT NULL,
  `min_for_correction` decimal(10,0) DEFAULT NULL,
  `max_for_corrections` int(11) DEFAULT NULL,
  `notification_string_when_high` varchar(15) DEFAULT 'High',
  `notification_string_when_low` varchar(15) DEFAULT 'Low',
  PRIMARY KEY (`interpretations_id`),
  KEY `idx_tissue_interpretation_parameters_phenological_stage_id` (`phenological_stage_id`),
  KEY `idx_tissue_interpretation_parameters_parameter_id` (`parameter_id`),
  KEY `idx_tissue_interpretation_parameters_crop_id` (`crop_id`),
  KEY `idx_tissue_interpretation_parameters_uom_id` (`uom_id`),
  CONSTRAINT `fk_tissue_interpretation_parameters_crop type` FOREIGN KEY (`crop_id`) REFERENCES `crop type` (`crop_id`),
  CONSTRAINT `fk_tissue_interpretation_parameters_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`),
  CONSTRAINT `fk_tissue_interpretation_parameters_pheonological stage` FOREIGN KEY (`phenological_stage_id`) REFERENCES `pheonological stage` (`pheonological_stage_id`),
  CONSTRAINT `fk_tissue_interpretation_parameters_uom` FOREIGN KEY (`uom_id`) REFERENCES `uom` (`uom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tissue_interpretation_parameters`
--

LOCK TABLES `tissue_interpretation_parameters` WRITE;
/*!40000 ALTER TABLE `tissue_interpretation_parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `tissue_interpretation_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tissue_lab_analysis`
--

DROP TABLE IF EXISTS `tissue_lab_analysis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tissue_lab_analysis` (
  `tissue_analysis_id` int(11) NOT NULL,
  `farm_id` int(11) NOT NULL,
  `sample_date` datetime NOT NULL,
  `test_type_id` int(11) NOT NULL,
  `id_status` int(11) NOT NULL,
  `lab_id` int(11) DEFAULT NULL,
  `sample name` varchar(100) DEFAULT NULL,
  `irrigation_block_id` int(11) NOT NULL,
  `tissue_type_id` int(11) NOT NULL,
  `phenological_stage_id` int(11) NOT NULL,
  `custom_fields` varchar(1000) DEFAULT NULL COMMENT 'max',
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `user_delete` varchar(20) DEFAULT NULL,
  `date_delete` datetime DEFAULT NULL,
  PRIMARY KEY (`tissue_analysis_id`),
  KEY `idx_tissue_lab_analysis_phenological_stage_id` (`phenological_stage_id`),
  KEY `idx_tissue_lab_analysis_tissue_type_id` (`tissue_type_id`),
  KEY `idx_tissue_lab_analysis_irrigation_block_id` (`irrigation_block_id`),
  KEY `idx_tissue_lab_analysis_test_type_id` (`test_type_id`),
  KEY `idx_tissue_lab_analysis_id_status` (`id_status`),
  KEY `idx_tissue_lab_analysis_farm_id` (`farm_id`),
  KEY `idx_tissue_lab_analysis_lab_id` (`lab_id`),
  CONSTRAINT `fk_tissue_lab_analysis_crop type` FOREIGN KEY (`farm_id`) REFERENCES `crop type` (`crop_id`),
  CONSTRAINT `fk_tissue_lab_analysis_farms` FOREIGN KEY (`farm_id`) REFERENCES `farms` (`farm_id`),
  CONSTRAINT `fk_tissue_lab_analysis_irrigation blocks` FOREIGN KEY (`irrigation_block_id`) REFERENCES `irrigation_blocks` (`ib_id`),
  CONSTRAINT `fk_tissue_lab_analysis_lab_analysis__status` FOREIGN KEY (`id_status`) REFERENCES `analysis status type` (`id_status`),
  CONSTRAINT `fk_tissue_lab_analysis_labs` FOREIGN KEY (`lab_id`) REFERENCES `labs` (`lab_id`),
  CONSTRAINT `fk_tissue_lab_analysis_pheonological stage` FOREIGN KEY (`phenological_stage_id`) REFERENCES `pheonological stage` (`pheonological_stage_id`),
  CONSTRAINT `fk_tissue_lab_analysis_test_type` FOREIGN KEY (`test_type_id`) REFERENCES `test_type` (`test_type_id`),
  CONSTRAINT `fk_tissue_lab_analysis_tissue type` FOREIGN KEY (`tissue_type_id`) REFERENCES `tissue type` (`tissue_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tissue_lab_analysis`
--

LOCK TABLES `tissue_lab_analysis` WRITE;
/*!40000 ALTER TABLE `tissue_lab_analysis` DISABLE KEYS */;
/*!40000 ALTER TABLE `tissue_lab_analysis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tissue_thresholds`
--

DROP TABLE IF EXISTS `tissue_thresholds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tissue_thresholds` (
  `tissue_threshold_id` int(11) NOT NULL AUTO_INCREMENT,
  `lab_id` int(11) NOT NULL,
  `tissue_analysis_id` int(11) DEFAULT NULL,
  `parameter_id` int(11) NOT NULL,
  `uom_id` int(11) NOT NULL,
  `crop_id` int(11) NOT NULL,
  `variety_id` int(11) NOT NULL,
  `tissue_type_id` int(11) NOT NULL,
  `phenological_stage_id` int(11) NOT NULL,
  `farm_id` int(11) DEFAULT NULL,
  `other_lab_name` varchar(250) DEFAULT NULL,
  `lab_website` varchar(150) DEFAULT NULL,
  `lab_phone` varchar(15) DEFAULT NULL,
  `lab_address` varchar(150) DEFAULT NULL,
  `lower_threshold` decimal(10,0) DEFAULT NULL,
  `upper_threshold` decimal(10,0) DEFAULT NULL,
  `target_value` decimal(10,0) DEFAULT NULL,
  `low_correction_factor` decimal(10,0) DEFAULT NULL,
  `high_correction_factor` decimal(10,0) DEFAULT NULL,
  `min_for_correction` decimal(10,0) DEFAULT NULL,
  `max_for_correction` decimal(10,0) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `user_delete` varchar(20) DEFAULT NULL,
  `date_delete` datetime DEFAULT NULL,
  PRIMARY KEY (`tissue_threshold_id`),
  KEY `idx_tissue_thresholds_lab_id` (`lab_id`),
  CONSTRAINT `fk_tissue_thresholds_labs` FOREIGN KEY (`lab_id`) REFERENCES `labs` (`lab_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tissue_thresholds`
--

LOCK TABLES `tissue_thresholds` WRITE;
/*!40000 ALTER TABLE `tissue_thresholds` DISABLE KEYS */;
/*!40000 ALTER TABLE `tissue_thresholds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tissue_type_to_crop`
--

DROP TABLE IF EXISTS `tissue_type_to_crop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tissue_type_to_crop` (
  `tissue_to_crop_id` int(11) NOT NULL,
  `tissue_type_id` int(11) NOT NULL,
  `crop_id` int(11) NOT NULL,
  `phenological_stage_id` int(11) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`tissue_to_crop_id`),
  KEY `idx_tissue_type_to_crop_tissue_type_id` (`tissue_type_id`),
  KEY `idx_tissue_type_to_crop_crop_id` (`crop_id`),
  KEY `idx_tissue_type_to_crop_phenological_stage_id` (`phenological_stage_id`),
  CONSTRAINT `fk_tissue_type_to_crop_crop type` FOREIGN KEY (`crop_id`) REFERENCES `crop type` (`crop_id`),
  CONSTRAINT `fk_tissue_type_to_crop_pheonological stage` FOREIGN KEY (`phenological_stage_id`) REFERENCES `pheonological stage` (`pheonological_stage_id`),
  CONSTRAINT `fk_tissue_type_to_crop_tissue type` FOREIGN KEY (`tissue_type_id`) REFERENCES `tissue type` (`tissue_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tissue_type_to_crop`
--

LOCK TABLES `tissue_type_to_crop` WRITE;
/*!40000 ALTER TABLE `tissue_type_to_crop` DISABLE KEYS */;
/*!40000 ALTER TABLE `tissue_type_to_crop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tissue_user_interpretation_parameters`
--

DROP TABLE IF EXISTS `tissue_user_interpretation_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tissue_user_interpretation_parameters` (
  `user_tissue_interpretations_id` int(11) NOT NULL,
  `crop_id` int(11) NOT NULL,
  `sampled_tissue_id` int(11) DEFAULT NULL,
  `phenological_stage_id` int(11) NOT NULL,
  `parameter_id` int(11) DEFAULT NULL,
  `uom_id` int(11) NOT NULL,
  `lower_threshold` decimal(10,0) DEFAULT NULL,
  `upper_threshold` decimal(10,0) DEFAULT NULL,
  `target_value` decimal(10,0) DEFAULT NULL,
  `low_correction_factor` decimal(10,0) DEFAULT NULL,
  `high_correction_factor` decimal(10,0) DEFAULT NULL,
  `min_for_correction` decimal(10,0) DEFAULT NULL,
  `max_for_corrections` int(11) DEFAULT NULL,
  `notification_string_when_high` varchar(15) DEFAULT 'High',
  `notification_string_when_low` varchar(15) DEFAULT 'Low',
  PRIMARY KEY (`user_tissue_interpretations_id`),
  KEY `idx_tissue_interpretation_parameters_phenological_stage_id_0` (`phenological_stage_id`),
  KEY `idx_tissue_interpretation_parameters_parameter_id_0` (`parameter_id`),
  KEY `idx_tissue_interpretation_parameters_crop_id_0` (`crop_id`),
  KEY `idx_tissue_user_interpretation_parameters_uom_id` (`uom_id`),
  CONSTRAINT `fk_tissue_user_interpretation_parameters_crop type` FOREIGN KEY (`crop_id`) REFERENCES `crop type` (`crop_id`),
  CONSTRAINT `fk_tissue_user_interpretation_parameters_crop type_0` FOREIGN KEY (`crop_id`) REFERENCES `crop type` (`crop_id`),
  CONSTRAINT `fk_tissue_user_interpretation_parameters_parameters` FOREIGN KEY (`parameter_id`) REFERENCES `parameters` (`parameter_id`),
  CONSTRAINT `fk_tissue_user_interpretation_parameters_pheonological stage` FOREIGN KEY (`phenological_stage_id`) REFERENCES `pheonological stage` (`pheonological_stage_id`),
  CONSTRAINT `fk_tissue_user_interpretation_parameters_uom` FOREIGN KEY (`uom_id`) REFERENCES `uom` (`uom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tissue_user_interpretation_parameters`
--

LOCK TABLES `tissue_user_interpretation_parameters` WRITE;
/*!40000 ALTER TABLE `tissue_user_interpretation_parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `tissue_user_interpretation_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uom`
--

DROP TABLE IF EXISTS `uom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `uom` (
  `uom_id` int(11) NOT NULL,
  `uom_desc` int(11) NOT NULL,
  `uom_symbol` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`uom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uom`
--

LOCK TABLES `uom` WRITE;
/*!40000 ALTER TABLE `uom` DISABLE KEYS */;
/*!40000 ALTER TABLE `uom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variety_type`
--

DROP TABLE IF EXISTS `variety_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `variety_type` (
  `variety_id` int(11) NOT NULL,
  `variety_name` varchar(50) NOT NULL,
  PRIMARY KEY (`variety_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variety_type`
--

LOCK TABLES `variety_type` WRITE;
/*!40000 ALTER TABLE `variety_type` DISABLE KEYS */;
INSERT INTO `variety_type` VALUES (1,'Hass'),(2,'Arabica'),(3,'Robusta'),(4,'Sugarcane - General'),(5,'Pima'),(6,'Upland'),(7,'Akalfi'),(8,'Processing tomatoes - general'),(9,'Grain - Short'),(10,'Grain - Medium'),(11,'Grain - Long'),(12,'Silage - Short'),(13,'Silage - Medium'),(14,'Silage - Long'),(15,'Potatoes - General'),(16,'Almond'),(17,'Avocado 1st year'),(18,'Avocado 2nd year'),(19,'Avocado 3rd year'),(20,'Strawberries - General'),(21,'Soybeans - General'),(22,'Table grapes - General'),(23,'Wine grapes - General'),(24,'Pomegranade - General'),(25,'Onion - General'),(26,'Or');
/*!40000 ALTER TABLE `variety_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `water_interpretation`
--

DROP TABLE IF EXISTS `water_interpretation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `water_interpretation` (
  `water_interpretation_id` int(11) NOT NULL AUTO_INCREMENT,
  `farm_id` int(11) NOT NULL,
  `water_analysis_id` int(11) NOT NULL,
  `parameter_id` int(11) NOT NULL,
  `uom_id` int(11) NOT NULL,
  `interpretation` tinyint(4) DEFAULT NULL COMMENT 'ENUM :\n1 - Very low\n2- Low\n3- Sufficent\n4- High\n5 - Very high',
  `user_insert` varchar(15) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(15) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`water_interpretation_id`),
  KEY `idx_tissue_interpretation_parameter_id_2` (`parameter_id`),
  KEY `idx_tissue_interpretation_uom_id_2` (`uom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `water_interpretation`
--

LOCK TABLES `water_interpretation` WRITE;
/*!40000 ALTER TABLE `water_interpretation` DISABLE KEYS */;
/*!40000 ALTER TABLE `water_interpretation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `water_lab_analysis`
--

DROP TABLE IF EXISTS `water_lab_analysis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `water_lab_analysis` (
  `water_analysis_id` int(11) NOT NULL,
  `is_active` tinyint(4) DEFAULT NULL,
  `farm_id` int(11) NOT NULL,
  `sample_date` date DEFAULT NULL,
  `sample_name` varchar(100) DEFAULT NULL,
  `ib_id` int(11) NOT NULL,
  `water_EC` decimal(10,3) DEFAULT NULL,
  `water_pH` decimal(10,3) DEFAULT NULL,
  `id_status` int(11) DEFAULT NULL,
  `user_insert` varchar(20) DEFAULT NULL,
  `date_insert` datetime DEFAULT NULL,
  `user_update` varchar(20) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  `user_delete` varchar(20) DEFAULT NULL,
  `date_delete` datetime DEFAULT NULL,
  PRIMARY KEY (`water_analysis_id`),
  KEY `idx_wataer_lab_analysis_ib_id` (`ib_id`),
  KEY `idx_wataer_lab_analysis_id_status` (`id_status`),
  CONSTRAINT `fk_wataer_lab_analysis_irrigation_blocks` FOREIGN KEY (`ib_id`) REFERENCES `irrigation_blocks` (`ib_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `water_lab_analysis`
--

LOCK TABLES `water_lab_analysis` WRITE;
/*!40000 ALTER TABLE `water_lab_analysis` DISABLE KEYS */;
INSERT INTO `water_lab_analysis` VALUES (19,NULL,1,'2018-03-01','tap',1,1.100,6.500,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `water_lab_analysis` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-05 15:06:00
