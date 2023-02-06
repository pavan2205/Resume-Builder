/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

/**
 *
 * @author prax
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;

public class PDFGenerator {
    public void CreatePdf(int cvid) throws Exception {
        // Create a new document
        PDDocument document = new PDDocument();
        
        // Create a new page
        PDPage page = new PDPage();
        
        // Add the page to the document
        document.addPage(page);
        String path = System.getProperty("user.home") + File.separator +"Desktop";
        // Create a file object for the image
        File imageFile = new File(path+File.separator+"resume"+cvid+".jpeg");
        
        // Create an image object from the file
        PDImageXObject image = PDImageXObject.createFromFile(imageFile.getAbsolutePath(), document);
        
        // Create a content stream for the page
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        
        // Draw the image on the page
        contentStream.drawImage(image, 0, 0,625,793);
        
        // Close the content stream
        contentStream.close();
        
        // Save the document to a file
        document.save(new File(path+File.separator+"doc"+cvid+".pdf"));
        
        // Close the document
        document.close();
        
        System.out.println("PDF created successfully.");
    }
}

