package mx.edu.tesoem.isc.sqlite_practica1_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import mx.edu.tesoem.isc.sqlite_practica1_crud.entidades.ConexionSQLiteHelper;
import mx.edu.tesoem.isc.sqlite_practica1_crud.entidades.Usuario;
import mx.edu.tesoem.isc.sqlite_practica1_crud.utulidades.Utilidades;

public class Activity_Spinner extends AppCompatActivity {
	Spinner combopersonas;
	TextView txtDocumento,txtNombre,txtTelefono;

	ArrayList<String> listaPersonas;
	ArrayList<Usuario> personasList;

	ConexionSQLiteHelper conn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__spinner);
		conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);

		combopersonas =(Spinner)findViewById(R.id.combopersonas);

		txtDocumento =(TextView)findViewById(R.id.txtDocumento);
		txtTelefono=(TextView)findViewById(R.id.txtTelefono);
		txtNombre=(TextView)findViewById(R.id.txtNombre);

		consultarListaPersonas();

		ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaPersonas);

		combopersonas.setAdapter(adaptador);
		combopersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id1) {
			if (position!=0)
			{
				txtDocumento.setText("Id:       "+personasList.get(position-1).getId().toString());
				txtNombre.setText("Nombre:      "+personasList.get(position-1).getNombre());
				txtTelefono.setText("Telefono:      "+personasList.get(position-1).getTelefono());
			}
			else {
				txtDocumento.setText("");
				txtNombre.setText("");
				txtTelefono.setText("");
			}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}

	private void consultarListaPersonas()
	{
		SQLiteDatabase db=conn.getReadableDatabase();
		Usuario persona=null;
		personasList = new ArrayList<Usuario>();

		//select* from Usuarios;
		Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);
		while (cursor.moveToNext())
		{
			persona = new Usuario();
			persona.setId(cursor.getInt(0));
			persona.setNombre(cursor.getString(1));
			persona.setTelefono(cursor.getString(2));

			personasList.add(persona);
		}
		obtenerLista();

	}

	private void obtenerLista()
	{
		listaPersonas= new ArrayList<String>();
		listaPersonas.add("Seleccione");

		for (int  i=0; i<personasList.size();i++)
		{
			listaPersonas.add(personasList.get(i).getId()+" --  "+personasList.get(i).getNombre());
		}
	}
}
