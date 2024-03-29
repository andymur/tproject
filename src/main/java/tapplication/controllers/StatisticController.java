package tapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tapplication.service.StatisticService;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by alexpench on 28.04.17.
 */
@Controller
public class StatisticController {
    @Autowired
    private StatisticService statisticService;
//    @ResponseBody
    @RequestMapping(value = "statistic", method = RequestMethod.GET)
    public Object getStatistic(Model model){
        Map<String, Object> stat = new HashMap<>();
        model.addAttribute("topProducts", statisticService.getTopOrderedProducts());
        model.addAttribute("topUsers", statisticService.getTopUsers());
        model.addAttribute("monthRevenue", statisticService.getMonthRevenue());
        model.addAttribute("weekRevenue", statisticService.getWeekRevenue());
        return "statistic";
    }
}
