package com.YunussEmree.Qualifier;

import org.springframework.stereotype.Component;

public class WorldFileReader implements Reader {

    @Override
    public String readFile() {
        return "Reading a World file";
    }
}
