package via.sep4gr2.sep4websocketstest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import via.sep4gr2.sep4websocketstest.services.EdwMeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController
{
    @Autowired
    private EdwMeasurementService edwMeasurementService;

    @CrossOrigin(origins = "*")
    @GetMapping("/latest/{measurementType}/{id}")
    public @ResponseBody
    double getLatestMeasurement(@PathVariable String measurementType, @PathVariable int id)
    {
        try
        {
            return edwMeasurementService.getLatestMeasurement(measurementType, id);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/average/{measurementType}/{id}")
    public @ResponseBody
    double getAverageMeasurement(@PathVariable String measurementType, @PathVariable int id)
    {
        try
        {
            return edwMeasurementService.getAverage(measurementType, id);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/history/{measurementType}/{id}")
    public @ResponseBody
    List<Double> getMeasurementHistory(@PathVariable String measurementType, @PathVariable int id)
    {
        try
        {
            return edwMeasurementService.getTemperatureHistory(measurementType, id);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
