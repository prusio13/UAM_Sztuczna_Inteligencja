package szi;

import java.awt.EventQueue;

public class SZI {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
		new Window();
            }
        });
    }
    
}
