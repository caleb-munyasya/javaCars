package JDBC.service;

import JDBC.domain.Producer;
import JDBC.repository.ProducerRepository;

import java.util.List;

public class ProducerService {
    public static void save (Producer producer){
        ProducerRepository.save(producer);
    }

    public static void delete (Integer id){
        requireValidId(id);
        ProducerRepository.delete(id);

    }public static void update (Producer producer){
        requireValidId(producer.getId());
        ProducerRepository.update(producer);
    }
    public static List<Producer> findAll (){
        return ProducerRepository.findAll();
    }

    public static void showResultSetMetaData (){
         ProducerRepository.showResultSetMetaData();
    }
    public static List<Producer> findByName (String name){
        return ProducerRepository.findByName(name);
    }


    private static void requireValidId (Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid value passed to id, is it bigger than 0?");
        }
    }
}
