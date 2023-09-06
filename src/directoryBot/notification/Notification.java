package directoryBot.notification;
import java.awt.TrayIcon.MessageType;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;

public class Notification {

    public Notification(String message){
        try {
            SystemTray systemTray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("image.jpg");
            TrayIcon trayIcon = new TrayIcon(image, "Notification");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("System Tray Icon Demo");
            systemTray.add(trayIcon);

            trayIcon.displayMessage("Directory Bot", message, MessageType.INFO);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
