package main;

import database.LogIntoDatabase;

import java.io.*;

/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class designed for manage login1.dat file</br>
 * This class has following functions<br>
 * 1. Checking if the file exist.<br>
 * 2. Read an object of LogIntoDatabase class from login1.dat file.<br>
 * 3. Write an object of LogIntoDatabase class into login1.dat file.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 * @see LogIntoDatabase
 * @see ObjectInputStream
 * @see ObjectInputStream
 *
 */
public class FileIO {
    public static final String FILE_NAME = "login.dat";

    public static boolean isFileExist(){
        File dbFile = new File(FILE_NAME);
        return dbFile.exists();
    }

    public static void writeObject(LogIntoDatabase log){

        try{

            File file = new File(FILE_NAME);
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(FILE_NAME)
            );

            outputStream.writeObject(log);
            outputStream.close();


        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static LogIntoDatabase readObject(){
        LogIntoDatabase log = null;

        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
            log = (LogIntoDatabase) inputStream.readObject();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return log;

    }
}
