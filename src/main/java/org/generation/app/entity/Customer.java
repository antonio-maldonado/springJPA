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
 *  dicha tabla. Adem�s, cada instancia se la clase se considera
 *  una fila en la tabla.
 */

/*
 *  @Bean se utiliza para indicar que un m�todo en una clase
 *  de Spring, devuelve un objeto que debe ser administrado
 *  por el contener de Spring.
 *  
 *  Cuando se utliza @Bean en un m�todo, Spring se encarga
 *  de llamar a ese m�todo y registrar el objeto devuelto
 *  en el contexto de la aplicaci�n como un bran.
 *  Este bean estar� disponible para su inyecci�n de dependencias
 *  en otras partes de la aplicaci�n.
 *  
 *  Command Line Runner es una interfaz funcional proporcionada
 *  por Spring que define un m�todo run() que se ejeucta una
 *  vez que se haya iniciado complementamente el
 *  contexto de la aplicaci�n de Spring. Este m�todo
 *  se utiliza comunmente para ejecutar tareas de inicializaci�n
 *  o configuraci�n al inicio de la aplicaci�n.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers") // nombre de la tabla en la DB
public class Customer {

	@Id // Indica que el atributo ser� la clave primaria de la entidad
	// Indica como se generar�n autom�ticamente las claves primarias
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
�* GenerationType.AUTO: Esta estrategia le permite al proveedor de JPA 
�* elegir autom�ticamente la estrategia de generaci�n m�s adecuada seg�n 
�* la base de datos y la configuraci�n. El comportamiento exacto puede 
�* variar dependiendo del proveedor utilizado.
�*
�* GenerationType.IDENTITY: Esta estrategia utiliza una columna de identidad 
de la base de datos para generar autom�ticamente los valores de la clave primaria. 
Es compatible con bases de datos como MySQL que admiten columnas de autoincremento. 
En este caso, la base de datos se encarga de generar y asignar el valor de la clave primaria.

GenerationType.SEQUENCE: Esta estrategia utiliza una secuencia de la base 
de datos para generar autom�ticamente los valores de la clave primaria. 
Se requiere que la base de datos admita secuencias. El proveedor de JPA 
utiliza la secuencia definida en la base de datos para obtener los valores 
de la clave primaria.

GenerationType.TABLE: Esta estrategia utiliza una tabla especial en la base 
de datos para generar los valores de la clave primaria. Se crea una tabla 
separada que registra los valores generados para cada entidad. El proveedor 
de JPA consulta esta tabla para obtener el pr�ximo valor de la clave primaria.
�* 
�*/

/*
�* La especificaci�n de JPA es una especificaci�n est�ndar de Java 
�* que define una interfaz com�n y un conjunto de reglas para 
�* el mapeo objeto-relacional y la gesti�n de entidades en aplicaciones Java.
�* 
�* Varios proveedores de tecnolog�a, como Hibernate, EclipseLink, Apache OpenJPA, 
�* entre otros, implementan la especificaci�n de JPA y proporcionan las bibliotecas 
�* y herramientas necesarias para utilizar JPA en aplicaciones Java. 
�* Estas implementaciones ofrecen funcionalidades adicionales y 
�* caracter�sticas espec�ficas, adem�s de cumplir con los requisitos 
�* b�sicos definidos por la especificaci�n de JPA.
�* 
�* �Por defecto, Spring Boot utiliza Hibernate como proveedor de JPA.
�* �
�* �Puedes especificar el proveedor de JPA a trav�s de la propiedad 
�* �spring.jpa.properties.hibernate.dialect, donde hibernate.dialect 
�* �es la propiedad espec�fica de Hibernate
�* �
�* �Hibernate es un framework de mapeo objeto-relacional que simplifica 
�* �el acceso a bases de datos relacionales y permite a los desarrolladores 
�* �trabajar con objetos en lugar de consultas SQL. �Hibernate proporciona 
�* �un lenguaje de consulta llamado Hibernate Query Language (HQL), 
�* �similar a SQL pero orientado a objetos.
�* �
�* �CrudRepository es una interfaz b�sica que proporciona m�todos CRUD est�ndar, 
�* �mientras que JpaRepository es una interfaz extendida de CrudRepository 
�* �que agrega funcionalidades espec�ficas de JPA. Si est�s utilizando JPA 
�* �en tu aplicaci�n de Spring y necesitas caracter�sticas adicionales como 
�* �consultas personalizadas o paginaci�n, es recomendable utilizar JpaRepository. 
�* �Sin embargo, si solo necesitas las operaciones CRUD b�sicas, 
�* �CrudRepository puede ser suficiente.
�*/
