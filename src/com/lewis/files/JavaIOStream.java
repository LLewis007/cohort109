package com.lewis.files;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class JavaIOStream {

    public void readOneCharWithFileReader(){
        try{
            FileReader fr = new FileReader("resources/characterfile.txt");
            System.out.println(fr.read());
            int data = fr.read();
            System.out.println((char)data);
            fr.close();
        }catch (Exception e){
            System.out.println("Input file is not available");
        }

    }
    public void readAllCharWithFileReader(){
        try{
            FileReader fr =  new FileReader("resources/characterfile.txt");
            int i = 0;
            while((i = fr.read())  != -1){
                System.out.println(i + ": " + (char) i);
            }
        }catch (Exception e){
            System.out.println("Cannot read the file");
            e.printStackTrace();
        }
    }

    public void useFileWriter(){
        try{
            FileWriter fileWriter = new FileWriter("resources/output.txt");
            char[] chars =  new char[]{'A', 'B', 'C', 'D', 'E'};
            String content = "I love my country \n";
            fileWriter.write(content);
            fileWriter.write(chars);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readAndWrite() throws  IOException{
        FileReader in = null;
        FileWriter out = null;

        try{
            in = new FileReader("resources/characterfile.txt");
            out = new FileWriter("resources/sampleOutput3.txt");
            int c;
            while((c = in.read()) != -1){
                out.write(c);
            }
            System.out.println("Reading and Writing in a file is done !!");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(in !=null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        }


    }

    public void usePrintWriter(){
        String data = "This is text inside the file";
        try{
            PrintWriter output =  new PrintWriter("resources/pw-output.txt");
            output.print(data);
            output.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public void readWriteWithFileInputOutputStream(){
        FileInputStream infile = null;
        FileOutputStream outfile = null;

        try{
            infile = new FileInputStream("resources/characterfile.txt");
            outfile = new FileOutputStream("resources/sampleOutput4.txt");
            int c;
            while((c = infile.read()) != -1){
                outfile.write(c);
               // System.out.println("Reading and Writing has been completed");
            }
            System.out.println("Reading and Writing has been completed");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(infile != null){
                try {
                    infile.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(outfile != null){
                try {
                    outfile.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void useBufferAndChannel(){
        String inputFile = "resources/inputfile.txt ";
        String outputFile = "resources/outputfile.txt";

        try{
            FileInputStream inputStream = new FileInputStream(inputFile);
            FileOutputStream outputStream = new FileOutputStream(outputFile);

            FileChannel inputChannel = inputStream.getChannel();
            FileChannel outputChannel = outputStream.getChannel();

            //Create buffer with 4KB capacity
            ByteBuffer buffer = ByteBuffer.allocate(4096);

            //Read data from input file into buffer
            while(inputChannel.read(buffer) != -1){
                //Switch buffer to read mode
                buffer.flip();

                //Write data from the buffer to output file
                outputChannel.write(buffer);

                //Clear buffer for next read
                buffer.clear();
            }
            System.out.println("File copied successfully.");

        }catch (IOException e){
            e.printStackTrace();
        }


    }


}
