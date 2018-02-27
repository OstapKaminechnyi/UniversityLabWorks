package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringProcessor {
    public String readInputText() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String: ");
        return br.readLine();

    }

    public String processText(String inputText) {
        inputText = inputText.replaceAll("-", "_");
        return inputText;
    }

    public void showResult(String resultText) {
        System.out.println(resultText);

    }

}


