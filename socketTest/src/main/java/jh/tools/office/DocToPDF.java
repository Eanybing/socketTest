package jh.tools.office;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * Created by 17020751 on 2018/4/11.
 */
public class DocToPDF {
    /**
     * @param inpuFile 输入的文件流
     * @param outFile  输出的文件对象
     * @return
     * @function 利用Apache POI从输入的文件中生成PDF文件
     */
    public static void convertWithPOI(InputStream inpuFile, File outFile) throws IOException {
        //从输入的文件流创建对象
        XWPFDocument document = new XWPFDocument(inpuFile);
        //创建PDF选项
        PdfOptions pdfOptions = PdfOptions.create();//.fontEncoding("windows-1250")
        //为输出文件创建目录
        //outFile.getParentFile().mkdirs();
        //执行PDF转化
        PdfConverter.getInstance().convert(document, new FileOutputStream(outFile), pdfOptions);
    }

    public static void main(String[] args) throws IOException {
        InputStream inpuFile = new FileInputStream(new File("D:/文档/案例库/t.docx"));
        convertWithPOI(inpuFile,new File("D:/文档/案例库/KBS需求www.pdf"));
    }

//    public void doc2pdf(String docFileName) throws Exception{
//
//        Parser p = new DocParser();// create a new parser instance
//        FileInputStream fis = new FileInputStream("D:/tt.doc");// creating InputStream for use with parser
//        DocumentElement mydoc = p.parse(fis,true,false);// parse document from input stream
//        DocWriter w = new PDFWriter();// create PDF writer
//        w.writeDocument(mydoc,new FileOutputStream("D:/tt.pdf"));// write document as pdf using writer
//
//        wordMLPackage = WordprocessingMLPackage.load(new java.io.File(inputfilepath));
//
//        // Set up font mapper
//        Mapper fontMapper = new IdentityPlusMapper();
//        wordMLPackage.setFontMapper(fontMapper);
//
//        // Example of mapping missing font Algerian to installed font Comic Sans MS
//        PhysicalFont font
//                = PhysicalFonts.getPhysicalFonts().get("Comic Sans MS");
//        fontMapper.getFontMappings().put("Algerian", font);
//
//        org.docx4j.convert.out.pdf.PdfConversion c
//                = new org.docx4j.convert.out.pdf.viaXSLFO.Conversion(wordMLPackage);
//        //  = new org.docx4j.convert.out.pdf.viaIText.Conversion(wordMLPackage);
//
//        OutputStream os = new java.io.FileOutputStream(inputfilepath + ".pdf");
//    }
}
