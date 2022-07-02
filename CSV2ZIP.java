import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import java.util.Scanner;
// import java.io.FileReader;
// import com.opencsv.CSVReader;

public class CSV2ZIP extends DataParser {

  private String inputFile;
  private String outputFile;

  @Override
  List<String[]> readFile(String inputFile) throws IOException {
    // TODO Auto-generated method stub
    File f = new File(inputFile);
    if (f.exists()||f.isDirectory())
    {
      List<String[]> data = new ArrayList<String[]>();
   
      Scanner sc = new Scanner(new File(inputFile));
      // parsing a CSV file into the constructor of Scanner class
      sc.useDelimiter(",");
      // setting comma as delimiter pattern
      int i = 0;
      String[] a = new String[] {};
      while (sc.hasNext()) {

        data.add(new String[] { sc.next() });
      }

      sc.close();
      // closes the scanner
      return data;
    }
    else 
    {
      System.out.println("File is not exists. Please check the name file!!");
      return null;
    }



  }

  @Override
  String writeFile(String outputFile,List<String[]> data) throws IOException {

    File file = new File(outputFile);
    if (data.size()!=0)
    {
      FileOutputStream fos = new FileOutputStream(outputFile);
      ZipOutputStream zipOut = new ZipOutputStream(fos);
      FileInputStream fis = new FileInputStream(file);
      ZipEntry zipEntry = new ZipEntry(file.getName());
      zipOut.putNextEntry(zipEntry);
      byte[] bytes = new byte[2048];
      int length;
      while ((length = fis.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
      fis.close();
  
      zipOut.close();
      fos.close();
      return outputFile;
    }
    else 
    {
      System.out.println("Data to write is empty");

      return null;
    }

  }

  public void zip(File file) throws IOException {

    FileOutputStream fos = new FileOutputStream("test1.zip");
    ZipOutputStream zipOut = new ZipOutputStream(fos);

 
    FileInputStream fis = new FileInputStream(file);
    ZipEntry zipEntry = new ZipEntry(file.getName());
    zipOut.putNextEntry(zipEntry);
    byte[] bytes = new byte[2048];
    int length;
    while ((length = fis.read(bytes)) >= 0) {
      zipOut.write(bytes, 0, length);
    }
    fis.close();


    zipOut.close();
    fos.close();
  }




}
