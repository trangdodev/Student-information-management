import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class ClientThread implements Runnable {
    private ObjectInputStream ois;
    private TraCuuDiem parentFrame;

    public ClientThread(ObjectInputStream ois, TraCuuDiem parentFrame) {
        this.ois = ois;
        this.parentFrame = parentFrame;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object dataFromServer = ois.readObject();

                if (dataFromServer instanceof String) {
                    String data = (String) dataFromServer;
                    parentFrame.sendRequest(data); // Gọi phương thức để cập nhật UI
                } else {
                    JOptionPane.showMessageDialog(parentFrame, "Dữ liệu không hợp lý từ máy chủ.");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(parentFrame, "Lỗi khi nhận dữ liệu từ máy chủ.");
        }
    }
}

