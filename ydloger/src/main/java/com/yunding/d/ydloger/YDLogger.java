package com.yunding.d.ydloger;

public class YDLogger {

    public static  void  e(String tag,String message){
       YdLogerAdapter.singleton.getLogger().e(tag,message);

    }

    
}
