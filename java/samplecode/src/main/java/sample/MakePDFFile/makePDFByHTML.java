package sample.MakePDFFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class makePDFByHTML {

    public static final String pdfFilePath = "results/xmlworker/html_in_cell.pdf";
    public static final String CSS = "p { font-family: Cardo; }";

    public static void main(String[] args) throws DocumentException, IOException {
        File file = new File(pdfFilePath);

        file.getParentFile().mkdirs();
        new makePDFByHTML().createPdf(pdfFilePath);
    }


    public void createPdf(String pdfFile) throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(pdfFile)).setInitialLeading(12);

        // step 3
        document.open();
        // step 4
        StringBuilder sb = new StringBuilder();

        sb.append(PDFMaker.getHtmlContentor(new TableContent()));


        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell();
        ElementList list = XMLWorkerHelper.parseToElementList(sb.toString(), CSS);
        for (Element element : list) {
            cell.addElement(element);
        }
        table.addCell(cell);
        document.add(table);

        // step 5
        document.close();
    }
}
