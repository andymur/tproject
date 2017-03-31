//package tapplication.service;
//
//import org.springframework.stereotype.Service;
//import tapplication.repositories.AbstractDao;
//import tapplication.exceptions.AlreadyExistException;
//import tapplication.exceptions.NotFoundException;
//
///**
// * Created by alexpench on 31.03.17.
// */
//@Service
//public class AbstractService<ENTITY> implements CoreService<ENTITY> {
//    private AbstractDao<ENTITY, Long> dao;
//    private final Class entryClass = dao.getEntryClass();
//
//    public void setDao(AbstractDao<ENTITY, Long> dao) {
//        this.dao = dao;
//    }
//
//    @SuppressWarnings("unchecked")
//    public ENTITY create(ENTITY entity) throws AlreadyExistException {
//        String param = entryClass.getDeclaredField("NAME");
//        dao.count();
//        dao.persist(entity);
//        return entity;
//    }
//
//    public ENTITY update(ENTITY val) throws NotFoundException {
//        return null;
//    }
//
//    public void delete(ENTITY val) throws NotFoundException {
//
//    }
//}
