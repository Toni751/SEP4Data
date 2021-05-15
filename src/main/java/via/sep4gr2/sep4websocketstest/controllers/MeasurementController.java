package via.sep4gr2.sep4websocketstest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import via.sep4gr2.sep4websocketstest.models.restnetworking.Measurement;
import via.sep4gr2.sep4websocketstest.services.EdwMeasurementService;

import java.util.List;
//                  /measurements/plantId?type=latest?measurementType=LIGHT
@RestController
@RequestMapping("/measurements")
public class MeasurementController
{
    @Autowired
    private EdwMeasurementService edwMeasurementService;

    @CrossOrigin(origins = "*")
    @GetMapping("/{plantId}")
    public @ResponseBody List<Measurement> getMeasurementsForPlant(@PathVariable int plantId, @RequestParam String type, @RequestParam String measurementType )
    {
        try
        {
            return edwMeasurementService.getMeasurementsForPlant(plantId, type, measurementType);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

//    @CrossOrigin(origins = "*")
//    @GetMapping("/average")
//    public @ResponseBody
//    double getAverageMeasurement(@RequestParam String measurementType, @RequestParam int plantId)
//    {
//        try
//        {
//            return edwMeasurementService.getAverage(measurementType, plantId);
//        } catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//            return 0;
//        }
//    }
//
//    @CrossOrigin(origins = "*")
//    @GetMapping("/history")
//    public @ResponseBody
//    List<Double> getMeasurementHistory(@RequestParam String measurementType, @RequestParam int plantId)
//    {
//        try
//        {
//            return edwMeasurementService.getTemperatureHistory(measurementType, plantId);
//        } catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
}
