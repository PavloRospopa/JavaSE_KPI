package com.gmail.at.rospopa.pavlo.io;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class EncodingReader extends FilterReader {

    private char encodingChar = 0;
    /**
     * Creates a new encoding reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @param encodingChar
     * @throws NullPointerException if <code>in</code> is <code>null</code>
     */
    public EncodingReader(Reader in, char encodingChar) {
        super(in);
        this.encodingChar = encodingChar;
    }

    public char getEncodingChar() {
        return encodingChar;
    }

    public void setEncodingChar(char encodingChar) {
        this.encodingChar = encodingChar;
    }

    /**
     * Reads a single character and encode it.
     *
     * @throws IOException
     */
    public int read() throws IOException {
        int c = super.read();
        if (c == -1) {
            return c;
        }
        return encodingChar + c;
    }
}
