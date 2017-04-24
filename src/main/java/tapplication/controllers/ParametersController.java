//package tapplication.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import tapplication.exceptions.AlreadyExistException;
//import tapplication.exceptions.NotFoundException;
//import tapplication.model.Parameters;
//import tapplication.service.ParametersServiceImpl;
//
///**
// * Created by alexpench on 01.04.17.
// */
//@RestController
//public class ParametersController {
//    @Autowired
//    private ParametersServiceImpl service;
//
//    @RequestMapping(value = "product/parameters/create")
//    public Object create(@RequestParam (value = "size") String size,
//                         @RequestParam (value = "weight") Long weight,
//                         @RequestParam (value = "productId") Long productId) throws AlreadyExistException {
//        Parameters newParameters = service.create(size, weight, productId);
//        return newParameters;
//    }
//
//    @RequestMapping(value = "product/parameters")
//    public Object findAll() {
//        return service.findAll();
//    }
//
//    @RequestMapping(value = "product/parameters/update")
//    public Object update(@RequestBody Parameters entity) throws NotFoundException {
//        return service.update(entity);
//    }
//
//    @RequestMapping(value = "product/parameters/delete")
//    public void delete(@RequestBody Parameters entity) throws NotFoundException {
//        service.delete(entity);
//    }
//}
