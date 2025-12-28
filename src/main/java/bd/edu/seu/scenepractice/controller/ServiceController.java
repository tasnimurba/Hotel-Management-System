package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;

public class ServiceController {


    public void home()
    {
        HelloApplication.changeScene("hello-view");
    }

    public void back()
    {
        HelloApplication.changeScene("hello-view");
    }

}
