package com.gmail.at.rospopa.pavlo;

import com.gmail.at.rospopa.pavlo.io.DecodingWriter;
import com.gmail.at.rospopa.pavlo.io.EncodingReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Runner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        File inFile = new File("in.txt");
        File encodedFile = new File("encoded.txt");
        File outFile = new File("out.txt");

        Reader reader = null;
        Writer writer = null;
        try {
            reader = new EncodingReader(new FileReader(inFile), 'A');
            //writer = new DecodingWriter(new FileWriter(encodedFile), 'A');
            writer = new PrintWriter(System.out);
            //writer = new DecodingWriter(new OutputStreamWriter(System.out), 'A');

            int c;
            while((c = reader.read()) != -1) {
                writer.write(c);
            }
        }
        catch (FileNotFoundException e){
            logger.log(Level.FATAL, "file {0} not found", inFile);
        }
        catch (IOException e){
            logger.fatal(e);
        }
        finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.warn("Exception occurred during closing EncodingReader instance", e);
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    logger.warn("Exception occurred during closing DecodingWriter instance", e);
                }
            }
        }
    }
}
