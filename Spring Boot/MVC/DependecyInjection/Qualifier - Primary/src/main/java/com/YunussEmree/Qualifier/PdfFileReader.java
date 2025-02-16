package com.YunussEmree.Qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("pdfFileReader")
@Primary // this annotation is used to specify the primary bean to be used when multiple beans of the same type are present
public class PdfFileReader implements Reader {

    @Override
    public String readFile() {
        return "Reading a PDF file";
    }

}
