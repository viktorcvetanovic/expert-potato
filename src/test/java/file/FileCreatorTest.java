package file;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.util.UUID;

public class FileCreatorTest extends TestCase {
    private String fileName="proba3";

    public void testCreate() {
        FileCreator fileCreator = new FileCreator(fileName, "txt",false);
         File file = fileCreator.create();
        assertNotNull(file);
    }

    public void testCreateOverride(){
        FileCreator fileCreator = new FileCreator(fileName, "txt",true);
         File file = fileCreator.create();
        assertNotNull(file);
    }
}