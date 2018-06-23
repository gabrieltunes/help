package ftec.com.br.help;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ADM on 22/06/2018.
 */

class CustomListAdapter extends ArrayAdapter<Clinica> {
    private final Activity contexto;
    private final ArrayList<Clinica> clinicas;

    public CustomListAdapter(Activity contexto, ArrayList<Clinica> clinicas) {
        super(contexto, R.layout.mylist, clinicas);

        this.contexto = contexto;
        this.clinicas = clinicas;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = contexto.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null,true);

        Clinica clinica = (Clinica) getItem(position);

        TextView txtNome = (TextView) rowView.findViewById(R.id.usuarioNome);
        TextView txtEmail = (TextView) rowView.findViewById(R.id.usuarioEmail);

        txtNome.setText(usuario.getNome());
        txtEmail.setText(usuario.getEmail());

        return rowView;

    };
}
