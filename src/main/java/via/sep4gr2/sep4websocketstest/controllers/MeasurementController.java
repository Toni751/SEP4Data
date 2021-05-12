package via.sep4gr2.sep4websocketstest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import via.sep4gr2.sep4websocketstest.services.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController
{
    @Autowired
    private MeasurementService measurementService;

    @CrossOrigin(origins = "*")
    @GetMapping("/latest/{measurementType}/{id}")
    public @ResponseBody
    double getLatestMeasurement(@PathVariable String measurementType, @PathVariable int id)
    {
        try
        {
            return measurementService.getLatestMeasurement(measurementType, id);
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
            return measurementService.getAverage(measurementType, id);
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
            return measurementService.getTemperatureHistory(measurementType, id);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
