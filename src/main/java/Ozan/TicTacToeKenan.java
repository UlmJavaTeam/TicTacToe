package Ozan;

import java.util.Scanner;

public class TicTacToeKenan {
    /*oyunun algoritması
    öncelikle array ile 3 boyutlu ve her boyutta 3 elemanlı matris dizisi yapalım. elemanları 1den 9a kadar rakam verelim.
    oyuncu bir rakamı seçince seçilen rakam X olur
    bilgisayar random bir rakam seçer O  olur
    eğer(if) sıralı veya çapraz aynı olursa oyun biter aksi halde sıfırlayıp tekrar eder.
     */

    public static void main(String[] args) {
        System.out.println("welcome to TickTackToe");
        Scanner input = new Scanner(System.in);
        boolean controls = true;
        String[][] master = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        String testX= "XXX";
        String testO= "OOO";
        String tekrarkontrol = "f";
        int count=0;
        System.out.println("1. iki kişi oynamak için ");
        System.out.println("2 bilgisayara karşı oynamak için");
        int secim;
        while (true) {
            secim = input.nextInt();
            if (secim==1||secim==2)
                break;
            else{
                System.out.println("lütfen iki seçimden birini  yapın");
                continue;
            }

        }

        while (controls) {
            //matrisi yazdırdım
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(master[i][j] + " ");
                }
                System.out.println();
            }
            //karşılaştırmayı çok zor yaptım
            String kelime1= master[0][0]+master[0][1]+master [0][2];
            String kelime2= master[1][0]+master[1][1]+master [1][2];
            String kelime3= master[2][0]+master[2][1]+master [2][2];
            String kelime4= master[0][0]+master[1][0]+master [2][0];
            String kelime5= master[0][1]+master[1][1]+master [2][1];
            String kelime6= master[0][2]+master[1][2]+master [2][2];
            String kelime7= master[0][0]+master[1][1]+master [2][2];
            String kelime8= master[0][2]+master[1][1]+master [2][0];

            if (testX.equals(kelime1) || testX.equals(kelime2) || testX.equals(kelime3) || testX.equals(kelime4) || testX.equals(kelime5) || testX.equals(kelime6) || testX.equals(kelime7) || testX.equals(kelime8) ) {
                System.out.println("kazandınız XXX");
                count=0;
                System.out.println("1. oyuna devam etmek için ");
                System.out.println("2. oyundan çıkmak için ");
                int karar = input.nextInt();
                if (karar==1){
                    tekrarkontrol="f";
                    int a=0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            a++;
                            master[i][j]= String.valueOf(a);
                        }
                    }
                }else if (karar==2)
                    continue;
                controls = false;
            }
            if (testO.equals(kelime1) || testO.equals(kelime2) || testO.equals(kelime3) || testO.equals(kelime4) || testO.equals(kelime5) || testO.equals(kelime6) || testO.equals(kelime7) || testO.equals(kelime8) ) {
                System.out.println("kazandınız OOO");
                count=0;
                System.out.println("1. oyuna devam etmek için ");
                System.out.println("2. oyundan çıkmak için ");
                int karar = input.nextInt();
                if (karar==1){
                    tekrarkontrol="f";
                    int a=0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            a++;
                            master[i][j]= String.valueOf(a);
                        }
                    }
                }else if (karar==2)
                    continue;
                controls = false;
            }



//kullanıcıdan seçim alma
            while (true) {
                System.out.println("lütfen bir rakam seçiniz");
                int nummer1 =input.nextInt();
                String kullanıcıGirisi =String.valueOf(nummer1);

                if (tekrarkontrol.contains(kullanıcıGirisi)) {
                    System.out.println("lütfen daha önce seçilen sayıyı seçmeyin");
                    continue;
                }
                else {
                    tekrarkontrol = tekrarkontrol + kullanıcıGirisi;
                    count++;

                    switch (kullanıcıGirisi) {
                        case "1":
                            master[0][0] = "X";
                            break;
                        case "2":
                            master[0][1] = "X";
                            break;
                        case "3":
                            master[0][2] = "X";
                            break;
                        case "4":
                            master[1][0] = "X";
                            break;
                        case "5":
                            master[1][1] = "X";
                            break;
                        case "6":
                            master[1][2] = "X";
                            break;
                        case "7":
                            master[2][0] = "X";
                            break;
                        case "8":
                            master[2][1] = "X";
                            break;
                        case "9":
                            master[2][2] = "X";
                            break;
                        default:
                            System.out.println("yanlış sayı girdiniz");
                            continue;
                    }
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            System.out.print(master[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                }
            }
            //tüm alanlar oynanınca uyarmak için
            if (count==9){
                System.out.println("kazanan yok !!");
                System.out.println("1. oyuna tekrar başlamak için ");
                System.out.println("2. oyundan çıkmak için ");
                int karar = input.nextInt();
                if (karar==1){
                    tekrarkontrol="f";
                    int a=0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            a++;
                            master[i][j]= String.valueOf(a);
                        }
                    }
                }else if (karar==2)
                    controls = false;
                continue;
            }

//ikinci kişinin oynadığı yer
            switch (secim) {
                case 1:
                    while (true) {
                        System.out.println("lütfen bir rakam seçiniz");
                        int nummer2= input.nextInt();
                        String kullanıcıGirisi2 = String.valueOf(nummer2);
                        if (tekrarkontrol.contains(kullanıcıGirisi2)) {
                            System.out.println("lütfen daha önce seçilen sayıyı seçmeyin");
                            continue;
                        }
                        else {
                            tekrarkontrol = tekrarkontrol + kullanıcıGirisi2;
                            count++;

                            switch (kullanıcıGirisi2) {
                                case "1":
                                    master[0][0] = "O";
                                    break;
                                case "2":
                                    master[0][1] = "O";
                                    break;
                                case "3":
                                    master[0][2] = "O";
                                    break;
                                case "4":
                                    master[1][0] = "O";
                                    break;
                                case "5":
                                    master[1][1] = "O";
                                    break;
                                case "6":
                                    master[1][2] = "O";
                                    break;
                                case "7":
                                    master[2][0] = "O";
                                    break;
                                case "8":
                                    master[2][1] = "O";
                                    break;
                                case "9":
                                    master[2][2] = "O";
                                    break;
                                default:
                                    System.out.println("yanlış sayı girdiniz");
                                    continue;
                            }
                            break;
                        }
                    }
                    break;

                //bilgisayar otomatik atama
                case 2:
                    while (true) {
                        int random = (int) (Math.random() * 9) + 1;
                        String rastgele = String.valueOf(random);
                        if (tekrarkontrol.contains(rastgele))
                            continue;
                        else {
                            tekrarkontrol = tekrarkontrol + rastgele;
                            count++;
                            switch (rastgele) {
                                case "1":
                                    master[0][0] = "O";
                                    break;
                                case "2":
                                    master[0][1] = "O";
                                    break;
                                case "3":
                                    master[0][2] = "O";
                                    break;
                                case "4":
                                    master[1][0] = "O";
                                    break;
                                case "5":
                                    master[1][1] = "O";
                                    break;
                                case "6":
                                    master[1][2] = "O";
                                    break;
                                case "7":
                                    master[2][0] = "O";
                                    break;
                                case "8":
                                    master[2][1] = "O";
                                    break;
                                case "9":
                                    master[2][2] = "O";
                                    break;
                            }
                            break;
                        }
                    }
                    break;
            }

        }

    }

}

