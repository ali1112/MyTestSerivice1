import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by msharafat on 3/30/17.
 */
public class FileUtils {


    public static void main(String args[]){

        FileUtils fileUtils = new FileUtils();
        fileUtils.splitFile("src/testfile.txt", 200);

    }
    public void splitFile(String file, int chunkSize){

        String content;
        long fileSize=0;
        int count = 1;

        try{

            Files.createDirectories(Paths.get("test"));


            long timeStamp = Calendar.getInstance().getTimeInMillis();

            Files.write(Paths.get("test/chunk-"+timeStamp+"-"+count),"".getBytes(), StandardOpenOption.CREATE);

             BufferedReader br = Files.newBufferedReader(Paths.get(file), StandardCharsets.UTF_8) ;
             for (String line = null; (line = br.readLine()) != null;) {

                    fileSize = fileSize + line.getBytes().length;

                    if(fileSize > chunkSize){
                        timeStamp = Calendar.getInstance().getTimeInMillis();
                        count++;
                        Files.write(Paths.get("test/chunk-"+timeStamp+"-"+count),"".getBytes(), StandardOpenOption.CREATE);
                        fileSize = 0;
                    }
                    Files.write(Paths.get("test/chunk-"+timeStamp+"-"+count), line.getBytes(), StandardOpenOption.APPEND);
             }


        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}
