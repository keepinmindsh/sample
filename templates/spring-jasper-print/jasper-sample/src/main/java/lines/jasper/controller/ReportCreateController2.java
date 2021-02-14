package lines.jasper.controller;

import lines.jasper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.json.JSONArray;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api")
@Slf4j
public class ReportCreateController2 {

    final ModelAndView model = new ModelAndView();

    // Method to create the pdf report via jasper framework.
    @GetMapping(value = "/view2")
    public ModelAndView viewReport() {
        log.info("Preparing the pdf report via jasper.");
        try {
            createPdfReport();
            log.info("File successfully saved at the given path.");
        } catch (final Exception e) {
            log.error("Some error has occurred while preparing the employee pdf report.");
            e.printStackTrace();
        }
        // Returning the view name as the index page for ease.
        model.setViewName("welcome");
        return model;
    }

    // Method to create the pdf file using the employee list datasource.
    private void createPdfReport() throws JRException {
        // Fetching the .jrxml file from the resources folder.
        final InputStream stream = this.getClass().getResourceAsStream("/TEST_PRINT.jrxml");

        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);

        String jsonData = StringUtil.unescapeHtml("[" +
                    "{\"PRINT_STRING\":\"   05/17     CITY LEDGER                                   -5,000  [11] Front Desk(00004851)\",\"PRT_DATE\":\"\",\"PRT_TIT\":\"\",\"PRT_AMT1\":\"\",\"PRT_AMT2\":\"\",\"REF_AMT_1\":\"\",\"PRT_REF_NO\":\"\",\"INHS_GEST_NAME\":\"0803 객실키\",\"ADDRESS\":\"\",\"FOLIO_NO\":\"20003675\",\"CASHER_NAME\":\"Wings Admin.\",\"ROOM_NO\":\"0408\",\"DEPT_DATE\":\"2018/05/31\",\"ARRV_DATE\":\"2018/05/17\",\"COMPANY_NAME\":\"Front Desk\",\"ROOM_CNT\":\"\",\"PASSPORT_NO\":\"\",\"GROUP_ID\":\"\",\"GROUP_NAME\":\"\",\"COL_1\":\"HOTEL SANHA \",\"COL_2\":\"Tel. +82-32-123-4567     Fax. +82-32-234-5678 \",\"COL_3\":\"서울특별시 금천구 디지털로9길 68 대륭포스트타워5차 15F\\r\\n83, Dosan-daero 1-gil, Gangnam-gu, Seoul, Republic of Korea \",\"COL_4\":\"손학기 \",\"COL_5\":\"123-45-67890 \",\"ACCOUNT_NAME\":\"\",\"BSNS_CODE\":\"11\",\"BRN\":\"214-81-79819\",\"BSNS_ADDR\":\"제주특별자치도 서귀포시 태평로 347(서귀동) 서귀포시 서귀동 314-2\",\"BSNS_ENG_ADDR\":\"83, Dosan-daero 1-gil, Gangnam-gu, Seoul, Republic of Korea\",\"BSNS_FAX_NO\":\"+82-2-1544-4172\",\"BSNS_NAME\":\"WINGSPMS5 11\",\"BSNS_TEL_NO\":\"+82-2-1544-4172\",\"CEO_NAME\":\"홍길동\",\"HOMEPAGE_URL\":\"www.sanhait.co.kr\"}," +
                    "{\"PRINT_STRING\":\"   05/17     CASH                                          -5,000  \",\"PRT_DATE\":\"\",\"PRT_TIT\":\"\",\"PRT_AMT1\":\"\",\"PRT_AMT2\":\"\",\"REF_AMT_1\":\"\",\"PRT_REF_NO\":\"\",\"INHS_GEST_NAME\":\"0803 객실키\",\"ADDRESS\":\"\",\"FOLIO_NO\":\"20003675\",\"CASHER_NAME\":\"Wings Admin.\",\"ROOM_NO\":\"0408\",\"DEPT_DATE\":\"2018/05/31\",\"ARRV_DATE\":\"2018/05/17\",\"COMPANY_NAME\":\"Front Desk\",\"ROOM_CNT\":\"\",\"PASSPORT_NO\":\"\",\"GROUP_ID\":\"\",\"GROUP_NAME\":\"\",\"COL_1\":\"HOTEL SANHA \",\"COL_2\":\"Tel. +82-32-123-4567     Fax. +82-32-234-5678 \",\"COL_3\":\"서울특별시 금천구 디지털로9길 68 대륭포스트타워5차 15F\\r\\n83, Dosan-daero 1-gil, Gangnam-gu, Seoul, Republic of Korea \",\"COL_4\":\"손학기 \",\"COL_5\":\"123-45-67890 \",\"ACCOUNT_NAME\":\"\",\"BSNS_CODE\":\"11\",\"BRN\":\"214-81-79819\",\"BSNS_ADDR\":\"제주특별자치도 서귀포시 태평로 347(서귀동) 서귀포시 서귀동 314-2\",\"BSNS_ENG_ADDR\":\"83, Dosan-daero 1-gil, Gangnam-gu, Seoul, Republic of Korea\",\"BSNS_FAX_NO\":\"+82-2-1544-4172\",\"BSNS_NAME\":\"WINGSPMS5 11\",\"BSNS_TEL_NO\":\"+82-2-1544-4172\",\"CEO_NAME\":\"홍길동\",\"HOMEPAGE_URL\":\"www.sanhait.co.kr\"}," +
                    "{\"PRINT_STRING\":\"             Occurrence Total                              \",\"PRT_DATE\":\"\",\"PRT_TIT\":\"\",\"PRT_AMT1\":\"\",\"PRT_AMT2\":\"\",\"REF_AMT_1\":\"\",\"PRT_REF_NO\":\"\",\"INHS_GEST_NAME\":\"0803 객실키\",\"ADDRESS\":\"\",\"FOLIO_NO\":\"20003675\",\"CASHER_NAME\":\"Wings Admin.\",\"ROOM_NO\":\"0408\",\"DEPT_DATE\":\"2018/05/31\",\"ARRV_DATE\":\"2018/05/17\",\"COMPANY_NAME\":\"Front Desk\",\"ROOM_CNT\":\"\",\"PASSPORT_NO\":\"\",\"GROUP_ID\":\"\",\"GROUP_NAME\":\"\",\"COL_1\":\"HOTEL SANHA \",\"COL_2\":\"Tel. +82-32-123-4567     Fax. +82-32-234-5678 \",\"COL_3\":\"서울특별시 금천구 디지털로9길 68 대륭포스트타워5차 15F\\r\\n83, Dosan-daero 1-gil, Gangnam-gu, Seoul, Republic of Korea \",\"COL_4\":\"손학기 \",\"COL_5\":\"123-45-67890 \",\"ACCOUNT_NAME\":\"\",\"BSNS_CODE\":\"11\",\"BRN\":\"214-81-79819\",\"BSNS_ADDR\":\"제주특별자치도 서귀포시 태평로 347(서귀동) 서귀포시 서귀동 314-2\",\"BSNS_ENG_ADDR\":\"83, Dosan-daero 1-gil, Gangnam-gu, Seoul, Republic of Korea\",\"BSNS_FAX_NO\":\"+82-2-1544-4172\",\"BSNS_NAME\":\"WINGSPMS5 11\",\"BSNS_TEL_NO\":\"+82-2-1544-4172\",\"CEO_NAME\":\"홍길동\",\"HOMEPAGE_URL\":\"www.sanhait.co.kr\"}," +
                    "{\"PRINT_STRING\":\"             Payment Total                                -10,000                        \",\"PRT_DATE\":\"\",\"PRT_TIT\":\"\",\"PRT_AMT1\":\"\",\"PRT_AMT2\":\"\",\"REF_AMT_1\":\"\",\"PRT_REF_NO\":\"\",\"INHS_GEST_NAME\":\"0803 객실키\",\"ADDRESS\":\"\",\"FOLIO_NO\":\"20003675\",\"CASHER_NAME\":\"Wings Admin.\",\"ROOM_NO\":\"0408\",\"DEPT_DATE\":\"2018/05/31\",\"ARRV_DATE\":\"2018/05/17\",\"COMPANY_NAME\":\"Front Desk\",\"ROOM_CNT\":\"\",\"PASSPORT_NO\":\"\",\"GROUP_ID\":\"\",\"GROUP_NAME\":\"\",\"COL_1\":\"HOTEL SANHA \",\"COL_2\":\"Tel. +82-32-123-4567     Fax. +82-32-234-5678 \",\"COL_3\":\"서울특별시 금천구 디지털로9길 68 대륭포스트타워5차 15F\\r\\n83, Dosan-daero 1-gil, Gangnam-gu, Seoul, Republic of Korea \",\"COL_4\":\"손학기 \",\"COL_5\":\"123-45-67890 \",\"ACCOUNT_NAME\":\"\",\"BSNS_CODE\":\"11\",\"BRN\":\"214-81-79819\",\"BSNS_ADDR\":\"제주특별자치도 서귀포시 태평로 347(서귀동) 서귀포시 서귀동 314-2\",\"BSNS_ENG_ADDR\":\"83, Dosan-daero 1-gil, Gangnam-gu, Seoul, Republic of Korea\",\"BSNS_FAX_NO\":\"+82-2-1544-4172\",\"BSNS_NAME\":\"WINGSPMS5 11\",\"BSNS_TEL_NO\":\"+82-2-1544-4172\",\"CEO_NAME\":\"홍길동\",\"HOMEPAGE_URL\":\"www.sanhait.co.kr\"}," +
                    "{\"PRINT_STRING\":\"             BALANCE DUE                                  -10,000                        \",\"PRT_DATE\":\"\",\"PRT_TIT\":\"\",\"PRT_AMT1\":\"\",\"PRT_AMT2\":\"\",\"REF_AMT_1\":\"\",\"PRT_REF_NO\":\"\",\"INHS_GEST_NAME\":\"0803 객실키\",\"ADDRESS\":\"\",\"FOLIO_NO\":\"20003675\",\"CASHER_NAME\":\"Wings Admin.\",\"ROOM_NO\":\"0408\",\"DEPT_DATE\":\"2018/05/31\",\"ARRV_DATE\":\"2018/05/17\",\"COMPANY_NAME\":\"Front Desk\",\"ROOM_CNT\":\"\",\"PASSPORT_NO\":\"\",\"GROUP_ID\":\"\",\"GROUP_NAME\":\"\",\"COL_1\":\"HOTEL SANHA \",\"COL_2\":\"Tel. +82-32-123-4567     Fax. +82-32-234-5678 \",\"COL_3\":\"서울특별시 금천구 디지털로9길 68 대륭포스트타워5차 15F\\r\\n83, Dosan-daero 1-gil, Gangnam-gu, Seoul, Republic of Korea \",\"COL_4\":\"손학기 \",\"COL_5\":\"123-45-67890 \",\"ACCOUNT_NAME\":\"\",\"BSNS_CODE\":\"11\",\"BRN\":\"214-81-79819\",\"BSNS_ADDR\":\"제주특별자치도 서귀포시 태평로 347(서귀동) 서귀포시 서귀동 314-2\",\"BSNS_ENG_ADDR\":\"83, Dosan-daero 1-gil, Gangnam-gu, Seoul, Republic of Korea\",\"BSNS_FAX_NO\":\"+82-2-1544-4172\",\"BSNS_NAME\":\"WINGSPMS5 11\",\"BSNS_TEL_NO\":\"+82-2-1544-4172\",\"CEO_NAME\":\"홍길동\",\"HOMEPAGE_URL\":\"www.sanhait.co.kr\"}" +
                "]");

        JSONArray obj = JSONArray.fromObject(jsonData.replace("&quot;", "\"").replaceAll(":null", ":\"\""));
//		JSONArray obj = JSONArray.fromObject(jsonData);

        //Convert JSONArray --> List<HashMap>
        List<Map<String, Object>> listjrbean = JSONArray.toList(obj, HashMap.class);

        // Fetching the employees from the data source.
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(listjrbean);

        // Adding the additional parameters to the pdf.
        final Map<String, Object> commandMap = new HashMap<>();
        commandMap.put("Condition",  "Condition");
        commandMap.put("Condition1", "Condition1");
        commandMap.put("Condition2", "Condition2");
        commandMap.put("Condition3", "Condition3");

        commandMap.put("Title_Main", "Title_Main");
        commandMap.put("Title_Up",   "Title_Up");
        commandMap.put("Title_Down", "Title_Down");
        commandMap.put("Row_Count",  "Row_Count : "+ 1);

        commandMap.put("Sale_Date","Cur. Date : 20200723 ");

        commandMap.put("Print_Date", "Printed Date : 2020-07-23 ");
        commandMap.put("Print_User_ID", "Printed by : " + "admin" + " " + "admin" + " " + "1.1.1.1");
        commandMap.put("Print_User", "Printed by : " + "admin" + " " + "admin" + " " + "1.1.1.");
        commandMap.put("Hotel_Name", "Sanhait");

        // Filling the report with the employee data and additional parameters information.
        final JasperPrint print = JasperFillManager.fillReport(report, commandMap, source);

        // Users can change as per their project requrirements or can take it as request input requirement.
        // For simplicity, this tutorial will automatically place the file under the "c:" drive.
        // If users want to download the pdf file on the browser, then they need to use the "Content-Disposition" technique.
        final String filePath = "C://WINGS/";
        // Export the report to a PDF file.
        JasperExportManager.exportReportToPdfFile(print, filePath + "TEST_REPORT.pdf");

        try {
            PDDocument document = PDDocument.load(new File("C://TEST_REPORT.pdf"));

            PrintService myPrintService = PrintServiceLookup.lookupDefaultPrintService();
            System.out.println("기본 프린터 이름 : "+myPrintService);
            PrinterJob job = PrinterJob.getPrinterJob();

            job.setPageable(new PDFPageable(document));
            job.setPrintService(myPrintService);

            //프로세스바 종료
            job.print();

        }catch(Exception e) {

            //프로세스바 종료
            e.printStackTrace();
        }

    }
}
