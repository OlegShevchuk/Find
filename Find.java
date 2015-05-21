package ua.artcode.ds.Week4.Find;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Олег on 21.05.2015.
 */
public class Find
{
    private static String fileName="D:\\RUSH\\Project\\JavaRushHomeWork\\src\\ua\\artcode\\ds\\Week4\\Find\\result.txt";


    public Find(String dir, String key)
    {
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(fileName))){

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        new Thread(new FindThread(new File(dir),key)).start();

    }

    public synchronized static void writerResult(String str){

        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(fileName,true))){

            bufferedWriter.write(str+"\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
