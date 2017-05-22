//package tapplication.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import tapplication.dto.ParametersDto;
//import tapplication.service.ParametersServiceImpl;
//
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by alexpench on 01.04.17.
// */
//@Controller
//public class ParametersController {
//    @Autowired
//    private ParametersServiceImpl parametersService;
//
//    @RequestMapping(value = "/product/parameters/add" )
//    public void add(@RequestBody ParametersDto parametersDto, HttpServletResponse response) {
//        parametersService.add(parametersDto);
//        response.setStatus(200);
//    }
//}
