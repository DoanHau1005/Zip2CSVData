import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
public abstract class DataParser 
{
  
     abstract List<String[]> readFile(String inputFile) throws IOException;

     abstract String writeFile(String outputFile,List<String[]> data) throws IOException;

     void parseAndProcessFile(String inputFile,String outputFile) throws IOException
    {
        List<String[]> data=readFile(inputFile);
        writeFile(outputFile,data);

    }

     void printData(List<String[]> data)
     {
         
        System.out.println("-------Data from function readFile-------");
        for (String[] strings : data) {
            for(String i : strings)
            {
                System.out.print(i+"\t");
            }
            // System.out.print("\n");
        }
            System.out.println("\n");
     }
     void processFile()
     {

     }

    
}