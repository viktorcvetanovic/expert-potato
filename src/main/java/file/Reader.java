package file;

import java.io.*;
// default implementations for reading File, we use this to cetralize our code for reading so we cant make mistake
public interface Reader{


    default String read(BufferedReader bufferedReader){
        StringBuilder rV= new StringBuilder();
        String line;
        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
                rV.append(line);
           } catch (IOException e) {

                throw new RuntimeException(e);
            }
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rV.toString();
    }

    default String read(String fileName, String filePath){
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath+fileName));
            return read(bufferedReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    default String read(File file){
        try {
            return read(new BufferedReader(new FileReader(file)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
