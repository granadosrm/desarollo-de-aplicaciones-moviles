package mx.edu.tesoem.isc.sqlite_practica1_crud.utulidades;

public class Utilidades
{
	//constantes campos tabla usuario
	public static final String TABLA_USUARIO = "usuario";
	public static final String CAMPO_NOMBRE = "nombre";
	public static final String CAMPO_ID = "id";
	public static final String CAMPO_TELEFONO = "telefono";

	public static final String CREATE_TABLE_USUARIO="CREATE TABLE "+TABLA_USUARIO+" " +
			"("+CAMPO_ID+" INTEGER, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_TELEFONO+" TEXT)";


	//constantes campos tabla mascotas
//	public static  final String TABLA_MASCOTA="mascota";
//	public static  final String CAMPO_IDDUENIO="id_duenio";
//	public static  final String CAMPO_IDMASCOTA="id_mascota";
//	public static  final String CAMPO_NOMBREMASCOTA="nombre_mascota";
//	public static  final String CAMPO_RAZA ="raza";

//	public static  final String CREATE_TABLE_MASCOTA="CREATE TABLE "+TABLA_MASCOTA+" "+"("+CAMPO_IDMASCOTA+"INTEGER PRIMARY KEY AUTOINCREMENT, "
//			+CAMPO_NOMBREMASCOTA+" TEXT"+CAMPO_RAZA+"TEXT"+CAMPO_IDDUENIO+"INTEGER)"; //CAMPO_IDDUENIO+"INTEGER FOREIGN KEY)";

}
