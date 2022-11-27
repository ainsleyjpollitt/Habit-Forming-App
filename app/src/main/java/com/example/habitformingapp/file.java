package com.example.habitformingapp;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class file {
    public static File directory;
    public static ArrayList<String> files = new ArrayList<>();

    public static void write(String name, String time, String date, String taskInterval, Context c) throws IOException {
        try {
        File task = new File(directory, name);
        FileWriter writer = new FileWriter(task);

        writer.append(name + " " + time + " " + date + " " + taskInterval);
        writer.flush();
        writer.close();

        files.add(task.getName());
        } catch (Exception e){
            System.out.println(e);

            e.printStackTrace();
        }
    }
}
