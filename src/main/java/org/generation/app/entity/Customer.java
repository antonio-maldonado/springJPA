package org.generation.app.entity;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  @Entity se usa para marcar una clase como una entidad
 *  que se puede persistir en una base de datos relacional.
 *  Se indica a JPA que la clase representa una tabla
 *  en la base de datos y que los objetos de esta clase
 *  puedan ser alamcenados, actualizados o eliminados en 
 *  dicha tabla. Además, cada instancia se la clase se considera
 *  una fila en la tabla.
 */

/*
 *  @Bean se utiliza para indicar que un método en una clase
 *  de Spring, devuelve un objeto que debe ser administrado
 *  por el contener de Spring.
 *  
 *  Cuando se utliza @Bean en un método, Spring se encarga
 *  de llamar a ese método y registrar el objeto devuelto
 *  en el contexto de la aplicación como un bran.
 *  Este bean estará disponible para su inyección de dependencias
 *  en otras partes de la aplicación.
 *  
 *  Command Line Runner es una interfaz funcional proporcionada
 *  por Spring que define un método run() que se ejeucta una
 *  vez que se haya iniciado complementamente el
 *  contexto de la aplicación de Spring. Este método
 *  se utiliza comunmente para ejecutar tareas de inicialización
 *  o configuración al inicio de la aplicación.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers") // nombre de la tabla en la DB
public class Customer {

	@Id // Indica que el atributo será la clave primaria de la entidad
	// Indica como se generarán automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	@Column(name = "firstname", nullable = false, length = 150)
	private String firstName;
	@Column(name = "lastname", length = 150)
	private String lastName;
	@Column(name = "email", nullable = false, length = 150, unique = true)
	private String email;
	@Column(name = "password", length = 200)
	private String password;
	@Column(name = "active")
	private Boolean active;
	@Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP" )
	private Date createdAt;
	
	public Customer(String firstName, String lastName) {
		    this.firstName = firstName;
		    this.lastName = lastName;
		  }
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
	private List<OrderProduct> orders = new ArrayList<>();

}
/*
 * GenerationType.AUTO: Esta estrategia le permite al proveedor de JPA 
 * elegir automáticamente la estrategia de generación más adecuada según 
 * la base de datos y la configuración. El comportamiento exacto puede 
 * variar dependiendo del proveedor utilizado.
 *
 * GenerationType.IDENTITY: Esta estrategia utiliza una columna de identidad 
de la base de datos para generar automáticamente los valores de la clave primaria. 
Es compatible con bases de datos como MySQL que admiten columnas de autoincremento. 
En este caso, la base de datos se encarga de generar y asignar el valor de la clave primaria.

GenerationType.SEQUENCE: Esta estrategia utiliza una secuencia de la base 
de datos para generar automáticamente los valores de la clave primaria. 
Se requiere que la base de datos admita secuencias. El proveedor de JPA 
utiliza la secuencia definida en la base de datos para obtener los valores 
de la clave primaria.

GenerationType.TABLE: Esta estrategia utiliza una tabla especial en la base 
de datos para generar los valores de la clave primaria. Se crea una tabla 
separada que registra los valores generados para cada entidad. El proveedor 
de JPA consulta esta tabla para obtener el próximo valor de la clave primaria.
 * 
 */

/*
 * La especificación de JPA es una especificación estándar de Java 
 * que define una interfaz común y un conjunto de reglas para 
 * el mapeo objeto-relacional y la gestión de entidades en aplicaciones Java.
 * 
 * Varios proveedores de tecnología, como Hibernate, EclipseLink, Apache OpenJPA, 
 * entre otros, implementan la especificación de JPA y proporcionan las bibliotecas 
 * y herramientas necesarias para utilizar JPA en aplicaciones Java. 
 * Estas implementaciones ofrecen funcionalidades adicionales y 
 * características específicas, además de cumplir con los requisitos 
 * básicos definidos por la especificación de JPA.
 * 
 *  Por defecto, Spring Boot utiliza Hibernate como proveedor de JPA.
 *  
 *  Puedes especificar el proveedor de JPA a través de la propiedad 
 *  spring.jpa.properties.hibernate.dialect, donde hibernate.dialect 
 *  es la propiedad específica de Hibernate
 *  
 *  Hibernate es un framework de mapeo objeto-relacional que simplifica 
 *  el acceso a bases de datos relacionales y permite a los desarrolladores 
 *  trabajar con objetos en lugar de consultas SQL.  Hibernate proporciona 
 *  un lenguaje de consulta llamado Hibernate Query Language (HQL), 
 *  similar a SQL pero orientado a objetos.
 *  
 *  CrudRepository es una interfaz básica que proporciona métodos CRUD estándar, 
 *  mientras que JpaRepository es una interfaz extendida de CrudRepository 
 *  que agrega funcionalidades específicas de JPA. Si estás utilizando JPA 
 *  en tu aplicación de Spring y necesitas características adicionales como 
 *  consultas personalizadas o paginación, es recomendable utilizar JpaRepository. 
 *  Sin embargo, si solo necesitas las operaciones CRUD básicas, 
 *  CrudRepository puede ser suficiente.
 */
