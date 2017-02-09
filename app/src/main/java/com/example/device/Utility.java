package com.example.device;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Anand on 08/02/2017.
 */

public final class Utility {

    public static StringBuffer getFileInfo(String path) {

        StringBuffer buffer = new StringBuffer();
        String line;

        if (new File(path).exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }

                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            return buffer;
        }
        else {
            return null;
        }
    }
}
