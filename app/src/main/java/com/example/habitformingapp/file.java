package com.example.habitformingapp;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    /* Get the list of file names that each represent
       a task to display on the Tasks page.
       Use this over files property.
    */
    public static ArrayList<String> getFiles(){
        ArrayList<String> taskList =  new ArrayList<>();
        File[] files = directory.listFiles();
        for (int i = 0; i < files.length; i++)
        {
            taskList.add(files[i].getName());
        }
        return taskList;
    }
}
