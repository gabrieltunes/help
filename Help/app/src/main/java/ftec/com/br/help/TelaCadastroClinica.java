package ftec.com.br.help;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ADM on 22/06/2018.
 */

public class TelaCadastroClinica extends AppCompatActivity {

    private static final String TAG = "_TELA_CAD_CLINICA_";
    EditText etNome, etTelefone, etEmail;
    Clinica usuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_usuario);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setSubtitle(getResources().getString(R.string.tela_edicao_usuario));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNome = (EditText) findViewById(R.id.etNome);
        etTelefone = (EditText) findViewById(R.id.etTelefone);
        etEmail = (EditText) findViewById(R.id.etEmail);

        Intent intent = getIntent();
        usuario = (Usuario) intent.getSerializableExtra("usuario");
        if (usuario != null) {
            etNome.setText(usuario.getNome());
            etTelefone.setText(usuario.getTelefone());
            etEmail.setText(usuario.getEmail());
        }

        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean usuarioNovo = false;
                if (usuario == null) {
                    usuario = new Usuario();
                    usuarioNovo = true;
                }
                usuario.setNome(etNome.getText().toString());
                usuario.setTelefone(etTelefone.getText().toString());
                usuario.setEmail(etEmail.getText().toString());
                try {
                    if (usuarioNovo) {
                        DAO.incluirUsuario(usuario);
                    } else {
                        DAO.alterarUsuario(usuario);
                    }

                    Toast.makeText(TelaCadastroUsuario.this, "Usuário " + usuario.getNome() + " cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Log.e(TAG, "Ocorreu um erro ao tentar salvar " + etNome.getText().toString());
                }
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
