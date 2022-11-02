package org.example;

import com.itextpdf.text.DocumentException;
import org.example.utils.JpgOperationsPerformed;
import org.example.utils.PdfOperationPerformed;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws DocumentException, IOException {
        System.out.println("Hello world!");
        //Convert Pdf to Jpg file.
        new PdfOperationPerformed().pdfToJpgConversion("C:\\Users\\himani.vijay\\Downloads\\panCard.pdf", "src/main/resources/Outputs/");
        //Compressing Pdf file.
        //new PdfOperationPerformed().compressPdf("C:\\Users\\himani.vijay\\Downloads\\pdfBigSize.pdf", "C:\\Users\\himani.vijay\\Downloads\\outputCompressNew2.pdf");
        //Combining multiple Jpg files to Pdf file
        //new JpgOperationsPerformed().combineJPGToPDF("C:\\Users\\himani.vijay\\Downloads\\outputjpgMerge.pdf","C:\\Users\\himani.vijay\\Downloads\\panCard_1.jpg","C:\\Users\\himani.vijay\\Downloads\\panCard_2.jpg");

    }
}