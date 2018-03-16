package com.sas.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("com.sas.webapi.Repository")
@EntityScan(basePackages = "com.sas.webapi.Model")
@ComponentScan(basePackages = "com.sas.webapi")
@EnableTransactionManagement
public class Runner {

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}
}
//TODO: rol sınıfı veritabanına tablo eklenecek superuser kolonu silinecek
//todo : videoda dk 30 da kaldık
// todo: video linki : https://www.youtube.com/watch?v=egXtoL5Kg08
//todo : diger classların metodları denenmedi onların denenmesi gerek