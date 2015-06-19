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
