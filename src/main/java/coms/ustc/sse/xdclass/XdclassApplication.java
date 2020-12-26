package coms.ustc.sse.xdclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("coms.ustc.sse.xdclass.mapper")
public class XdclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdclassApplication.class, args);
	}

}
