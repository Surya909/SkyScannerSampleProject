package com.sample.utils;


import com.sample.pageFactory.Pages;
import org.openqa.selenium.JavascriptExecutor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;


    public class Helpers extends Pages {
        protected static Properties prop;

        public int randomNumberGenerator(int size) {
            int randomValue = 0;
            Vector<Integer> vec = new Vector<Integer>();
            for (int i = 1; i < size; i++)
                vec.add(i);
            Random rnd = new Random();
            while (vec.size() > 0) {
                int nextRnd = rnd.nextInt(vec.size());
                randomValue = vec.remove(nextRnd);
            }
            return randomValue;
        }

        public Properties loadPropertiesFiles(String file) {
            try{
                prop = new Properties();
                InputStream propertyFile;
                propertyFile = new FileInputStream(
                        System.getProperty("user.dir") + "/src/test/resources/config/" + file + ".properties");
                prop.load(propertyFile);
            }catch(IOException ex){
                ex.printStackTrace();
            }
            return prop;
        }

        public void navigateTo(String url){
            driver.navigate().to(driver.getCurrentUrl()+url);
        }

        public void scrollUpToViewElements(){
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,-250)", "");
        }
    }

