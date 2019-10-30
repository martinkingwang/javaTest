package org.martin;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.net.URLClassLoader;

public class Test {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("org.martin.Test14");
			Method method = clazz.getDeclaredMethod("run", null);
			method.invoke(clazz.newInstance(), null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			//e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			//e.printStackTrace();
		}
	}

   public static List<String> getClassName(String packageName) {
       return getClassName(packageName, true);
   }

   public static List<String> getClassName(String packageName, boolean childPackage) {
       List<String> fileNames = null;
       ClassLoader loader = Thread.currentThread().getContextClassLoader();
       String packagePath = packageName.replace(".", "/");
       URL url = loader.getResource(packagePath);
       if (url != null) {
           String type = url.getProtocol();
           if (type.equals("file")) {
               fileNames = getClassNameByFile(url.getPath(), null, childPackage);
           } else if (type.equals("jar")) {
               fileNames = getClassNameByJar(url.getPath(), childPackage);
           }
       } else {
           fileNames = getClassNameByJars(((URLClassLoader) loader).getURLs(), packagePath, childPackage);
       }
       return fileNames;
   }

   private static List<String> getClassNameByFile(String filePath, List<String> className, boolean childPackage) {
       List<String> myClassName = new ArrayList<>();
       File file = new File(filePath);
       File[] childFiles = file.listFiles();
       for (File childFile : childFiles) {
           if (childFile.isDirectory()) {
               if (childPackage) {
                   myClassName.addAll(getClassNameByFile(childFile.getPath(), myClassName, childPackage));
               }
           } else {
               String childFilePath = childFile.getPath();
               if (childFilePath.endsWith(".class")) {
                   childFilePath = childFilePath.substring(childFilePath.indexOf("\\bin") + 5,
                           childFilePath.lastIndexOf("."));
                   childFilePath = childFilePath.replace("\\", ".");
                   myClassName.add(childFilePath);
               }
           }
       }

       return myClassName;
   }

   private static List<String> getClassNameByJar(String jarPath, boolean childPackage) {
       List<String> myClassName = new ArrayList<>();
       String[] jarInfo = jarPath.split("!");
       String jarFilePath = jarInfo[0].substring(jarInfo[0].indexOf("/"));
       String packagePath = jarInfo[1].substring(1);
       try {
           JarFile jarFile = new JarFile(jarFilePath);
           Enumeration<JarEntry> entrys = jarFile.entries();
           while (entrys.hasMoreElements()) {
               JarEntry jarEntry = entrys.nextElement();
               String entryName = jarEntry.getName();
               if (entryName.endsWith(".class")) {
                   if (childPackage) {
                       if (entryName.startsWith(packagePath)) {
                           entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
                           myClassName.add(entryName);
                       }
                   } else {
                       int index = entryName.lastIndexOf("/");
                       String myPackagePath;
                       if (index != -1) {
                           myPackagePath = entryName.substring(0, index);
                       } else {
                           myPackagePath = entryName;
                       }
                       if (myPackagePath.equals(packagePath)) {
                           entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
                           myClassName.add(entryName);
                       }
                   }
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return myClassName;
   }

   private static List<String> getClassNameByJars(URL[] urls, String packagePath, boolean childPackage) {
       List<String> myClassName = new ArrayList<>();
       if (urls != null) {
           for (int i = 0; i < urls.length; i++) {
               URL url = urls[i];
               String urlPath = url.getPath();
               // ��������classes�ļ���
               if (urlPath.endsWith("classes/")) {
                   continue;
               }
               String jarPath = urlPath + "!/" + packagePath;
               myClassName.addAll(getClassNameByJar(jarPath, childPackage));
           }
       }
       return myClassName;
   }
}
