package via.sep4gr2.sep4websocketstest.models.loriotnetworking;

public class DownLinkMessage {
    private String cmd;
    private String EUI;
    private int port;
    private boolean confirmed;
    private String data;

    public DownLinkMessage(int port, boolean confirmed, String data) {
        this.cmd = "tx";
        this.EUI = "0004A30B00219CAC";
        this.port = port;
        this.confirmed = confirmed;
        this.data = data;
    }

    public String getCmd() {
        return cmd;
    }

    public String getEUI() {
        return EUI;
    }

    public int getPort() {
        return port;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DownLinkMessage{" +
                "cmd='" + cmd + '\'' +
                ", EUI='" + EUI + '\'' +
                ", port=" + port +
                ", confirmed=" + confirmed +
                ", data='" + data + '\'' +
                '}';
    }
}
