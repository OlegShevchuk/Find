package ua.artcode.ds.Week4.Find;

import java.io.File;

/**
 * Created by Олег on 21.05.2015.
 */
public class FindThread implements Runnable
{
    Find find;

    public FindThread(Find find)
    {
        this.find = find;
    }

    @Override
    public void run()
    {

        if (find.getDir()==null) return ;

        File[]  fin=find.getDir().listFiles();
        if (fin!=null)
        {
            for (int i = 0; i < fin.length; i++)
            {
                if (fin[i].isDirectory()){
                    FindThread path=new FindThread(new Find(fin[i],find));
                    Thread temp=new Thread(path);
                    temp.start();
                }
                if (fin[i].getName().toLowerCase().contains(find.getKey().toLowerCase())) find.writerResult(fin[i].getAbsolutePath());

            }
        }

    }
}
