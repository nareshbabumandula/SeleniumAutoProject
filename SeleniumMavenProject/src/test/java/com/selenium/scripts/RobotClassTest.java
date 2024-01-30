package com.selenium.scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * Benefits of Robot Class
	1. Robot Class can simulate Keyboard and Mouse Event
	2. Robot Class can help in upload/download of files when using selenium web driver
	3. Robot Class can easily be integrated with current automation framework (keyword, data-driven or hybrid)

Disadvantages of Robot Class:

Robot framwork has few disadvantages mentioned below:
	1. Keyword/mouse event will only works on current instance of Window. E.g. suppose a code is performing any robot class 
	event, and during the code execution user has moved to some other screen then keyword/mouse event will occur on that 
	screen.
	2. Most of the methods like mouseMove is screen resolution dependent so there might be a chance that code working on one
	machine might not work on other.
 * @author nares
 *
 */
public class RobotClassTest {
    public static void main(String[] args) {
        try {
            // Create an instance of the Robot class
            Robot robot = new Robot();

            // Open Notepad (Assuming it's in the path)
            Runtime.getRuntime().exec("notepad.exe");

            // Delay to allow Notepad to open
            Thread.sleep(2000);

            // Type some text (for demonstration purposes)
            String textToCopy = "This is the text to copy.";
            for (char c : textToCopy.toCharArray()) {
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
            }

            // Copy the selected text (Ctrl+C)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Open another instance of Notepad
            Runtime.getRuntime().exec("notepad.exe");
            
            // Delay to allow the second Notepad to open
            Thread.sleep(2000);

            // Paste the copied text (Ctrl+V)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
