package com.lewis.files;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LewisFile {
    String location = "resources/courses.txt";   //    C:\Users\LaTonyaLewis\Documents\TheFile\resources\courses.txt

    public void readFile(){
        //Read and display file content

        try{
            File file = new File(location);
            Scanner sc = new Scanner(file);
            String data = "";

            while (sc.hasNextLine()){
                data = sc.nextLine();
                System.out.println(data);

            }
            System.out.println(file.isAbsolute());
            System.out.println(file.getAbsolutePath());

            System.out.println("Is Directory: " + file.isDirectory());

            String dirpath = "C:\\Users\\LaTonyaLewis\\Documents\\TheFile";
            File path = new File(dirpath);
            System.out.println("Is this a Directory: " + path.isDirectory());
            File[] listOfFiles = path.listFiles();
            System.out.println(Arrays.toString(listOfFiles));

        }catch (FileNotFoundException e){
            System.out.println("Either file is not found or file is not able to access");
            e.printStackTrace();
        }
    }

    public void useFileMethods(){
        String path = "resources/courses.txt";
        File f = new File(path);
        System.out.println("File Name: " + f.getName());
        System.out.println("File Path: " + f.getPath());
        System.out.println("Is path absolute: " + f.isAbsolute());
        System.out.println("Return Absolute path of the File " + f.getAbsolutePath());
        System.out.println("Return Parent folder of the given File " + f.getParent());
        System.out.println("File Exist " + f.exists());

        //Conditional operator
        System.out.println(f.exists() ? "Yes file exists" : "file does not exist");
        if(f.exists())  // return true or False
        {
            System.out.println("File is Found");
            System.out.println("IS file Readable " +  f.canRead());
            System.out.println("IS file Writable " +  f.canWrite());
            System.out.println("File size in a bytes " + f.length()); // file size in byte
        }

    }

    public void createAFile(){
        try{
            File file = new File("resources/newFile.txt");
            if(file.createNewFile()){
                System.out.print("New file created");
            }else{
                System.out.println("The file already exist");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void deleteFile(){
        File file = new File("resources/newFile.txt");
        file.delete();
    }

    public void createDirectory(){
        File file = new File("resources/templates");
        file.mkdir();
    }

}
