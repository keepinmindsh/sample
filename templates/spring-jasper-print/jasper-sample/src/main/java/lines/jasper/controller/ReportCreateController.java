package lines.jasper.controller;

import lines.jasper.model.ReportData;
import lines.jasper.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api")
@Slf4j
public class ReportCreateController {
    final ModelAndView model = new ModelAndView();

    // @Autowired annotation provides the automatic dependency injection.
    @Autowired
    ReportService eservice;

    // Method to display the index page of the application.
    @GetMapping(value= "/welcome")
    public ModelAndView index() {
        log.info("Showing the welcome page.");
        model.setViewName("welcome");
        return model;
    }

    // Method to create the pdf report via jasper framework.
    @GetMapping(value = "/view")
    public ModelAndView viewReport() {
        log.info("Preparing the pdf report via jasper.");
        try {
            createPdfReport(eservice.findAll());
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
    private void createPdfReport(final List<ReportData> reportData) throws JRException {
        // Fetching the .jrxml file from the resources folder.
        final InputStream stream = this.getClass().getResourceAsStream("/report.jrxml");

        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);

        // Fetching the employees from the data source.
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(reportData);

        // Adding the additional parameters to the pdf.
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "SHJeong");

        // Filling the report with the employee data and additional parameters information.
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);

        // Users can change as per their project requrirements or can take it as request input requirement.
        // For simplicity, this tutorial will automatically place the file under the "c:" drive.
        // If users want to download the pdf file on the browser, then they need to use the "Content-Disposition" technique.
        final String filePath = "\\";
        // Export the report to a PDF file.
        JasperExportManager.exportReportToPdfFile(print, filePath + "Report_Sample_Example.pdf");
    }
}
