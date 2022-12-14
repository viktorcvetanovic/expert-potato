package file;

import file.impl.DefaultReader;
import file.impl.DefaultWriter;
import junit.framework.TestCase;
import org.junit.Test;



public class WriterAndReaderTest extends TestCase {
    private static final String fileName="proba.txt";
    private static final String filePath="";
    private static final String textToWrite="Proba da vidimo da li radi";



    @Test
    public void testWrite(){
        IWriter writer = new DefaultWriter();
        writer.write(fileName,filePath,textToWrite);

    }


    @Test
    public void testRead(){
        IReader reader=new DefaultReader();
        String text=reader.read(fileName,filePath);
        assertEquals(textToWrite,text);

    }



}