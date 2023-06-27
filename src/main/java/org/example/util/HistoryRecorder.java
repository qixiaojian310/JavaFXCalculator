package org.example.util;

import com.alibaba.fastjson2.JSON;
import org.example.controller.HistoryShow;
import org.example.pojo.History;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HistoryRecorder {
    public static void writeDownHistory(History history){
        // write json String to file
        try {
            File file = new File("histories.json");
            if (!file.exists()){
                file.createNewFile();
            }
            //read file
            ArrayList<History> histories = readHistory();
            histories.add(history);
            Writer writer =  new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            String historiesString = JSON.toJSONString(histories);
            writer.write(historiesString);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<History> readHistory(){
        File file = new File("histories.json");
        if (!file.exists()){
            return new ArrayList<History>();
        }
        try {
            Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            String historiesString = new String(chars);
            ArrayList<History> histories = (ArrayList<History>) JSON.parseArray(historiesString,History.class);
            reader.close();
            if(histories == null) {
                return new ArrayList<History>();
            } else {
                return histories;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
