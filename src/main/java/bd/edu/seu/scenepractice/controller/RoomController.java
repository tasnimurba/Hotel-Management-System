package bd.edu.seu.scenepractice.controller;

import bd.edu.seu.scenepractice.HelloApplication;

public class RoomController {

    public void home()
    {
        HelloApplication.changeScene("hello-view");
    }

    public void book()
    {
        HelloApplication.changeScene("book-room");
    }

}
