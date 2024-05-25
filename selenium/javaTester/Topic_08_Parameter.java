package javaTester;

public class Topic_08_Parameter {
    static String fullNameGlobal = "Automation Testing";

    public static void main (String[] args)
    {
        //Tham so
        setFullName("Manual Testing");

        System.out.println(getFullName());
    }

    public static void setFullName(String fullName)
    {
        // tham so
        fullNameGlobal = fullName;
    }

    public static String getFullName(){
        return fullNameGlobal;
    }



}
