package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;

public class FirstPageController

{
    public void owner()
    {
        HelloApplication.changeScene("owner-page");
    }

    public void customer()
    {
        HelloApplication.changeScene("hello-view");
    }



}
