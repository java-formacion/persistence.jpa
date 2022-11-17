# persistencia.jpa

Java Persitance Api, ORM e Hibernate.

Usamos un SGBD de MySQL y driver mysql-connector-java 5.1.46.

## Importar proyecto a eclipse

1. Clonar repositorio desde Github a Eclipse
2. Importar > Existing Maven Project

## Configuración bbdd

No hace falta los scripts de la bbdd porque lo crea Hibernate mediante ORM.

Si que es necesario: crear la base datos llamada **jpa**, intersante mirar el fichero **java/resources/META-INF/persistance.xml**

```
<?xml version="1.0" encoding="UTF-8"?>

<!-- configuración de la persistencia contra la bbdd -->

<persistence version="2.0"
	xmlns="http://java.sun.com/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">

	<!-- nombre de la unidad de persistencia que usa EntityManager -->
	<persistence-unit name="jpa_pu" transaction-type="RESOURCE_LOCAL">

		<!-- clase que implementa la Api de JPA en este caso Hibernate -->
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		
		<!-- Clases que van a ser persistidas contra la bbdd -->		
		<class>com.txurdi.persistencia.model.Libro</class>
		
		<properties>
			<!-- propiedes de conexion de la bbdd -->
			<property name="javax.persistence.jdbc.driver"   value="com.mysql.jdbc.Driver" />			
			<property name="javax.persistence.jdbc.url"      value="jdbc:mysql://localhost/jpa" />			
			<property name="javax.persistence.jdbc.user"     value="root" />
			<property name="javax.persistence.jdbc.password" value="root" />

			<!--  posibles valores:
				validate: valide que el esquema coincida, no realice cambios en el esquema de la base de datos, probablemente lo desee para la producción.
				update : actualiza el esquema para reflejar las entidades que se mantienen
				create: crea el esquema necesario para sus entidades, destruyendo cualquier dato anterior.
				create-drop : crea el esquema como en create anterior, pero también suelte el esquema al final de la sesión. Esto es genial en el desarrollo temprano o para pruebas. 
			-->
			
			<property name="hibernate.hbm2ddl.auto" value="create"/>

			<!-- los para mostar las sql en consola -->
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="true" />
			

		</properties>
	</persistence-unit>
</persistence>

```

### TAG 0.1

Tenemos dos Entidades ( Editorial y Libro ) pero sin union entre ellas.
[Readme del tag](/readmes/readme01.md)



### TAG 0.2

Creamos la relación de 1 a N, entre Editorial y Libro.
[Readme del tag](/readmes/readme02.md)





