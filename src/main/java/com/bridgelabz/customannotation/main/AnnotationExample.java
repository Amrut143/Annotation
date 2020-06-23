package com.bridgelabz.customannotation.main;

import com.bridgelabz.customannotation.annotation.MethodInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {

    @Override
    @MethodInfo(author = "Deepak", comments = "Main Method", date = "Nov 17 2012", revision=1 )
    public String toString(){
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
    public static void oldMethod(){
        System.out.println("old method, don't use it.");
    }
    public static void main(String[] args){
        try{
            for(Method method : AnnotationExample.class.getMethods()){
                //checks if MethodInfo annotation is present for the method
                if(method.isAnnotationPresent(MethodInfo.class)){
                    try{
                        //iterates all the annotations available in the method
                        for (Annotation anno : method.getDeclaredAnnotations()){
                            System.out.println("Annotation in Method '" + method + "' :" + anno);
                        }
                        MethodInfo methodAnnotation=method.getAnnotation(MethodInfo.class);
                        if(methodAnnotation.revision()==1){
                            System.out.println("Method with revision no 1 = " + method);
                        }
                    }catch (Throwable ex){
                        ex.printStackTrace();
                    }
                }
            }
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }
}
