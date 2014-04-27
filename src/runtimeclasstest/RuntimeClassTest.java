/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runtimeclasstest;

import java.io.*;

/**
 *
 * @author Adix
 */
public class RuntimeClassTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // TODO code application logic here
        String line;
        OutputStream stdin = null;
        InputStream stderr = null;
        InputStream stdout = null;

        // launch EXE and grab stdin/stdout and stderr
        String[] cmd1 = {"javac",  
                 "/Users/Adix/Desktop/Test.java"};
        
        Process process2 = Runtime.getRuntime().exec(cmd1);
        
        
        String[] cmd = {"java", 
                 "-cp",
                 "/Users/Adix/Desktop/",
                 "Test"};
                
        Process process = Runtime.getRuntime().exec(cmd);
        
        stdin = process.getOutputStream();
        stderr = process.getErrorStream();
        stdout = process.getInputStream();

        // "write" the parms into stdin
        /**line = "param1" + "\n";
        stdin.write(line.getBytes());
        stdin.flush();

        line = "param2" + "\n";
        stdin.write(line.getBytes());
        stdin.flush();

        line = "param3" + "\n";
        stdin.write(line.getBytes());
        stdin.flush();

        stdin.close();**/

        // clean up if any output in stdout
        BufferedReader brCleanUp =
                new BufferedReader(new InputStreamReader(stdout));
        while ((line = brCleanUp.readLine()) != null) {
            System.out.println ("[Stdout] " + line);
        }
        brCleanUp.close();

        // clean up if any output in stderr
        brCleanUp =
                new BufferedReader(new InputStreamReader(stderr));
        while ((line = brCleanUp.readLine()) != null) {
            System.out.println ("[Stderr] " + line);
        }
        brCleanUp.close();
    }
}
