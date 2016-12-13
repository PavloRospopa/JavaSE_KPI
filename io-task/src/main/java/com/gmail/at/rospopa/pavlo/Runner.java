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
        char ch = 'A';
        File inFile = new File("in.txt");

        try(Reader reader = new EncodingReader(new FileReader(inFile), ch);
            PrintWriter writer = new PrintWriter(System.out);
            Reader newReader = new EncodingReader(new FileReader(inFile), ch);
            Writer newWriter = new DecodingWriter(writer, ch)) {
            int c;
            while((c = reader.read()) != -1) {
                writer.write(c);
            }

            writer.println();

            while((c = newReader.read()) != -1) {
                newWriter.write(c);
            }
        }
        catch (FileNotFoundException e){
            logger.log(Level.FATAL, "file {0} not found", inFile);
        }
        catch (IOException e){
            logger.fatal(e);
        }
    }
}
