package org.example.util;

import com.alibaba.fastjson2.JSON;
import org.example.controller.HistoryShow;
import org.example.pojo.History;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

public class HistoryRecorder {
    public static void writeDownHistory(String expression,String result,String historyID){
        // write json String to file
        try {
            File file = new File("histories.json");
            if (!file.exists()){
                file.createNewFile();
            }
            //read file
            boolean haveHistory = false;
            ArrayList<History> histories = readHistory();
            if(historyID.isEmpty()){
                History addHistory = new History(expression,result);
                addHistory.generateHistoryId();
                histories.add(addHistory);
            }else{
                System.out.println(expression);
                for(History history:histories){
                    if(Objects.equals(history.getHistoryId(),historyID)){
                        history.setExpression(expression);
                        history.setResult(result);
                        break;
                    }
                }
            }
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
