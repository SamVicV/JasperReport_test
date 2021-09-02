import models.XmlItem;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class ReportBuilder {

    private String PATH           = "./";
    private String REPORT_pdf     = "report.pdf";
    private String REPORT_pattern = "test.jrxml";

    public boolean build(ArrayList<XmlItem> data){
        try {
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(data);
            File reportPattern = new File(PATH + REPORT_pattern);
            InputStream inputstream = new FileInputStream(PATH + REPORT_pattern);
            JasperDesign jasperDesign = JRXmlLoader.load(inputstream);
//            JasperDesign jasperDesign = JRXmlLoader.load(reportPattern);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                    null,
                    beanColDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint,
                    PATH + REPORT_pdf);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
