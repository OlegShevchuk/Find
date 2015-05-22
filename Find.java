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
    private String fileName;
    private File dir;
    private String key;

    public Find(String dir, String key){
        this(dir, key, "D:\\RUSH\\Project\\JavaRushHomeWork\\src\\ua\\artcode\\ds\\Week4\\Find\\result.txt");

    }
    public Find(File dir,Find find){
        this.dir=dir;
        this.fileName=find.getFileName();
        this.key=find.getKey();

    }

    public Find(String dir, String key, String fileName)
    {
        this.fileName=fileName;
        this.dir=new File(dir);
        this.key=key;
        findStart();

    }
    public void findStart(){

        new Thread(new FindThread(this)).start();
    }

    public synchronized void writerResult(String str){

        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(fileName,true))){

            bufferedWriter.write(str+"\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public File getDir()
    {
        return dir;
    }

    public void setDir(File dir)
    {
        this.dir = dir;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
