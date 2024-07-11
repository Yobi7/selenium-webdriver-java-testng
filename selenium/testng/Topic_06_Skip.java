package testng;

import org.testng.annotations.Test;

public class Topic_06_Skip {

    @Test
    public  void test_01_SearchWithDate(){}

    @Test(enabled = false)
    public  void test_02_SearchWithBilling(){}

    @Test
    public  void test_03_SearchWithProduct(){}


}
