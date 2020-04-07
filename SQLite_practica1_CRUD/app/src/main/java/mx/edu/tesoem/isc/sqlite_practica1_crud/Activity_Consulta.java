package mx.edu.tesoem.isc.sqlite_practica1_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import mx.edu.tesoem.isc.sqlite_practica1_crud.entidades.ConexionSQLiteHelper;
import mx.edu.tesoem.isc.sqlite_practica1_crud.utulidades.Utilidades;

public class Activity_Consulta extends AppCompatActivity {
	EditText documento_consulta,nombre_consulta,telefono_consulta;
	ConexionSQLiteHelper conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__consulta);

		conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);

		documento_consulta=(EditText)findViewById(R.id.documento_consulta);
		nombre_consulta=(EditText)findViewById(R.id.nombre_consulta);
		telefono_consulta=(EditText)findViewById(R.id.telefono_consulta);


	}

	public void Consulta (View v)
	{
		switch (v.getId())
		{
			case R.id.btnBuscar_consultar:
				validavaciosBuscar();
				//consultar();
				break;

			case R.id.btnActualizar_consultar:
				validavaciosActualizar();
				//actualizarusuario();
				break;

			case R.id.btnEliminar_consultar:
				validavaciosEliminar();
				//eliminarusuario();
				break;
		}
	}

	private void validavaciosEliminar()
	{
		String id = documento_consulta.getText().toString();
		if (TextUtils.isEmpty(id))
		{
			documento_consulta.setError("ingrese un id para eliminar");
			return;
		}
		else
		{
			eliminarusuario();
		}
	}

	private void validavaciosActualizar()
	{
		String id = documento_consulta.getText().toString();
		String nombre = nombre_consulta.getText().toString();
		String telefono = telefono_consulta.getText().toString();

		if (TextUtils.isEmpty(id))
		{
			documento_consulta.setError("Ingrese un id");
			return;
		}
		if (TextUtils.isEmpty(nombre))
		{
			nombre_consulta.setError("ingrese un nombre");
			return;
		}
		if (TextUtils.isEmpty(telefono))
		{
			telefono_consulta.setError("ingrese el telefono");
		}
		else
		{
			actualizarusuario();
		}

	}

	private void eliminarusuario()
	{
		SQLiteDatabase db=conn.getWritableDatabase();
		String [] parametros={documento_consulta.getText().toString()};

		db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
		Toast.makeText(getApplicationContext(),"Usuario eliminado",Toast.LENGTH_LONG).show();
		documento_consulta.setText("");
		limpiar();
		db.close();
	}

	private void actualizarusuario()
	{
		SQLiteDatabase db=conn.getWritableDatabase();
		String [] parametros={documento_consulta.getText().toString()};
		ContentValues values = new ContentValues();
		values.put(Utilidades.CAMPO_NOMBRE,nombre_consulta.getText().toString());
		values.put(Utilidades.CAMPO_TELEFONO,telefono_consulta.getText().toString());

		db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID+"=?",parametros);
		Toast.makeText(getApplicationContext(),"Usuario actualizado",Toast.LENGTH_LONG).show();
		db.close();
	}

	private void validavaciosBuscar()
	{
		String id = documento_consulta.getText().toString();
		if (TextUtils.isEmpty(id))
		{
			documento_consulta.setError("introducir id de usuario");
			return;
		}
		else
		{
			consultar();
		}
	}

	private void consultar()
	{
		SQLiteDatabase db = conn.getReadableDatabase();
		String [] parametros={documento_consulta.getText().toString()};
		String[] campos ={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};


		try
		{
			Cursor cursor = db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
			cursor.moveToFirst();
			nombre_consulta.setText(cursor.getString(0));
			telefono_consulta.setText(cursor.getString(1));
			cursor.close();
		}catch (Exception e)
		{
			Toast.makeText(getApplicationContext(),"el documento no existe",Toast.LENGTH_LONG).show();
			limpiar();
		}


	}

	private void limpiar()
	{
		nombre_consulta.setText("");
		telefono_consulta.setText("");
	}
}
