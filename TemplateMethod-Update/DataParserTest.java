import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
// import java.io.FileReader;
// import com.opencsv.CSVReader;
public class DataParserTest {
    


    public static void main(String[] args) throws IOException
    {
        System.out.println("-------------Class ZIP2CSV------------- ");
        DataParser zip2csv=new ZIP2CSV();

        zip2csv.parseAndProcessFile("ZIP2CSV.zip","ZIP2CSV123.csv");
        /* Input is a file excel(file excel exists in folder run file)*/

        /*Print data from function readFile */
        zip2csv.printData(zip2csv.readFile("ZIP2CSV.zip"));



        System.out.println("-------------Class CSV2ZIP-------------");
        DataParser csv2zip=new CSV2ZIP();

        csv2zip.parseAndProcessFile("CSV2ZIP.csv", "CSV2ZIP.zip");
        /* Input is a file zip(file zip exists in folder run file)*/

        /*Print data from function readFile */
        csv2zip.printData(csv2zip.readFile("ZIP2CSV.csv"));

        // csv2zip.writeFile("CSV2ZIP.csv");/*Return file zip CSV2ZIP.zip*/
    }
}
