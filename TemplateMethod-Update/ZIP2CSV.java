import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javafx.print.Printer;
// import java.io.FileReader;
// import com.opencsv.CSVReader;
public class ZIP2CSV extends DataParser{

  
    private String inputFile;
    private String outputFile;
    


    List<String[]> readFile(String inputFile) throws IOException {
                // TODO Auto-generated method stub
                File f = new File(inputFile);
                if(f.exists() && !f.isDirectory()) { 

                    ZipFile zipFile = new ZipFile(inputFile);

                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    List<String[]> data = new ArrayList<String[]>();

                
                    while(entries.hasMoreElements()){
                        /*Using ZipEntry run to the next childElement in zip file. */
                        ZipEntry entry = entries.nextElement();

                        /*Get path file of childElement zip*/
                        InputStream stream = zipFile.getInputStream(entry); 
                        data.add(new String[] {entry.getName(),Long.toString(entry.getSize()),getFileExtension(entry.getName()),entry.getLastModifiedTime().toString()});
                        
                    }

                return data;
        
                }
                else
                {
                    System.out.println("File is not exists. Please check the name file!!");
                    return null;
                }
              
    }

    String writeFile(String outputFile,List<String[]> data) throws IOException {
        

        File f = new File(outputFile.substring(0, outputFile.length()-3)+"zip");
        // System.err.println(f.getName());
        if(data.size()!=0) { 
            // f.
            // List<String[]> data=readFile(f.getName());
            File csvFile=new File(outputFile);
            PrintWriter out=new PrintWriter(csvFile);

            out.printf("%s, %s, %s, %s\n","FileName","Size","Type","Last Modified Time");
            for (String[] a : data) {
                for (String i: a)
                {
                    out.printf("%s,",i);
                }
                out.printf("\n");
            }
            out.close();
            return "Zip file"+outputFile+"to CSV successful!!";
        }
        else 
        {
            System.out.println("Data to write is empty");
            return null;
        }
             
    }

    private String getFileExtension(String name) {

        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        if (name.substring(lastIndexOf).equals(".txt"))
        {
            return "Text Document";
        }
        else if (name.substring(lastIndexOf).equals(".csv"))
        {
            return "Microsoft Excel Comma";
        }
        else if (name.substring(lastIndexOf).equals(".docx") || name.substring(lastIndexOf).equals(".doc"))
        return "Microsoft Word Document";
        else if (name.substring(lastIndexOf).equals(".pdf"))
        return "Microsoft Edge PDF Document";
        else return name.substring(lastIndexOf);
    }





    



}
