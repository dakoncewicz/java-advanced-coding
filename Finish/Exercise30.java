package com.dkoncewicz;
/* Zadanie 30
Napisz program, który odczyta dowolny plik i zapisze go w tym samym folderze.
Zawartość jak i tytuł nowego pliku powinny być odwrócone (od tyłu).
 */

import java.io.*;
import java.util.Stack;

public class Exercise30 {
    // Key concepts : I/O Stream

    public void show() throws IOException {
        String path = "/Users/darekkoncewicz/Documents/Biezace/Moje szkolenia/SDA Academy/Java - advanced/Java-advanced-coding/Assets/";
        String fileName = "SDAexample";
        String fileExt = ".txt";
        BufferedReader in = null;
        BufferedWriter out = null;
        String line;
        String reverted;

        Stack<String> myStack = new Stack<>();

        // reverse the fileName
        reverted = new StringBuilder(fileName).reverse().toString();
        System.out.println("Reverted text file will be write into : "+ reverted + fileExt );

        try {
            //open an input and output stream
            in = new BufferedReader(
                    new FileReader(path + fileName + fileExt));
            out = new BufferedWriter(
                    new FileWriter(path + reverted + fileExt));

            //Reading the file from stream and store each line in a queue LIFO
            while((line = in.readLine()) != null) {
                myStack.push(line);
            }

            while( !myStack.isEmpty())
                out.write(myStack.pop() + "\n");

            in.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }

    }
}
