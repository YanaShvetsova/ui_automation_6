package testng_knowledge;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class _03_Ignoring_Tests {

    @Test
    public void test1(){
        System.out.println("Test1");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("Test2");
    }


    @Test(enabled = false)
    public void test3(){
        System.out.println("Test3");
    }
}
