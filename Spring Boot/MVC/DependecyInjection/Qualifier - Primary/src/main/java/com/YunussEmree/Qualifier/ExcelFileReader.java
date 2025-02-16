package com.YunussEmree.Qualifier;

import org.springframework.stereotype.Component;

@Component("excelFileReader")
public class ExcelFileReader implements Reader {

    @Override
    public String readFile() {
        return "Reading an Excel file";
    }

}
