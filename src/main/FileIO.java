package main;

import database.LogIntoDatabase;

import java.io.*;

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
