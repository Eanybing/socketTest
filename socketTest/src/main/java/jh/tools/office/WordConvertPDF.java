package jh.tools.office;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class WordConvertPDF {
    public static void main(String[] args) {
        WordConvertPDF cwoWord = new WordConvertPDF();
        cwoWord.ConvertToPDF("D:/t2.docx", "D:/Test.pdf");
    }

    public void ConvertToPDF(String docPath, String pdfPath) {
        try {
            InputStream in = new FileInputStream(new File(docPath));
            XWPFDocument document = new XWPFDocument(in);
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File(pdfPath));
            PdfConverter.getInstance().convert(document, out, options);
            in.close();
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
