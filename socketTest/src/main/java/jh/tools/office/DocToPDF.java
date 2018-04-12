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
}
