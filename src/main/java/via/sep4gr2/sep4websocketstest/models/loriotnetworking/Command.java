package via.sep4gr2.sep4websocketstest.models.loriotnetworking;

public class Command {
    private String value;
    private int destinationPort;

    public Command(String value, int destinationPort) {
        this.value = value;
        this.destinationPort = destinationPort;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(int destinationPort) {
        this.destinationPort = destinationPort;
    }

    @Override
    public String toString() {
        return "Command{" +
                ", value='" + value + '\'' +
                ", destinationPort=" + destinationPort +
                '}';
    }
}
