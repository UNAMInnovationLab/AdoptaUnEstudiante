package com.lab.innovation.unam.adoptaunestudiante.Model;

public class Util {

    public static boolean isNetworkConnectionAvailable() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        }
        catch (Exception e){}
        return false;
    }

}
