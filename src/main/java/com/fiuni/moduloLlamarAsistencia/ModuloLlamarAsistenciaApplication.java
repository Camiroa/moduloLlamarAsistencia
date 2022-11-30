package com.fiuni.moduloLlamarAsistencia;

import com.fiuni.moduloLlamarAsistencia.dto.detalles.Detalles_PADTO;
import com.fiuni.moduloLlamarAsistencia.service.Detalles_PA.Detalles_PAServiceImp;
import com.fiuni.moduloLlamarAsistencia.service.Detalles_PA.IDetalles_PAService;
import com.fiuni.moduloLlamarAsistencia.service.Planilla_Asistencias.Planilla_AsistenciasServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.ResponseEntity;

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
//		IDetalles_PAService impl= new Detalles_PAServiceImp();
//		Detalles_PADTO detalle= new Detalles_PADTO();
//		detalle.setId(20);
//		detalle.setEstado(true);
//		detalle.setAsistencia('A');
//		detalle.setIdPlanillaAsistencia(1);
//		detalle.setJustificativo("");
//		detalle.setIdListaAlumno(1);
//		System.out.println(detalle);
//		System.out.println(detalle.getAsistencia());
//		ResponseEntity<Detalles_PADTO> resp= impl.save(detalle);
//		System.out.println(resp);
	}

}
