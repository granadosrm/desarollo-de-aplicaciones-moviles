package mx.edu.tesoem.isc.sqlite_practica1_crud.entidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import mx.edu.tesoem.isc.sqlite_practica1_crud.utulidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper
{


	public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(Utilidades.CREATE_TABLE_USUARIO);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
		db.execSQL("DROP TABLE IF EXISTS usuarios");

		onCreate(db);
	}
}
