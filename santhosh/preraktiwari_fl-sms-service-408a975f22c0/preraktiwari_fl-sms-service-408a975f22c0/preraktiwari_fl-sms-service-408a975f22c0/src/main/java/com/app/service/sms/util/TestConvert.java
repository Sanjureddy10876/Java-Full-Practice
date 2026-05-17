package com.app.service.sms.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Br;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Text;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestConvert {
	
	public static void main(String[] args) {
		try {
            InputStream templateInputStream = new FileInputStream("/Users/ptiwari/Desktop/test/input1.docx");
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(templateInputStream);
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

            String outputfilepath = "/Users/ptiwari/Desktop/test/output1.pdf";
            FileOutputStream os = new FileOutputStream(outputfilepath);
            Docx4J.toPDF(wordMLPackage,os);
            os.flush();
            os.close();
        } catch (Throwable e) {

            e.printStackTrace();
        } 
	}
	
	private static List<Object> getAllElementFromObject(Object obj,
	         Class<?> toSearch) {
	      List<Object> result = new ArrayList<Object>();
	      if (obj instanceof JAXBElement)
	         obj = ((JAXBElement<?>) obj).getValue();

	      if (obj.getClass().equals(toSearch))
	         result.add(obj);
	      else if (obj instanceof ContentAccessor) {
	         List<?> children = ((ContentAccessor) obj).getContent();
	         for (Object child : children) {
	            result.addAll(getAllElementFromObject(child, toSearch));
	         }

	      }
	      return result;
	   }
	
	 /**
     * Convert the description in table cell back into html code to be saved into database
     * 
     * @param tc
     * @return
     */
    private String convertTcToHtml(Tc tc) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");

        List<Object> paragraphs = getAllElementFromObject(tc, P.class);
        if (paragraphs == null || paragraphs.size() == 0) {
            return null;
        }

        /* Description exported from alm only has one paragraph in word. */
        List<Object> runs = getAllElementFromObject(paragraphs.get(0), R.class);
        addRunsToHtmlStringBuffer(sb, runs);

        /* If user modify description in word it may generate more paragraphs in word. */
        if (paragraphs.size() > 1) {
            sb.append("<br />");
            for (int i = 1; i < paragraphs.size(); i++) {
                List<Object> moreRuns = getAllElementFromObject(paragraphs.get(i), R.class);
                addRunsToHtmlStringBuffer(sb, moreRuns);
                /* Every paragraph should be starting from a new line */
                sb.append("<br />");
            }
        }

        sb.append("</body></html>");
        return sb.toString();
    }

    /**
     * Add Texts of a list of Runs to the html string builder
     * 
     * @param sb
     * @param runs
     */
    private void addRunsToHtmlStringBuffer(StringBuilder sb, List<Object> runs) {
        if (runs != null && runs.size() > 0) {
            for (Object r : runs) {
                R run = (R) r;

                List<Object> brs = getAllElementFromObject(run, Br.class);
                if (brs != null && brs.size() > 0) {
                    log.info("BR:");
                    sb.append("<br/>");
                }

                /* One run usually has one text */
                List<Object> texts = getAllElementFromObject(run, Text.class);
                if (texts != null && texts.size() > 0) {
                    StringBuilder text_sb = new StringBuilder();
                    for (Object t : texts) {
                        Text text = (Text) t;
                        text_sb.append(text.getValue());
                    }

                    String htmlText = replaceWithHtmlCharacters(text_sb.toString());

                    if (run.getRPr() != null && run.getRPr().getB() != null && (run.getRPr().getB().isVal())) {
                        log.info("Bold Text:");
                        sb.append("<b>");
                        sb.append(htmlText);
                        sb.append("</b>");
                    } else {
                        log.info("Normal Text:");
                        sb.append(htmlText);
                    }
                }
            }
        }
    }

    /**
     * Replace ", <, > with html special charactors
     * 
     * @param text
     * @return
     */
    private String replaceWithHtmlCharacters(String text) {
        text = text.replace("\"", "&quot;");
        text = text.replace("<", "&lt;");
        text = text.replace(">", "&gt;");

        return text;
    }

}
