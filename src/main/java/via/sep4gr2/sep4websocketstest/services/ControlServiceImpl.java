package via.sep4gr2.sep4websocketstest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.sep4gr2.sep4websocketstest.loriotconnection.LoriotControllerImpl;
import via.sep4gr2.sep4websocketstest.models.loriotnetworking.Command;

@Service
public class ControlServiceImpl implements ControlService {

    @Autowired
    private LoriotControllerImpl loriotController;

    @Override
    public void controlWindow(boolean isOpen) {
        String windowCommand = "000";
        if(isOpen){
            windowCommand += "1";
        } else {
            windowCommand += "0";
        }
        loriotController.send(new Command(windowCommand, 2));
    }
}
