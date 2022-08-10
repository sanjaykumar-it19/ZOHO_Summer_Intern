package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class TaskMultiThread {
    static int nof;


    public static void main(String[] args) throws Exception {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the no of threads:");
                nof = sc.nextInt();

                ExecutorService executor = Executors.newFixedThreadPool(nof);
        // creating obj for token file.
        File token = new File("C://Users//sanjay-pt5743//Desktop//sample-search-tokenfile.txt");
           Scanner  scany =  null;

        scany = new Scanner(token);

        ArrayList array = new ArrayList();
        while (scany.hasNextLine()) {

            String word = scany.next();
            array.add(word);
        }

        long start1 = System.nanoTime();
        for (int i=0;i< array.size();i++) {

            String search = (String)array.get(i);
            Runnable find = new MyRunnable(search);
            executor.execute(find);
        }

        executor.shutdown();
        System.out.println("No of Threads : "+nof);
             while (!executor.isTerminated()) {


        }
        long end1 = System.nanoTime();
        long elapsedTime1 = end1 - start1;

        System.out.println("Total time Taken: " + TimeUnit.NANOSECONDS.toMillis(elapsedTime1) + "ms");

        System.out.println("\nFinished all threads");
    }

    public static class MyRunnable implements Runnable {
        private final String url;

        MyRunnable(String url) {
            this.url = url;
        }

        @Override
        public void run() {

            int count =0;
            String result = "";

            try {
                Scanner sc1 = null;
                Scanner sc2 = null;
                File file1 = new File("C://Users//sanjay-pt5743//Desktop//sample-input-search-file-1.txt");
                // creating obj for file2
                File file2 = new File("C://Users//sanjay-pt5743//Desktop//sample-input-search-file-2.txt");
                sc1 = new Scanner(file1);
                sc2 = new Scanner(file2);
                while(sc1.hasNextLine())
                {   String match = sc1.next();

                    if(match.equals(url))
                    {   //System.out.println(word + match);
                        count++;
                    }
                }
                // Scanning the second file for match1
                while(sc2.hasNextLine())
                {
                    String match2 = sc2.next();
                    if(match2.equals(url))count++;
                }
                if(count != 0)
                    System.out.println(url+ "- Match - " + count + " Instance");
                else
                    System.out.println(url+ "- No Match - " + count+ " Instance");



            } catch (Exception e) {

            }
           
        }
    }
}
