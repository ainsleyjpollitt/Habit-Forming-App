package com.example.habitformingapp;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class file {
    public static File directory;
    public static ArrayList<String> files = new ArrayList<>();

    public static void write(String name, String time, String date, String taskInterval, Context c) throws IOException {
        try {
        File task = new File(directory, name);
        FileWriter writer = new FileWriter(task);

        writer.append(" " + name + ", " + time + ", " + date + ", " + taskInterval);
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
       Use this over files property directly.
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

    /* Delete the given file from the directory to
       permanently remove it from storage.
    */
    public static void deleteFile(String fileName) {
        /*
        File[] files = directory.listFiles();
        String[] fileNames = directory.list();
        File foundFile = null;
        for(int i = 0; i < fileNames.length; i++) {
            if(fileNames[i].equals(fileName)) {
                foundFile = files[i];
                break;
            }
        }

        if(foundFile != null) {
            String filePath = foundFile.getAbsolutePath();
            Path path = directory.getAbsolutePath(filePath);
        }
        */
        /*
        File currentFile;
        if(files != null) {
            currentFile = files[0];
            int pos = 1;
            while(!currentFile.toString().equals(fileName)) {
                currentFile = files[pos];
                if(currentFile.toString().equals(fileName)) {
                    directory.getName(currentFile).delete();
                }
            }
        }
        */


    }
}
