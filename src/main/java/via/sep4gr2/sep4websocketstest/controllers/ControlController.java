package via.sep4gr2.sep4websocketstest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import via.sep4gr2.sep4websocketstest.services.ControlService;

@RestController
@RequestMapping("/control")
public class ControlController {

    @Autowired
    private ControlService controlService;

    @PostMapping
    public void controlWindow(@RequestParam boolean isOpen){
        controlService.controlWindow(isOpen);
    }
}
