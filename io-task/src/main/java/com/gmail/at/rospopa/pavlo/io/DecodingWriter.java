package com.gmail.at.rospopa.pavlo.io;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class DecodingWriter extends FilterWriter {

    private char decodingChar;
    /**
     * Create a new decoding writer.
     *
     * @param out a Writer object to provide the underlying stream.
     * @throws NullPointerException if <code>out</code> is <code>null</code>
     */
    public DecodingWriter(Writer out, char decodingChar) {
        super(out);
        this.decodingChar = decodingChar;
    }

    public char getDecodingChar() {
        return decodingChar;
    }

    public void setDecodingChar(char decodingChar) {
        this.decodingChar = decodingChar;
    }

    /**
     * Decodes and writes a single character.
     *
     * @exception  IOException  If an I/O error occurs
     */
    public void write(int c) throws IOException {
        super.write(c - decodingChar);
    }
}
