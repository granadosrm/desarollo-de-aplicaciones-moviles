package mx.edu.tesoem.isc.sqlite_practica1_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mx.edu.tesoem.isc.sqlite_practica1_crud.entidades.ConexionSQLiteHelper;

public class MainActivity extends AppCompatActivity {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
	}

	public void Registro_act(View v)
	{
		Intent in = new Intent(MainActivity.this,Activity_Registro.class);
		startActivity(in);
		//finish();
	}
	public void Consulta_act(View v)
	{
		Intent in = new Intent(MainActivity.this,Activity_Consulta.class);
		startActivity(in);
		//finish();
	}

	public void Consulta_act_spinner(View v)
	{
		Intent in = new Intent(MainActivity.this,Activity_Spinner.class);
		startActivity(in);
		//finish();
	}

	public void Consulta_act_listview(View v)
	{
		Intent in = new Intent(MainActivity.this,Activity_Listview.class);
		startActivity(in);
		//finish();
	}

}
