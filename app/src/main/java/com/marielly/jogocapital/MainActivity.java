package com.marielly.jogocapital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Estado[] arrEstados = new Estado[27];
    int numEstado, acertos = 0, rodada = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criaEstados();
        sortear();

    }
    public class Estado {
        private String estado;
        private String capital;

        public Estado() { };
        public Estado(String estado, String capital) {
            this.estado = estado;
            this.capital = capital;
        }

        public String getEstado() {
            return this.estado;
        }

        public String getCapital() {
            return this.capital;
        }
    }

    public void sortear(View view) {
        TextView nomeEstado = findViewById(R.id.nomeEstado);
        Button botaoProxima = findViewById(R.id.botaoProxima);
        Button botaoVerificar = findViewById(R.id.botaoVerificar);
        Random r = new Random();
        numEstado = r.nextInt(26);

        nomeEstado.setText(arrEstados[numEstado].estado);
        rodada++;
        botaoProxima.setEnabled(false);
        botaoVerificar.setEnabled(true);
    }

    public void sortear() {
        TextView nomeEstado = findViewById(R.id.nomeEstado);
        Random r = new Random();
        numEstado = r.nextInt(26);

        nomeEstado.setText(arrEstados[numEstado].estado);
        rodada++;
    }

    public void verificar(View view) {
        EditText capital = findViewById(R.id.capital);
        Button botaoVerificar = findViewById(R.id.botaoVerificar);
        Button botaoProxima = findViewById(R.id.botaoProxima);
        TextView resultado = findViewById(R.id.resultado);
        TextView pontuacao = findViewById(R.id.pontuacao);

        if (capital.length() == 0) {
            Toast.makeText(this, "Insira uma capital, plis!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (arrEstados[numEstado].capital.equalsIgnoreCase(capital.getText().toString().trim())) {
            acertos++;
            resultado.setText("Parabéns! Você acertou :D");
        } else {
            resultado.setText("Ooops! Você errou tururu :(");
        }

        capital.setText("");
        botaoVerificar.setEnabled(false);
        botaoProxima.setEnabled(true);

        if (rodada >= 5) {
            botaoProxima.setEnabled(false);
            pontuacao.setText("Sua pontuação final: " + acertos * 10 + "/50 pontos!");
        } else {
            pontuacao.setText("Sua pontuação atual: " + acertos * 10 + "/50 pontos!");
        }

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public void criaEstados() {
        arrEstados[0] = new Estado("Acre", "Rio Branco");
        arrEstados[1] = new Estado("Alagoas", "Maceió");
        arrEstados[2] = new Estado("Amapá", "Macapá");
        arrEstados[3] = new Estado("Amazonas", "Manaus");
        arrEstados[4] = new Estado("Bahia", "Salvador");
        arrEstados[5] = new Estado("Ceará", "Fortaleza");
        arrEstados[6] = new Estado("Espírito Santo", "Vitória");
        arrEstados[7] = new Estado("Goiás", "Goiânia");
        arrEstados[8] = new Estado("Maranhão", "São Luís");
        arrEstados[9] = new Estado("Mato Grosso", "Cuiabá");
        arrEstados[10] = new Estado("Mato Grosso do Sul", "Campo Grande");
        arrEstados[11] = new Estado("Minas Gerais", "Belo Horizonte");
        arrEstados[12] = new Estado("Pará", "Belém");
        arrEstados[13]= new Estado("Paraíba", "João Pessoa");
        arrEstados[14] = new Estado("Paraná", "Curitiba");
        arrEstados[15] = new Estado("Pernambuco", "Recife");
        arrEstados[16] = new Estado("Piauí", "Teresina");
        arrEstados[17] = new Estado("Rio de Janeiro", "Rio de Janeiro");
        arrEstados[18] = new Estado("Rio Grande do Norte", "Natal");
        arrEstados[19] = new Estado("Rio Grande do Sul", "Porto Alegre");
        arrEstados[20] = new Estado("Rondônia", "Porto Velho");
        arrEstados[21] = new Estado("Roraima", "Boa Vista");
        arrEstados[22] = new Estado("Santa Catarina", "Florianópolis");
        arrEstados[23] = new Estado("São Paulo", "São Paulo");
        arrEstados[24] = new Estado("Sergipe", "Aracaju");
        arrEstados[25] = new Estado("Tocantins", "Palmas");
    }
}