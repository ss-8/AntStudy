package com.aaa.test;

public class Base
{
    private String baseName = "base";
    public Base()
    {
        callName();
    }

    public void callName()
    {
        System. out. println("11"+baseName);
    }

    static class Sub extends Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println ("22"+baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub();
    }
}