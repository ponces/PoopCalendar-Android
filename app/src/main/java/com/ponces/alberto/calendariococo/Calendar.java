package com.ponces.alberto.calendariococo;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alberto Ponces on 10/06/15.
 */
public class Calendar extends SQLiteOpenHelper {

    private Context context;
    private String description;
    private String heart;

    public Calendar(Context context) {
        super(context, "calendar.db", null, 1);
        this.context = context;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS cozinho " +
                "(date TEXT, description TEXT, UNIQUE(date, description));");
        db.execSQL("CREATE TABLE IF NOT EXISTS cozinha " +
                "(date TEXT, description TEXT, UNIQUE(date, description));");
        db.execSQL("CREATE TABLE IF NOT EXISTS cozinho_dia " +
                "(date TEXT, heart TEXT, description TEXT, UNIQUE(date, heart, description));");
        db.execSQL("CREATE TABLE IF NOT EXISTS cozinha_dia " +
                "(date TEXT, heart TEXT, description TEXT, UNIQUE(date, heart, description));");
        insertsCozinho(db);
        insertsCozinha(db);
        insertsCozinhoDia(db);
        insertsCozinhaDia(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private void insertsCozinho(SQLiteDatabase db) {
        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-01', 'Quando caminhamos abraçados, a tua mão faz-me festinhas no braço.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-02', 'Marcas muitos golos quando jogas futebol.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-03', 'Faz-me bem gostar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-04', 'Gostas de ver \"Os Barbixas\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-05', 'É impossível não gostar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-06', 'Gostas de ler Dan Brown.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-07', 'Na piscina, brincas mais do que nadas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-08', 'Gostas de maçã laminada.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-10', 'Me dás beijinhos nas costas quando estão destapadas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-11', 'Ris-te quando eu não digo as palavras direitinhas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-12', 'Só demoras meia hora desde que acordas até que sais de casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-13', 'Nunca fazes o que eu digo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-14', 'Me fazes cócegas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-15', 'Gostas de andar descalço.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-16', 'Sabes onde começam e acabam as zonas do Andante.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-17', 'Toda a gente gosta de nós.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-18', 'Às vezes tentas chegar ao chão sem dobrar as pernas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-19', 'És assim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-20', 'Deixas-me sentar no teu colinho e agarras-me com força.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-21', 'És mais velho do que eu.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-22', 'Depois de Receita, bebes Sangria para eu gostar dos teus beijinhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-23', 'Queres sempre saber como foi o meu dia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-24', 'Gostas do chocolate quente do grão.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-25', 'Dizes que não posso dizer que sim a tudo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-26', 'Quando me dás a mão, fazes-me festinhas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-27', 'Não percebes nada de marcas de carros.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-28', 'Gostas de crianças.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-29', 'Gostas de andar de bicicleta.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-30', 'Já não me chamas trenga.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('01-31', 'Gostas de mudanças.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-01', 'Não consegues estar quieto muito tempo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-02', 'Ficas triste quando eu estou triste.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-03', 'Vais ser um engenheiro rico.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-04', 'Bebes sopa numa caneca, em vez de usares um prato.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-05', 'Me deste um colar lindo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-06', 'Decoras as Passwords da Internet.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-07', 'Não me deixas fazer nada por ti.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-08', 'Me levas muitas vezes à faculdade.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-10', 'Parece que ainda estamos na fase inicial e cor-de-rosa do namoro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-11', 'Dizes que não se pode enrolar os cabos, por ficarem estragados.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-12', 'Todos os dias dizes \"Nana bem, Có\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-13', 'Gostas de me ver de brincos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-14', 'Gostas mais de piscina do que de praia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-15', 'Revês os meus trabalhos, para veres se estão bem formatados.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-16', 'És muito corajoso.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-17', 'Dizes que o Boavista não é fixe.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-18', 'Foste meu Amigo antes de seres meu Namorado.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-19', 'Escreves miminhos virtuais perfeitos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-20', 'Passas a vida a rapar o cabelo contra a minha vontade.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-21', 'Escondes a perna do porco quando eu estou em casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-22', 'Gostas de dormir até tarde.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-23', 'Ris-te das pessoas que ficam sérias a dançar nos bailaricos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-24', 'A tua família me trata bem.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-25', 'Pareces o Mr. Bean.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-26', 'Inventamos nomes para os beijinhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-27', 'Fazes as camas muito direitinhas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-28', 'Não sabias que no Gmail não é preciso escrever @gmail.com.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('02-29', 'És o Totó mais bonito que conheço.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-01', 'Gostas de ir ao cinema.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-02', 'Me Amas Cocomente muito.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-03', 'Dás abraços com festinhas nas costas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-04', 'Tratas-me com muito carinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-05', 'Gostas de fazer desporto.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-06', 'Em casa comes pouquinho, mas quando estás fora, és muito gordo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-07', 'Só sabes dançar à Totó.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-08', 'Não gostas de areia na toalha.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-10', 'Não te zangas quando eu tenho pouco tempo para nós.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-11', 'Me entortaste o joelho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-12', 'Apanhas secas por minha causa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-13', 'Dizes \"Olha um gatinho\" com uma voz de criança.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-14', 'Gostas de Pizza com ananás.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-15', 'Não gostas de ficar suado.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-16', 'Me dás miminhos no cinema.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-17', 'Comes muitos chipicao.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-18', 'Escutas o que eu tenho para dizer.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-19', 'Dizes atacadores em vez de cordões.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-20', 'Passeias comigo ao pôr-do-sol.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-21', 'Contas-me segredos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-22', 'Quando ponho os óculos, dizes que a Có desapareceu.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-23', 'Me dás a mão quando estamos na Igreja.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-24', 'És meu Namorado.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-25', 'Dizes para irmos para casa quando reparas que estou com sono.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-26', 'Me pediste o número com a calculadora.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-27', 'Amas a tua Família.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-28', 'Cortas a pizza com uma tesoura.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-29', 'Todos os dias me envias uma mensagem de boas noites.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-30', 'Já sei que vestido vou usar no casamento.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('03-31', 'Me fazes muito feliz.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-01', 'Gostas de festas na Aldeia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-02', 'Ainda tens um Gameboy.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-03', 'Guardas as tuas coisas na minha mala e depois esqueces-te.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-04', 'Namoramos há 1000 dias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-05', 'Confundes sempre o Violoncelo com o Contrabaixo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-06', 'Reclamas quando tenho as mãos suadas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-07', 'Não sabíamos que o nosso passe dava para ir até ao Fórum Maia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-08', 'Todos os dias agradeço a Deus por te ter.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-10', 'Fazes um beicinho lindo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-11', 'Todos os dias me queres dar beijinhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-12', 'Não gostas da \"Ressaca\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-13', 'Somos clientes assíduos do Grão.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-14', 'Não gostas de sentir um sapato mais apertado do que outro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-15', 'Me sinto a pessoa mais importante do mundo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-16', 'Reclamas das pessoas têm óptimos telemóveis e não os sabem usar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-17', 'Vemos Fogo-de-artifício muito agarradinhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-18', 'Se ganhasses 5€ por cada PC formatado, eras rico.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-19', 'Às vezes vens até a minha casa para me dares um beijinho rápido.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-20', 'Escreves Bus em vez de Autocarro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-21', 'Cantamos Músicas da Disney.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-22', 'Gostas de passear comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-23', 'Gostas dos meus braços.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-24', 'Pões o alarme para 10 minutos mais cedo, para dormires mais um bocadinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-25', 'Dizes que as minhas roupas são bonitas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-26', 'Sabes quando eu não estou bem, mesmo sem eu dizer.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-27', 'Reclamas quando não imprimo as coisas em casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-28', 'Ficas feliz por namorar com uma professora.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-29', 'Gostas de magia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('04-30', 'Tens os horários da Resende no telemóvel.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-01', 'O teu sorriso é muito bonito.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-02', 'Me mandas mensagens a desejar boas aulas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-03', 'Gostas de 7up.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-04', 'És feliz.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-05', 'Gosto de conversar contigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-06', 'Queres visitar New York.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-07', 'Tentas sempre não criar discussões.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-08', 'Sabes falar Inglês.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-10', 'Dizes \"Ó Mulher\" quando não faço algo como devia ser.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-11', 'Me tratas tão bem.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-12', 'Gostas de tirar fotos com cara de Totó.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-13', 'Os teus olhos dizem que gostas de mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-14', 'Dizes que existe \"A outra\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-15', 'Gostas de frutos vermelhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-16', 'Me ensinaste a usar tinteiros reciclados.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-17', 'Nunca me mentes.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-18', 'Inventaste o <4.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-19', 'Pensas primeiro em mim e depois em ti.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-20', 'Sabes jogar Poker.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-21', 'Me tratas como uma deusa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-22', 'Nunca te lembras de me tirar fotos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-23', 'Sabes contar anedotas do \"Quim Roscas\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-24', 'Me fazes companhia quando tenho que andar sozinha de autocarro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-25', 'Queres traduzir expressões que só fazem sentido em Inglês.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-26', 'Não te zangas quando adormeço sem te enviar beijinhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-27', 'Tens um esquema numérico para te lembrares do nosso aniversário.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-28', 'Se não gostasse, era infeliz.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-29', 'Gostas de mim como sou.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-30', 'Queres sempre saber o que eu estou a pensar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('05-31', 'Dizes que tens sorte em me ter.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-01', 'Estamos muito bem um para o outro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-02', 'Dizes que sou gorda.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-03', 'Sabes sempre tudo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-04', 'Os teus abraços são reconfortantes.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-05', 'Dizes que sou Cocó.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-06', 'Bebes suminhos em minha casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-07', 'Gostas de reclamar comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-08', 'Vou com a tua cara.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-10', 'Conversamos muito no banquinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-11', 'Sabes fazer vozes esquisitas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-12', 'Ainda és Criança.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-13', 'Gostas de dormir a sesta.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-14', 'Sabes imitar o Gary.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-15', 'Gostas dos teus Amigos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-16', 'Estás sempre preocupado com o que o meu Pai pensa de ti.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-17', 'És uma óptima companhia para ver filmes.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-18', 'Te preocupas comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-19', 'Gostas de dormir a sesta.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-20', 'Dizes que às vezes tenho que ter mais paciência.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-21', 'Desabafas comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-22', 'Ficas muito bonito de calções.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-23', 'Só me dás razões para gostar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-24', 'Ainda me vais Amar quando eu for uma velhinha chata.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-25', 'Ficas meia hora a olhar para mim e depois dizes que sou bonita.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-26', 'Vivemos momentos inesquecíveis.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-27', 'Quando passas algum tempo sem mim, dizes que morres de saudade.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-28', 'Experimentas sempre as minhas experiências culinárias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-29', 'Tu gostas de mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('06-30', 'Gostar me faz sentir feliz.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-01', 'Me tornaste numa mimalha.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-02', 'Tenho que ser sempre eu a decidir onde vamos passear.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-03', 'Reclamas quando me esqueço de tirar o telemóvel do silêncio.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-04', 'Gostas de \"Lord of the Rings\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-05', 'Te descascas a rir a ver os gatos a serem totós.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-06', 'Fazes contas de cabeça muito rápido.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-07', 'Estás sempre a par das actualizações tecnológicas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-08', 'És o Cocó.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-10', 'Me dás flores.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-11', 'Gostas quando eu digo \"Ó Có...\"');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-12', 'Me dás atenção.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-13', 'Não carregas nos botões stop dos autocarros.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-14', 'Cheiras bem.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-15', 'Me dás beijinhos à porta de minha casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-16', 'Gostas de comida japonesa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-17', 'És o Betinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-18', 'Dizes que demoras 5 minutos a sair, e demoras 15.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-19', 'És distraído.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-20', 'Às vezes entro primeiro no autocarro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-21', 'Nadas muito bem.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-22', 'Gosto de gostar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-23', 'Sabes imitar o som de um foguete.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-24', 'Gostas dos meus Amigos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-25', 'Quando comes um cachorro, metade vai para o chão.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-26', 'Secas o cabelo com o secador.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-27', 'Todos os dias perguntas: \"Como é a nossa vida\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-28', 'Gostamos de F.R.I.E.N.D.S.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-29', 'És fixe.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-30', 'Tens bochechas boas para dar beijinhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('07-31', 'Não gostas de leite.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-01', 'Tens paciência para mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-02', 'És muito alto.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-03', 'Dizes sempre: \"Decide tu, Có\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-04', 'Te ris para trás.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-05', 'Escreves coisas nos meus apontamentos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-06', 'A sopinha da tua Mãe é muito boa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-07', 'Tens cócegas nos braços.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-08', 'És gordo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-10', 'Mostras ao mundo que me Amas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-11', 'Gostas de pão com Nutella.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-12', 'Me dás o teu casaco quando está frio.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-13', 'Sabes tanto sobre computadores.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-14', 'Cantas bem.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-15', 'Não gostas de acordar cedo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-16', 'Demos muitos beijinhos no Baile.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-17', 'Sabes as letras da Músicas de cor.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-18', 'És Mimólico.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-19', 'Não gostas de areia nos pés.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-20', 'Tiramos fotos lindas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-21', 'Te portas mal à mesa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-22', 'Posso abraçar-te dentro do casaco.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-23', 'Dizes \"Ó Mor\" com uma voz muito aguda.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-24', 'Sabes mudar a rom do telemóvel.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-25', 'Inventamos o CPP.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-26', 'Ficas bonito a nadar mariposa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-27', 'Assobias quando me deixas na faculdade.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-28', 'Dizes que não podemos gastar dinheiro em lanchinhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-29', 'Somos felizes.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-30', 'Dizes \"Pigosso\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('08-31', 'Andamos de mão dada na rua.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-01', 'Me mostras vídeos engraçados.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-02', 'Gostas de me ouvir.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-03', 'Me dás beijinhos nos pés.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-04', 'Passas a vida a picar-me.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-05', 'Gostas da minha família.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-06', 'És marguinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-07', 'Gostas de desenhos animados.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-08', 'Ti Amo quadriliões.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-10', 'Estás sempre a dizer: \"Tu é que sabes, Có\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-11', 'Me fazes rir.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-12', 'Gostas das minhas sandes.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-13', 'Tens o PC organizado.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-14', 'Brincas comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-15', 'És engraçado.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-16', 'Andamos agarrados debaixo do guarda-chuva.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-17', 'Foi a Pantera que me pediu para namorar contigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-18', 'Gostas de sidra.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-19', 'Danças comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-20', 'Vês quinhentos episódios de uma série num dia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-21', 'Me conheces bem.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-22', 'Sabes fazer omeletes.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-23', 'Dás berrinhos quando vou a conduzir.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-24', 'Dás-me prendas sempre lindas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-25', 'Tens camisolas quentinhas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-26', 'Gozas comigo porque gosto da mesa bem posta.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-27', 'Dás abraços deliciosos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-28', 'Carregas o meu Violino.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-29', 'Um dia vamos ter um cão chamado Poopy.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('09-30', 'Dizes que sou uma chata.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-01', 'Gostas de brincar com o Gatolas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-02', 'Me ensinaste a Amar bastante imensamente muito.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-03', 'Pagas os cafés.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-04', 'Brincas quando temos que largar as mãos a passar nos postes.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-05', 'Gostas mais de Linux do que Windows.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-06', 'Dizes que sou bonita.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-07', 'Me levas a jantar a sítios românticos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-08', 'Nunca te lembras das coisas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-10', 'Temos planos para o futuro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-11', 'Carregas os sacos do supermercado.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-12', 'Gostas de jogos de vídeo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-13', 'Fico sempre primeiro em casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-14', 'Não gostas de falar ao telemóvel.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-15', 'Deixas-me subir quando faço olhinhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-16', 'És um melga.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-17', 'Me apoias nas minhas decisões.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-18', 'Já não almoças a ver CS.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-19', 'Me ensinaste a dar a cambalhota debaixo de água.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-20', 'Nunca usas o relógio que te dei.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-21', 'Sou mimólica.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-22', 'Finges que estragas os retrovisores.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-23', 'Sabes sempre as notícias mais actuais.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-24', 'Passas a vida a reclamar com a Apple.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-25', 'Tens sentido de humor.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-26', 'És Cocó por afinidade.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-27', 'Ris-te quando digo que não como coelho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-28', 'Bebes muitos iogurtes líquidos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-29', 'Aturas as minhas Cocozices.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-30', 'Vamos ter 3 bebés.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('10-31', 'Não te incomodas por usar uma meia de cada cor.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-01', 'Dizes todos os dias que sonhaste comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-02', 'Sabes fazer habilidades com o guarda-chuva.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-03', 'Dizes que tens orgulho em mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-04', 'Ficas feliz quando tenho aguinha na carteira.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-05', 'Me ensinaste o que é uma versão beta.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-06', 'Atendes o telemóvel assim: \"Tôôôôôôô\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-07', 'Finges que és infeliz.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-08', 'Sacas filmes e séries para mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-10', 'Me deixas adormecer no teu peitinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-11', 'Dás abraços bons quando eu estou em cima de um degrau.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-12', 'Quando escolhes uma cor, o verde é a primeira opção.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-13', 'Gostas dos meus caracóis.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-14', 'Brincas com a Bia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-15', 'Dás os bons dias aos motoristas dos autocarros.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-16', 'Não sabias o que era mini-meia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-17', 'Lembras-te da roupa que eu usei no em que me conheceste.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-18', 'Sabes o que são pontas espigadas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-19', 'Tens uns óculos de sol muito bonitos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-20', 'Gostas de queijo batata frita.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-21', 'Sabes pôr gasolina.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-22', 'Sabes o meu nome completo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-23', 'Abres o frigorífico e ficas meia hora a olhar lá para dentro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-24', 'Tens sempre solução para quando a tecnologia me dá problemas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-25', 'Gostas de Criminal Minds.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-26', 'Tens uma cena fixe para pôr o PC em cima das pernas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-27', 'Fazes milhentas coisas por mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-28', 'Admiras-te com a chávena do café por ficar suja em baixo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-29', 'Consegues comer carne com um garfo de peixe.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('11-30', 'Conheces todos os sketch do Gato Fedorento.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-01', 'Vamos ser velhotes e namorar todos os dias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-02', 'Ficas aborrecido quando passas o todo em casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-03', 'Te preocupas com o meu Bem-estar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-04', 'Todos os dias me amas mais um bocadinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-05', 'Vais às minhas audições de Violino.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-06', 'Fazes muitas totozices.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-07', 'Tens bom gosto para filmes.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-08', 'Aprendeste a gostar de iogurte com chocapic.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-10', 'Enquanto caminhamos, vais a olhar para trás a ver se vem o autocarro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-11', 'Ficas a dormir enquanto eu vou dar aulas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-12', 'Não gostas de me ver de cabelo preso.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-13', 'Vais trabalhar numa empresa de informática com muitas regalias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-14', 'Gostas mais de Burger King do que McDonald’s.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-15', 'Não gostas que deixe a toalha torta depois de secar as mãos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-16', 'Conheces uma aplicação para descobrir as passwords da Thompson.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-17', 'Me dás muitos miminhos virtuais.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-18', 'Em vez de decidires, dizes: \"É como o meu Amor quiser\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-19', 'Não és grande fã de doces de Natal.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-20', 'Conheces bem os bonecos da Marvel.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-21', 'És um bocadinho Nerd.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-22', 'Consegues trincar gelo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-23', 'Gostas de sopa com couves.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-24', 'Dizes \"ócensa\" em vez de \"com licença\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-25', 'Já te vi chorar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-26', 'Dizes que sou a mulher da tua vida.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-27', 'Partilhas a tua vida comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-28', 'Não gostas de esperar pelo autocarro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-29', 'Achas piada às pessoas que dizem Lidal em vez de Lidl.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-30', 'Tens o mesmo estojo há quinhentos anos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinho(date, description) " +
                "VALUES('12-31', 'Quase nunca comemos pipocas no cinema.');");
    }

    private void insertsCozinha(SQLiteDatabase db) {
        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-01', 'Fazes tudo com muito amor e carinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-02', 'Dizes que sou o melhor namorado do Mundo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-03', 'Gostas de namorar no banquinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-04', 'Tens uma fotografia muito linda de quando eras pequenina.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-05', 'Me trazes iogurtes de chocolate da Nesquik quando tens em tua casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-06', 'Gostas que te mude a ROM do telemóvel.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-07', 'Me deixas bilhetinhos na mochila ou na carteira.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-08', 'Ainda tens o top azul que usaste no dia em que te conheci.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-10', 'Tens um auto-controlo muito grande para me aturares.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-11', 'Não gostas que te chame trenga.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-12', 'Partimo-nos a rir ao ver e recordar sketches de Gato Fedorento.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-13', 'Te partes a rir com o sketch do teleférico do Gato Fedorento.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-14', 'Me fazes feliz todos os dias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-15', 'És uma benção de Deus para mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-16', 'Queres ficar comigo para sempre.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-17', 'Adormeceste muitas vezes antes de mandares a mensagem à noite.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-18', 'Não gostas que eu seja indeciso e obrigas-me a decidir.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-19', 'Pedes a minha opinião para tomares decisões.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-20', 'Dizes \"Pigosso\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-21', 'Me amas mesmo quando sou um esquecido.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-22', 'Reclamas comigo por me atrasar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-23', 'Gostas quando te abraço e fico a fazer festas no braço.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-24', 'Sabes tudo sobre música.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-25', 'Tens que correr para acompanhar o meu passo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-26', 'Me deste um mp3 muito giro que parece um Lego e ainda funciona.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-27', 'Ainda estamos apaixonados.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-28', 'Instalas aplicações porque eu te mostro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-29', 'Quando eu vou jogar futebol, queres sempre que marque golos para ti.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-30', 'Tocas violino.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('01-31', 'És a razão da minha felicidade.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-01', 'Namoro com uma mulher mais nova.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-02', 'Te partes a rir quando me rio para trás.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-03', 'Tens sempre um sorriso na boca.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-04', 'Não sabes jogar mini-golf.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-05', 'Me trazes presentes quando vais passear ou viajar sem mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-06', 'Os motoristas dos autocarros só páram porque mostras o passe ao fazer paragem.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-07', 'Sabes muitas coisas sobre a Bíblia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-08', 'Vais educar os nossos filhos na Música.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-10', 'Tens ciúmes da \"outra\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-11', 'Gostas de animais.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-12', 'Ficas muito bonita quando choras.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-13', 'Fazes sanduíches muito boas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-14', 'Também gostas de fazer caras totós ao tirar fotografias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-15', 'Depois de nos zangarmos dás-me muitos miminhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-16', 'Te preocupas comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-17', 'Ficas muito bem de óculos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-18', 'Sabes muitas coisas sobre estrelas e constelações.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-19', 'Nunca acertas se eu quero café normal ou cheio.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-20', 'Me achas bonito.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-21', 'Me fizeste um calendário de razões para gostares de mim para cada dia do ano.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-22', 'És a Có.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-23', 'Dás graças comigo sempre que temos uma refeição juntos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-24', 'Estamos muito bem um para o outro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-25', 'Sabes quando eu não estou bem.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-26', 'Me roubas as camisolas grossas e depois dizes que são tuas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-27', 'Gostas que te explique coisas sobre informática.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-28', 'Também gostas de provar comida de outras cozinhas do Mundo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('02-29', 'Gostas da sopa da minha mãe.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-01', 'Achas que vais ficar com uma camisola quentinha de carapuço.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-02', 'Vamos ao cinema juntos ver filmes de animação que são para crianças.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-03', 'Posso dizer que namoro com uma Professora.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-04', 'Gostas do \"Lord of the Rings\" e do \"The Hobbit\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-05', 'Ficas linda de vestidos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-06', 'Deste um colete nos anos para ficar como o Patrick Jane.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-07', 'Tens a mania que não gostas de pés.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-08', 'Não gostas de correr para os autocarros ou para o metro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-10', 'Tu gostas de mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-11', 'Ficas facilmente com sono à noite.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-12', 'Gostas muito de Filipinos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-13', 'Te estraguei o joelho e Amas-me na mesma.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-14', 'Vamos ter uma lua de mel de auto caravana por Portugal.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-15', 'Não gostas que berre dentro do carro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-16', 'Decides as coisas quando eu não consigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-17', 'Todos os dias usas o colar que te dei.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-18', 'Me escreves cartas muito lindas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-19', 'Olhas para a porta para me lançar um beijinho quando estás a subir as escadas do teu prédio.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-20', 'Me dás livros de banda desenhada.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-21', 'Tens uma família muito linda.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-22', 'Comias leite condensado à colher quando eras criança.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-23', 'Desabafas comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-24', 'Compras mini-meias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-25', 'Levantas a divisão das cadeiras do cinema para vir para os meus miminhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-26', 'És perfeita.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-27', 'Pedes desculpa quando eu sinto um cheiro estranho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-28', 'És única.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-29', 'Dizes que vou ser eu a fazer as camas na nossa casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-30', 'Partilhamos momentos felizes e apaixonados.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('03-31', 'Fazes planos comigo para o futuro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-01', 'Gostas de cidra.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-02', 'Gostas de piqueniques.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-03', 'Ficas alegre quando bebes sangria.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-04', 'A fruta é a parte que gostas mais da sangria.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-05', 'És muito saudável.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-06', 'Dizes que somos o \"Bucha & Estica\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-07', 'Me fazes rir.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-08', 'Pões a mesa numa maneira muito arranjadinha.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-10', 'Ao abraçar-te só te vejo a cabeça.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-11', 'És muito rígida quanto ao uso de talheres de peixe ou de carne.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-12', 'O teu gelado favorito é o \"Perna de Pau\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-13', 'Não me deixas tocar nos teus sovacos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-14', 'Gostas de mim na mesma apesar dos meus defeitos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-15', 'As pessoas reparam que tu ficas apaixonadamente a sorrir a olhar para mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-16', 'Não comes coelho por ser muito fofinho, mas comes galinha por ser um animal estúpido.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-17', 'Namorámos muito nos \"Físicos\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-18', 'Tenho uma caixa em casa só com coisas nossas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-19', 'Me dás de prenda relógios muito giros.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-20', 'Insistes comigo para passar na passadeira.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-21', 'Sem ti não seria nada.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-22', 'Me dás os pickles dos teus hambúrgueres.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-23', 'Não gostas que deixe crescer muito a barba.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-24', 'Ao sair do metro nunca sabes com certeza o lado do nosso destino.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-25', 'Num Sr. de Matosinhos, estavas sempre a dizer para te dar uma Pantera.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-26', 'És a minha mimólica.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-27', 'Rasguei-te as meias no fim do Baile de Finalistas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-28', 'Fazes olhinhos para eu te carregar o violino.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-29', 'Fazemos devocionais juntos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('04-30', 'Dizes para olhar para as estrelas para me dares um beijinho das estrelas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-01', 'Reclamas comigo nos casamentos por eu querer tirar o casaco e pôr as fraldas para fora.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-02', 'Me dás uns beijos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-03', 'Não sabes fazer laços ao apertar cordões.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-04', 'Ficas sempre por dentro num \"Imbraço\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-05', 'A Pantera te pediu em namoro por mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-06', 'Me lembras das coisas que eu me esqueço.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-07', 'Gostas da minha família.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-08', 'Vamos ser muito felizes quando formos velhotes.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-10', 'Não suportas que o volume do rádio esteja num número ímpar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-11', 'Conheci a Deus por ti e contigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-12', 'Não resistes a prendas, mesmo que sejam pequeninas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-13', 'Ao beberes a tua boca fica numa posição engraçada.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-14', 'Apontas para o chão ou para a frente para fazer paragem ao autocarro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-15', 'Achavas que parecia estar a chover quando olhavas para as árvores no dia do Baile.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-16', 'Não percebes nada de buffers e sockets.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-17', 'Cheias bem.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-18', 'Tens muito jeito para costura.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-19', 'Me dás uns beijos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-20', 'Me deixas brincar com o teu botão, com a alavanca e com o acordeão que trazes sempre contigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-21', 'Não te importas que durma até tarde.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-22', 'Fazemos muitas Cocozices.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-23', 'Um dia te vais chamar Rita Ponces.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-24', 'Ficas triste quando a separação das cadeiras do cinema não levanta.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-25', 'Gostas de passear à beira mar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-26', 'Quando passa um cão agarras-te a mim para te proteger.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-27', 'Mostras ao Mundo inteiro que recebeste uma flor minha.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-28', 'Queres abrir uma conta em conjunto no banco.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-29', 'Não gostas que eu diga cabide, frigideira, atacador e ténis.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-30', 'Consegues adormecer de um momento para o outro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('05-31', 'Me vais buscar ao ISEP com um sorriso na cara e um abraço.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-01', 'És a \"Pinchinhos\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-02', 'Gostas de tirar fotos totós.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-03', 'Me deste o teu estojo para o usar na faculdade.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-04', 'Falas a toda a gente sobre o meu método de cortar pizza com uma tesoura.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-05', 'Não sabes cuspir para muito longe.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-06', 'Queres sempre que eu te mande o link do Abelhas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-07', 'Deixas que eu esteja sempre do lado de fora do passeio para te proteger.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-08', 'Cantas muito bem.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-10', 'Vês comigo filmes no cinema que não te interessam por saberes que eu gosto.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-11', 'Consegues chegar ao chão com as mãos sem dobrar os joelhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-12', 'Gosto de te dar beijinhos em todo o lado.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-13', 'Gostas de fazer coisas por mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-14', 'Não consegues levar o guarda-chuva direito quando estamos os dois juntos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-15', 'Nos partimos a rir ao ver as senhoras gordas a correrem para o autocarro na Rua do Talho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-16', 'Não te importas que fique até tarde acordado.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-17', 'És muito linda.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-18', 'Deixas guardar as minhas coisas na tua mala.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-19', 'Dizes para eu ficar à porta da casa de banho por teres medo que alguém entre.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-20', 'Tens um sorriso lindo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-21', 'Sabes fazer muito bem de D. Helena.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-22', 'Gozas com as minhas meias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-23', 'Só no fim do Secundário é que começamos a namorar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-24', 'És especial.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-25', 'Sabes o que é um \"patch file\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-26', 'Já me rapaste o cabelo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-27', 'Gostas de miminhos virtuais.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-28', 'Damos abraços com percentagens.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-29', 'Gostas de ver o pôr do Sol comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('06-30', 'Não me adoras por \"Adorar\" ser só para Deus.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-01', 'Tens cócegas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-02', 'Cantas comigo na rua a música dos Smash Mouth alternadamente uma sílaba à vez.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-03', 'Gostas muito da Lua e das Estrelas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-04', 'Tens muito jeito para crianças.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-05', '\"Descobriste sozinha\" que as motas da Pizza Hut são dos próprios empregados.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-06', 'Gostas de mim desde aqui até à Lua.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-07', 'Confias em mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-08', 'Gostas muito de comer meias maçãs.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-10', 'Ficas a olhar muito fixamente para mim e depois dizes que sou bonito.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-11', 'Gostas mais do violino do que de mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-12', 'Gostas de jantar fora comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-13', 'Fazes um gelado de Oreos maravilhoso.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-14', 'Precisas de tapar o nariz com uma mão debaixo de água.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-15', 'Ficas sexy de calções.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-16', 'Me compras lanches deliciosos no Froiz quando me vens buscar ao ISEP.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-17', 'Tens orgulho em mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-18', 'Ficas muito feliz por receberes uma prenda.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-19', 'Gostas muito que te faça a montanha russa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-20', 'Aproveitas cada segundo comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-21', 'Um dia me vais fazer um cheesecake e vai ser o melhor do Mundo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-22', 'No S. João fazemos sempre a caminhada e vemos o nascer do dia juntos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-23', 'Reclamas comigo por me esquecer das coisas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-24', 'Consegues fazer o desafio do umbigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-25', 'Tens a mania que és hippie e quase que só vestes roupa da Natura.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-26', 'Demoras muito para acabar uma série.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-27', 'Reclamas com a minha mania da perfeição.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-28', 'Gosto dos teus pés enquanto que tu própria não.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-29', 'Já sabes assobiar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-30', 'Me perdoaste por não ter estado no teu baptismo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('07-31', 'És a minha \"Principessa\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-01', 'Não queres um casamento muito despampanante.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-02', 'Me achas maluco quando digo que passei por uma teia e fico com comichões.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-03', 'Me ensinaste algumas bases de formação musical para ler partituras.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-04', 'Mesmo de cabelo apanhado ficas linda.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-05', 'Dizes sempre \"Bom dia\" aos motoristas dos autocarros.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-06', 'Me aconselhas durante as compras de roupa bonita.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-07', 'Gostas muito de Barbixas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-08', 'Tens as pernas tortas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-10', 'Só gostas de ouvir rádio se estiver na Smooth Jazz.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-11', 'Dizes que não estou apaixonado por ti por andar rápido.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-12', 'Não gostas de andar com saltos altos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-13', 'Tens um jeitinho atrapalhado em qualquer desporto.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-14', 'Adoras casamentos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-15', 'Quando fico doente, tratas de mim.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-16', 'És uma Cocó e tinhas vergonha de andar de mão dada comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-17', 'Gostas que te vá buscar de carro a qualquer lado por te sentires crescida e especial.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-18', 'Queres dar dois beijinhos no casamento quando o pastor disser que nos podemos beijar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-19', 'Não gostas das Oreos falsas da minha casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-20', 'Tenho uma moldura muito gira no meu quarto.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-21', 'Trocas a esquerda pela direita e vice-versa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-22', 'Me ensinaste a falar com Deus.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-23', 'Gostas de cidra.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-24', 'Ti Amo quadriliões.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-25', 'Gritas feita maluca nos aniversários da tua família.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-26', 'Já fizeste o plano do casamento todo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-27', 'Sabes fazer a cambalhota na piscina.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-28', 'Me Amas milhões.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-29', '\"Love you this much\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-30', 'Não gostas de cerveja de maneira nenhuma.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('08-31', 'Na rua só podemos dar beijinhos quando ninguém está a olhar para nós.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-01', 'Gostas de dormir no meio peitinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-02', 'Sabes o que é um \"porta-bochechas\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-03', 'Gostas de me abraçar dentro do casaco.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-04', 'Inventamos o CPP (Cocós Por Portugal).');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-05', 'Gostas de ler.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-06', 'Tiveste um acidente ao ir contra um poste.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-07', 'Me deste um pijama muito fixe.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-08', 'Me pedes para experimentar as tuas experiências culinárias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-10', 'Te Amo assim pó muito.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-11', 'Gostas das festas da minha aldeia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-12', 'Parecemos umas crianças a brincar na piscina.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-13', 'Tens um \"beicinho\" muito irresistível.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-14', 'Me levaste à igreja.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-15', 'Deixas que eu te chame gorda quando sabes que não és.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-16', 'Também queres que o primeiro filho se chame Alberto.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-17', 'Não gostas que te grite no carro.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-18', 'Tens que te pôr em cima de alguma coisa para ficares na altura ideal para te abraçar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-19', 'Levas-me a concertos de música muito bons.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-20', 'Usas um brinco de cada nação.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-21', 'És docinha.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-22', 'Mostras ao Mundo que me Amas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-23', 'Já sabemos as músicas de entrada para o baile do nosso casamento.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-24', 'Já sabes enrolar cabos sem estragar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-25', 'Te molhas toda ao beber líquidos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-26', 'Te viras para mim para me dar miminhos quando subimos escadas rolantes.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-27', 'Dizes embaraçada que nunca deste um puzete à minha beira.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-28', 'Vamos ter 3 bebés.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-29', 'Fazes muitas vezes um sorriso assim: \":(\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('09-30', 'Ganhas sempre no \"Rummikub\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-01', 'És a minha melhor amiga.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-02', 'Amas a minha mão direita.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-03', 'Me Amas todos os dias mais um bocadinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-04', 'Gostamos de \"Friends\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-05', 'Também não és muito fã de praia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-06', 'Não gostas que diga \"obrigados\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-07', 'Tens uns caracóis muito lindos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-08', 'Nunca deste um arroto na tua vida.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-10', 'Dizes às tuas amigas que eu arranjo os computadores delas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-11', 'Demoras muito tempo para acabar uma série.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-12', 'Nem sempre te zangas por me esquecer das coisas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-13', 'Os teus palmiéres são os melhores do Mundo e arredores.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-14', 'Também não gostas muito de falar ao telemóvel.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-15', 'Uma partícula colidiu com outra e formou-se o Universo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-16', 'Gostas da minha \"nerdice\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-17', 'Me ensinaste que uma mula não é um burro fêmea.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-18', 'Queres fazer já o enxoval.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-19', 'Fazes vídeos muito originais para a tua família.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-20', 'Vou com a tua cara.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-21', 'Gostas de andar de bicicleta.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-22', 'Todos os anos vemos um concerto dos Azeitonas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-23', 'Damos voltas ao quarteirão para namorar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-24', 'Gostas muito de beber chá.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-25', 'És a minha Xuxu.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-26', 'A tua e a minha altura são as ideais para nos abraçamos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-27', 'Gostas de receber flores.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-28', 'És gordinha.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-29', 'Ainda achas que sou uma criança.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-30', 'Começamos a namorar depois de 3 anos juntos no Secundário.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('10-31', 'Os sinais dos teus indicadores são simétricos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-01', 'Gostas de sushi.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-02', 'Dizes que já não consegues ouvir música sem estar atenta à sua \"ciência\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-03', 'Também queres ir viver para a Maia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-04', 'Tens \"curvinhas\" geitosas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-05', 'Consegues beber chá sem açúcar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-06', 'Não gostas que espreite para dentro das tuas narinas quanto te assoas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-07', 'Te partes a rir com o Mr. Bean.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-08', 'Não gostas de mim quando eu rapo o cabelo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-10', 'Ficas impressionada com uma pata ou cabeça de porco.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-11', 'Me pedes para dizer \"Bu babô, inhunha o nhanhão\" para ter rires.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-12', 'Contigo sou feliz.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-13', 'Também és uma totó a dançar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-14', 'Dizes que sou eu que vou sustentar a nossa família.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-15', 'Fazes olhinhos para eu perceber que queres subir quando estamos à porta de tua casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-16', 'Ficas facilmente com saudades minhas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-17', 'Fizeste de mim uma pessoa melhor.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-18', 'Ficamos muito lindos a cantar as músicas da Disney juntos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-19', 'Gosto cocomente bastante imensamente muito de ti.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-20', 'Escreves mensagens muito lindas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-21', 'Já sabes juntar imagens digitalizadas num PDF.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-22', '\"Love you A LOT\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-23', 'Também gostas de ir à zona industrial comer um cachorro ou hambúrguer.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-24', 'Sabes o que é uma versão alpha e beta.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-25', 'Gostas de falar comigo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-26', 'Olhas para trás a rir quando te assobio ao deixar-te na Faculdade.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-27', 'Ficas com os olhos à chinesa quando te ris muito.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-28', 'Te arrepias facilmente.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-29', 'Nunca te lembras de tirar o telemóvel do modo silencioso.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('11-30', 'Fazes de conta que tens muito frio para eu te aquecer.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-01', 'Me ensinaste o que é um Moleskine.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-02', 'Sabes cozinhar na Bimbi.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-03', 'Deixas papeizinhos com amor e carinho nas minhas coisas sem eu ver.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-04', 'Ficas muito fofinha quando estás corada.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-05', 'Me deste o teu número de telemóvel por uma calculadora.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-06', 'Evitas que eu passe no vermelho dos peões.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-07', 'A tua cor favorita é o amarelo, mas não gostas de vestir amarelo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-08', 'Quando está muito calor, só damos as mãos pelo mindinho.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-10', 'Te ris muito quando faço de conta que o teu braço é o guiador de uma mota.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-11', 'Me encantaste no Baile de Finalistas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-12', 'Adoptaste a minha técnica de despejar o lixo no contentor sem sujar as mãos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-13', 'Te ris quando a minha família me chama \"Betinho\".');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-14', 'Durante o Secundário esperavas sempre por mim à porta de casa.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-15', 'Gostas mais de piscina do que de praia.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-16', 'Tens sempre água para mim na mochila.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-17', 'Só me dás razões para gostar.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-18', 'Vamos de férias juntos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-19', 'Já sei distinguir o Violoncelo do Contrabaixo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-20', 'Nunca pagas os cafés.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-21', 'Temos infinitos tipos de beijinhos.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-22', 'Não gostas que te chame \"Guju\" por causa do Tobias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-23', 'Tens ciúmes do Tobias.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-24', 'Gostas de olhar para as lojas com vestidos de casamento.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-25', 'Reclamas da minha maneira de fazer as camas.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-26', 'Gostas de agradar à minha família.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-27', 'Me ajudaste a tomar a decisão de mudar de curso.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-28', 'És totó.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-29', 'Não gostas de ficar sozinha durante muito tempo.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-30', 'Gostas muito de palavras.');");

        db.execSQL("INSERT OR IGNORE INTO cozinha(date, description) " +
                "VALUES('12-31', 'Gostas muito de tirar fotos comigo.');");
    }

    private void insertsCozinhoDia(SQLiteDatabase db) {
        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('01-09', '<30', 'Dear Lord ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('02-09', '<31', 'à Bebé ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('03-09', '<32', 'Marguinhos ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('04-09', '<33', 'Completos ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('05-09', '<34', 'do Respeito ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('06-09', '35', 'à Esquimó ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('07-09', '<36', 'Divertidos ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('08-09', '<25', 'das Estrelas ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('09-09', '<26', 'Doces ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('10-09', '<27', 'à Velhote ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('11-09', '<28', 'de Borboleta ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinho_dia(date, heart, description) " +
                "VALUES('12-09', '<29', 'Complicados ♥');");
    }

    private void insertsCozinhaDia(SQLiteDatabase db) {
        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('01-09', '<30', 'Milkshake ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('02-09', '<31', 'Antena Parabólica ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('03-09', '<32', 'Peixe-Balão ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('04-09', '<33', 'Subaquáticos ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('05-09', '<34', 'à Esquilo ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('06-09', '35', 'Gordinhos ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('07-09', '<36', 'Pigossos ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('08-09', '<25', 'Gelados ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('09-09', '<26', 'Graduais ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('10-09', '<27', 'à Pomba ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('11-09', '<28', 'à Homem Aranha ♥');");

        db.execSQL("INSERT OR IGNORE INTO cozinha_dia(date, heart, description) " +
                "VALUES('12-09', '<29', 'Laterais ♥');");
    }

    public void searchDay(SQLiteDatabase db, String date) {
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        String table = sharedPrefs.getString("table_list", "cozinho");
        Cursor c;
        if (date.equals("today")) {
            SimpleDateFormat df = new SimpleDateFormat("MM-dd");
            date = df.format(new Date());
        }
        int day = Integer.parseInt(date.split("-")[1]);
        if (day != 9) {
            c = db.rawQuery("SELECT description FROM " + table + " WHERE date='" + date + "'", null);
            if (c.moveToFirst()) {
                heart = "";
                description = c.getString(c.getColumnIndex("description"));
            }
        } else {
            c = db.rawQuery("SELECT description FROM " + table + "_dia WHERE date='" + date + "'", null);
            if (c.moveToFirst()) {
                description = "Dás beijinhos " + c.getString(c.getColumnIndex("description"));
            }
        }
        c.close();
    }

    public String[] getAll(SQLiteDatabase db) {
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(context);
        String table = sharedPrefs.getString("table_list", "cozinho");
        String date;
        ArrayList<String> all = new ArrayList<>();
        Cursor c, c2;
        c = db.rawQuery("SELECT date, description FROM " + table, null);
        c2 = db.rawQuery("SELECT date, description FROM " + table + "_dia", null);
        c.moveToFirst();
        c2.moveToFirst();
        while(!c.isAfterLast()) {
            date = c.getString(c.getColumnIndex("date"));
            all.add(c.getString(c.getColumnIndex("date")) + "/" +
                    c.getString(c.getColumnIndex("description")));
            if(date.split("-")[1].equals("08")) {
                all.add(c2.getString(c2.getColumnIndex("date")) + "/" +
                        "Dás beijinhos " + c2.getString(c2.getColumnIndex("description")));
                c2.moveToNext();
            }
            c.moveToNext();
        }
        return all.toArray(new String[all.size()]);
    }
}
