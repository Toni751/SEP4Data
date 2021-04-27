package via.sep4gr2.sep4websocketstest.models.networking;

public class Command {
    private String commandId;
    private String value;
    private int destinationPort;

    public Command(String commandId, String value, int destinationPort) {
        this.commandId = commandId;
        this.value = value;
        this.destinationPort = destinationPort;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
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
                "commandId='" + commandId + '\'' +
                ", value='" + value + '\'' +
                ", destinationPort=" + destinationPort +
                '}';
    }
}
