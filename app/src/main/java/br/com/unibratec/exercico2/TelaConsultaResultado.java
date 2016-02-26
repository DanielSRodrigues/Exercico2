package br.com.unibratec.exercico2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TelaConsultaResultado extends AppCompatActivity {
    @Bind(R.id.txtName)
    TextView mTxtName;
    @Bind(R.id.txtSendMail)
    TextView mTxtSendMail;
    @Bind(R.id.txtSocial)
    TextView mTxtSocial;

    boolean checked;
    int idSocialNetwork;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consulta_resultado);
        ButterKnife.bind(this);

        Intent callerIntent = getIntent();
        if (callerIntent != null) {
            checked = callerIntent.getBooleanExtra("checked", false);
            name = callerIntent.getStringExtra("name");
            idSocialNetwork = callerIntent.getIntExtra(SocialNetwork.idPuExtra, 0);
        }

        mTxtSendMail.setText((checked ? getString(R.string.Yes) : getString(R.string.No)));
        mTxtName.setText(name);
        mTxtSocial.setText(SocialNetwork.getSocialNetworkString(this, idSocialNetwork));
    }
}
