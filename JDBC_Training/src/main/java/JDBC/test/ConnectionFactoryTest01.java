package JDBC.test;

import JDBC.conn.ConnectionFactory;
import JDBC.domain.Producer;
import JDBC.repository.ProducerRepository;
import JDBC.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
       Producer producer = Producer.builder().name("Studio Deen").build();
       //Producer producerToUpdate = Producer.builder().id(1).name("Madhouse").build();
//        ProducerService.save(producer);
//        ProducerService.delete(1);
//        ProducerService.delete(7);
       // List<Producer> producersFound = ProducerService.findAll();
        ProducerService.showResultSetMetaData();
    }
}
