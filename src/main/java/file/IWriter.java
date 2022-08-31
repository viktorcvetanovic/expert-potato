package file;

import exceptions.EmptyString;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface IWriter {


    default void write(BufferedWriter bufferedWriter,String toWrite){
        if(toWrite==null || toWrite.isEmpty()){
            throw new EmptyString("You can not enter empty string to write");
        }

        try {
            bufferedWriter.write(toWrite);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    default void write(File file, String text){
        try {
            write(new BufferedWriter(new FileWriter(file)),text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    default void write(String fileName,String filePath, String text){
        try {
            write(new BufferedWriter(new FileWriter(filePath+fileName)),text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
