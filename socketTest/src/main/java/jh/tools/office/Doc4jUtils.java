package jh.tools.office;


import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.openpackaging.parts.WordprocessingML.StyleDefinitionsPart;
import org.docx4j.wml.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

/**
 * 创建、操作Docx
 */
public class Doc4jUtils {

    private static boolean DELETE_BOOKMARK = false;
    private static ObjectFactory factory = Context.getWmlObjectFactory();

    /**
     * 创建Docx的主方法
     *
     * @param templatePath        模板docx路径
     * @param parameters          参数和值
     * @return
     */
    private static void CreateWordprocessingMLPackageFromTemplate(String templatePath,
             HashMap<String, String> parameters,
             String pdfPath) throws Exception {
        FileInputStream fStream = new FileInputStream(templatePath);
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(fStream);
        style(wordMLPackage);
        font(wordMLPackage);//字体
        //替换字符参数
        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
        //if (parameters != null) {
            //word文档中对应配置前后不能有空格,不能在word中直接写,有样式影响,在其他编辑器中复制过去
            parameters.put("year","2018");
            parameters.put("mouth","4");
            parameters.put("day","16");
            documentPart.variableReplace(parameters);
        //}
        //转化成PDF
        FileOutputStream fileOutputStream = new FileOutputStream(pdfPath);
        FOSettings foSettings = Docx4J.createFOSettings();
        foSettings.setWmlPackage(wordMLPackage);
        Docx4J.toFO(foSettings, fileOutputStream, Docx4J.FLAG_EXPORT_PREFER_XSL);
        //Docx4J.toPDF(wordMLPackage, fileOutputStream);
        //PdfConversion conversion = new org.docx4j.convert.out.pdf.viaXSLFO.Conversion(wordMLPackage);
        //conversion.output(fileOutputStream, new PdfSettings());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    //样式
    private static void style(WordprocessingMLPackage wordMLPackage) {
        StyleDefinitionsPart styleDefinitionsPart =
                wordMLPackage.getMainDocumentPart().getStyleDefinitionsPart();
        Styles styles = styleDefinitionsPart.getJaxbElement();
        List<Style> stylesList = styles.getStyle();
        for (Style style : stylesList) {
            if (style.getStyleId().equals("amls-style")) {
                RPr rpr = style.getRPr();
                BooleanDefaultTrue b = new BooleanDefaultTrue();
                b.setVal(true);
                rpr.setB(b);
                style.setRPr(rpr);
            }
            RPr rpr = new RPr();
            U underline = new U();
            underline.setVal(UnderlineEnumeration.NONE);
            rpr.setU(underline);
            style.setRPr(rpr);
        }
    }

    //设置字体
    private static void font(WordprocessingMLPackage wordMLPackage) throws Exception {
        //解决中文乱码
        Mapper fontMapper = new IdentityPlusMapper();
        fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
        fontMapper.put("宋体",PhysicalFonts.get("SimSun"));
        fontMapper.put("微软雅黑",PhysicalFonts.get("Microsoft Yahei"));
        fontMapper.put("黑体",PhysicalFonts.get("SimHei"));
        fontMapper.put("楷体",PhysicalFonts.get("KaiTi"));
        fontMapper.put("新宋体",PhysicalFonts.get("NSimSun"));
        fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
        fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
        fontMapper.put("宋体扩展",PhysicalFonts.get("simsun-extB"));
        fontMapper.put("仿宋",PhysicalFonts.get("FangSong"));
        fontMapper.put("仿宋_GB2312",PhysicalFonts.get("FangSong_GB2312"));
        fontMapper.put("幼圆",PhysicalFonts.get("YouYuan"));
        fontMapper.put("华文宋体",PhysicalFonts.get("STSong"));
        fontMapper.put("华文中宋",PhysicalFonts.get("STZhongsong"));
        wordMLPackage.setFontMapper(fontMapper);
    }


    public static void main(String[] args) throws Exception {
        CreateWordprocessingMLPackageFromTemplate("D:\\t1.docx",new HashMap<String, String>(),"D:\\Test.pdf");
    }
}
