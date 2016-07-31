/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shriya.entity;

import com.shriya.FileOperations;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author shneha
 */
public class FileHandling {

    private Scanner input;
    private FileOperations FileOperations;

    public FileHandling(Scanner input, FileOperations FileOperations) {
        this.input = input;
        this.FileOperations = FileOperations;
    }

    public void operationmenu() {
        System.out.println("1.Write file:");
        System.out.println("2.Read file:");
        System.out.println("3.Buffered Reader:");
        System.out.println("4.Read content from URL:");
        System.out.println("5.Read URL from file, convert into html to access it::");
        System.out.println("6.Extract image:");
        System.out.println("7.Exit:");
        System.out.println("enter your choice[1-7]:");

    }

    public void operation() {

        while (true) {
            operationmenu();
            switch (input.nextInt()) {

                case 1:
                    FileOperations.fileWrite();

                    break;

                case 2:
                    FileOperations.fileRead();

                    break;

                case 3:

                    FileOperations.bufferedReader();

                    break;

                case 4:
                    FileOperations.readUrlContent();
                    break;
                case 5:
                    FileOperations.readUrlFile();
                    break;

                case 6:
                    FileOperations.Image();
                    break;
                case 7:

                    System.out.println("Do You want to continue[y/n]:");
                    if (input.next().equalsIgnoreCase("n")) {
                        System.exit(0);
                    }

            }
        }

    }
}
