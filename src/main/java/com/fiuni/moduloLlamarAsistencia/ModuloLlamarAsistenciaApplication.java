package com.fiuni.moduloLlamarAsistencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@EntityScan({"com.library.domainLibrary.domain.base",
		"com.library.domainLibrary.domain.ciclo",
		"com.library.domainLibrary.domain.clase",
		"com.library.domainLibrary.domain.colegio",
		"com.library.domainLibrary.domain.contactoEmergencias",
		"com.library.domainLibrary.domain.detalleInforme",
		"com.library.domainLibrary.domain.detallePA",
		"com.library.domainLibrary.domain.detallePN",
		"com.library.domainLibrary.domain.dia",
		"com.library.domainLibrary.domain.etapa",
		"com.library.domainLibrary.domain.evaluacion",
		"com.library.domainLibrary.domain.horaCatedra",
		"com.library.domainLibrary.domain.horaProfe",
		"com.library.domainLibrary.domain.informe",
		"com.library.domainLibrary.domain.listaAlumno",
		"com.library.domainLibrary.domain.listaMateria",
		"com.library.domainLibrary.domain.materia",
		"com.library.domainLibrary.domain.persona",
		"com.library.domainLibrary.domain.planClase",
		"com.library.domainLibrary.domain.planillaAsistencia",
		"com.library.domainLibrary.domain.rol",
		"com.library.domainLibrary.domain.planillaNota"})
@ImportResource("classpath:memcached.xml")
//men@EnableCaching
@SpringBootApplication
public class ModuloLlamarAsistenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuloLlamarAsistenciaApplication.class, args);
	}

}
