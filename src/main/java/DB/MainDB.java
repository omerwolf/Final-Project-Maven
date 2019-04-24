package DB;

import DB.Dao.*;
import DB.DaoImpl.*;
import DB.Entites.Crop;
import DB.Entites.Soil;
import DB.Entites.data_types;
import DB.Entites.variety_type;
import DB.Entites.pheonological_stage;
import DB.Entites.parameter_crop;
import DB.Entites.fertilization_method;
import DB.Entites.elements;
import DB.Entites.parameters;
import DB.Entites.layer_depth_type;
import DB.Entites.CropGroup;
import DB.Entites.PreviousCropNCredit;
import DB.Entites.IrrigationMethod;
import DB.Util.ConnectionConfiguration;
import DB.*;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainDB {

    public static void main(String[] args) {
        //data_typesDao cdi = new data_typesDaoImpl();
        //CropDao cdi = new CropDaoImpl();
        /**Insert a new record**/
        //Crop crop = new Crop(cdi.generateUniqueId(), "aaaaaaa");
        //cdi.insert(crop);
        /**Select by id**/
        //Crop crop = cdi.selectById(7);
        //System.out.println(crop.getId() + ", " + crop.getName() + ", " + crop.getCrop_group_id());

        /**Delete by id**/
        /*for (int i=1;i<=15;i++) {
            cdi.delete(i);
        }*/
        //cdi.delete(1);
        //cdi.delete(2);
        //cdi.delete(3);
        //cdi.delete(4);
        //cdi.delete(5);
        //cdi.delete(6);
        /**Update **/
        //Crop cropUpdate = new Crop("BBa",3);
        //cropUpdate.setId(16);
        //cdi.update(cropUpdate,2);


        /**Insert all**/
        //cdi.autoInsertAll();
        /**Select all**/
        /*List<Crop> crops = cdi.selectAll();
        for (Crop c : crops) {
            System.out.println(c.getId() + ", " + c.getName() + ", " + c.getCrop_group_id());
        }*/

        //SoilDao sdi = new SoilDaoImpl();
        //sdi.autoInsertAll();
        //List<Soil> soils = sdi.selectAll();
        //Soil soil = sdi.selectById(1);
        //sdi.update(soil,1);
        //sdi.delete(1);
        //sdi.autoInsertAll();


        //data type testing

        //data_typesDao dt = new data_typesDaoImpl();
        //data_types id = dt.selectById(1);
        //System.out.println(id.getData_type_id() + "," + id.getData_type_desc());
        //data_types dtn = new data_types(dt.generateUniqueId(),"an element");
        //dt.delete(1);
        //dt.delete(2);
        //dt.autoInsertAll();
        //data_types data = new data_types(4,"element");
        //dt.update(data,data.getData_type_id());
        /*List<data_types> ldata = dt.selectAll();
        for (data_types d: ldata) {
            System.out.println(d.getData_type_id() +" " + d.getData_type_desc());
        }*/

        //variety type testing

        //variety_typeDao vt = new variety_typeDaoImpl();
        //vt.autoInsertAll();
        //variety_type vtpe = new variety_type(vt.generateUniqueId(),"new");
        //vt.insert(vtpe);
        //vt.delete(27);
        //variety_type vtype2 = vt.selectById(13);
        //System.out.println(vtype2.getVariety_id() + ", " + vtype2.getVariety_name());
        //parameter_cropDao pc = new parameter_cropDaoImpl();
        //pc.autoInsertAll();
        //variety_type vtpeu = new variety_type(26,"Or");
        //vt.update(vtpeu,26);
        /*List<variety_type> listv = vt.selectAll();
        for (variety_type v: listv) {
            System.out.println(v.getVariety_id() + " " + v.getVariety_name());
        }*/

        //phenological stage testing

        //pheonological_stageDao psd = new pheonological_stageDaoImpl();
        //pheonological_stage ps = new pheonological_stage("hi2",3,3,null);
        //psd.insert(ps);
        //pheonological_stage update = new pheonological_stage("hia",6,5,2);
        //psd.update(update,update.getPheonological_stage_id());
        //pheonological_stage select= psd.selectById(0);
        //System.out.println(select.getPheonological_stage_desc() + " gdd: " + select.getPheonological_stage_duration_gdd());
        /*List<pheonological_stage> pslist = psd.selectAll();
        for (pheonological_stage item:pslist) {
            System.out.println(item.getPheonological_stage_id() + " " + item.getPheonological_stage_desc());
        }*/
        //pheonological_stage ps1 = psd.selectById(5);
        //psd.update(ps1,1);
        //psd.autoInsertAll();
        /*psd.delete(1);*/

        //fertilization method testing

        //fertilization_methodDao fert = new fertilization_methodDaoImpl();
        //fertilization_method fertm = new fertilization_method(fert.generateUniqueId(),"unique");
        //fert.insert(fertm);
        //fert.update(fertm,1);
        //fert.delete(1);
        //fertilization_method fert2 = fert.selectById(1);
        //System.out.println(fert2.getFert_method_id() + " " + fert2.getFert_method_desc());
        //String[] arrfert = {"first","second","third"};
        //fert.insertAll(arrfert);
        /*fert.autoInsertAll();
        List<fertilization_method> listfert= fert.selectAll();
        for (fertilization_method f:listfert) {
            System.out.println(f.getFert_method_id() +" " + f.getFert_method_desc());
        }*/

        //elements testing
        //elementsDao eled = new elementsDaoImpl();
        //elements element = new elements("S", "Something");
        //eled.insert(element);
        //eled.delete(0);
        //elements element2 = new elements("S2","Something2");
        //eled.insert(element2);
        //elements element3 = eled.selectById(1);
        //eled.update(element,0);
        /*List<elements> listelem = eled.selectAll();
        for (elements elem:listelem) {
            System.out.println(elem.getElement_id() + " " + elem.getSymbol() +" " + elem.getDescription());
        }*/
        //eled.autoInsertAll();

        //parameters testing
        //parametersDao parad = new parametersDaoImpl();
        //parad.autoInsertAll();
        /*List<parameters> parameterslist = parad.selectAll();
        for (parameters p:parameterslist) {
            System.out.println(p.getParameter_id());
        }
        parameters p1 = parad.selectById(2);
        System.out.println(p1.getPre_low_factor());
        for (int i=1;i<11;i++) {
            parad.delete(i);
        }*/

        //layer_depth testing
        /*layer_depth_typeDao layerd = new layer_depth_typeDaoImpl();
        layerd.autoInsertAll();
        List<layer_depth_type> listLayer = layerd.selectAll();
        for (layer_depth_type layer:listLayer) {
            System.out.println(layer.getLayer_depth_name());
        }
        //for (int i=1;i<10;i++) {
        //    layerd.delete(i);
        //}
        layer_depth_type layerid = layerd.selectById(5);
        System.out.println(layerid.getLayer_depth_name());*/

        //crop Group testing
        //CropGroupDao cropGroupDao = new CropGroupDaoImpl();
        //cropGroupDao.autoInsertAll();
        /*List<CropGroup> cropGroupList = cropGroupDao.selectAll();
        for (CropGroup cg:cropGroupList) {
            System.out.println(cg.getCropGroupId() + " " + cg.getCropGroupDesc());
        }*/
        /*for (int i=1;i<=2;i++) {
            cropGroupDao.delete(i);
        }*/
        /*CropGroup cropGroup = new CropGroup(1,"Group1");
        CropGroup cropGroup2 = new CropGroup(2,"Group2");
        cropGroupDao.insert(cropGroup);
        cropGroupDao.insert(cropGroup2);
        cropGroupDao.update(cropGroup2,1);
        CropGroup check = cropGroupDao.selectById(1);
        System.out.println(check.getCropGroupId());*/

        //previous crop n credit testing
        //PreviousCropNCreditDao pcncd = new PreviousCropNCreditDaoImpl();
        //pcncd.autoInsertAll();
        /*List<PreviousCropNCredit> pcncList = pcncd.selectAll();
        for (PreviousCropNCredit credit:pcncList) {
            System.out.println(credit.getPercent());
        }*/
        //PreviousCropNCredit pcncSelect = pcncd.selectById(5);
        //System.out.println(pcncSelect.getPreviousCropId() + " " + pcncSelect.getPreviousCropName());
        /*for (int i=1;i<=27; i++) {
            pcncd.delete(i);
        }*/
        /*PreviousCropNCredit pcnc1 = new PreviousCropNCredit(1,"example",50,50);
        PreviousCropNCredit pcnc2 = new PreviousCropNCredit(2,"example2",null,70);
        pcncd.update(pcnc2,1);*/

        //irrigation method testing
/*
        IrrigationMethodDao irrigationMethodDao = new IrrigationMethodDaoImpl();

        List<IrrigationMethod> listIrr = irrigationMethodDao.selectAll();
        for (IrrigationMethod im: listIrr) {
            System.out.println(im.getIrrigation_method_desc());
        }
        */
        //IrrigationMethod im1 = irrigationMethodDao.selectById(3);
        //System.out.println("im1 desc is: " +im1.getIrrigation_method_desc());

        //for (int i=6;i<=10;i++) {
        //   irrigationMethodDao.delete(i);
        //}
        //irrigationMethodDao.autoInsertAll();
        //IrrigationMethod im2 = irrigationMethodDao.selectById(2);
        //irrigationMethodDao.update(im2,5);

        //crop_expected_yield_validationDao ceyv = new crop_expected_yield_validationDaoImpl();
        //ceyv.autoInsertAll();

        ParameterPerStageDao pps = new ParameterPerStageDaoImpl();
        pps.autoInsertAll();

        //FertilizationMethodEfficiencyDao fme = new FertilizationMethodEfficiencyDaoImpl();
        //fme.autoInsertAll();

    }
    }