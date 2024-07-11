package categories;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Category_01_NewCategory {

    @BeforeClass(alwaysRun = true)
    public void init() {
        System.out.println("Pre-Condition for bellow testcases");
    }
    @Test(groups = "category")
    public  void testCreateNewCategoryEmpty(){}

    @Test(groups = "category")
    public  void testCreateNewCategoryNameAndDescription(){}

    @Test(groups = "category")
    public  void testCreateNewCategoryWithParentCategory(){}

    @AfterClass(alwaysRun = true)
    public void after() {
        System.out.println("Post-Condition for above testcases");
    }


}
