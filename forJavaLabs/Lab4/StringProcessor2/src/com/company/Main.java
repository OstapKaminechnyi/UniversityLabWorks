package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        try {
            StringProcessor stringProcessor = new StringProcessor();
            String text = stringProcessor.readInputText();
            text = stringProcessor.processText(text);
            stringProcessor.showResult(text);
        }catch(IOException e){

        }
    }
}
