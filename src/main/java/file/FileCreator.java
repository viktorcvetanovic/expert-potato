package file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;


@Data
@RequiredArgsConstructor
public class FileCreator {
    private final String fileName;
    private final String extension;
    private final Boolean forceCreate;



    private static File file;

    public File create() {
        try {
            file = new File(fileName + "." + extension);
            // this creates phisical file
            if (forceCreate || !file.exists()) {
                boolean createdFile = file.createNewFile();
                if (!createdFile) {
                    throw new IOException("File " + fileName + "." + extension + " could not be overridden, because admin permission is required");
                }
                System.out.println("File created: " + file.getAbsolutePath());
            }else{
                throw new IOException("File " + fileName + "." + extension + " already exists, use forceCreate to override");
            }

            return file;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete() {
        if (!file.delete()) {
            throw new RuntimeException("Error deleting file");
        }

    }


}
