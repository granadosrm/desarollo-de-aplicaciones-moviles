package mx.edu.tesoem.isc.sqlite_practica1_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import mx.edu.tesoem.isc.sqlite_practica1_crud.entidades.Usuario;

public class Activity_Listview_2 extends AppCompatActivity {
	TextView campoId,campoNombre,campoTelefono;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__listview_2);
		campoId=(TextView)findViewById(R.id.campoId);
		campoNombre=(TextView)findViewById(R.id.campoNombre);
		campoTelefono=(TextView)findViewById(R.id.campoTelefono);

		Bundle objetosenviados=getIntent().getExtras();
		Usuario user = null;
		if (objetosenviados!=null)
		{
			user= (Usuario) objetosenviados.getSerializable("usuario");
			campoId.setText(user.getId().toString());
			campoNombre.setText(user.getNombre().toString());
			campoTelefono.setText(user.getTelefono().toString());
		}
	}
}
