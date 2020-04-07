package mx.edu.tesoem.isc.sqlite_practica1_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.tesoem.isc.sqlite_practica1_crud.entidades.ConexionSQLiteHelper;
import mx.edu.tesoem.isc.sqlite_practica1_crud.utulidades.Utilidades;

public class Activity_Registro extends AppCompatActivity {
	EditText id_registro,nombre_registro,telefono_registro;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__registro);
		id_registro =(EditText)findViewById(R.id.id_registro);
		nombre_registro=(EditText)findViewById(R.id.nombre_registro);
		telefono_registro=(EditText)findViewById(R.id.telefono_registro);
	}
	public void registro(View v)
	{

		validavacios();
		//registrarusuarios();

	}

	private void validavacios()
	{
		String id = id_registro.getText().toString();
		String nombre = nombre_registro.getText().toString();
		String telefono = telefono_registro.getText().toString();
		if(TextUtils.isEmpty(id))
		{
			id_registro.setError("elegir un id de usuario");
			return;
		}
		if (TextUtils.isEmpty(nombre))
		{
			nombre_registro.setError("introducir nombre de usuario");
			return;
		}
		if (TextUtils.isEmpty(telefono))
		{
			telefono_registro.setError("introducir numero de telefono");
			return;
		}
		else
		{
			registrarusuarios();
		}
	}

	private void registrarusuarios()
	{

		ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

		SQLiteDatabase db = conn.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(Utilidades.CAMPO_ID,id_registro.getText().toString());
		values.put(Utilidades.CAMPO_NOMBRE,nombre_registro.getText().toString());
		values.put(Utilidades.CAMPO_TELEFONO,telefono_registro.getText().toString());

		Long idResultante = db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

		Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
		db.close();
		limpiar();
	}
	private void limpiar()
	{
		id_registro.setText("");
		nombre_registro.setText("");
		telefono_registro.setText("");
	}
}
