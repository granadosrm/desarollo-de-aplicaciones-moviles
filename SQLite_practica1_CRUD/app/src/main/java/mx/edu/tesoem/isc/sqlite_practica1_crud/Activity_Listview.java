package mx.edu.tesoem.isc.sqlite_practica1_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.edu.tesoem.isc.sqlite_practica1_crud.entidades.ConexionSQLiteHelper;
import mx.edu.tesoem.isc.sqlite_practica1_crud.entidades.Usuario;
import mx.edu.tesoem.isc.sqlite_practica1_crud.utulidades.Utilidades;

public class Activity_Listview extends AppCompatActivity {
	ListView listviewPersonas;

	ArrayList<String> listaInformacion;
	ArrayList<Usuario> listaUsuarios;

	ConexionSQLiteHelper conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__listview);
		listviewPersonas=(ListView)findViewById(R.id.listviewPersonas);

		conn= new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);

		consultarListaPersonas();
		ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
		listviewPersonas.setAdapter(adaptador);

		listviewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String informacion ="Id: "+listaUsuarios.get(position).getId()+"\n";
				informacion+="Nombre; "+listaUsuarios.get(position).getNombre()+"\n";
				informacion+="Telefono: "+listaUsuarios.get(position).getTelefono()+"\n";

				//Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_SHORT).show();

				Usuario user=listaUsuarios.get(position);

				Intent intent=new Intent(Activity_Listview.this,Activity_Listview_2.class);
				Bundle bundle=new Bundle();
				bundle.putSerializable("usuario",user);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}

	private void consultarListaPersonas()
	{
		SQLiteDatabase db=conn.getReadableDatabase();
		Usuario usuario = null;
		listaUsuarios = new ArrayList<Usuario>();

		//select * from Usuarios

		Cursor cursor =db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

		while (cursor.moveToNext())
		{
			usuario = new Usuario();
			usuario.setId(cursor.getInt(0));
			usuario.setNombre(cursor.getString(1));
			usuario.setTelefono(cursor.getString(2));

			listaUsuarios.add(usuario);
		}
		obtenerLista();
	}

	private void obtenerLista()
	{
		listaInformacion = new ArrayList<String>();

		for (int i=0;i<listaUsuarios.size();i++)
		{
			listaInformacion.add(listaUsuarios.get(i).getId()+" -- "+
					listaUsuarios.get(i).getNombre());
		}
	}
}
