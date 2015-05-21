package ua.artcode.ds.Week4.Find;

import java.io.File;

/**
 * Created by Олег on 21.05.2015.
 */
public class FindThread implements Runnable
{
    File dir;
    String key;

    public FindThread(File dir, String key)
    {
        this.dir = dir;
        this.key = key;
    }

    @Override
    public void run()
    {

        if (dir==null) return ;

        File[]  fin=dir.listFiles();
        if (fin!=null)
        {
            for (int i = 0; i < fin.length; i++)
            {
                if (fin[i].isDirectory()){
                    FindThread path=new FindThread(fin[i],key);
                    Thread temp=new Thread(path);
                    temp.start();
                }
                if (fin[i].getName().toLowerCase().contains(key.toLowerCase())) Find.writerResult(fin[i].getAbsolutePath());

            }
        }

    }
}
